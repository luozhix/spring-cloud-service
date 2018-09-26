package cn.nice123.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.nice123.product.dataobject.ProductInfo;
import cn.nice123.product.enums.ProductStatusEnum;
import cn.nice123.product.repository.ProductInfoRepository;
import cn.nice123.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductInfoRepository productInfoRespositoy;

	@Override
	public ProductInfo findOne(String id) {
		return null;
	}

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRespositoy.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {
		return null;
	}

	@Override
	public void on_sale(String id) {
	}

	@Override
	public void off_sale(String id) {
	}

	@Override
	public List<ProductInfo> findByIdList(List<String> productIdList) {
		return productInfoRespositoy.findByProductIdIn(productIdList);
	}
	


}
