package cn.nice123.product.service;

import java.util.List;

import cn.nice123.product.dataobject.ProductCategory;

public interface CategoryService {
	
	ProductCategory findOne(Integer id);
	
	List<ProductCategory> finAll();
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
	
	ProductCategory save(ProductCategory category);
	
}
