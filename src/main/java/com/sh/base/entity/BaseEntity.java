package com.sh.base.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public abstract class BaseEntity {
    //ID
    public Integer id;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
