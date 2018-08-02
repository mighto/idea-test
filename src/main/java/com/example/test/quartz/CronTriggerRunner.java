package com.example.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/30
 */
public class CronTriggerRunner {

    public static void main(String[] args){
        try{
            JobDetail jobDetail = new JobDetail("job_2", "group2", SimpleJob.class);
            //创建CronTrigger，指定组及名称
            CronTrigger cronTrigger = new CronTrigger("trigger2", "group2");
            //定义Cron表达式
            CronExpression cexp = new CronExpression("0/10 * * * * ?");
            //设置Cron表达式
            cronTrigger.setCronExpression(cexp);
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
            //Thread.currentThread.sleep(); //主线程休眠
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
