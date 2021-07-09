package com.eeeffff.monitor.eklogmonitor.common.enums;

/**
 * 钉钉机器人消息类型
 * @author fenglibin
 *
 */
public enum RobotMsgTypeEnum {

    TEXT("text"),
    LINK("link"),
    MARKDOWN("markdown");

    private String text;

    RobotMsgTypeEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}