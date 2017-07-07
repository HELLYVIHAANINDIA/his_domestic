package com.hisd.domestic.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_report")
public class TblReports implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="report_id")
	private int report_id;
	@Column(name="report_name")
	private String report_name;
	@Column(name="reportstatus")
	private int reportstatus;

	
	public TblReports(){
		super();
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public int getReportstatus() {
		return reportstatus;
	}

	public void setReportstatus(int reportstatus) {
		this.reportstatus = reportstatus;
	}
	

}
