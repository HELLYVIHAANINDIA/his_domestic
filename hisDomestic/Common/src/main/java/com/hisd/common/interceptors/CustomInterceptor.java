package com.hisd.common.interceptors;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hisd.common.services.CommonDAO;
import com.hisd.common.services.CommonService;
import com.hisd.common.utility.EncryptDecryptUtils;
import com.hisd.common.utility.SessionBean;

public class CustomInterceptor implements HandlerInterceptor  {
	
	    private static final String PASSWORD = "@Dev1238";
	    private static final String SECRETKEY = "DES";
	    private static final String UTF8 = "UTF-8";
	
	@Autowired
	CommonDAO commonDao;
	@Autowired
	CommonService commonService;
	@Autowired
	EncryptDecryptUtils encrptDecryptUtils;
	
	
	static Set<String> skipURL = new HashSet<String>();
	public CustomInterceptor(){
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
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String contextPath=request.getContextPath();
		if(!isPageSkipped(request.getRequestURI(), contextPath)) {
			if((SessionBean)request.getSession().getAttribute("sessionObject")==null) {
				response.sendRedirect(request.getContextPath()+"/notloggedin");
			}else {
				/*boolean isAllow = false;
				Set<String> userLinks = (Set<String>) request.getSession().getAttribute("userLinks");
					if(request.getMethod().equalsIgnoreCase("GET")){
						String encryptParam = request.getParameter("enc");
						String decryptParam = encrptDecryptUtils.decryptParam(encryptParam);
						StringBuffer urlWithoutEncryption = new StringBuffer(request.getRequestURI());
						if(urlWithoutEncryption.toString().equals(decryptParam)){
							for (String link : userLinks) {
								if(request.getRequestURI().contains(link)) {
									isAllow=true;
								}
							}
						}else{
							//making entry in table for temp purpose
							TblLinkAlter  linkAlter = new TblLinkAlter();
							linkAlter.setURL(request.getRequestURI());
							linkAlter.setType(request.getMethod() );
							commonDao.save(linkAlter);
							for (String link : userLinks) {
								if(request.getRequestURI().contains(link)) {
									isAllow=true;
								}
							}
//							isAllow=false;
						}
					}else{
						for (String link : userLinks) {
							if(request.getRequestURI().contains(link)) {
								isAllow=true;
							}
						}
					}
				if(!isAllow) {
					response.sendRedirect(request.getContextPath()+"/unauthorizedaccess");
				}*/
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// no implementation needed 
		
		
	}
	
	boolean isPageSkipped(String uri,String contextName) {
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
