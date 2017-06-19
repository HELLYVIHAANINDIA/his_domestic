package com.hisd.domestic.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_clinical")
public class TblClinical implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="clinical_id")
	private int clinical_id;
	@Column(name="patientid")
	private TblPatient tblPatient;
	@Column(name="clinicaldetailid")
	private int clinicaldetailid;
	@Column(name="statusId")
	private int statusId;
	@Column(name="history")
	private String history;
	@Column(name="comments")
	private String comments;
	@Column(name="remark")
	private String remark;
	
	public TblClinical(){
		super();
	}

	public int getClinical_id() {
		return clinical_id;
	}

	public void setClinical_id(int clinical_id) {
		this.clinical_id = clinical_id;
	}

	public TblPatient getTblPatient() {
		return tblPatient;
	}

	public void setTblPatient(TblPatient tblPatient) {
		this.tblPatient = tblPatient;
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

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	
}
