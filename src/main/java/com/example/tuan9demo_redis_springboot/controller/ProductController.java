package com.example.tuan9demo_redis_springboot.controller;


import com.example.tuan9demo_redis_springboot.entity.Product;
import com.example.tuan9demo_redis_springboot.reponsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductReponsitory reponsitory;
//    ProductService service;
    @PostMapping
    public Product save(@RequestBody Product product) {
        return reponsitory.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return reponsitory.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return reponsitory.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return reponsitory.deleteProduct(id);
    }
}
