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

@Entity
@Table(name="tbl_clinicalreports")
public class TblClinicalReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="clinicalreport_id")
	private int clinicalreport_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patientid")
	private TblPatient tblPatient;
	@Column(name="clnicalreportid")
	private int clnicalreportid;
	@Column(name="statusid")
	private int statusid;
	@Column(name="schedualid")
	private int schedualid;
	@Column(name="findingReport")
	private String findingReport;
	
	
	public TblClinicalReport(){
		super();
	}


	public int getClinicalreport_id() {
		return clinicalreport_id;
	}


	public void setClinicalreport_id(int clinicalreport_id) {
		this.clinicalreport_id = clinicalreport_id;
	}


	public TblPatient getTblPatient() {
		return tblPatient;
	}


	public void setTblPatient(TblPatient tblPatient) {
		this.tblPatient = tblPatient;
	}


	public int getClnicalreportid() {
		return clnicalreportid;
	}


	public void setClnicalreportid(int clnicalreportid) {
		this.clnicalreportid = clnicalreportid;
	}


	public int getStatusid() {
		return statusid;
	}


	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}


	public int getSchedualid() {
		return schedualid;
	}


	public void setSchedualid(int schedualid) {
		this.schedualid = schedualid;
	}


	public String getFindingReport() {
		return findingReport;
	}


	public void setFindingReport(String findingReport) {
		this.findingReport = findingReport;
	}
	

}
