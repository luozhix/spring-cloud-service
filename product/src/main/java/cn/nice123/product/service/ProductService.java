package cn.nice123.product.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.nice123.product.dataobject.ProductInfo;

public interface ProductService {
	
	List<ProductInfo> findByIdList(List<String> productIdList);
	
	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	ProductInfo findOne(String id);
	
	/**
	 * 查询所有上架商品
	 * @return
	 */
	List<ProductInfo> findUpAll();
	
	/**
	 * 查询所有商品，分页查询
	 * @param pageable
	 * @return
	 */
	Page<ProductInfo> findAll(Pageable pageable);
	
	/**
	 * 保存，修改商品
	 * @param productInfo
	 * @return
	 */
	ProductInfo save(ProductInfo productInfo);
	
	/**
	 * 增加库存
	 * @param cartDTOs
	 */
	/*void increaseStore(List<CartDTO> cartDTOs);
	
	*//**
	 * 减少库存
	 * @param cartDTOs
	 *//*
	void decreaseStore(List<CartDTO> cartDTOs);*/
	
	
	void on_sale(String id);
	
	void off_sale(String id);
	
	
	
	
}
