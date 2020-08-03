package com.algorithm.service.Ipml;

import com.algorithm.service.ObtainYesterdayTimeService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YesterdayStartServiceIpml implements ObtainYesterdayTimeService {
    @Override
    public String obtime() {
        Calendar cal = Calendar.getInstance();       //得到一个Calendar的实例
        cal.setTime(new Date());        //设置时间为当前时间
//        int dayofweek2 = cal.get(Calendar.DAY_OF_WEEK);
//        if (dayofweek2 == 1) {
//            dayofweek2 += 7;
//        }
//        cal.add(Calendar.DATE, 1 - dayofweek2);   //获取上上周日日期
        cal.add(Calendar.DATE, -2);      //获取前天日期
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date d2 = cal.getTime();         //结果
        SimpleDateFormat starttime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        System.out.println("开始时间：" + starttime.format(d2));      //获取开始时间
        String start = starttime.format(d2);

        return start;
    }
}
