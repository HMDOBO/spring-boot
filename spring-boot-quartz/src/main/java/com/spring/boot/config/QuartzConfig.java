package com.spring.boot.config;


import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.job.OneJob;
import com.spring.boot.job.SecondJob;
/**
 * Quartz配置文件.<p/>
 * 
 * 创建时间：2018年5月16日
 */
@Configuration
public class QuartzConfig {

	@Bean
	public TriggerBuilder<Trigger> trigger() {
		return TriggerBuilder.newTrigger();
	}
    
    /**
     * 开始调度任务
     * 
     * <li>job具体执行任务</li>
     * <li>trigger触发器</li>
     * <li>scheduler调度器</li>
     * @return
     * @throws Exception
     */
    @Bean(name="Scheduler")
    public Scheduler scheduler() throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
        // 获取具体要执行的job
        JobDetail oneJob = JobBuilder.newJob(OneJob.class).withIdentity("job1", "group1").build();
        JobDetail secondJob = JobBuilder.newJob(SecondJob.class).withIdentity("job2", "group2").build();
        
        // 定义具体触发器
        TriggerBuilder<Trigger> newTrigger = trigger();
		Trigger oneTrigger = newTrigger.withIdentity("trigger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
		Trigger secondTrigger = newTrigger.withIdentity("trigger2", "group2")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/4 * * * * ?")).build();
		
		// Scheduler将具体的job匹配对应的触发器Trigger
		scheduler.scheduleJob(oneJob, oneTrigger);
		scheduler.scheduleJob(secondJob, secondTrigger);
		
		// 开始调度任务
		scheduler.start();
		
		return scheduler;
    }
	
}
