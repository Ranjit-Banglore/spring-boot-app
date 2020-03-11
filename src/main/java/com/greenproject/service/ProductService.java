package com.greenproject.service;

import com.greenproject.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAll();

    void create(Product product);

    Product saveOrUpdate(Product product);

    void addAll();

    void deleteAll();

}
