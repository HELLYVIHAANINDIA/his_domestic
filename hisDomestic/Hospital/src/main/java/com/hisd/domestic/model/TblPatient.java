package com.hisd.domestic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.hisd.domestic.model.TblConsultingDoctor;
import com.hisd.domestic.model.TblUser;

@Entity
@Table(name = "tbl_patient")
public class TblPatient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patientid")
	private int patientid;
	@Column(name = "patientcrno")
	private String patientcrno;
	@Column(name = "regdate")
	private Date regdate;
	@Column(name = "age")
	private int age;
	@Column(name = "referenceid")
	private int referenceid;
	@Column(name = "socialeconomicstatusid")
	private int socialeconomicstatusid;
	@Column(name = "paybyid")
	private int paybyid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consultingdoctorid")
	private TblConsultingDoctor tblConsultingDoctor;
	@Column(name = "isdiabetic")
	private int isdiabetic;
	@Column(name = "ishignbp")
	private int ishignbp;
	@Column(name="refothersname")
	private String refothersname;
	@Column(name="patbyname")
	private String patbyname;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetailid")
	private TblUser tblUser;
	@Column(name ="appid")
	private int appid;
	@Column(name ="addictionother")
	private String addictionother;

	public TblPatient(){
		super();
	}
	public TblPatient(int patientid){
		this.patientid=patientid;
	}
	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getPatientcrno() {
		return patientcrno;
	}

	public void setPatientcrno(String patientcrno) {
		this.patientcrno = patientcrno;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getReferenceid() {
		return referenceid;
	}

	public void setReferenceid(int referenceid) {
		this.referenceid = referenceid;
	}

	public int getSocialeconomicstatusid() {
		return socialeconomicstatusid;
	}

	public void setSocialeconomicstatusid(int socialeconomicstatusid) {
		this.socialeconomicstatusid = socialeconomicstatusid;
	}

	public int getPaybyid() {
		return paybyid;
	}

	public void setPaybyid(int paybyid) {
		this.paybyid = paybyid;
	}

	

	public int getIsdiabetic() {
		return isdiabetic;
	}

	public void setIsdiabetic(int isdiabetic) {
		this.isdiabetic = isdiabetic;
	}

	public int getIshignbp() {
		return ishignbp;
	}

	public void setIshignbp(int ishignbp) {
		this.ishignbp = ishignbp;
	}


	public TblConsultingDoctor getTblConsultingDoctor() {
		return tblConsultingDoctor;
	}

	public void setTblConsultingDoctor(TblConsultingDoctor consultingdoctorid) {
		this.tblConsultingDoctor = consultingdoctorid;
	}

	public TblUser getTblUser() {
		return tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}
	public String getRefothersname() {
		return refothersname;
	}
	public void setRefothersname(String refothersname) {
		this.refothersname = refothersname;
	}
	public String getPatbyname() {
		return patbyname;
	}
	public void setPatbyname(String patbyname) {
		this.patbyname = patbyname;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getAddictionother() {
		return addictionother;
	}
	public void setAddictionother(String addictionother) {
		this.addictionother = addictionother;
	}
	@Override
	public String toString() {
		return "TblPatient [patientid=" + patientid + ", patientcrno="
				+ patientcrno + ", regdate=" + regdate + ", age=" + age
				+ ", referenceid=" + referenceid + ", socialeconomicstatusid="
				+ socialeconomicstatusid + ", paybyid=" + paybyid
				+ ", tblConsultingDoctor=" + tblConsultingDoctor
				+ ", isdiabetic=" + isdiabetic + ", ishignbp=" + ishignbp
				+ ", refothersname=" + refothersname + ", patbyname="
				+ patbyname + ", tblUser=" + tblUser + ", appid=" + appid
				+ ", addictionother=" + addictionother + "]";
	}
	

	
}
