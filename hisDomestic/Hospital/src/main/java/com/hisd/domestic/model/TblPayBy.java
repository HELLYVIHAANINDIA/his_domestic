package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_payby")
public class TblPayBy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="paybyid")
	private int paybyid;
	@Column(name="paybyname")
	private String paybyname;
	public int getPaybyid() {
		return paybyid;
	}
	public void setPaybyid(int paybyid) {
		this.paybyid = paybyid;
	}
	public String getPaybyname() {
		return paybyname;
	}
	public void setPaybyname(String paybyname) {
		this.paybyname = paybyname;
	}
	
	
	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(paybyid);
	        sb.append("]:"); 
	        sb.append(paybyname);
	        return sb.toString(); 
	}
	
}
