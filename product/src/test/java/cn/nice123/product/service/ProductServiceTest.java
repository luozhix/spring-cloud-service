package cn.nice123.product.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.nice123.product.ProductApplicationTests;
import cn.nice123.product.dataobject.ProductInfo;
import cn.nice123.product.service.ProductService;
import junit.framework.Assert;

@Component
public class ProductServiceTest extends ProductApplicationTests{

	@Autowired
	ProductService productService;
	
	@Test
	public void testFindUpAll() {
		List<ProductInfo> productInfoList = productService.findUpAll();
		Assert.assertEquals(0, productInfoList.size());
	}
	
	@Test
	public void testFindByIdList() {
		List<ProductInfo> productInfoList = productService.findByIdList(Arrays.asList("123121"));
		Assert.assertEquals(1, productInfoList.size());
	}

}
