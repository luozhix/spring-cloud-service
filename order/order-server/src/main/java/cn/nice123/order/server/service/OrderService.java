package cn.nice123.order.server.service;

import cn.nice123.order.server.dto.OrderDTO;

/**
 * Created by 廖师兄 2017-12-10 16:39
 */
public interface OrderService {

	/**
	 * 创建订单
	 * 
	 * @param orderDTO
	 * @return
	 */
	OrderDTO create(OrderDTO orderDTO);

	/**
	 * 完结订单，只能卖家访问
	 * @param orderId
	 * @return
	 */
	OrderDTO finish(String orderId);
}
