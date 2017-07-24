package com.hisd.domestic.model;
import java.io.Serializable;
import java.sql.Date;

import javax.jms.Session;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_document")
public class TblDocument implements Serializable {
	 private static final long serialVersionUID = 1L;
	    private Integer    documentid ;
	    private String     fileName     ;
	    private String     description  ;
	    private String     path         ;
	    private String     fileType     ;
	    private Integer    fileSize     ;
	    private Integer    objectId     ;
	    private Integer    childId      ;
	    private Integer    subChildId   ;
	    private Integer    otherSubChildId;
	    private Integer    officerId    ;
	    private Integer    cstatus      ;



	    //----------------------------------------------------------------------
	    // ENTITY LINKS ( RELATIONSHIP )
	    //----------------------------------------------------------------------

	    //----------------------------------------------------------------------
	    // CONSTRUCTOR(S)
	    //----------------------------------------------------------------------
	 public TblDocument() {
	
			super();
	    }
	    
	    //----------------------------------------------------------------------
	    // GETTER & SETTER FOR THE KEY FIELD
	    //----------------------------------------------------------------------
	    public void setdocumentid( Integer documentid ) {
	        this.documentid =documentid ;
	    }
	    
	    @Id
	    @GeneratedValue
	    @Column(name="documentid", nullable=false)
	    public Integer getdocumentid() {
	        return this.documentid;
	    }

	    //----------------------------------------------------------------------
	    // GETTERS & SETTERS FOR FIELDS
	    //----------------------------------------------------------------------
	    //--- DATABASE MAPPING : fileName ( VARCHAR ) 
	    public void setFileName( String fileName ) {
	        this.fileName = fileName;
	    }
	    @Column(name="fileName", nullable=false, length=250)
	    public String getFileName() {
	        return this.fileName;
	    }

	    //--- DATABASE MAPPING : description ( VARBINARY ) 
	    public void setDescription( String description ) {
	        this.description = description;
	    }
	    @Column(name="description")
	    public String getDescription() {
	        return this.description;
	    }

	    //--- DATABASE MAPPING : path ( VARCHAR ) 
	    public void setPath( String path ) {
	        this.path = path;
	    }
	    @Column(name="path", nullable=false, length=100)
	    public String getPath() {
	        return this.path;
	    }

	    //--- DATABASE MAPPING : fileType ( VARCHAR ) 
	    public void setFileType( String fileType ) {
	        this.fileType = fileType;
	    }
	    @Column(name="fileType", nullable=false, length=250)
	    public String getFileType() {
	        return this.fileType;
	    }

	    //--- DATABASE MAPPING : fileSize ( INT ) 
	    public void setFileSize( Integer fileSize ) {
	        this.fileSize = fileSize;
	    }
	    @Column(name="fileSize", nullable=false)
	    public Integer getFileSize() {
	        return this.fileSize;
	    }

	    //--- DATABASE MAPPING : objectId ( INT ) 
	    public void setObjectId( Integer objectId ) {
	        this.objectId = objectId;
	    }
	    @Column(name="objectId")
	    public Integer getObjectId() {
	        return this.objectId;
	    }

	    //--- DATABASE MAPPING : childId ( INT ) 
	    public void setChildId( Integer childId ) {
	        this.childId = childId;
	    }
	    @Column(name="childId")
	    public Integer getChildId() {
	        return this.childId;
	    }

	    //--- DATABASE MAPPING : subChildId ( INT ) 
	    public void setSubChildId( Integer subChildId ) {
	        this.subChildId = subChildId;
	    }
	    
	    @Column(name="otherSubChildId")
	    public Integer getOtherSubChildId() {
			return otherSubChildId;
		}

		public void setOtherSubChildId(Integer otherSubChildId) {
			this.otherSubChildId = otherSubChildId;
		}

		@Column(name="subChildId")
	    public Integer getSubChildId() {
	        return this.subChildId;
	    }

	    //--- DATABASE MAPPING : officerId ( INT ) 
	    public void setOfficerId( Integer officerId ) {
	        this.officerId = officerId;
	    }
	    @Column(name="officerId", nullable=false)
	    public Integer getOfficerId() {
	        return this.officerId;
	    }


	    //--- DATABASE MAPPING : cstatus ( INT ) 
	    public void setCstatus( Integer cstatus ) {
	        this.cstatus = cstatus;
	    }
	    @Column(name="cstatus", nullable=false)
	    public Integer getCstatus() {
	        return this.cstatus;
	    }


	    //----------------------------------------------------------------------
	    // GETTERS & SETTERS FOR LINKS
	    //----------------------------------------------------------------------

	    //----------------------------------------------------------------------
	    // toString METHOD
	    //----------------------------------------------------------------------
	    public String toString() { 
	        StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(documentid);
	        sb.append("]:"); 
	        sb.append(fileName);
	        // attribute 'description' not usable (type = byte[])
	        sb.append("|");
	        sb.append(path);
	        sb.append("|");
	        sb.append(fileType);
	        sb.append("|");
	        sb.append(fileSize);
	        sb.append("|");
	        sb.append(objectId);
	        sb.append("|");
	        sb.append(childId);
	        sb.append("|");
	        sb.append(subChildId);
	        sb.append("|");
	        sb.append(officerId);
	        sb.append("|");
	        sb.append(cstatus);
	        return sb.toString(); 
	    } 
	    protected Date createdAt;
		protected Date updatedAt;
		protected Long creatorId;
		protected Long updaterId;
			
		@Column(name="creatorId")
		public Long getCreatorId() {
			return creatorId;
		}

		public void setCreatorId(Long creatorId) {
			this.creatorId = creatorId;
		}

		@Column(name="updaterId")
		public Long getUpdaterId() {
			return updaterId;
		}

		public void setUpdaterId(Long updaterId) {
			this.updaterId = updaterId;
		}

		@Column(name = "createdAt")
		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		@Column(name = "updatedAt")
		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}



}
