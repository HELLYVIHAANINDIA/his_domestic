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
@Table(name = "tbl_exceptionlog")
public class TblExceptionLog implements java.io.Serializable {

    private String className;
    private int createdBy;
    private Date createdOn;
    private String errorMessage;
    private int exceptionLogId;
    private String fileName;
    private int lineNumber;
    private int linkId;
    private String method;

    @Column(name = "className", nullable = false, length = 100)
    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    
    @Column(name = "createdBy", nullable = false)
    public int getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false,insertable=false,updatable=false)
    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "errorMessage", nullable = false, length = 500)
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Id
    @GeneratedValue
    @Column(name = "exceptionLogId", unique = true, nullable = false)
    public int getExceptionLogId() {
        return this.exceptionLogId;
    }

    public void setExceptionLogId(int exceptionLogId) {
        this.exceptionLogId = exceptionLogId;
    }

    public TblExceptionLog(int exceptionLogId) {
        this.exceptionLogId = exceptionLogId;
    }

    @Column(name = "fileName", nullable = false, length = 100)
    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "lineNumber", nullable = false)
    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Column(name = "linkId", nullable = false)
    public int getLinkId() {
        return this.linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    @Column(name = "method", nullable = false, length = 100)
    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public TblExceptionLog() {
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("className", this.getClassName())
                .append("createdBy", this.getCreatedBy())
                .append("createdOn", this.getCreatedOn())
                .append("errorMessage", this.getErrorMessage())
                .append("exceptionLogId", this.getExceptionLogId())
                .append("fileName", this.getFileName())
                .append("lineNumber", this.getLineNumber())
                .append("linkId", this.getLinkId())
                .append("method", this.getMethod())
                .toString();

    }
}
