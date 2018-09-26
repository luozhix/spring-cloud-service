package cn.nice123.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.nice123.product.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
}
