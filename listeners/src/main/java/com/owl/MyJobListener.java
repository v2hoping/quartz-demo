package com.owl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by houping wang on 2018/10/9
 * Job监听类.
 * @author houping wang
 */
public class MyJobListener implements JobListener {

    /**
     * @return Job监听的名称
     */
    @Override
    public String getName() {
        return "MyJobListener";
    }

    /**
     * 在Job即将被执行时调用.
     * @param context context
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("MyJobListener.jobToBeExecuted()");
    }

    /**
     * 在Job即将被执行又被Trigger否决时调用》
     * @param context context.
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("MyJobListener.jobExecutionVetoed()");
    }

    /**
     * 在Job完成后执行.
     * @param context context
     * @param jobException jobException
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("MyJobListener.jobWasExecuted()");
    }
}
