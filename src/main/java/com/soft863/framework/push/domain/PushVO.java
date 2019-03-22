package com.soft863.framework.push.domain;

import java.io.Serializable;

/**
 * @ClassName: PushVO
 * @Author
 * @Date 2019/3/22 0022 10:38
 */
public class PushVO implements Serializable {
    /**
     * 平台类型
     */
    private String type;
    /**
     * 消息（通用）
     */
    private String message;
    private String title;
    /**
     * 目标群众
     */
    private String targetType;
    private String messageConetent;
    /**
     * true为已发送，false是未发送
     */
    private boolean isSend;
    /**
     * tag或者alias
     */
    private String targetArray;
    /**
     * 额外功能的key和value
     */
    private String extraKey;
    private String extraValue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getMessageConetent() {
        return messageConetent;
    }

    public void setMessageConetent(String messageConetent) {
        this.messageConetent = messageConetent;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public String getTargetArray() {
        return targetArray;
    }

    public void setTargetArray(String targetArray) {
        this.targetArray = targetArray;
    }

    public String getExtraKey() {
        return extraKey;
    }

    public void setExtraKey(String extraKey) {
        this.extraKey = extraKey;
    }

    public String getExtraValue() {
        return extraValue;
    }

    public void setExtraValue(String extraValue) {
        this.extraValue = extraValue;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PushVO{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", targetType='" + targetType + '\'' +
                ", messageConetent='" + messageConetent + '\'' +
                ", isSend=" + isSend +
                ", targetArray='" + targetArray + '\'' +
                ", extraKey='" + extraKey + '\'' +
                ", extraValue='" + extraValue + '\'' +
                '}';
    }
}

