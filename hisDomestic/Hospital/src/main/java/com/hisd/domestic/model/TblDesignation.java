/*
 * Created on 18 Nov 2016 ( Time 04:40:49 )

 */
// This Bean has a basic Primary Key (not composite) 

package com.hisd.domestic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

/**
 * Persistent class for entity stored in table "tbl_designation"
 *
 *
 */

@Entity
@Table(name="tbl_designation")
// Define named queries here

public class TblDesignation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer    designationId ;
    private String     designationName ;

    public TblDesignation() {
		super();
    }
    
    public TblDesignation(int designationId) {
    	this.designationId=designationId;
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setDesignationId( Integer designationId ) {
        this.designationId = designationId ;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="designationid", nullable=false)
    public Integer getDesignationId() {
        return this.designationId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : designationName ( VARCHAR ) 
    public void setDesignationName( String designationName ) {
        this.designationName = designationName;
    }
    @Column(name="designationname", nullable=false, length=50)
    public String getDesignationName() {
        return this.designationName;
    }


	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(designationId);
        sb.append("]:"); 
        sb.append(designationName);
        return sb.toString(); 
    } 

}
