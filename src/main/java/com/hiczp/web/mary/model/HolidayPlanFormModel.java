package com.hiczp.web.mary.model;

import com.hiczp.web.mary.entity.HolidayPlan;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Component
public class HolidayPlanFormModel {
    @NotNull
    private String id;

    @NotEmpty
    private String name;

    @NotNull
    private HolidayPlan.WhereToGo whereToGo;

    private Date leaveTime;

    private Date backTime;

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

    public HolidayPlan.WhereToGo getWhereToGo() {
        return whereToGo;
    }

    public void setWhereToGo(HolidayPlan.WhereToGo whereToGo) {
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
}
