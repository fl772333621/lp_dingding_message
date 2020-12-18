package com.lp.dingding.message.schedule;

import com.lp.dingding.message.biz.IDingDingSendMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时调度系统
 *
 * @author mengwei
 */
@Component
public class MessageScheduler {

    private static final Log LOGGER = LogFactory.getLog(MessageScheduler.class);

    private final IDingDingSendMessage dingDingSendMessage;

    public MessageScheduler(IDingDingSendMessage dingDingSendMessage) {
        this.dingDingSendMessage = dingDingSendMessage;
    }

    /**
     * 订餐提醒
     */
    @Scheduled(cron = "0 0 15 ? * 2,3,4,5,6")
    public void orderFood() {
        String result = dingDingSendMessage.sendMessageAtAll("工具人们~ 是时候订餐了~");
        LOGGER.warn(result);
    }

    /**
     * 下班打卡
     */
    @Scheduled(cron = "0 30 18 ? * 2,3,4,5,6")
    public void clockOff() {
        String result = dingDingSendMessage.sendMessageAtAll("工具人们~ 该下班打卡了~");
        LOGGER.warn(result);
    }

    /**
     * 写周报提醒
     */
    @Scheduled(cron = "0 0 18 ? * 6")
    public void weekSummary() {
        String result = dingDingSendMessage.sendMessageAtAll("工具人们~ 下周一的周报写了么~");
        LOGGER.warn(result);
    }
}
