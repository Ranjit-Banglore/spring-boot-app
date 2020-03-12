package com.greenproject.controller;

import com.greenproject.model.HolidayCheck;
import com.greenproject.service.HolidayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/holidaychecks")
public class HolidayCheckController {

    @Autowired
    private HolidayCheckService holidayCheckService;

    @RequestMapping("/all")
    public List<HolidayCheck> listProjects() {
        return holidayCheckService.listAll();
    }

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    //Job to populate holiday check data, this is needed only one time.
    //@Scheduled(cron = "0 44 13 * * ?")
    public void create() {
        holidayCheckService.create();
    }
}
