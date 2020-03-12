package com.greenproject.controller;

import com.greenproject.model.Product;
import com.greenproject.service.HolidayCheckService;
import com.greenproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HolidayCheckService holidayCheckService;

    @RequestMapping("/all")
    public List<Product> listProjects() {
        return productService.listAll();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void create(@RequestBody Product product) {
         productService.saveOrUpdate(product);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void saveOrUpdateById(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }

    //@RequestMapping(value = "/publish", method = RequestMethod.GET)
    @Scheduled(cron = "0 47 13 * * ?")
    public void publishData(){
        System.out.println("process started");
        holidayCheckService.initialiseChecks();
        productService.addAll();
        System.out.println("process finished");
    }

    //@Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentTime() throws Exception {
        System.out.println(new Date());
        Thread.sleep(10000);
    }
}
