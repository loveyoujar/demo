package com.ltq.demo.util.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 自动任务调度测试类
 * EnableScheduling 开启定时任务功能
 * @author LTQ
 */
@Component
@EnableScheduling
public class TestJob {
    Logger logger = LoggerFactory.getLogger(getClass());
    private int i;

    @Scheduled(cron = "0 * * * * ? ")
    public void execute() {
        logger.info("The application has been running for {} minute!", ++i);
    }
}
