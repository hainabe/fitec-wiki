package com.fitec.formation.wiki.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {

    public Date formatDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            System.out.println("### Exception: date error!");
            e.printStackTrace();
        }
        return date;
    }
}
