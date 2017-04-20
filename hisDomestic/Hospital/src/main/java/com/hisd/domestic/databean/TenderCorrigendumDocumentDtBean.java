package com.hisd.domestic.databean;



/**
 */
public class TenderCorrigendumDocumentDtBean {

	private int officerDocMappingId;       
        private String docName;
        private String description;
        private String fileSize;
        private String mappedOn;
        private String cstatus;
        private String downloadUrl;

    public int getOfficerDocMappingId() {
        return officerDocMappingId;
    }

    public void setOfficerDocMappingId(int officerDocMappingId) {
        this.officerDocMappingId = officerDocMappingId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getMappedOn() {
        return mappedOn;
    }

    public void setMappedOn(String mappedOn) {
        this.mappedOn = mappedOn;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

   
   
}