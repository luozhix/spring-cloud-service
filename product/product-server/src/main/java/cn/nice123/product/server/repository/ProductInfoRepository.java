package cn.nice123.product.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.nice123.product.server.dataobject.ProductInfo;

/**
 * Created by 廖师兄
 * 2017-12-09 21:29
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
