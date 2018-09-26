package cn.nice123.product.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品信息包括类目
 * @author xiang
 *
 */

public class ProductVO {

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	@JsonIgnore
	public List<ProductInfoVO> getProductInfoVOList() {
		return ProductInfoVOList;
	}

	public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
		ProductInfoVOList = productInfoVOList;
	}

	@JsonProperty("name")
	private String categoryName;
	
	@JsonProperty("type")
	private Integer categoryType;
	
	@JsonProperty("foods")
	private List<ProductInfoVO> ProductInfoVOList;
}
