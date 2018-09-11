package com.owl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by houping wang on 2018/9/11
 *
 * @author houping wang
 */
public class SampleJobExample {

    public static void main(String[] args) {

        try {
            Scheduler simpleScheduler = StdSchedulerFactory.getDefaultScheduler();
            simpleScheduler.start();
            //job
            JobDetail job = JobBuilder
                    .newJob(HelloJob.class)
                    .build();
            //trigger
            SimpleTrigger simpleTrigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .repeatForever()
                            .withIntervalInSeconds(10)).build();
            //当不shutdown时，应用将不能终止
            simpleScheduler.scheduleJob(job, simpleTrigger);
            Thread.sleep(60000);
            simpleScheduler.shutdown();
        } catch (SchedulerException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
