package com.hisd.domestic.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_finding")
public class TblFinding implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="findingid")
	private int findingid;
	@Column(name="findingname")
	private String findingname;
	@Column(name="findingstatus")
	private int findingstatus;
	
	public int getFindingid() {
		return findingid;
	}
	public void setFindingid(int findingid) {
		this.findingid = findingid;
	}
	public String getFindingname() {
		return findingname;
	}
	public void setFindingname(String findingname) {
		this.findingname = findingname;
	}
	public int getFindingstatus() {
		return findingstatus;
	}
	public void setFindingstatus(int findingstatus) {
		this.findingstatus = findingstatus;
	}
	
	
}
