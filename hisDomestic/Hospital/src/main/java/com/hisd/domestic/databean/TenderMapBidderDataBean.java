/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.databean;

/**
 *
 */
public class TenderMapBidderDataBean {

    private String[] chkBidderId;
    private int hdTenderId;
    private int hdMappingType;
    private String[] chkMapBidderId;
    private int hdRowId;
    private int hdTableId;
    private int hdFormId;

    public int getHdFormId() {
        return hdFormId;
    }

    public void setHdFormId(int hdFormId) {
        this.hdFormId = hdFormId;
    }

    public int getHdRowId() {
        return hdRowId;
    }

    public void setHdRowId(int hdRowId) {
        this.hdRowId = hdRowId;
    }

    public int getHdTableId() {
        return hdTableId;
    }

    public void setHdTableId(int hdTableId) {
        this.hdTableId = hdTableId;
    }

    public String[] getChkMapBidderId() {
        return chkMapBidderId;
    }

    public void setChkMapBidderId(String[] chkMapBidderId) {
        this.chkMapBidderId = chkMapBidderId;
    }

    public String[] getChkBidderId() {
        return chkBidderId;
    }

    public void setChkBidderId(String[] chkBidderId) {
        this.chkBidderId = chkBidderId;
    }

    public int getHdTenderId() {
        return hdTenderId;
    }

    public void setHdTenderId(int hdTenderId) {
        this.hdTenderId = hdTenderId;
    }

    public int getHdMappingType() {
        return hdMappingType;
    }

    public void setHdMappingType(int hdMappingType) {
        this.hdMappingType = hdMappingType;
    }
}
