package com.minghai.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期
 */
public class StringToDateConvert implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        // 判断
        if (source == null) {
            throw  new RuntimeException("请您传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 把字符串转换成日期
        try {
            return df.parse(source);
        } catch (Exception e) {
           throw  new RuntimeException("数据类型转换异常");
        }
    }
}
