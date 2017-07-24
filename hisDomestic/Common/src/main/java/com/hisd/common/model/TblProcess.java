package com.hisd.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Process")
public class TblProcess implements java.io.Serializable {

    private int processId;
    private String processName;
    private int isActive;
    private String tableName;
    private String processText;
    
    public TblProcess(int processId){
    	this.setProcessId(processId);
    }

    public TblProcess(){
    }

    @Column(name="processText")
    public String getProcessText() {
		return processText;
	}

	public void setProcessText(String processText) {
		this.processText = processText;
	}

	@Column(name="tableName")
    public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Id
    @GeneratedValue
    @Column(name="processId",unique=true,nullable=false)
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	@Column(name="processName")
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	@Column(name="isActive")
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
