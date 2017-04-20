package com.hisd.domestic.enumeration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */

public enum UserEnum {
    OFFICER(1),
    BIDDER(2),
    AUTO(3);



	

	private int userType;

	private UserEnum(int userType) {
		this.userType = userType;
	}

	public int getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return userType+"";
	}

        public static String getNameById(int code) {
                for (UserEnum e : UserEnum.values()) {
                    if (code == e.userType) {
                        return e.name();
                    }
                }
        return "";
    }
    
}
