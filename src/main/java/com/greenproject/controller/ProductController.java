package com.greenproject.controller;

import com.greenproject.model.Product;
import com.greenproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void saveOrUpdateById(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }

    //@RequestMapping(value = "/publish", method = RequestMethod.GET)
    @Scheduled(cron = "0 2 3 * * ?")
    public void publishData(){
        System.out.println("process started");
        productService.addAll();
        System.out.println("process finished");
    }

    //@Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() throws Exception {
        System.out.println(new Date());
        Thread.sleep(10000);
    }
}
