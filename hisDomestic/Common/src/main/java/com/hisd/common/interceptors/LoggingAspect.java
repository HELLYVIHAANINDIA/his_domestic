package com.hisd.common.interceptors;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hisd.common.model.TblAuditLog;
import com.hisd.common.services.CommonDAO;
import com.hisd.common.services.CommonService;
import com.hisd.common.utility.CommonKeywords;
import com.hisd.common.utility.SessionBean;

@Aspect
public class LoggingAspect {

	@Autowired
	CommonDAO commonDao;
	@Autowired
	CommonService commonService;
	static Set<String> skipURL = new HashSet<String>();
	public LoggingAspect(){
		skipURL.add("/common/user/getCategoryData");
		skipURL.add("/common/user/notificationTab");
		skipURL.add("/common/user/getstatebycountry");
		skipURL.add("/ajax/downloadbriefcasefile");
		skipURL.add("/etender/buyer/viewcorrigendum");
		skipURL.add("/etender/buyer/getDocumentList");
		skipURL.add("/sessionexpired");
		skipURL.add("/exportDataFromPage");
		skipURL.add("/etender/buyer/viewtender");
                skipURL.add("/eBid/Bid/viewAuction");
		skipURL.add("/etender/commonListPage");
		skipURL.add("/etender/commonDataGrid");
		skipURL.add("/etender/buyer/validatePublishtender");
		skipURL.add("/common/viewMarquee");
		skipURL.add("/notloggedin");
		skipURL.add("/resources");
		skipURL.add("/setcookie");
		skipURL.add("/submitLogin");
		skipURL.add("/submitlogout");
		skipURL.add("/notloggedin");
		skipURL.add("/common/user/getbidderregistration");
		skipURL.add("/common/user/addbidder");
		skipURL.add("/login");
		skipURL.add("/getforgotpassword");
		skipURL.add("/postforgotpassword");
		skipURL.add("/resetpasswordbymail");
		skipURL.add("/postresetpassword");
		skipURL.add("/ajaxhit");
		skipURL.add("/etender/bidder/briefcasecontent");
		skipURL.add("/etender/bidder/uploadbriefcasedocuments");
		skipURL.add("/ajax/submitbriefcasefileupload");
		skipURL.add("/etender/buyer/getDocumentList");
		skipURL.add("/ajax/getbriefcaseuploadeddocs");
		skipURL.add("/ajax/deletebriefcasefile");
		skipURL.add("/ajax/downloadbriefcasefile");
		skipURL.add("/common/user/getorganization");
		skipURL.add("/common/user/addOrganization");
		skipURL.add("/verifyregistration/");
		skipURL.add("/registersuccess");
		skipURL.add("/changepasswordredirect");
		skipURL.add("/ajax/departments/");
		
	}
	
	@Before("within(com.hisd.common.controller.*) || within(com.hisd.domestic.controller.*)")
	public void beforeExecution(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String requestType="";
		boolean isSkipURL = false;
		HttpServletRequest request = null;
		if(args!=null) {
			TblAuditLog auditLog = new TblAuditLog();
			for (int i = 0; i < args.length; i++) {
				Object object = args[i];
				if(object instanceof HttpServletRequest) {
					request = (HttpServletRequest) object;
					String contextPath = request.getContextPath();

					if (!isSkipURL) {
						isSkipURL = isPageSkipped(request.getRequestURI(), contextPath);
					}
					if (!isSkipURL) {
					
					requestType = request.getMethod();
			        HttpSession session = request.getSession();
			        SessionBean sessionBean = session != null && session.getAttribute(CommonKeywords.SESSION_OBJ.toString()) != null ? (SessionBean) session.getAttribute(CommonKeywords.SESSION_OBJ.toString()) : null;
			        String linkDetail="User has access ";
			        if(sessionBean!=null) {
			        	Map<String,String> userLinkDtls = (Map<String,String>) request.getSession().getAttribute("userLinksDtls");
						if (userLinkDtls != null && userLinkDtls.size() > 0) {
							if (!isSkipURL) {
								for (Map.Entry<String, String> entry : userLinkDtls.entrySet()) {
									if (request.getRequestURI().contains(entry.getKey())) {
										linkDetail = linkDetail + entry.getValue();
									}
								}
							}
						}
			        	if(!isSkipURL) {
			        		auditLog.setAction(request.getMethod());
			        		auditLog.setCreatedDate(commonService.getServerDateTime());
			        		auditLog.setEmailId("");
			        		auditLog.setPageUrl(request.getRequestURI());
			        		auditLog.setEntityName(sessionBean.getUserName());
			        		auditLog.setDetail(linkDetail);
			        	}
			        }else {
			        	
			        }
				}
				
			}
                                
			if(!isSkipURL) {
			if(requestType.equals("GET")){
				if(args[0] instanceof Integer){
					auditLog.setEntityId((Integer)args[0]);
				}else{
					auditLog.setEntityId(0);
				}
			}else if (requestType.equals("POST")){
				if(request!=null){
					if(request.getParameter("hdTenderId") !=null && pInt(request,"hdTenderId") > 0){
						auditLog.setEntityId(pInt(request,"hdTenderId"));
					}else if(request.getParameter("tenderId") !=null && pInt(request,"tenderId") > 0){
						auditLog.setEntityId(pInt(request,"tenderId"));
					}else {
						auditLog.setEntityId(0);
					}
				}else{
					auditLog.setEntityId(0);
				}
			}else{
					auditLog.setEntityId(0);
			}
			}
		}
			if(request!=null){
				if(!isSkipURL) {
	        		commonDao.save(auditLog);
	        	}
			}
		}
	}
	
	public Integer pInt(HttpServletRequest request, String val){
		if(request.getParameter(val) != null && !"".equals(request.getParameter(val))){
			return Integer.parseInt(request.getParameter(val));
		}
		return 0;
	}
	private boolean isPageSkipped(String uri,String contextName) {
		boolean pageSkipped = false;
        if(uri.equals(contextName+"/")){
        	pageSkipped = true;
        }else {
		    for(String str : skipURL){
		    	if(uri.contains(contextName+str)){
		    		pageSkipped = true;
		    		break;
		    	}
		    }
        }
        return pageSkipped;
    }
}


