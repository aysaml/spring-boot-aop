package com.jd.tms.product.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * 项目信息实体对象:
 * 对应的表:tms_projects
 *
 * @author wangning113
 * @since 2017/12/10
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 5850357988911265658L;
    /**
     * 项目id
     */
    private String id;
    /**
     * 项目名称
     */
    private String proname;
    /**
     * 状态信息
     */
    private String state;
    /**
     * 备注信息
     */
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProname() {
        return proname;
    }

    public void setPrname(String proname) {
        this.proname = proname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", proname='" + proname + '\'' +
                ", state='" + state + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
