/*
 * Created on 26 Nov 2016 ( Time 05:36:42 )

 */
// This Bean has a basic Primary Key (not composite) 

package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;
import java.util.List;

/**
 * Persistent class for entity stored in table "tbl_country"
 *
 *
 */

@Entity
@Table(name="tbl_country")
// Define named queries here

public class TblCountry implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer    countryId    ;
    private String     countryName  ;
    private String     countryCode  ;
    private List<TblState> listOfTblState;
    
    public TblCountry(){
    	super();
    }
    public TblCountry(int countryId) {
		this.countryId=countryId;
    }
    public void setCountryId( Integer countryId ) {
        this.countryId = countryId ;
    }
    
    @Id
    @GeneratedValue
    @Column(name="countryId", nullable=false)
    public Integer getCountryId() {
        return this.countryId;
    }
    public void setCountryName( String countryName ) {
        this.countryName = countryName;
    }
    @Column(name="countryName", nullable=false, length=25)
    public String getCountryName() {
        return this.countryName;
    }
    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }
    @Column(name="countryCode", length=10)
    public String getCountryCode() {
        return this.countryCode;
    }
   
    public void setListOfTblState( List<TblState> listOfTblState ) {
        this.listOfTblState = listOfTblState;
    }
    @OneToMany(mappedBy="tblCountry", targetEntity=TblState.class)
    public List<TblState> getListOfTblState() {
        return this.listOfTblState;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(countryId);
        sb.append("]:"); 
        sb.append(countryName);
        sb.append("|");
        sb.append(countryCode);
        return sb.toString(); 
    } 

}
