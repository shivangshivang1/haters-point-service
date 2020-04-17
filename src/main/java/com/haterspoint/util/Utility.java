package com.haterspoint.util;

import com.haterspoint.entity.Generics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {


    public static Generics getCreateGenericDetails(String user){
        return Generics.builder()
                .createdBy(user)
                .createdTime(getCurrentTime())
                .build();

    }


    private static String getCurrentTime(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd-mmm-yyyy");
        String dateStr = dateFormat.format(date);
        return dateStr;



    }

}
