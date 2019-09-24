package com.ltq.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 自动任务调度测试类
 */
@Component
@EnableScheduling // 开启定时任务功能
public class TestJob {
    Logger logger = LoggerFactory.getLogger(getClass());
    private int i;

    @Scheduled(cron = "0/10 * * * * ?")
    public void execute() {
        logger.info("FixedPrintTask execute times:{}", ++i);
    }
}
