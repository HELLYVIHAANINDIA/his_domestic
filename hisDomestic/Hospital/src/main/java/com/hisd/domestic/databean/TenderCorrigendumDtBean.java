package com.hisd.domestic.databean;

import java.util.List;

/**
 *
 */
public class TenderCorrigendumDtBean {

    private int id;
    private int cstatus;
    private String ctext;
    private List<TenderCorrigendumDetailDtBean> details;
    private List<TenderCurrencyCorrigendumDtBean> currencies;
    private List<TenderFormCorrigendumDtBean> forms;
    private List<TenderCorrigendumDocumentDtBean> documents;
    private List<TenderEnvelopeCorrigendumDtBean> envelopes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCstatus() {
        return cstatus;
    }

    public void setCstatus(int cstatus) {
        this.cstatus = cstatus;
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }
    public List<TenderCorrigendumDetailDtBean> getDetails() {
        return details;
    }

    public void setDetails(List<TenderCorrigendumDetailDtBean> details) {
        this.details = details;
    }

    public List<TenderCurrencyCorrigendumDtBean> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<TenderCurrencyCorrigendumDtBean> currencies) {
        this.currencies = currencies;
    }

    public List<TenderFormCorrigendumDtBean> getForms() {
        return forms;
    }

    public void setForms(List<TenderFormCorrigendumDtBean> forms) {
        this.forms = forms;
    }

    public List<TenderCorrigendumDocumentDtBean> getDocuments() {
        return documents;
    }

    public void setDocuments(List<TenderCorrigendumDocumentDtBean> documents) {
        this.documents = documents;
    }

    public List<TenderEnvelopeCorrigendumDtBean> getEnvelopes() {
        return envelopes;
    }

    public void setEnvelopes(List<TenderEnvelopeCorrigendumDtBean> envelopes) {
        this.envelopes = envelopes;
    }
    
   
}
