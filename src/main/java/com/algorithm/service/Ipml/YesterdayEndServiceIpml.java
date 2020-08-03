package com.algorithm.service.Ipml;

import com.algorithm.service.ObtainYesterdayTimeService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YesterdayEndServiceIpml implements ObtainYesterdayTimeService {

    @Override    //表示重写,编译器可以验证@Override下面的方法名是否是你父类中所有的,如果没有则报错,
                 //如果没写@Override,编译器以为这个方法是你的子类中自己增加的方法,不会报错
    public String obtime() {
        //获取上上周日结束时间
        Calendar ca = Calendar.getInstance();       //得到一个Calendar的实例
        ca.setTime(new Date());        //设置时间为当前时间
//        int dayofweek1 = ca.get(Calendar.DAY_OF_WEEK);
//        if (dayofweek1 == 1) {
//            dayofweek1 += 7;
//        }
//        ca.add(Calendar.DATE, -6 - dayofweek1);      //获取上周日日期
        ca.add(Calendar.DATE, -1);      //获取昨天日期
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);              //定为23时59分59秒
        Date d1 = ca.getTime();       //结果
//        ca.add(Calendar.MONTH, -1);   //求前一月
//        ca.add(Calendar.YEAR, -1);   //前一年
        SimpleDateFormat endttime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        System.out.println("结束时间：" + endttime.format(d1));    //获取结束时间
        String end = endttime.format(d1);

        return end;
    }
}
