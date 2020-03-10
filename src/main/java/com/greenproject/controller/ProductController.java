package com.greenproject.controller;

import com.greenproject.model.Product;
import com.greenproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/all")
    public List<Product> listProjects() {
        return productService.listAll();
    }

    @RequestMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable int id) {
        productService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void saveOrUpdateById(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }
}
