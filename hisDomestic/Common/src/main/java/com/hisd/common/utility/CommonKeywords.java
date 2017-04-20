package com.hisd.common.utility;

public enum CommonKeywords {

	SUCCESS_MSG("successMsg"),
	ERROR_MSG("errorMsg"),
	AUDIT_BEAN("auditBean"),
	SESSION_OBJ("sessionObject"),
	CLIENT_OBJ("clientObject"),
	TEMP_SESSIONOBJ("tempSessionObject"),
	ERROR_MSG_KEY("redirect_failure_common"),
	ILLEGAL_OPERATION("msg_illegaloperation");
	
	private final String keyword;
	
	private CommonKeywords(String keyword) {
		this.keyword=keyword;
	}
	
	@Override
	public String toString(){
		return keyword;
	}
}
