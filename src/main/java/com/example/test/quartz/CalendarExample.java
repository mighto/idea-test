package com.example.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author mistaker
 * @description：
 * @create 2018/04/09
 */
public class CalendarExample {

    public static void main(String[] args){
        try{
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();
            //法定节日是以每年为周期的，所以使用AnnualCalendar
            AnnualCalendar holidays = new AnnualCalendar();

            //五一劳动节
            Calendar laborDay = new GregorianCalendar();
            laborDay.add(Calendar.MONTH, 5);
            laborDay.add(Calendar.DATE, 1);

            //国庆节
            Calendar nationalDay = new GregorianCalendar();
            nationalDay.add(Calendar.MONTH, 10);
            nationalDay.add(Calendar.DATE, 1);

            ArrayList<Calendar> calendars = new ArrayList<>();
            calendars.add(laborDay);
            calendars.add(nationalDay);
            holidays.setDaysExcluded(calendars);

            //向 Scheduler注册日历
            scheduler.addCalendar("holidays", holidays, false, false);
            //4月1日上午10点
            Date runDate = TriggerUtils.getDateOf(0,0, 10, 1, 4);
            JobDetail job = new JobDetail("job1", "group1", SimpleJob.class);
            SimpleTrigger trigger = new SimpleTrigger("trigger1", "group1",
                                            runDate,
                                            null,
                                            SimpleTrigger.REPEAT_INDEFINITELY,
                                            60L * 60L * 1000L);
            //让Trigger应用指定的日历规则
            trigger.setCalendarName("holidays");
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
            //在实际应用中主线程不能停止，否则Schedule得不到执行。
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
