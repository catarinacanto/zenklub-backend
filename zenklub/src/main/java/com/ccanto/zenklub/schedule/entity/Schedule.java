package com.ccanto.zenklub.schedule.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Table(name = "zk_schedule")
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long fkProfessionalId;

    @Column(nullable = false)
    private String days;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkProfessionalId() {
        return fkProfessionalId;
    }

    public void setFkProfessionalId(Long fkProfessionalId) {
        this.fkProfessionalId = fkProfessionalId;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", fkProfessionalId=" + fkProfessionalId +
                ", days='" + days + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
