package com.zhifa.erweima;

import com.xkzhangsan.time.formatter.DateTimeFormatterUtil;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author lzf
 * @version 1.0
 * @date 2020-02-18 13:45
 */
public class DateTimeTest {
    public static void main(String[] args) {
        String format = DateTimeFormatterUtil.format(new Date(), DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(format);

    }
}
