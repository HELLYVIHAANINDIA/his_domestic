package com.hisd.domestic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_appointment")
public class TblAppointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appid")
	private int appid;
	@Column(name = "status")
	private int status;
	@Column(name = "appdate")
	private Date appdate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate")
	private Date createddate = new Date();
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "casetypeid")
	private TblCaseType tblCaseType;
	
	@JoinColumn(name = "reseaon")
	private String reseaon;

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

	public Date getAppdate() {
		return appdate;
	}

	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public TblCaseType getTblCaseType() {
		return tblCaseType;
	}

	public void setTblCaseType(TblCaseType tblCaseType) {
		this.tblCaseType = tblCaseType;
	}

	public String getReseaon() {
		return reseaon;
	}

	public void setReseaon(String reseaon) {
		this.reseaon = reseaon;
	}

	

	
}
