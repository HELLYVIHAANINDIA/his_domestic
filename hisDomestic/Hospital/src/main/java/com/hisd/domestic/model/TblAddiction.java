package com.hisd.domestic.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_addiction")
public class TblAddiction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="addictionid")
	private int addictionid;
	@Column(name="addictionname")
	private String addictionname;
	public TblAddiction(){
		super();
	}
	public TblAddiction(int id){
		this.addictionid = id;
	}
	public int getAddictionid() {
		return addictionid;
	}
	public void setAddictionid(int addictionid) {
		this.addictionid = addictionid;
	}
	public String getAddictionname() {
		return addictionname;
	}
	public void setAddictionname(String addictionname) {
		this.addictionname = addictionname;
	}
	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(addictionid);
	        sb.append("]:"); 
	        sb.append(addictionname);
	        return sb.toString(); 
	}

}
