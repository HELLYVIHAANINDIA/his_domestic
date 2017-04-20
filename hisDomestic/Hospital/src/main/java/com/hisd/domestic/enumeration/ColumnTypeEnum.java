/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.enumeration;

/**
 *
 * @author Lenovo
 */
public enum ColumnTypeEnum {
    Item_Description(1)
      ,
            Quantity(2),
            Unit_Rate(3),
            Total_Rate(4),
            Category(5),
            Others(6);
            private int status;

            private ColumnTypeEnum(int status) {
			this.status = status;
		}
            @Override
	     public String toString(){
	         return status+"";
	     } 

            public static String getNameById(int code) {
                for (ColumnTypeEnum e : ColumnTypeEnum.values()) {
                    if (code == e.status) {
                        return e.name();
                    }
                }
        return "";
    }
    
    
}
