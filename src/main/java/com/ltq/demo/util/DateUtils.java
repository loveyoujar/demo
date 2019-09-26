package com.ltq.demo.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/**
     * &#x6309;&#x7ed9;&#x5b9a;&#x7684;pattern&#x5c06;&#x5b57;&#x7b26;&#x4e32;&#x8f6c;&#x6362;&#x6210;&#x65e5;&#x671f;&#x7c7b;
     * @param dateStr
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateStr, String pattern) throws ParseException {
        DateFormat df = new SimpleDateFormat(pattern);

        return df.parse(dateStr);
    }
	
	
	/**
     * 按格式转换日期
     * @param sDate
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parseDateNoTime(String sDate, String format) throws ParseException {
        if (StringUtils.isBlank(format)) {
            throw new ParseException("Null format. ", 0);
        }

        DateFormat dateFormat = new SimpleDateFormat(format);

        if ((sDate == null) || (sDate.length() < format.length())) {
            throw new ParseException("length too little", 0);
        }

        return dateFormat.parse(sDate);
    }
	
	



    /** 减天数 */
    public static String minusDay(String dates,int days)
    {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(null == date)
        {
            return null;
        }

        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - days);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /** 指定日期的后一天 */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(null == date)
        {
            return null;
        }

        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
            .format(c.getTime());
        return dayAfter;
    }

 /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     *字符串的日期格式的计算
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    /** 增加分钟 */
    public static Date addMins(Date date, int n)
    {
        try
        {
            if(date != null)
            {
                Calendar ca = Calendar.getInstance();
                ca.setTime(date);
                ca.add(Calendar.MINUTE, n);

                return ca.getTime();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    /** 增加小时 */
    public static Date addHours(Date date, int n)
    {

        try
        {
            if(date != null)
            {
                if(n != 0){

                    Calendar ca = Calendar.getInstance();
                    ca.setTime(date);
                    ca.add(Calendar.HOUR, n);
                    return ca.getTime();

                }else{

                    return date;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public static Date addHoursAndMinute(Date date,double n)
    {
        try
        {
            if(date != null)
            {
                if(n != 0)
                {
                    String[] hm = (n+"").split("\\.");
                    Calendar ca = Calendar.getInstance();
                    ca.setTime(date);
                    if(n>0)
                    {
                        ca.add(Calendar.HOUR, Integer.parseInt(hm[0]));
                        if(hm.length==2)
                        {
                            ca.add(Calendar.MINUTE, Integer.parseInt(hm[1])*6);
                        }
                    }else
                    {
                        ca.add(Calendar.HOUR, Integer.parseInt(hm[0]));
                        if(hm.length==2)
                        {
                            ca.add(Calendar.MINUTE, -(Integer.parseInt(hm[1])*6));
                        }
                    }
                    return ca.getTime();

                }else{

                    return date;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public  static boolean isInTimeArea(Date date,String startTime,String endTime)
    {


        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int nowHour = ca.get(Calendar.HOUR_OF_DAY);
        int nowMin =  ca.get(Calendar.MINUTE);
        //23:25(HH:mm)

        int startHour = 0;
        int startMin = 0;

        String[] arr = null;
        arr = startTime.split(":");

        startHour = Integer.parseInt(arr[0]);
        startMin = Integer.parseInt(arr[1]);

        int endHour = 0;
        int endMin = 0;
        arr = endTime.split(":");

        endHour = Integer.parseInt(arr[0]);
        endMin = Integer.parseInt(arr[1]);


        //11:32 --> 11:50
        if((nowHour == startHour && startMin <= nowMin) || (nowHour == endHour && endMin > nowMin))
        {
            return true;
        }
        // < end
        boolean isBeforeEnd = false;
        if(nowHour >= 0 && nowHour < endHour)
        {
            isBeforeEnd = true;
        }

        // > start
        boolean isAfterStart = false;
        if(nowHour <= 23 && nowHour > startHour)
        {
            isAfterStart = true;
        }


        if(isBeforeEnd && isAfterStart)
        {
            return true;
        }

        if(startHour > endHour)//23:20 ---- 08:50
        {

            if(nowHour > startHour && nowHour<=23 && endHour > 0)
            {
                return true;
            }
            else if(nowHour >= 0 && nowHour < endHour)
            {
                return true;
            }
        }


        return false;
    }


    public  static boolean isInTimeArea2(Date date,String startTime,String endTime)
    {


        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int nowHour = ca.get(Calendar.HOUR_OF_DAY);
        int nowMin =  ca.get(Calendar.MINUTE);
        //23:25(HH:mm)

        String nowMinStr = "";

        if(nowMin == 0){

            nowMinStr = "00";

        }else if(nowMin < 10){

            nowMinStr = "0"+nowMin;

        }else{

            nowMinStr = String.valueOf(nowMin);
        }

        long nowTimeLong = Long.valueOf(nowHour+""+nowMinStr);

        String[] arr = null;

        arr = startTime.split(":");

        long startTimeLong = Long.valueOf(arr[0]+arr[1]);

        arr = endTime.split(":");

        long endTimeLong = Long.valueOf(arr[0]+arr[1]);



        if(startTimeLong > endTimeLong){

            return !(nowTimeLong < startTimeLong && nowTimeLong > endTimeLong);

        }else if(startTimeLong < endTimeLong){

            return (nowTimeLong >= startTimeLong && nowTimeLong <= endTimeLong);
        }


        return false;

    }

/**
     * 计算时间差
     * @return
     */
    public static long  differenceTime(Date startdate,Date enddate){

        long diff = enddate.getTime() - startdate.getTime();

        long second = diff / 1000 ;

        return second;
    }




    /**
     * 比较日期大小
     *
     * @param DATE1
     * @param DATE2
     * @return
     *  0:参数1 等于参数2
     *  1:参数1大于参数2
     * -1:参数小于参数2
     */
    public static int compare_date(String DATE1, String DATE2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);

            if (dt1.getTime() > dt2.getTime()) {

                return 1;

            } else if (dt1.getTime() < dt2.getTime()) {

                return -1;

            } else {

                return 0;
            }

        } catch (Exception exception) {

            exception.printStackTrace();
        }

        return 0;
    }

    public static boolean isInDateArea(String date,String startDate,String endDate){

        int  compareStartDate = compare_date(date, startDate);

        int  compareEndDate = compare_date(date,endDate);

        boolean result = false;

        if(compareStartDate != -1 && compareEndDate!= 1){

            result = true;
        }

        return result;
    }

/**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static int getWeekOfDate(Date dt) {
        int[] weekDays = {1, 2, 3, 4, 5, 6, 7};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }



    public static String minStr(String minTime,int type)
    {
        int min = Integer.parseInt(minTime);
        String hour = min/60+"";
        String m = min%60+"";
        if(type==0)
        {
            if(hour.length()==1){
                hour ="0"+hour;
            }
            if(m.length()==1)
            {
                m+="0";
            }
            return hour+":"+m;
        }else{
            return hour+"小时"+m+"分钟";
        }

    }



}