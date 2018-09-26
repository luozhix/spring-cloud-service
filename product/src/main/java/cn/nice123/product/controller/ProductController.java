package cn.nice123.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.nice123.product.dataobject.ProductCategory;
import cn.nice123.product.dataobject.ProductInfo;
import cn.nice123.product.service.CategoryService;
import cn.nice123.product.service.ProductService;
import cn.nice123.product.util.ResultVOUtil;
import cn.nice123.product.vo.ProductInfoVO;
import cn.nice123.product.vo.ProductVO;
import cn.nice123.product.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	/**
	 * 
	 * 查询所有上架商品按照给定格式返回给前端
	 * @return
	 */
	@GetMapping("/list")
	public ResultVO list() { 
		//1.查询所有上架商品
		List<ProductInfo> productList = productService.findUpAll();
		
		//2.查询类目(一次性查询)
		List<Integer> categoryTypeList = productList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
		List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
		
		//3.数据拼接
		List<ProductVO> ProductVOList = new ArrayList<>();
		for (ProductCategory productCategory : productCategoryList) {
			ProductVO productVO = new ProductVO();
			productVO.setCategoryName(productCategory.getCategoryName());
			productVO.setCategoryType(productCategory.getCategoryType());
			List<ProductInfoVO> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo : productList) {
				if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoVO productInfoVO = new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}		
			}
			productVO.setProductInfoVOList(productInfoVOList);
			ProductVOList.add(productVO);
		}
		return ResultVOUtil.success(ProductVOList);
	}
	/**
	 * 获取商品列表（给订单服务用）
	 * @param productIdList
	 * @return
	 */
	@GetMapping("/listForOrder")
	public List<ProductInfo> listForOrder(){
		List<ProductInfo> productInfoList = productService.findByIdList(Arrays.asList("123121","12312"));
		log.info("productInfoList={}",productInfoList);
		return productInfoList;
	}
}
