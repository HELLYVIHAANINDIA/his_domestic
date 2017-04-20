package com.hisd.domestic.databean;


/**
 *
 * @author Lipi Shah
 */
public class TenderRebateDetailBean {
   String formName;
   String tableName;
   String columnHeader;
   String GTValue;
   Integer bidId;
   int columnId;
   
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnHeader() {
		return columnHeader;
	}
	public void setColumnHeader(String columnHeader) {
		this.columnHeader = columnHeader;
	}
	public String getGTValue() {
		return GTValue;
	}
	public void setGTValue(String gTValue) {
		GTValue = gTValue;
	}
	public Integer getBidId() {
		return bidId;
	}
	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

   
}
