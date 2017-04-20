/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.databean;

/**
 *
 */
public class TenderCorrigendumDetailDtBean {

    private int corrigendumId;
    private String fieldName;
    private String fieldLabel;
    private String newValue;
    private String oldValue;
    private String currencyName;
    private int processId;
    private int objectId;

    public int getCorrigendumId() {
        return corrigendumId;
    }

    public void setCorrigendumId(int corrigendumId) {
        this.corrigendumId = corrigendumId;
    }
    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }
    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

  
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    
}
