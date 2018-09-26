package cn.nice123.product.server.service;


import java.util.List;

import cn.nice123.product.server.dataobject.ProductCategory;

/**
 * 类目
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
