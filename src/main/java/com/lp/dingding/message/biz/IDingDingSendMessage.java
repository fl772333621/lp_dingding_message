package com.lp.dingding.message.biz;

/**
 * 钉钉消息发送服务
 *
 * @author mengwei
 */
public interface IDingDingSendMessage {

    /**
     * 发送消息
     *
     * @param text 消息内容
     * @return 响应内容
     */
    String sendMessageAtAll(String text);
}
