package com.greenproject.model;

import java.util.Date;

public class Project {
    private Integer id;
    private String type;
    private Integer cost;
    private String scale;
    private String location;
    private Date startDate;
    private Date endDate;
    private Boolean isApproved;

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Project() {}

    public Project(Integer id, String type, Integer cost, String scale, String location, Date startDate, Date endDate, Boolean isApproved) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.scale = scale;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isApproved = isApproved;
    }
}
