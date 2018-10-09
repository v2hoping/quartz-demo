package com.owl;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * Created by houping wang on 2018/10/9
 * 触发器监听.
 * @author houping wang
 */
public class MyTriggerListener implements TriggerListener{

    /**
     * @return 触发器名称.
     */
    @Override
    public String getName() {
        return "MyTriggerListener";
    }

    /**
     * 触发器触发之前.
     */
    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        System.out.println("MyTriggerListener.triggerFired()");
    }

    /**
     * @return false表示执行触发，true表示触发被否决.
     */
    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        System.out.println("MyTriggerListener.vetoJobExecution()");
        return false;
    }

    /**
     * 错过触发.
     */
    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("MyTriggerListener.triggerMisfired()");
    }

    /**
     * 触发完成.
     */
    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("MyTriggerListener.triggerComplete()");
    }
}
