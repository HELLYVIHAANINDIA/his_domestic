package com.hisd.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_commonlisting")
public class CommonListing implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "listingId", unique = true, nullable = false)
	private Integer listingId;
	@Column(name = "columnName")
	private String columnName;
	@Column(name = "actionItem")
	private String actionItem;
	@Column(name = "commonAction")
	private String commonAction;
	@Column(name = "status")
	private int status;
	@Column(name = "discription")
	private String discription;
	@Column(name = "fromClause")
	String fromClause;
	@Column(name = "isHQL")
	Boolean isHQL;
	@Column(name = "srnoCol")
	Integer srnoCol;
	
	public Integer getSrnoCol() {
		return srnoCol;
	}
	public void setSrnoCol(Integer srnoCol) {
		this.srnoCol = srnoCol;
	}
	public Integer getListingId() {
		return listingId;
	}
	public void setListingId(Integer listingId) {
		this.listingId = listingId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getActionItem() {
		return actionItem;
	}
	public void setActionItem(String actionItem) {
		this.actionItem = actionItem;
	}
	public String getCommonAction() {
		return commonAction;
	}
	public void setCommonAction(String commonAction) {
		this.commonAction = commonAction;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDiscription() {
		return discription;
	}
	public String getFromClause() {
		return fromClause;
	}
	public void setFromClause(String fromClause) {
		this.fromClause = fromClause;
	}
	public Boolean getIsHQL() {
		return isHQL;
	}
	public void setIsHQL(Boolean isHQL) {
		this.isHQL = isHQL;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	

}
