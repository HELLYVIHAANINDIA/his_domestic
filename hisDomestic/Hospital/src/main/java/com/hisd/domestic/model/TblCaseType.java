package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_casetype")
public class TblCaseType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "casetypeid")
	public int casetypeid;
	
	@Column(name = "casetypename")
	public String casetypename;
	public TblCaseType(){
		super();
	}

	public TblCaseType(int casetypeid) {
		this.casetypeid = casetypeid;
	}

	public int getCasetypeid() {
		return casetypeid;
	}

	public void setCasetypeid(int casetypeid) {
		this.casetypeid = casetypeid;
	}

	public String getCasetypename() {
		return casetypename;
	}

	public void setCasetypename(String casetypename) {
		this.casetypename = casetypename;
	}
	@Override
	 public String toString() { 
	        StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(casetypeid);
	        sb.append("]:"); 
	        sb.append(casetypename);
	        return sb.toString(); 
	    } 

}
