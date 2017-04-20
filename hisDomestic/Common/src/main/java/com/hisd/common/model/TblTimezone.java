/*
 * Created on 26 Nov 2016 ( Time 05:36:42 )

 */
// This Bean has a basic Primary Key (not composite) 

package com.hisd.common.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "tbl_country"
 *
 *
 */

@Entity
@Table(name="tbl_timezone")
// Define named queries here

public class TblTimezone implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer    timezoneId    ;
    private String     countryName  ;
    private String     utcOffset  ;
    
    public TblTimezone(){
    	super();
    }
    public TblTimezone(int timezoneId) {
		this.timezoneId=timezoneId;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="timezoneId", nullable=false)
    public Integer getTimezoneId() {
		return timezoneId;
	}
	public void setTimezoneId(Integer timezoneId) {
		this.timezoneId = timezoneId;
	}
	@Column(name="countryName", nullable=false)
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Column(name="utcOffset", nullable=false)
	public String getUtcOffset() {
		return utcOffset;
	}
	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}
}
