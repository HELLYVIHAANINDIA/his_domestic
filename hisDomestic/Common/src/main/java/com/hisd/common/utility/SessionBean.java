package com.hisd.common.utility;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SessionBean implements Serializable {

    private long userId;
    private String userName;
    private String fullName;
    private int userTypeId;
    private String lastLoginDateTime;
    private String ipAddress;
    private String timeZoneOffset;
    private int deptId;
    private List<Integer> designationId;
    private int userDetailId;
    private String timeZoneAbbr;
    private String rights;
    private int companyId;
    private long officerId;
    private long bidderId;
    private int isCTPLUser; 
    private int parentDeptId;
    private int grandParentDeptId;
    private int timezoneId;
    
	 public int getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(int parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	public int getGrandParentDeptId() {
		return grandParentDeptId;
	}

	public void setGrandParentDeptId(int grandParentDeptId) {
		this.grandParentDeptId = grandParentDeptId;
	}

    public int getIsCTPLUser() {
		return isCTPLUser;
	}

	public void setIsCTPLUser(int isCTPLUser) {
		this.isCTPLUser = isCTPLUser;
	}


	public long getOfficerId() {
		return officerId;
	}

	public void setOfficerId(long officerId) {
		this.officerId = officerId;
	}

	public long getBidderId() {
		return bidderId;
	}

	public void setBidderId(long bidderId) {
		this.bidderId = bidderId;
	}

	public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    
    public List<Integer> getDesignationId() {
		return designationId;
	}

	public void setDesignationId(List<Integer> designationId) {
		this.designationId = designationId;
	}

    public SessionBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(String lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }


    public void setUserDetailId(int userDetailId) {
        this.userDetailId = userDetailId;
    }    

    public int getUserDetailId() {
        return userDetailId;
    }    

    public String getTimeZoneAbbr() {
        return timeZoneAbbr;
    }

    public void setTimeZoneAbbr(String timeZoneAbbr) {
        this.timeZoneAbbr = timeZoneAbbr;
    }    

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
    
	/**
	 * @return the eventSpecVerify
	 */

	public int getTimezoneId() {
		return timezoneId;
	}

	public void setTimezoneId(int timezoneId) {
		this.timezoneId = timezoneId;
	}

	/**
	 * @param eventSpecVerify the eventSpecVerify to set
	 */

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }                    
}
