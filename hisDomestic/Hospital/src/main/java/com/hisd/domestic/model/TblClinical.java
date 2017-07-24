package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_clinicaldetail")
public class TblClinical implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="clinical_id")
	private int clinical_id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patientid")
	private TblPatient tblPatient;
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
