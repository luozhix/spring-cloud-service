package cn.nice123.product.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.nice123.product.ProductApplicationTests;
import cn.nice123.product.dataobject.ProductCategory;
import cn.nice123.product.service.CategoryService;
import junit.framework.Assert;

public class CategoryServiceImplTest extends ProductApplicationTests{
	
	@Autowired
	CategoryService categoryService;

	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> productCategoryTypeList = categoryService.findByCategoryTypeIn(Arrays.asList(2,3,4));
		Assert.assertEquals(3, productCategoryTypeList.size());
	}

}
