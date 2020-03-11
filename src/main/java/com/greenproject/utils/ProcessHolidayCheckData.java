package com.greenproject.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class ProcessHolidayCheckData {

    public static void execute() throws Exception {
        BufferedReader csvReader = new BufferedReader(new FileReader("HolidayCheckEuropaData.csv"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(";");
        }
        csvReader.close();
    }
}
