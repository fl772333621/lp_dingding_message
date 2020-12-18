package com.lp.dingding.message.biz.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.lp.dingding.message.biz.IDingDingSendMessage;
import com.lp.dingding.message.util.DingDingHttpUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 钉钉消息发送服务
 *
 * @author mengwei
 */
@Service
public class DingDingSendMessageImpl implements IDingDingSendMessage {

    /**
     * 钉钉的webhook
     */
    private static final String DING_DING_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=c14313d55b9b2f2fbb6ff29d73c1075cf0fc8d6147529dae083e2746d822dfad";

    @Override
    public String sendMessageAtAll(String text) {
        // 请求的JSON数据，这里我用map在工具类里转成json格式
        Map<String, Object> json = Maps.newHashMap();
        json.put("msgtype", "text");
        // 钉钉展示的内容
        json.put("text", ImmutableMap.of("content", text));
        // 添加@all
        json.put("at", ImmutableMap.of("isAtAll", true));
        return DingDingHttpUtils.sendPostByMap(DING_DING_TOKEN, json);
    }
}
