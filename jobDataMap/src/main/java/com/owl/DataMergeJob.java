package com.owl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by houping wang on 2018/9/14
 *
 * @author houping wang
 * 数据.
 */
public class DataMergeJob implements Job{

    private String jobSays;

    private Float myFloatValue;

    /**
     * trigger数据参数.
     */
    private String name;

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(Float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DataJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获得Job的DataMap
        LOGGER.info("jobSays:" + jobSays + "|" + "myFloatValue:" + myFloatValue + "|" + "name:" + name);
    }
}
