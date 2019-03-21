package com.soft863.framework.push.domain;

import java.io.Serializable;


/**
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-21 15:21:21
 */
public class PushDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //消息推送编号
    private Integer pushId;
    //消息编号
    private Integer messageId;
    //推送平台啊
    private String platfrom;
    //推送结果
    private Long result;
    //推送状态
    private Long status;
    //推送人群
    private String audience;
    //推送通知
    private String alter;
    //推送额外信息
    private String extra;
    //推送主题
    private String title;
    //推送的消息
    private String message;

    /**
     * 设置：消息推送编号
     */
    public void setPushId(Integer pushId) {
        this.pushId = pushId;
    }

    /**
     * 获取：消息推送编号
     */
    public Integer getPushId() {
        return pushId;
    }

    /**
     * 设置：消息编号
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取：消息编号
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * 设置：推送平台啊
     */
    public void setPlatfrom(String platfrom) {
        this.platfrom = platfrom;
    }

    /**
     * 获取：推送平台啊
     */
    public String getPlatfrom() {
        return platfrom;
    }

    /**
     * 设置：推送结果
     */
    public void setResult(Long result) {
        this.result = result;
    }

    /**
     * 获取：推送结果
     */
    public Long getResult() {
        return result;
    }

    /**
     * 设置：推送状态
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 获取：推送状态
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置：推送人群
     */
    public void setAudience(String audience) {
        this.audience = audience;
    }

    /**
     * 获取：推送人群
     */
    public String getAudience() {
        return audience;
    }

    /**
     * 设置：推送通知
     */
    public void setAlter(String alter) {
        this.alter = alter;
    }

    /**
     * 获取：推送通知
     */
    public String getAlter() {
        return alter;
    }

    /**
     * 设置：推送额外信息
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * 获取：推送额外信息
     */
    public String getExtra() {
        return extra;
    }

    /**
     * 设置：推送主题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：推送主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置：推送的消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取：推送的消息
     */
    public String getMessage() {
        return message;
    }
}
