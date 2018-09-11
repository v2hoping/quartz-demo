package com.owl;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by houping wang on 2018/9/11
 *
 * @author houping wang
 */
public class SampleExample {

    public static void main(String[] args) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.start();
            //当不shutdown时，应用将不能终止
            defaultScheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
