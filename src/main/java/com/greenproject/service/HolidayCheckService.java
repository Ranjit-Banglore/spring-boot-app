package com.greenproject.service;

import com.greenproject.model.HolidayCheck;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface HolidayCheckService {

    List<HolidayCheck> listAll();

    void create();

    void initialiseChecks();

    List<Set<String>> getChecks();

}
