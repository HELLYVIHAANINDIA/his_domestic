package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_consultingdoctor")
public class TblConsultingDoctor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="consultingdoctorid")
	private int consultingdoctorid;
	@Column(name="consultingdoctorname")
	private String consultingdoctorname;
	@Column(name="userid")
	private long userid;
	 public TblConsultingDoctor(){
		 super();
	 }
	public TblConsultingDoctor(int consltingDoctorId) {
		this.consultingdoctorid = consltingDoctorId;
	}
	public int getConsultingdoctorid() {
		return consultingdoctorid;
	}
	public void setConsultingdoctorid(int consultingdoctorid) {
		this.consultingdoctorid = consultingdoctorid;
	}
	public String getConsultingdoctorname() {
		return consultingdoctorname;
	}
	public void setConsultingdoctorname(String consultingdoctorname) {
		this.consultingdoctorname = consultingdoctorname;
	}
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(consultingdoctorid);
	        sb.append("]:"); 
	        sb.append(consultingdoctorname);
	        return sb.toString(); 
	}
}
