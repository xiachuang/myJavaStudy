package cn.hdj.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public  static  String date2String(Date date,String ptt){
       SimpleDateFormat sdf= new SimpleDateFormat(ptt);
       String str=sdf.format(date);
       return  str;
    }
    public  static  Date ting2Date(String str1,String ptt) throws ParseException {
       SimpleDateFormat sdf= new SimpleDateFormat(ptt);
        Date date=  sdf.parse(str1);
       return  date;
    }
}
