package cn.hdj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换成字符串
    public static String date2String(Date date, String pat) {
        SimpleDateFormat sdf = new SimpleDateFormat(pat);
        String format = sdf.format(date); //日期转成 字符串
        return format;
    }

    //字符串转换成日期
    public static Date string2Date(String str, String pat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pat);
        Date parse = sdf.parse(str);//将字符串 转成日期
        return parse;
    }
}
