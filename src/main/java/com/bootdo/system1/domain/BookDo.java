package com.bootdo.system1.domain;

import com.google.common.eventbus.AllowConcurrentEvents;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class BookDo implements Serializable {
    /*
        图书id
     */
    private Long bookId;
    /*
        图书名
     */
    private String bookName;
    /*
        图书状态，0为上架，1为下架
     */
    private Integer status;
    /*
        图书描述
     */
    private String bookDesc;
    /*
        上架时间
     */
    @DateTimeFormat(pattern = "yyyy-dd-MM HH:mm:ss")
    private Date gmtGrounding;

    @DateTimeFormat(pattern = "yyyy-dd-MM HH:mm:ss")
    private Date gmtUpdate;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Date getGmtGrounding() {
        return gmtGrounding;
    }

    public void setGmtGrounding(Date gmtGrounding) {
        this.gmtGrounding = gmtGrounding;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Override
    public String toString() {
        return "BookDo{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", status=" + status +
                ", bookDesc='" + bookDesc + '\'' +
                ", gmtGrounding=" + gmtGrounding +
                ", gmtUpdate=" + gmtUpdate +
                '}';
    }
}
