package com.example.nativeqry.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.List;


@EnableScheduling
@Component
@Slf4j
public class ThreadPoolMonitoring {

    @Autowired
    List<ThreadPoolTaskExecutor> threadPoolTaskExecutors;

    @Autowired
    ThreadPoolTaskScheduler threadPoolTaskScheduler;

  //  @Scheduled(fixedDelayString = "${MONITOR.REFRESH.DELAY:20000}")
    public void monitorMessageAdaptorThreadPool() {
        showThreadPoolCount();
    }

    private void showThreadPoolCount() {
        log.info("******************************************** \r\n \r\n");
        threadPoolTaskExecutors.forEach(threadPool -> {
            if (threadPool != null) {
                int queueSize = threadPool.getThreadPoolExecutor().getQueue().size();
                int remainingSize = threadPool.getThreadPoolExecutor().getQueue().remainingCapacity();
                //int total = queueSize + remainingSize;
                log.info(threadPool.getThreadNamePrefix() +
                        "::Active-Count::" + threadPool.getActiveCount() +
                        "::Pool-Size::" + threadPool.getPoolSize() +
                        "::Core-Pool-Size::" + threadPool.getPoolSize() +
                        "::Queue-Size::" + queueSize +
                        "\n\r::Remaining-Size::" + remainingSize);
            }
        });
        log.info(threadPoolTaskScheduler.getThreadNamePrefix() +
                "::Active-Count::" + threadPoolTaskScheduler.getScheduledThreadPoolExecutor().getActiveCount() +
                "::Pool-Size::" + threadPoolTaskScheduler.getScheduledThreadPoolExecutor().getPoolSize() +
                "::Core-Pool-Size::" + threadPoolTaskScheduler.getScheduledThreadPoolExecutor().getCorePoolSize() +
                "::Queue-Size::" + threadPoolTaskScheduler.getScheduledThreadPoolExecutor().getQueue().size() +
                "::Remaining-Size::" + threadPoolTaskScheduler.getScheduledThreadPoolExecutor().getQueue().remainingCapacity());
        //  log.info("CAS RequestHolder Count: " + RequestsHolder.XB_REST_REQ_HOLDER.keySet().size() + " XB Rest RequestHolder Count: " + RequestsHolder.XB_REST_REQ_HOLDER.keySet().size());
    }
}
