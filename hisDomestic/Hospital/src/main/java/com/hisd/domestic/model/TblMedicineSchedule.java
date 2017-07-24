package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_medicineschedule")
public class TblMedicineSchedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="seduleid")
	private int seduleid;
	@Column(name ="medicineschedule")
	private String medicineschedule;
	@Column(name="status")
	private int status;
	public int getSeduleid() {
		return seduleid;
	}
	public void setSeduleid(int seduleid) {
		this.seduleid = seduleid;
	}
	
	public String getMedicineschedule() {
		return medicineschedule;
	}
	public void setMedicineschedule(String medicineschedule) {
		this.medicineschedule = medicineschedule;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
