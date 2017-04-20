package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.hisd.domestic.model.TblReferenceType;

@Entity
@Table(name = "tbl_patientreference")
public class TblPatientRefrence implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "referenceid")
	private int referenceid;
	@Column(name = "referencedtl")
	private String referencedtl;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referencebytypeid")
	private TblReferenceType referencebytypeid;

	public int getReferenceid() {
		return referenceid;
	}

	public void setReferenceid(int referenceid) {
		this.referenceid = referenceid;
	}

	public String getReferencedtl() {
		return referencedtl;
	}

	public void setReferencedtl(String referencedtl) {
		this.referencedtl = referencedtl;
	}

	public TblReferenceType getReferencebytypeid() {
		return referencebytypeid;
	}

	public void setReferencebytypeid(TblReferenceType referencebytypeid) {
		this.referencebytypeid = referencebytypeid;
	}

	

}
