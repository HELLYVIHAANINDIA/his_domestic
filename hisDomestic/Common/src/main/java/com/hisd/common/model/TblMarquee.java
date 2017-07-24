/*
 * Created on 17 Nov 2016 ( Time 01:57:57 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.hisd.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "tbl_department"
 *
 *
 */

@Entity
@Table(name = "tbl_marquee")
// Define named queries here

public class TblMarquee implements Serializable {

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@GeneratedValue
	@Column(name = "marqueeId", nullable = false)
	private Integer marqueeId;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate", nullable = false, length = 250)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDate", length = 500)
	private Date endDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn")
	private Date createdOn;
	@Column(name = "createdBy")
	private Integer createdBy;
	@Column(name = "marqueeText", nullable = false)
	private String marqueeText;
	@Column(name = "isActive", nullable = false)
	private Integer isActive;
	@Column(name = "tenderId")
	private Integer tenderId = 0;
	@Column(name = "marqueeTo")	// Officer or bidder id, by default 0
	private Integer marqueeTo=0;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processId")
	private TblProcess tblProcess;

	public Integer getMarqueeTo() {
		return marqueeTo;
	}

	public void setMarqueeTo(Integer marqueeTo) {
		this.marqueeTo = marqueeTo;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getTenderId() {
		return tenderId;
	}

	public void setTenderId(Integer tenderId) {
		this.tenderId = tenderId;
	}
	
	public TblProcess getTblProcess() {
        return this.tblProcess;
    }

    public void setTblProcess(TblProcess tblProcess) {
        this.tblProcess = tblProcess;
    }

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public TblMarquee() {
		super();
	}

	public TblMarquee(int marqueeId) {
		this.marqueeId = marqueeId;
	}

	public Integer getMarqueeId() {
		return marqueeId;
	}

	public void setMarqueeId(Integer marqueeId) {
		this.marqueeId = marqueeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getMarqueeText() {
		return marqueeText;
	}

	public void setMarqueeText(String marqueeText) {
		this.marqueeText = marqueeText;
	}

}
