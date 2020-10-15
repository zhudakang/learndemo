package com.dk.learndemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import static java.util.Calendar.DAY_OF_MONTH;

/**
 * @author :zhudakang
 * @description : A
 * @create : 2020/08/11
 */
public class CalendarTest {

    private final static ThreadLocal<SimpleDateFormat> DAYFORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    private final static ThreadLocal<SimpleDateFormat> DATEFORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    //用于sql resultSet列名解析
    private final static String TOTAL_COUNT = "totalcount";
    //根据域名枚举查询sql模板
    private final static String DOMAIN_QUERY_TEMPLATE = "select url ,status,sum(total_count) as totalCount FROM odw.dws_nginx_full_log_view where biz_type = '%s' and minute_range >= '%s' and minute_range <= '%s' and is_ok =1 and traffic_type = 0 and day_format = '%s' GROUP BY url , status ORDER BY totalCount DESC LIMIT 50;";


    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(DAYFORMAT.get().format(cal.getTime()));
        cal.add(DAY_OF_MONTH, -1);  //时间偏移量

        //在这边Calendar.DAY_OF_MONTH 和 Calendar.DATE 是一样的内容；
        //DAY_OF_MONTH的主要作用是cal.get(DAY_OF_MONTH)，用来获得这一天在是这个月的第多少天
        //Calendar.DAY_OF_YEAR的主要作用是cal.get(DAY_OF_YEAR)，用来获得这一天在是这个年的第多少天。
        //同样，还有DAY_OF_WEEK，用来获得当前日期是一周的第几天

        System.out.println(cal.get(DAY_OF_MONTH));;

        String oneDayAgo = DAYFORMAT.get().format(cal.getTime());// 获取昨天时间

        System.out.println(oneDayAgo);

        cal.add(DAY_OF_MONTH, -1);
        String twoDayssAgo = DAYFORMAT.get().format(cal.getTime());// 获取前天的时间
        System.out.println(twoDayssAgo);

        cal.add(DAY_OF_MONTH, -1);
        String threeDaysAgo = DAYFORMAT.get().format(cal.getTime());// 获取三天之前的时间
        System.out.println(threeDaysAgo);
    }

}
