package cn.nice123.product.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nice123.product.server.dataobject.ProductCategory;
import cn.nice123.product.server.repository.ProductCategoryRepository;
import cn.nice123.product.server.service.CategoryService;

/**
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
