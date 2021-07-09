/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.dao.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * app_monitor_dept.
 *
 * @author autoCode
 * @version 1.0.5
 */
@TableName("app_monitor_dept")
public class AppMonitorDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长主键.
     */
    @TableId(value = "`id`", type = IdType.AUTO)
    private Long id;

    /**
     * 所属项目部的名称.
     */
    @TableField("`deptName`")
    private String deptName;


    /**
     * 设置自增长主键.
     *
     * @param id 自增长主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取自增长主键.
     *
     * @return id  自增长主键
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置所属项目部的名称.
     *
     * @param deptName 所属项目部的名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取所属项目部的名称.
     *
     * @return deptName  所属项目部的名称
     */
    public String getDeptName() {
        return this.deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("deptName", getDeptName())
                .toString();
    }
}

