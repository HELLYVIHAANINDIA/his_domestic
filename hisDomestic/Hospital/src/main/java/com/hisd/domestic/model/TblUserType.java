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
@Table(name="tbl_usertype")
// Define named queries here

public class TblUserType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer    usertypeid ;
    private String     usertypename ;

    public TblUserType() {
		super();
    }
    
    public TblUserType(int usertypeid) {
    	this.usertypeid=usertypeid;
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUsertypeid( Integer usertypeid ) {
        this.usertypeid = usertypeid ;
    }
    @Id
    @GeneratedValue
    @Column(name="usertypeid", nullable=false)
    public Integer getUsertypeid() {
        return this.usertypeid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : designationName ( VARCHAR ) 
    public void setUsertypename( String usertypename ) {
        this.usertypename = usertypename;
    }
    @Column(name="usertypename", nullable=false, length=50)
    public String getUsertypename() {
        return this.usertypename;
    }


	//----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(usertypeid);
        sb.append("]:"); 
        sb.append(usertypename);
        return sb.toString(); 
    } 

}
