package com.ltq.demo.core;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体类基类
 */
public class EntrtyBase implements Serializable {

    private Date createdTime;
    private String createdId;
    private String createdName;


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedId() {
        return createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }
}
