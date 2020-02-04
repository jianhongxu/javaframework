package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductMy;
import com.example.demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @autor xujianhong
 * @date 2020/2/4 9:05
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @GetMapping("/{id}")
    public Product getProductInfo(@PathVariable("id")Long productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProductInfo(@PathVariable("id")Long productId, @RequestBody Product newProduct) {
        Product p = productMapper.selectByPrimaryKey(productId);
        newProduct.setId(p.getId());
        productMapper.updateByPrimaryKey(newProduct);
        return newProduct;
    }

}
