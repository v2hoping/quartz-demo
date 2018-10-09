package com.owl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * Created by houping wang on 2018/10/9
 *
 * @author houping wang
 */
public class SchedulerListenerExample {

    public static void main(String[] args) throws SchedulerException {
        //工厂获取调度程序
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.getListenerManager().addSchedulerListener(new MySchedulerListener());
        //Job
        JobDetail job = JobBuilder.newJob(Job.class).withIdentity("job1", "group1").build();
        //Trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").build();
        defaultScheduler.scheduleJob(job, trigger);
        //开始
        defaultScheduler.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        defaultScheduler.shutdown();
    }
}
