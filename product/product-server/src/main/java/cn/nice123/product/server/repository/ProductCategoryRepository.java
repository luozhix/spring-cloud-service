package cn.nice123.product.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.nice123.product.server.dataobject.ProductCategory;

/**
 * Created by 廖师兄
 * 2017-12-09 21:41
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
