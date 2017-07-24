package com.hisd.domestic.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_socialeconomicstatus")
public class TblSocialEconomicStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="socialeconomicstatusid")
	private int socialeconomicstatusid;
	@Column(name="socialeconomicstatusname")
	private String socialeconomicstatusname;
	public int getSocialeconomicastatusid() {
		return socialeconomicstatusid;
	}
	public void setSocialeconomicastatusid(int socialeconomicstatusid) {
		this.socialeconomicstatusid = socialeconomicstatusid;
	}
	public String getSocialeconomicstatusname() {
		return socialeconomicstatusname;
	}
	public void setSocialeconomicstatusname(String socialeconomicstatusname) {
		this.socialeconomicstatusname = socialeconomicstatusname;
	}
	@Override
	public String toString() {
		 StringBuffer sb = new StringBuffer(); 
	        sb.append("["); 
	        sb.append(socialeconomicstatusid);
	        sb.append("]:"); 
	        sb.append(socialeconomicstatusname);
	        return sb.toString(); 
	}
	
	

}
