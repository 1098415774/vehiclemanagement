package com.sh.base.form;

import com.sh.base.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public abstract class BaseForm<T extends BaseEntity> {

    protected T entity;

    public Integer id;
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
    /*
    * Form对象转entity对象
    * */
    public void FormToEntity(T entity) throws Exception{
        entity.setId(id);
        entity.setCreateTime(new Date());
    }


}
