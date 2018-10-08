package com.owl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by houping wang on 2018/9/14
 *
 * @author houping wang
 * job dataMap使用set方法赋值.
 */
public class JobDataMapSetExample {

    public static void main(String[] args) {

        try {
            Scheduler simpleScheduler = StdSchedulerFactory.getDefaultScheduler();
            simpleScheduler.start();
            //job
            JobDetail job = JobBuilder
                    .newJob(DataSetJob.class)
                    .withIdentity("myJob", "group1") // name "myJob", group "group1"
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();
            //trigger
            SimpleTrigger simpleTrigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .repeatForever()
                            .withIntervalInSeconds(10))
                    .build();
            //当不shutdown时，应用将不能终止
            simpleScheduler.scheduleJob(job, simpleTrigger);
            Thread.sleep(60000);
            simpleScheduler.shutdown();
        } catch (SchedulerException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
