package com.owl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.KeyMatcher;
import org.quartz.impl.matchers.OrMatcher;
import org.quartz.impl.matchers.StringMatcher;

/**
 * Created by houping wang on 2018/10/9
 *
 * @author houping wang
 */
public class JobListenerExample {

    public static void main(String[] args) throws SchedulerException {
        Scheduler simpleScheduler = StdSchedulerFactory.getDefaultScheduler();
        //Job
        JobDetail job = JobBuilder.newJob(Job.class).withIdentity("job1", "group1").build();
        //Trigger
        Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("trigger1", "group1").build();
        simpleScheduler.scheduleJob(job, trigger);
        simpleScheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("job1", "group1")));
        //开始任务
        simpleScheduler.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simpleScheduler.shutdown();
    }
}
