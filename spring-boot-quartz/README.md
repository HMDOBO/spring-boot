# spring-boot整合Quartz

### 简单整合步骤
1. 添加maven依赖

	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-context-support</artifactId>
	</dependency>
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-tx</artifactId>
	</dependency>
	<dependency>
		<groupId>org.quartz-scheduler</groupId>
		<artifactId>quartz</artifactId>
		<version>2.2.3</version>
	</dependency>

2. 创建job类，实现org.quartz.Job

	public class OneJob implements Job {
	
		@Override
		public void execute(JobExecutionContext context) throws JobExecutionException {
			System.out.println("=====One Job执行时间: " + new Date() + "=====");
		}
	
	}
3. 配置Quartz，注入Spring

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
