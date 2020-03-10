package com.greenproject.service;

import com.greenproject.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAll();

    Product getById(int id);

    void create(Product product);

    Product saveOrUpdate(Product product);

    void delete(int id);

}
