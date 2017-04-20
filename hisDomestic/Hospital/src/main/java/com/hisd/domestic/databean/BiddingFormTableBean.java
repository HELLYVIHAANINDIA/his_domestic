/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.databean;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class BiddingFormTableBean {
    
    private int tableId;
    private int createdBy;
    private int hasGTRow;
    private int isMandatory;
    private int isMultipleFilling;
    private int isPartialFillingAllowed;
    private int noOfCols;
    private int noOfRows;
    private int sortOrder;
    private int updatedBy;
    private int formId;
    private String tableFooter;
    private String tableHeader;
    private String tableName;
    private Date createdOn;
    private Date updatedOn;

    public int getTenderId() {
        return TenderId;
    }

    public void setTenderId(int TenderId) {
        this.TenderId = TenderId;
    }
    private int TenderId;
    
    

    /**
     * @return the tableId
     */
    public int getTableId() {
        return tableId;
    }

    /**
     * @param tableId the tableId to set
     */
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    /**
     * @return the createdBy
     */
    public int getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the hasGTRow
     */
    public int getHasGTRow() {
        return hasGTRow;
    }

    /**
     * @param hasGTRow the hasGTRow to set
     */
    public void setHasGTRow(int hasGTRow) {
        this.hasGTRow = hasGTRow;
    }

    /**
     * @return the isMandatory
     */
    public int getIsMandatory() {
        return isMandatory;
    }

    /**
     * @param isMandatory the isMandatory to set
     */
    public void setIsMandatory(int isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
     * @return the isMultipleFilling
     */
    public int getIsMultipleFilling() {
        return isMultipleFilling;
    }

    /**
     * @param isMultipleFilling the isMultipleFilling to set
     */
    public void setIsMultipleFilling(int isMultipleFilling) {
        this.isMultipleFilling = isMultipleFilling;
    }

    /**
     * @return the isPartialFillingAllowed
     */
    public int getIsPartialFillingAllowed() {
        return isPartialFillingAllowed;
    }

    /**
     * @param isPartialFillingAllowed the isPartialFillingAllowed to set
     */
    public void setIsPartialFillingAllowed(int isPartialFillingAllowed) {
        this.isPartialFillingAllowed = isPartialFillingAllowed;
    }

    /**
     * @return the noOfCols
     */
    public int getNoOfCols() {
        return noOfCols;
    }

    /**
     * @param noOfCols the noOfCols to set
     */
    public void setNoOfCols(int noOfCols) {
        this.noOfCols = noOfCols;
    }

    /**
     * @return the noOfRows
     */
    public int getNoOfRows() {
        return noOfRows;
    }

    /**
     * @param noOfRows the noOfRows to set
     */
    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    /**
     * @return the sortOrder
     */
    public int getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return the updatedBy
     */
    public int getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the formId
     */
    public int getFormId() {
        return formId;
    }

    /**
     * @param formId the formId to set
     */
    public void setFormId(int formId) {
        this.formId = formId;
    }

    /**
     * @return the tableFooter
     */
    public String getTableFooter() {
        return tableFooter;
    }

    /**
     * @param tableFooter the tableFooter to set
     */
    public void setTableFooter(String tableFooter) {
        this.tableFooter = tableFooter;
    }

    /**
     * @return the tableHeader
     */
    public String getTableHeader() {
        return tableHeader;
    }

    /**
     * @param tableHeader the tableHeader to set
     */
    public void setTableHeader(String tableHeader) {
        this.tableHeader = tableHeader;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn the updatedOn to set
     */
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    
}
