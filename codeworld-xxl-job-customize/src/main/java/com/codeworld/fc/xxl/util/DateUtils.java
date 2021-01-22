package com.codeworld.fc.xxl.util;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Lenovo
 */
public class DateUtils {

    /**
     * 日期格式yyyy-MM-dd
     */
    public static final String pattern_date = "yyyy-MM-dd";

    /**
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final String pattern_time = "yyyy-MM-dd HH:mm:ss";

    /**
     * 描述：日期格式化
     *
     * @param date 日期
     * @return 输出格式为 yyyy-MM-dd 的字串
     */
    public static String formatDate(Date date) {

        return formatDate(date, pattern_time);

    }

    /**
     * 描述：日期格式化
     *
     * @param date    日期
     * @param pattern 格式化类型
     * @return
     */
    public static String formatDate(Date date, String pattern) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.format(date);
    }

    /***
     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date date) {
        String dateFormat = "ss mm HH dd MM ? yyyy";
        return formatDate(date, dateFormat);
    }
}
