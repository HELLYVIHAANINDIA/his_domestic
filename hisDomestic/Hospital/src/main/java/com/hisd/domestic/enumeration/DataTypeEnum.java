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
public enum DataTypeEnum {
    
    Small_Text(1)
      ,
            Long_Text(2),
            Number_with_Dot(3),
            Number_without_Dot(4),
            All_Numbers(5),
            Auto_number(6),
            Date(7),
            Combo_box(8),
            Master_Data_Sheet(9)
            
            ;
            private int status;

            private DataTypeEnum(int status) {
			this.status = status;
		}
            public int getStatus() {
				return status;
			}
			@Override
	     public String toString(){
	         return status+"";
	     } 

            public static String getNameById(int code) {
                for (DataTypeEnum e : DataTypeEnum.values()) {
                    if (code == e.status) {
                        return e.name();
                    }
                }
        return "";
    }
    
}
