package com.owl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by houping wang on 2018/10/9
 *
 * @author houping wang
 */
public class Job implements org.quartz.Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("调度任务执行！！！");
    }
}
