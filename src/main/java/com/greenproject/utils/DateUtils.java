package com.greenproject.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat small=new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat medium=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    public static Date date(String dateString){

        try {
            return small.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
