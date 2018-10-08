package com.owl;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by houping wang on 2018/9/11
 *
 * @author houping wang
 */
public class DataJob implements Job{

    private static final Logger LOGGER = LoggerFactory.getLogger(DataJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获得Job的DataMap
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        String jobSays = jobDataMap.getString("jobSays");
        Float myFloatValue = jobDataMap.getFloat("myFloatValue");

        LOGGER.info("jobSays:" + jobSays + "|" + "myFloatValue:" + myFloatValue);
    }
}
