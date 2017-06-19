package com.hisd.domestic.databean;

import com.hisd.domestic.model.TblPatient;

public class Clinicalbean {
	private int clinical_id;
	private int patientid;
	private int clinicaldetailid;
	private int statusId;
	private String txthistory;
	private String txtcomments;
	private String txtremark;
	private int complaintsid;
	private String complaintsname;
	private int medicine_id;
	private String medicine_name;
	private int report_id;
	private String report_name;
	private String[] comlaintsList;
	private String[] medicineList;
	private String[] reportList;
	public int getClinical_id() {
		return clinical_id;
	}
	public void setClinical_id(int clinical_id) {
		this.clinical_id = clinical_id;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getClinicaldetailid() {
		return clinicaldetailid;
	}
	public void setClinicaldetailid(int clinicaldetailid) {
		this.clinicaldetailid = clinicaldetailid;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getTxthistory() {
		return txthistory;
	}
	public void setTxthistory(String txthistory) {
		this.txthistory = txthistory;
	}
	public String getTxtcomments() {
		return txtcomments;
	}
	public void setTxtcomments(String txtcomments) {
		this.txtcomments = txtcomments;
	}
	public String getTxtremark() {
		return txtremark;
	}
	public void setTxtremark(String txtremark) {
		this.txtremark = txtremark;
	}
	public int getComplaintsid() {
		return complaintsid;
	}
	public void setComplaintsid(int complaintsid) {
		this.complaintsid = complaintsid;
	}
	public String getComplaintsname() {
		return complaintsname;
	}
	public void setComplaintsname(String complaintsname) {
		this.complaintsname = complaintsname;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
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
	public String[] getComlaintsList() {
		return comlaintsList;
	}
	public void setComlaintsList(String[] comlaintsList) {
		this.comlaintsList = comlaintsList;
	}
	public String[] getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(String[] medicineList) {
		this.medicineList = medicineList;
	}
	public String[] getReportList() {
		return reportList;
	}
	public void setReportList(String[] reportList) {
		this.reportList = reportList;
	}
	
	
	

}
