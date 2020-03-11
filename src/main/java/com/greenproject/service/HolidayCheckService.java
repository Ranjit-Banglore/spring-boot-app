package com.greenproject.service;

import com.greenproject.model.HolidayCheck;

import java.util.List;

public interface HolidayCheckService {

    List<HolidayCheck> listAll();

    void create();

}
