package com.example.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/29
 */
public class SimpleTriggerRunner {

    public static void main(String[] args){
        try{
            //创建一个JobDetail实例，指定SimpleJob
            JobDetail jobDetail = new JobDetail("job_1", "jgroup1", SimpleJob.class);
            //通过SimpleTrigger定义调度规则，马上启动，每2秒运行一次，共运行10次。
            SimpleTrigger simpleTrigger = new SimpleTrigger("trigger_1", "tgroup1");
            simpleTrigger.setStartTime(new Date());
            simpleTrigger.setRepeatInterval(2000);
            simpleTrigger.setRepeatCount(10);
//            simpleTrigger.setJobGroup(); //指定关联的Job组名
//            simpleTrigger.setJobName(); //指定关联的Job名称
            //通过SchedulerFactory获取一个调度器实例
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
//            scheduler.addJob(jobDetail, true);  //注册JobDetail
//            scheduler.scheduleJob(simpleTrigger); //注册指定了关联JobDetail的Trigger
            //注册并进行调度
            scheduler.scheduleJob(jobDetail, simpleTrigger);
            //调度启动
            scheduler.start();
        }catch (SchedulerException e){
            e.printStackTrace();
        }
    }

}
