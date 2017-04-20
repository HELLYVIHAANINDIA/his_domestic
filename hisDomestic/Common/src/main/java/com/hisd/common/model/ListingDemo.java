package com.hisd.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "tbl_listingdemo")
public class ListingDemo implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private String id;
	@Column(name = "engine")
	private int engine;
	@Column(name = "browser")
	private Date browser;
	@Column(name = "platForm")
	private String platForm;
	@Column(name = "version")
	private int version;
	@Column(name = "grade")
	private String discription;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public Date getBrowser() {
		return browser;
	}
	public void setBrowser(Date browser) {
		this.browser = browser;
	}
	public String getPlatForm() {
		return platForm;
	}
	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

}
