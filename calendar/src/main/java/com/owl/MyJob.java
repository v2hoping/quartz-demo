package com.owl;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by houping wang on 2018/9/19
 *
 * @author houping wang
 */
public class MyJob implements Job{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("MyJob执行");
    }
}
