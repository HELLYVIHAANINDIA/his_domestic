package com.hisd.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_currencymap")
public class TblCurrencyMap implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "currencyMapId", nullable = false)
    private int currencyMapId;
	@Column(name = "departmentId")
    private int departmentId;
	@Column(name = "currencyId")
    private int currencyId;
	@Column(name = "createdById")
    private int createdById;
	@Column(name = "createdByDate")
    private Date createdByDate;

	public int getCurrencyMapId() {
		return currencyMapId;
	}
	public void setCurrencyMapId(int currencyMapId) {
		this.currencyMapId = currencyMapId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public int getCreatedById() {
		return createdById;
	}
	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}
	public Date getCreatedByDate() {
		return createdByDate;
	}
	public void setCreatedByDate(Date createdByDate) {
		this.createdByDate = createdByDate;
	}
}
