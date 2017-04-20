package com.hisd.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categorymap")
public class TblCategoryMap implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryMapId", nullable = false)
    private int categoryMapId;
	@Column(name = "userId")
    private int userId;
	@Column(name = "tenderId")
    private int tenderId;
	@Column(name = "categoryText")
	private String categoryText;
	@Column(name = "categoryCode")
	private int categoryCode;
	@Column(name = "corrigendumId")
	private int corrigendumId;
	
	public int getCorrigendumId() {
		return corrigendumId;
	}

	public void setCorrigendumId(int corrigendumId) {
		this.corrigendumId = corrigendumId;
	}

	public String getCategoryText() {
		return categoryText;
	}
 
	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}


	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public TblCategoryMap(int categoryMapId) {
		this.setCategoryMapId(categoryMapId);
	}
	
	public TblCategoryMap() {
	}
	
	public int getCategoryMapId() {
		return categoryMapId;
	}
	
	public void setCategoryMapId(int categoryMapId) {
		this.categoryMapId = categoryMapId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTenderId() {
		return tenderId;
	}
	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}
}
