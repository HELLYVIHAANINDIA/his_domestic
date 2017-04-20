package com.hisd.domestic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_user")
public class TblUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userdetailid")
	private int userdetailid;
	@Column(name = "usercode")
	private String usercode;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "middlename")
	private String middlename;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "gender")
	private String gender;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dob")
	private Date bod;
	@Column(name = "mobileno")
	private String mobileno;
	@Column(name = "coutrycodemobile")
	private String countrycodemobileno;
	@Column(name = "landlineno")
	private String  landlineno;
	@Column(name = "countrycodelandline")
	private String countrycodelandline;
	@Column(name = "extlandline")
	private String extlandline;
	@Column(name = "address")
	private String address;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "area")
	private String area;

	@Column(name = "countryId")
	private int countryId;

	@Column(name = "stateId")
	private int stateId;

	@Column(name = "city")
	private String city;
	@Column(name = "pincode")
	private String  pincode;
     @Column(name = "userid")
	private long userid;
     @Column(name="status")
     private int status;
      
	public int getUserdetailid() {
		return userdetailid;
	}

	public void setUserdetailid(int userdetailid) {
		this.userdetailid = userdetailid;
	}

	public TblUser(){
		super();
	}
	public TblUser(int userdetailid){
		this.userdetailid=userdetailid;
	}
	public int getstateId() {
		return stateId;
	}

	public void setstateId(int stateId) {
		this.stateId = stateId;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBod() {
		return bod;
	}

	public void setBod(Date bod) {
		this.bod = bod;
	}
   public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setcountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getCountrycodemobileno() {
		return countrycodemobileno;
	}

	public void setCountrycodemobileno(String countrycodemobileno) {
		this.countrycodemobileno = countrycodemobileno;
	}

	public String getLandlineno() {
		return landlineno;
	}

	public void setLandlineno(String landlineno) {
		this.landlineno = landlineno;
	}

	public String getCountrycodelandline() {
		return countrycodelandline;
	}

	public void setCountrycodelandline(String countrycodelandline) {
		this.countrycodelandline = countrycodelandline;
	}

	public String getExtlandline() {
		return extlandline;
	}

	public void setExtlandline(String extlandline) {
		this.extlandline = extlandline;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
    
}
