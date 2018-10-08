package com.owl;

import org.quartz.*;

import java.util.TimeZone;

/**
 * Created by houping wang on 2018/9/21
 *
 * @author houping wang
 */
public class CronTriggerExample {

    public static void main(String[] args) {
        //每天8点-17点在小时中每2分钟触发一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?"))
                .forJob("myJob", "group1")
                .build();
        //在每天10:42触发
        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(10, 42))
                .forJob("myJob1", "group1")
                .build();
        //构建触发器将会在每星期三10:42am触发，在默认时区之外
        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(DateBuilder.WEDNESDAY, 10, 42))
                .forJob("myJob2", "group1")
//                .inTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))
                .build();
        //构建触发器将会在每星期三10:42am触发，在默认时区之外:
        Trigger trigger3 = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 42 10 ? * WED"))
//                .inTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))
                .forJob("myJob3", "group1")
                .build();
        //构造触发器时，指定异常处理
        Trigger trigger4 = TriggerBuilder.newTrigger()
                .withIdentity("trigger3", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?")
                        .withMisfireHandlingInstructionFireAndProceed())
                .forJob("myJob", "group1")
                .build();
    }
}
