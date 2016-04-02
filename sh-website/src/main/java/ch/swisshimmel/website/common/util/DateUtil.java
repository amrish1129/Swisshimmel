package ch.swisshimmel.website.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    
    public static Date convertStrToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
             if (dateStr != null  && dateStr.length() == 10) {
             date = formatter.parse(dateStr);
             }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    
    }
    
    public static String convertDateToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String dateStr = null;
       
            if (null!= date) {
            dateStr = formatter.format(date);
            }

        
        return dateStr;
    }
}
