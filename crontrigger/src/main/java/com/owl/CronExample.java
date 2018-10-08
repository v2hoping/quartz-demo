package com.owl;

import com.alibaba.fastjson.JSON;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by houping wang on 2018/9/21
 *
 * @author houping wang
 */
public class CronExample {

    private static final String CRON = "0 0/5 * * * ?";

    private static final String CRON1 = "10 0/5 * * * ?";

    private static final String CRON2 = "0 30 10-13 ? * WED,FRI";

    private static final String CRON3 = "0 0/30 8-9 5,20 * ?";

    public static void main(String[] args) throws ParseException {
        printCron5(CRON);
        printCron5(CRON1);
        printCron5(CRON2);
        printCron5(CRON3);
    }

    private static void printCron5(String cron) throws ParseException {
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setCronExpression(cron);
        List<Date> dates = TriggerUtils.computeFireTimes(cronTrigger, null, 5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("====" + cron + "===");
        for(Date date : dates) {
            System.out.println(simpleDateFormat.format(date));
        }
    }

}
