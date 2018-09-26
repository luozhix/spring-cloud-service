package cn.nice123.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.nice123.product.dataobject.ProductCategory;
import cn.nice123.product.repository.ProductCategoryRepository;
import cn.nice123.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Resource
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public ProductCategory findOne(Integer id) {
		ProductCategory productCategory = productCategoryRepository.findById(id).get();
		return productCategory;
	}

	@Override
	public List<ProductCategory> finAll() {
		List<ProductCategory> list = productCategoryRepository.findAll();
		return list;
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
		List<ProductCategory> productCategorys = productCategoryRepository.findByCategoryTypeIn(list);
		return productCategorys;
	}

	@Override
	public ProductCategory save(ProductCategory category) {
		ProductCategory productCategory = productCategoryRepository.save(category);
		return productCategory;
	}

}
