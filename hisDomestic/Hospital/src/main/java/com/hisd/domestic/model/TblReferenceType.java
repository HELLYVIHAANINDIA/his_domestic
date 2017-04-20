package com.hisd.domestic.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_referencebytype")
public class TblReferenceType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="referencebytypeid")
	private Integer referencebytypeid;
	
	@Column(name="referencebytypename")
	private String referencebytypename;

	public TblReferenceType(){
		super();
	}
	public TblReferenceType(int referencebytypeid){
		this.referencebytypeid=referencebytypeid;
	}
	
	public Integer getReferencebytypeid() {
		return referencebytypeid;
	}
	public void setReferencebytypeid(int referencebytypeid) {
		this.referencebytypeid = referencebytypeid;
	}
	public String getReferencebytypename() {
		return referencebytypename;
	}
	public void setReferencebytypename(String referencebytypename) {
		this.referencebytypename = referencebytypename;
	}
	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(referencebytypeid);
	        sb.append("]:"); 
	        sb.append(referencebytypename);
	        return sb.toString(); 
	}
	
	
	

}
