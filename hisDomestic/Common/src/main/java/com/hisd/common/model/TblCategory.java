package com.hisd.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Category")
public class TblCategory implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId", nullable = false)
    private int categoryId;
	@Column(name = "unspscId")
    private int unspscId;
	@Column(name = "unspscDesc")
    private String unspscDesc;
	@Column(name = "extraData")
    private String extraData;
	@Column(name = "isActive")
    private int isActive;
    
    
    public TblCategory(int categoryId){
    	this.setCategoryId(categoryId);
    }

    public TblCategory(){
    }

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUnspscId() {
		return unspscId;
	}

	public void setUnspscId(int unspscId) {
		this.unspscId = unspscId;
	}

	public String getUnspscDesc() {
		return unspscDesc;
	}

	public void setUnspscDesc(String unspscDesc) {
		this.unspscDesc = unspscDesc;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
