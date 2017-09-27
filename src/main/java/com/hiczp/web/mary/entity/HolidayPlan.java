package com.hiczp.web.mary.entity;

import com.hiczp.web.mary.model.HolidayPlanFormModel;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class HolidayPlan {
    @Id
    @Column(length = 32)
    private String id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 32)
    @Enumerated(EnumType.STRING)
    private WhereToGo whereToGo;

    @Column
    private Date leaveTime;

    @Column
    private Date backTime;

    @Column(length = 128)
    private String ip;

    @Column
    private Timestamp submitTime;

    @Column(length = 32)
    private String holidayName;

    public HolidayPlan() {

    }

    public HolidayPlan(HolidayPlanFormModel holidayPlanFormModel) {
        id = holidayPlanFormModel.getId();
        name = holidayPlanFormModel.getName();
        whereToGo = holidayPlanFormModel.getWhereToGo();
        leaveTime = holidayPlanFormModel.getLeaveTime();
        backTime = holidayPlanFormModel.getBackTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WhereToGo getWhereToGo() {
        return whereToGo;
    }

    public void setWhereToGo(WhereToGo whereToGo) {
        this.whereToGo = whereToGo;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public enum WhereToGo {
        GO_HOME,
        STAY_IN_SCHOOL
    }
}
