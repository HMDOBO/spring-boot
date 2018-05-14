package com.spring.boot.scheduler;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.spring.boot.job.HelloJob;

@Component
public class Scheduler {
	
	@Autowired
    SchedulerFactoryBean schedulerFactoryBean;

	@PostConstruct
    public void scheduleJobs() throws SchedulerException {
		
        org.quartz.Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobArg", "world");
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .setJobData(jobDataMap)
                .withDescription("demo")
                .withIdentity("demo-job", "demo-group")
                .build();
        
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();
        
        if(!scheduler.checkExists(JobKey.jobKey("demo-job","demo-group"))){
            scheduler.scheduleJob(jobDetail,trigger);
        }
        
        scheduler.start();
    }

}
