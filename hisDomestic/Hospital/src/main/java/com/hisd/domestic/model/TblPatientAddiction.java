package com.hisd.domestic.model;
import java.io.Serializable;

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
@Table(name="tbl_patientaddiction")
public class TblPatientAddiction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="patientaddictionid")
	private int patientaddictionid;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="addictionid")
	private TblAddiction tblAddiction;
	
	@Column(name = "patientid")
	private Integer patientid;
	
	public TblPatientAddiction(){
		super();
	}
	
	public TblPatientAddiction(Integer patientid){
		this.patientid=patientid;
	}
	
	public int getPatientaddictionid() {
		return patientaddictionid;
	}
	public void setPatientaddictionid(int patientaddictionid) {
		this.patientaddictionid = patientaddictionid;
	}

	public TblAddiction getTblAddiction() {
		return tblAddiction;
	}
	public void setTblAddiction(TblAddiction tblAddiction) {
		this.tblAddiction = tblAddiction;
	}
	public Integer getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	
	

}
