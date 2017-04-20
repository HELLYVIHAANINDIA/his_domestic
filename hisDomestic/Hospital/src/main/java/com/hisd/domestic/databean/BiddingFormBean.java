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
public class BiddingFormBean 
{
    private String formFooter;
    private String formHeader;
    private String formName;
    private int formId;
    private int cancelledBy;
    private int createdBy;
    private int cstatus;
    private int incrementItems;
    private int isDocumentReq;
    private int isEncryptedDocument;
    private int isEncryptionReq;
    private int isEvaluationReq;
    private int isItemWiseDocAllowed;
    private int isMandatory;
    private int isMultipleFilling;
    private int isPriceBid;
    private int isSecondary;
    private int loadNoOfItems;
    private int masterFormId;
    private int minTablesReqForBidding;
    private int noOfTables;
    private int parentFormId;
    private int publishedBy;
    private int tenderid;
    private int envelopeid;
    private Date cancelledOn;
    private Date createdOn;
    private Date publishedOn;
    private int sortOrder;
    private int showDocuments;
    private Double formWeight;
    
    
    

    public Double getFormWeight() {
		return formWeight;
	}

	public void setFormWeight(Double formWeight) {
		this.formWeight = formWeight;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getShowDocuments() {
		return showDocuments;
	}

	public void setShowDocuments(int showDocuments) {
		this.showDocuments = showDocuments;
	}

	/**
     * @return the formFooter
     */
    public String getFormFooter() {
        return formFooter;
    }

    /**
     * @param formFooter the formFooter to set
     */
    public void setFormFooter(String formFooter) {
        this.formFooter = formFooter;
    }

    /**
     * @return the formHeader
     */
    public String getFormHeader() {
        return formHeader;
    }

    /**
     * @param formHeader the formHeader to set
     */
    public void setFormHeader(String formHeader) {
        this.formHeader = formHeader;
    }

    /**
     * @return the formName
     */
    public String getFormName() {
        return formName;
    }

    /**
     * @param formName the formName to set
     */
    public void setFormName(String formName) {
        this.formName = formName;
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
     * @return the cancelledBy
     */
    public int getCancelledBy() {
        return cancelledBy;
    }

    /**
     * @param cancelledBy the cancelledBy to set
     */
    public void setCancelledBy(int cancelledBy) {
        this.cancelledBy = cancelledBy;
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
     * @return the cstatus
     */
    public int getCstatus() {
        return cstatus;
    }

    /**
     * @param cstatus the cstatus to set
     */
    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }

    /**
     * @return the incrementItems
     */
    public int getIncrementItems() {
        return incrementItems;
    }

    /**
     * @param incrementItems the incrementItems to set
     */
    public void setIncrementItems(int incrementItems) {
        this.incrementItems = incrementItems;
    }

    /**
     * @return the isDocumentReq
     */
    public int getIsDocumentReq() {
        return isDocumentReq;
    }

    /**
     * @param isDocumentReq the isDocumentReq to set
     */
    public void setIsDocumentReq(int isDocumentReq) {
        this.isDocumentReq = isDocumentReq;
    }

    /**
     * @return the isEncryptedDocument
     */
    public int getIsEncryptedDocument() {
        return isEncryptedDocument;
    }

    /**
     * @param isEncryptedDocument the isEncryptedDocument to set
     */
    public void setIsEncryptedDocument(int isEncryptedDocument) {
        this.isEncryptedDocument = isEncryptedDocument;
    }

    /**
     * @return the isEncryptionReq
     */
    public int getIsEncryptionReq() {
        return isEncryptionReq;
    }

    /**
     * @param isEncryptionReq the isEncryptionReq to set
     */
    public void setIsEncryptionReq(int isEncryptionReq) {
        this.isEncryptionReq = isEncryptionReq;
    }

    /**
     * @return the isEvaluationReq
     */
    public int getIsEvaluationReq() {
        return isEvaluationReq;
    }

    /**
     * @param isEvaluationReq the isEvaluationReq to set
     */
    public void setIsEvaluationReq(int isEvaluationReq) {
        this.isEvaluationReq = isEvaluationReq;
    }

    /**
     * @return the isItemWiseDocAllowed
     */
    public int getIsItemWiseDocAllowed() {
        return isItemWiseDocAllowed;
    }

    /**
     * @param isItemWiseDocAllowed the isItemWiseDocAllowed to set
     */
    public void setIsItemWiseDocAllowed(int isItemWiseDocAllowed) {
        this.isItemWiseDocAllowed = isItemWiseDocAllowed;
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
     * @return the isPriceBid
     */
    public int getIsPriceBid() {
        return isPriceBid;
    }

    /**
     * @param isPriceBid the isPriceBid to set
     */
    public void setIsPriceBid(int isPriceBid) {
        this.isPriceBid = isPriceBid;
    }

    /**
     * @return the isSecondary
     */
    public int getIsSecondary() {
        return isSecondary;
    }

    /**
     * @param isSecondary the isSecondary to set
     */
    public void setIsSecondary(int isSecondary) {
        this.isSecondary = isSecondary;
    }

    /**
     * @return the loadNoOfItems
     */
    public int getLoadNoOfItems() {
        return loadNoOfItems;
    }

    /**
     * @param loadNoOfItems the loadNoOfItems to set
     */
    public void setLoadNoOfItems(int loadNoOfItems) {
        this.loadNoOfItems = loadNoOfItems;
    }

    /**
     * @return the masterFormId
     */
    public int getMasterFormId() {
        return masterFormId;
    }

    /**
     * @param masterFormId the masterFormId to set
     */
    public void setMasterFormId(int masterFormId) {
        this.masterFormId = masterFormId;
    }

    /**
     * @return the minTablesReqForBidding
     */
    public int getMinTablesReqForBidding() {
        return minTablesReqForBidding;
    }

    /**
     * @param minTablesReqForBidding the minTablesReqForBidding to set
     */
    public void setMinTablesReqForBidding(int minTablesReqForBidding) {
        this.minTablesReqForBidding = minTablesReqForBidding;
    }

    /**
     * @return the noOfTables
     */
    public int getNoOfTables() {
        return noOfTables;
    }

    /**
     * @param noOfTables the noOfTables to set
     */
    public void setNoOfTables(int noOfTables) {
        this.noOfTables = noOfTables;
    }

    /**
     * @return the parentFormId
     */
    public int getParentFormId() {
        return parentFormId;
    }

    /**
     * @param parentFormId the parentFormId to set
     */
    public void setParentFormId(int parentFormId) {
        this.parentFormId = parentFormId;
    }

    /**
     * @return the publishedBy
     */
    public int getPublishedBy() {
        return publishedBy;
    }

    /**
     * @param publishedBy the publishedBy to set
     */
    public void setPublishedBy(int publishedBy) {
        this.publishedBy = publishedBy;
    }

    /**
     * @return the tenderid
     */
    public int getTenderid() {
        return tenderid;
    }

    /**
     * @param tenderid the tenderid to set
     */
    public void setTenderid(int tenderid) {
        this.tenderid = tenderid;
    }

    /**
     * @return the envelopeid
     */
    public int getEnvelopeid() {
        return envelopeid;
    }

    /**
     * @param envelopeid the envelopeid to set
     */
    public void setEnvelopeid(int envelopeid) {
        this.envelopeid = envelopeid;
    }

    /**
     * @return the cancelledOn
     */
    public Date getCancelledOn() {
        return cancelledOn;
    }

    /**
     * @param cancelledOn the cancelledOn to set
     */
    public void setCancelledOn(Date cancelledOn) {
        this.cancelledOn = cancelledOn;
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
     * @return the publishedOn
     */
    public Date getPublishedOn() {
        return publishedOn;
    }

    /**
     * @param publishedOn the publishedOn to set
     */
    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

}
