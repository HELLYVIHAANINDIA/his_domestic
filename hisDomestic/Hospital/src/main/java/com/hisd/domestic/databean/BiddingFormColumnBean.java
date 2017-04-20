/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.databean;

/**
 *
 * @author Lenovo
 */
public class BiddingFormColumnBean {
    private int columnId;
    private int columnNo;
    private int dataType;
    private int filledBy;
    private int isCurrConvReq;
    private int isShown;
    private int columntypeid;
    private int formid;
    private int tableid;
    private String columnHeader;
    private String formula;
    private int formSortOrder;
    private int sortOrder;
    private int columnOrder;
    private int isGTColumn;
    private int isPriceSummary;

    
    
    public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public int getFormSortOrder() {
		return formSortOrder;
	}

	public void setFormSortOrder(int formSortOrder) {
		this.formSortOrder = formSortOrder;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getColumnOrder() {
		return columnOrder;
	}

	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}

	/**
     * @return the columnId
     */
    public int getColumnId() {
        return columnId;
    }

    /**
     * @param columnId the columnId to set
     */
    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    /**
     * @return the columnNo
     */
    public int getColumnNo() {
        return columnNo;
    }

    /**
     * @param columnNo the columnNo to set
     */
    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    /**
     * @return the dataType
     */
    public int getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the filledBy
     */
    public int getFilledBy() {
        return filledBy;
    }

    /**
     * @param filledBy the filledBy to set
     */
    public void setFilledBy(int filledBy) {
        this.filledBy = filledBy;
    }

    /**
     * @return the isCurrConvReq
     */
    public int getIsCurrConvReq() {
        return isCurrConvReq;
    }

    /**
     * @param isCurrConvReq the isCurrConvReq to set
     */
    public void setIsCurrConvReq(int isCurrConvReq) {
        this.isCurrConvReq = isCurrConvReq;
    }

    /**
     * @return the isShown
     */
    public int getIsShown() {
        return isShown;
    }

    /**
     * @param isShown the isShown to set
     */
    public void setIsShown(int isShown) {
        this.isShown = isShown;
    }

    /**
     * @return the columntypeid
     */
    public int getColumntypeid() {
        return columntypeid;
    }

    /**
     * @param columntypeid the columntypeid to set
     */
    public void setColumntypeid(int columntypeid) {
        this.columntypeid = columntypeid;
    }

    /**
     * @return the formid
     */
    public int getFormid() {
        return formid;
    }

    /**
     * @param formid the formid to set
     */
    public void setFormid(int formid) {
        this.formid = formid;
    }

    /**
     * @return the tableid
     */
    public int getTableid() {
        return tableid;
    }

    /**
     * @param tableid the tableid to set
     */
    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    /**
     * @return the columnHeader
     */
    public String getColumnHeader() {
        return columnHeader;
    }

    /**
     * @param columnHeader the columnHeader to set
     */
    public void setColumnHeader(String columnHeader) {
        this.columnHeader = columnHeader;
    }
    
    public int getIsGTColumn() {
        return isGTColumn;
    }

    public void setIsGTColumn(int isGTColumn) {
        this.isGTColumn = isGTColumn;
    }

    public int getIsPriceSummary() {
        return isPriceSummary;
    }

    public void setIsPriceSummary(int isPriceSummary) {
        this.isPriceSummary = isPriceSummary;
    }

    
}
