package com.example.billiardclubapi.config;

import com.example.billiardclubapi.job.ReservationCompleteJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail ReservationCompleteJobDetail() {
        return JobBuilder.newJob(ReservationCompleteJob.class)
                .withIdentity("reservationCompleteJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger reservationCompleteJobTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/10 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(ReservationCompleteJobDetail())
                .withIdentity("reservationCompleteTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public Scheduler scheduler(SchedulerFactoryBean factory) throws SchedulerException {
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(ReservationCompleteJobDetail(), reservationCompleteJobTrigger());
        return scheduler;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactory(SpringBeanJobFactory jobFactory) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean
    public SpringBeanJobFactory jobFactory() {
        return new SpringBeanJobFactory();
    }
}