package cn.nice123.order.server.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.nice123.order.server.dataobject.OrderDetail;
import cn.nice123.order.server.dataobject.OrderMaster;
import cn.nice123.order.server.dto.OrderDTO;
import cn.nice123.order.server.enums.OrderStatusEnum;
import cn.nice123.order.server.enums.PayStatusEnum;
import cn.nice123.order.server.repository.OrderDetailRepository;
import cn.nice123.order.server.repository.OrderMasterRepository;
import cn.nice123.order.server.service.OrderService;
import cn.nice123.order.server.util.KeyUtil;
import cn.nice123.product.client.ProductClient;
import cn.nice123.product.common.DecreaseStockInput;
import cn.nice123.product.common.ProductInfoOutput;

/**
 * Created by 廖师兄 2017-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Autowired
	private ProductClient productClient;

	@Override
	@Transactional
	public OrderDTO create(OrderDTO orderDTO) {
		String orderId = KeyUtil.genUniqueKey();

		// 查询商品信息(调用商品服务)
		List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId)
				.collect(Collectors.toList());
		List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);

		// 计算总价
		BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
		for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
			for (ProductInfoOutput productInfo : productInfoList) {
				if (productInfo.getProductId().equals(orderDetail.getProductId())) {
					// 单价*数量
					orderAmout = productInfo.getProductPrice()
							.multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
					BeanUtils.copyProperties(productInfo, orderDetail);
					orderDetail.setOrderId(orderId);
					orderDetail.setDetailId(KeyUtil.genUniqueKey());
					// 订单详情入库
					orderDetailRepository.save(orderDetail);
				}
			}
		}

		// 扣库存(调用商品服务)
		List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
				.map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
				.collect(Collectors.toList());
		productClient.decreaseStock(decreaseStockInputList);

		// 订单入库
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(orderAmout);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}
}
