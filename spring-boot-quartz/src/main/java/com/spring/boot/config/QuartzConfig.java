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

@Configuration
public class QuartzConfig {

	@Bean
	public TriggerBuilder<Trigger> trigger() {
		return TriggerBuilder.newTrigger();
	}
    
    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="Scheduler")
    public Scheduler scheduler() throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
        JobDetail oneJob = JobBuilder.newJob(OneJob.class).withIdentity("job1", "group1").build();
        JobDetail secondJob = JobBuilder.newJob(SecondJob.class).withIdentity("job2", "group2").build();
        
        TriggerBuilder<Trigger> newTrigger = trigger();
        
		Trigger oneTrigger = newTrigger.withIdentity("trigger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
		Trigger secondTrigger = newTrigger.withIdentity("trigger2", "group2")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/4 * * * * ?")).build();
		
		scheduler.scheduleJob(oneJob, oneTrigger);
		scheduler.scheduleJob(secondJob, secondTrigger);
		
		scheduler.start();
		
		return scheduler;
    }
	
}
