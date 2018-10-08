package com.owl;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by houping wang on 2018/9/14
 *
 * @author houping wang
 */
public class DataSetJob implements Job{

    private String jobSays;

    private Float myFloatValue;

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(Float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DataJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获得Job的DataMap
        LOGGER.info("jobSays:" + jobSays + "|" + "myFloatValue:" + myFloatValue);
    }
}
