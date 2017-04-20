package com.hisd.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "tbl_ruleviolation")
public class TblRuleViolation implements java.io.Serializable {

    private Date createdOn;
    private String pageName;
    private int ruleViolationId;
    private long trackLoginId;
    private String violationData;
    private String violationField;
    private String violationFor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false, updatable = false, insertable = false)
    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "pageName", nullable = false, length = 1000)
    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ruleViolationId", unique = true, nullable = false)
    public int getRuleViolationId() {
        return this.ruleViolationId;
    }

    public void setRuleViolationId(int ruleViolationId) {
        this.ruleViolationId = ruleViolationId;
    }

    public TblRuleViolation(int ruleViolationId) {
        this.ruleViolationId = ruleViolationId;
    }

    @Column(name = "trackLoginId", nullable = false)
    public long getTrackLoginId() {
        return this.trackLoginId;
    }

    public void setTrackLoginId(long trackLoginId) {
        this.trackLoginId = trackLoginId;
    }

    @Column(name = "violationData", nullable = false, length = 200)
    public String getViolationData() {
        return this.violationData;
    }

    public void setViolationData(String violationData) {
        this.violationData = violationData;
    }

    @Column(name = "violationField", nullable = false, length = 50)
    public String getViolationField() {
        return this.violationField;
    }

    public void setViolationField(String violationField) {
        this.violationField = violationField;
    }

    @Column(name = "violationFor", nullable = false, length = 50)
    public String getViolationFor() {
        return this.violationFor;
    }

    public void setViolationFor(String violationFor) {
        this.violationFor = violationFor;
    }

    public TblRuleViolation() {
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("createdOn", this.getCreatedOn())
                .append("pageName", this.getPageName())
                .append("ruleViolationId", this.getRuleViolationId())
                .append("trackLoginId", this.getTrackLoginId())
                .append("violationData", this.getViolationData())
                .append("violationField", this.getViolationField())
                .append("violationFor", this.getViolationFor())
                .toString();

    }
}