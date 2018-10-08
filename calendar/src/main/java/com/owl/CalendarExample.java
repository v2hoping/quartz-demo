package com.owl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by houping wang on 2018/9/19
 *
 * @author houping wang
 */
public class CalendarExample {

    public static void main(String[] args) {
        try {
            //获取后一分钟的时间
            Date now = new Date();
            Calendar calendarDate = Calendar.getInstance();
            calendarDate.setTime(now);
            calendarDate.add(Calendar.MINUTE, 1);
            calendarDate.set(Calendar.SECOND, 0);
            Date time = calendarDate.getTime();
            //排除当日节假日
            HolidayCalendar calendar = new HolidayCalendar();
            calendar.addExcludedDate(time);
            Scheduler simpleScheduler = StdSchedulerFactory.getDefaultScheduler();
            simpleScheduler.addCalendar("holiday", calendar, false, false);
            simpleScheduler.start();
            //job
            JobDetail job = JobBuilder
                    .newJob(MyJob.class)
                    .withIdentity("myJob") // name "myJob"
                    .build();
            //trigger
            SimpleTrigger simpleTrigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("trigger")
                    .forJob("myJob")
                    .modifiedByCalendar("holiday")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .repeatForever()
                            .withIntervalInSeconds(1))
                    .build();
            //当不shutdown时，应用将不能终止

            simpleScheduler.scheduleJob(job, simpleTrigger);
            Thread.sleep(100000);
            simpleScheduler.shutdown();
        } catch (SchedulerException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
