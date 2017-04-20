package com.hisd.domestic.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_complaints")
public class TblComplaints implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "complaintsid")
	public int complaintsid;
	@Column(name = "complaintsname")
	public String complaintsname;
	@Column(name = "complaintsstatus")
	public int complaintsstatus;

	public int getComplaintsid() {
		return complaintsid;
	}

	public void setComplaintsid(int complaintsid) {
		this.complaintsid = complaintsid;
	}

	public String getComplaintsname() {
		return complaintsname;
	}

	public void setComplaintsname(String complaintsname) {
		this.complaintsname = complaintsname;
	}

	public int getComplaintsstatus() {
		return complaintsstatus;
	}

	public void setComplaintsstatus(int complaintsstatus) {
		this.complaintsstatus = complaintsstatus;
	}

}
