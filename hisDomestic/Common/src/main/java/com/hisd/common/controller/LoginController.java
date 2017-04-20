package com.hisd.common.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hisd.common.model.TblTimezone;
import com.hisd.common.services.CommonService;
import com.hisd.common.services.ExceptionHandlerService;
import com.hisd.common.utility.CommonKeywords;
import com.hisd.common.utility.EncryptDecryptUtils;
import com.hisd.common.utility.SessionBean;
import com.hisd.common.utility.SpringMailSender;
//import com.hisd.common.utility.SpringMailSender;

@Controller
public class LoginController {
	@Autowired	
	private SessionFactory sessionFactory;
	@Autowired
	private CommonService commonServices;
	@Autowired
	private ExceptionHandlerService exceptionHandlerService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SpringMailSender mailSender;
	@Value("#{hospitalProperties['default_offsettime']}")
    private String default_offsettime;
	@Value("#{hospitalProperties['client_dateformate_hhmm']}")
    private String client_dateformate_hhmm;
	@Value("#{projectProperties['stagingurl']}")
    private String stagingurl;
	@Autowired
    private EncryptDecryptUtils encrptDecryptUtils;
	@Value("#{projectProperties['registrationkey']}")
    private String registrationkey;
	@Value("#{projectProperties['passwordkey']}")
    private String passwordkey;
	
	
	
	
	@RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request) throws Exception {
		if(request.getSession().getAttribute("sessionObject")!=null) {
			SessionBean bean = (SessionBean)request.getSession().getAttribute("sessionObject");
//			if(bean.getUserTypeId() == 1){
				return "redirect:/domestic/user/dashboard";
//			}else{
//				return "redirect:etender/bidder/bidderTenderListing/0";
//			}
    	}else {
    		return "Login";
    	}
	}

	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public String submitLogin(HttpServletRequest request,final RedirectAttributes redirectAttributes) throws Exception {
		String redirect = "";
		Session session = sessionFactory.openSession();
        HttpSession httpSession = request.getSession();
        int i = 0;
        boolean Allow = false;
        StringBuilder loginWidEmailId = null;
        List resultSetList1 = null;
        String userName = StringUtils.hasLength(request.getParameter("j_username")) ? request.getParameter("j_username") : "";
        String password = StringUtils.hasLength(request.getParameter("j_password")) ? request.getParameter("j_password") : "";
        try{
            loginWidEmailId = new StringBuilder();
            loginWidEmailId.append("select new map(ul.loginid as loginid,ul.password as password) ");
            loginWidEmailId.append("from TblUserLogin ul ");
            loginWidEmailId.append("where ul.loginid=:loginid");
            Query query1 = session.createQuery(loginWidEmailId.toString());
            query1.setString("loginid",userName);
            resultSetList1 = query1.list();
            if(resultSetList1!=null && !resultSetList1.isEmpty() && resultSetList1.size()>0){
                i = resultSetList1.size();
            }
                if (i != 0) {
                    Allow = true;
                }
                if(Allow){
                    String loginid = null;
                    String passwordDb = null;
                    int failedAttempts = 0;
                    long userid = 0;
                    Integer userType=0;
                    Integer isOrgenizationUser=0;
                    Integer isCTPLUser=0;
                    Date lastLoginDateAndTime=null;
                    int cstatus=0;
                    int timezoneId=0;
                    int isFirstLogin=0;
                    StringBuilder loginQuery = new StringBuilder();
                    
                    loginQuery.append("select new map(ul.loginid as loginid,ul.password as password,ul.isCTPLUser as isCTPLUser,ul.failedattempt as failedattempt,ul.userId as userId,ul.tblUserType.usertypeid as userType,cstatus as cstatus,ul.lastLogin as lastLogin , ul.isFirstLogin as isFirstLogin)");
                    loginQuery.append("from TblUserLogin ul ");
                    loginQuery.append("where ul.loginid=:loginid");
                    Query query2 = session.createQuery(loginQuery.toString());
                    query2.setString("loginid", userName);
                    List resultSetList = query2.list();
                    Iterator it = resultSetList.iterator();
                    if (resultSetList != null && !resultSetList.isEmpty()) {
                        while (it.hasNext()) {
                            Map resultMap = (HashMap) it.next();
                            loginid = resultMap.get("loginid").toString();
                            userType = (Integer)resultMap.get("userType");
                            passwordDb = (resultMap.get("password")!=null && !"".equalsIgnoreCase(resultMap.get("password").toString()))?resultMap.get("password").toString():"";
                            passwordDb = encrptDecryptUtils.decrypt(passwordDb,passwordkey.substring(0, 16).toString().getBytes());
                            failedAttempts = Integer.parseInt(resultMap.get("failedattempt").toString());
                            userid = Integer.parseInt(resultMap.get("userId").toString());
                        	isCTPLUser=Integer.parseInt(resultMap.get("isCTPLUser").toString());
                        	cstatus=Integer.parseInt(resultMap.get("cstatus").toString());
//                        	timezoneId=Integer.parseInt(resultMap.get("timezoneId").toString());
                        	lastLoginDateAndTime=(Date) resultMap.get("lastLogin");
                        	isFirstLogin=Integer.parseInt(resultMap.get("isFirstLogin").toString());
                        }
                        if(cstatus==1) {
	                        if (loginid != null && loginid.equalsIgnoreCase(userName)) {
	                            	boolean flag = false;	
	                            		flag = password.equals(passwordDb);
	                            		if(flag) {
//	                            			List<Integer> userRoles = commonServices.getUserRoleByUserId((Long)userid);
//	                                		if(userRoles!=null && !userRoles.isEmpty()) {
//	                                			Set<Object[]> userLinks = commonServices.getLinkDetailsByRoleId(userRoles);
//	                                			Map<String,String> userLinksDtl = new HashMap<String, String>();
//	                                			Set<String> userLinksSet = new HashSet<String>();
//	                                			for (Object[] link : userLinks) {
//	                                				userLinksDtl.put((String)link[1], (String)link[2]);
//	                                				userLinksSet.add((String)link[1]);
//												}
//	                                			if(userLinks!=null && !userLinks.isEmpty()) {
//	                                				httpSession.setAttribute("userLinks", userLinksSet);
//	                                				httpSession.setAttribute("userLinksDtls", userLinksDtl);
//	                                			}
//	                                		}
	                                    	httpSession.setAttribute("userId", userid);
	                                    	SessionBean sessionBean = new SessionBean();
	                                    	sessionBean.setUserId(userid);
	                                    	
	                                    	sessionBean.setUserName(userName);
	                                    	sessionBean.setUserTypeId(userType);
	                                    	sessionBean.setIsCTPLUser(isCTPLUser);
	                                    	if(lastLoginDateAndTime != null){
		                                    	String lastLogin = commonService.convertSqlToClientDate(client_dateformate_hhmm, lastLoginDateAndTime.toString());
		                                    	sessionBean.setLastLoginDateTime(lastLogin);
	                                    	}
	                                    	List<TblTimezone> tblTimezone =  commonService.getTimezoneList(timezoneId);
	                                    	if(tblTimezone != null && !tblTimezone.isEmpty()){
	                                    		TblTimezone tblTimezone2 = tblTimezone.get(0);
	                                    		sessionBean.setTimeZoneOffset(tblTimezone2.getUtcOffset());
	                                    		sessionBean.setTimezoneId(tblTimezone2.getTimezoneId());
	                                    	}else{
	                                    		sessionBean.setTimeZoneOffset(default_offsettime);
	                                    		sessionBean.setTimezoneId(0);
	                                    	}
	                                    	
                                    		if(isFirstLogin==1) {
                                    			redirect = "redirect:/user/getpasswordchange/"+userid+"/"+1;
                                    		}else {
                                    			if(isCTPLUser == 1 || userType==1 || userType==2){
                                    				redirect = "redirect:/domestic/user/dashboard";
                                    			}
	                                    	}
	                                    		
	                                    	httpSession.setAttribute("sessionObject", sessionBean);
	                                    	commonService.updateLastLogin(userid, commonService.getServerDateTime());
	                            		} else {
	                            			redirectAttributes.addFlashAttribute("message", "Login credentials are invalid.");
	                            			redirect="redirect:loginfailed";
	                                        throw new BadCredentialsException("Bad credentials");
	                                    }
	                        } else {
	                        	redirectAttributes.addFlashAttribute("message", "Login credentials are invalid.");
	                        	redirect="redirect:loginfailed";
	                            throw new BadCredentialsException("Bad credentials");
	                        }
                        }else {
                        	if(cstatus==0) {
                        		redirectAttributes.addFlashAttribute("message", "Your request is pending for approval");
	                        	redirect="redirect:loginfailed";
	                            throw new BadCredentialsException("Bad credentials");	
                        	}else if(cstatus==2) {
                        		redirectAttributes.addFlashAttribute("message", "Your request is rejected");
	                        	redirect="redirect:loginfailed";
	                            throw new BadCredentialsException("Bad credentials");
                        	}else if(cstatus==3) {
                        		redirectAttributes.addFlashAttribute("message", "Your account is di-activated");
	                        	redirect="redirect:loginfailed";
	                            throw new BadCredentialsException("Bad credentials");
                        	}
                        }
                    } else {
                    	redirectAttributes.addFlashAttribute("message", "Your request is pending for approval");
                    	redirect="redirect:loginfailed";
                        throw new BadCredentialsException("User doesn't exists");
                    }
                }else{
                	redirectAttributes.addFlashAttribute("message", "Your request is pending for approval");
                	redirect="redirect:loginfailed";
                    throw new BadCredentialsException("User doesn't exists");
                }
        }catch(Exception e){
            exceptionHandlerService.writeLog(e);
        }
        if(redirect.isEmpty()){
        	redirect = "redirect:/domestic/user/dashboard";
        }
		return redirect;
	}
	
	public HttpServletRequest getServletRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }
	
	@RequestMapping(value = {"/submitlogout","/sessionexpired","/notloggedin"}, method = RequestMethod.GET)
	public String submitLogout(HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();  
        if(session != null){
        	session.invalidate();
        }
		return "redirect:/login";
	}

	@RequestMapping(value = {"/etenderdashboard"}, method = RequestMethod.GET)
	public String eTenderDashboard(HttpServletRequest request) {
	    return "redirect:/etender/buyer/tenderListing";
	}
	
	@RequestMapping(value = {"/unauthorizedaccess","/pagenotfound"}, method = RequestMethod.GET)
	public String unauthorizedaccess() {
	    return "UnauthorizedAccess";
	}
	
	@RequestMapping(value = {"/loginfailed"}, method = RequestMethod.GET)
	public String loginfailed() {
	    return "Login";
	}
	
	@RequestMapping(value = {"/getforgotpassword"}, method = RequestMethod.GET)
	public String getforgotpassword(HttpServletRequest request,RedirectAttributes redirectAttributes) {
	    return "ForgotPassword";
	}
	
	
	@RequestMapping(value = {"/registersuccess"}, method = RequestMethod.GET)
	public String regsistersuccess(HttpServletRequest request,RedirectAttributes redirectAttributes) {
//		redirectAttributes.addFlashAttribute("message", msg_bidder_create_successfully);
	    return "RegisterSuccess";
	}
	
	
	@RequestMapping(value = {"/changepasswordredirect"}, method = RequestMethod.GET)
	public String changepasswordredirect(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(CommonKeywords.SUCCESS_MSG.toString(), "msg_password_change_successfully");
	    return "PasswordChangeSuccess";
	}
	
	
	
	@RequestMapping(value = "/resetpasswordbymail/{userId}/{hash}", method = RequestMethod.GET)
	public String getforgotpassword(HttpServletRequest request,@PathVariable("userId") String userId,@PathVariable("hash") String hash,ModelMap modelMap,RedirectAttributes redirectAttributes) {
		String Redirect="redirect:/loginfailed";
		try {
			List<Object[]> userLoginDtl = commonServices.getUserLoginDetailById(Integer.parseInt(userId));
			if(userLoginDtl!=null) {
				if(userLoginDtl.get(0)[1]!=null && userLoginDtl.get(0)[2]!=null) {
					Date d1 = (Date)userLoginDtl.get(0)[2];
					Date d2 = commonServices.getServerDateTime();
				    // Get msec from each, and subtract.
				    long diff = d2.getTime() - d1.getTime();
				    long diffHours = diff / (60 * 60 * 1000);
					if(hash.equals(userLoginDtl.get(0)[1]) && diffHours<2) {
						Redirect="ResetPassword";
					}else {
						redirectAttributes.addFlashAttribute(CommonKeywords.ERROR_MSG.toString(), "msg_password_reset_link_expire");
					}
				}else {
					redirectAttributes.addFlashAttribute(CommonKeywords.ERROR_MSG.toString(), "msg_password_reset_link_expire");
				}
			}
			modelMap.addAttribute("userId",userId);
		}catch(Exception e) {
			exceptionHandlerService.writeLog(e);
		}
	    return Redirect;
	}
	
	
	
	@RequestMapping(value = "/verifyregistration/{type}/{hash}", method = RequestMethod.GET)
	public String getVerifyRegistration(HttpServletRequest request,@PathVariable("type") String type,@PathVariable("hash") String hash,ModelMap modelMap,RedirectAttributes redirectAttributes) {
		String Redirect="redirect:/loginfailed";
		try {
			String decodeHash = hash.replace("~d~", "/");
			int userId = Integer.parseInt(encrptDecryptUtils.decrypt(decodeHash, registrationkey.substring(0, 16).getBytes()));
			List<Object[]> userLoginDtl = null;
			int isEmailverified = 0;
			if(type.equals("org")){
				userLoginDtl = commonServices.getDepartmentById(userId);
				isEmailverified = userLoginDtl.get(0)[2]!=null ? Integer.parseInt(userLoginDtl.get(0)[2].toString()) : 0 ;
			}else{
				userLoginDtl = commonServices.getBidderDtls(userId);
				isEmailverified = userLoginDtl.get(0)[7]!=null ? Integer.parseInt(userLoginDtl.get(0)[7].toString()) : 0 ;
			}
			modelMap.addAttribute("isEmailVerified",isEmailverified);
			if((isEmailverified!=1)){
					commonService.updateIsEmailVerified(userId,type);
			}
			if(userLoginDtl!=null) {
				Redirect="EmailVerify";
			}
			modelMap.addAttribute("userId",userId);
		}catch(Exception e) {
			exceptionHandlerService.writeLog(e);
		}
	    return Redirect;
	}
	
	
	@RequestMapping(value = {"/postforgotpassword"}, method = RequestMethod.POST)
	public String postforgotpassword(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
		String redirect = "redirect:/login";
		String emailId = request.getParameter("emailId")!=null ? request.getParameter("emailId"):"";
		StringBuilder loginWidEmailId = new StringBuilder();
		Session session = sessionFactory.openSession();
		List resultSetList1 = null;
		String generatedEmailHash = null;
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		String emailToHash = emailId+n;
		int numRow=0;
		try {
			StringBuilder loginQuery = new StringBuilder();
            loginQuery.append("select new map(ul.loginid as loginid,ul.userId as userId)");
            loginQuery.append("from TblUserLogin ul ");
            loginQuery.append("where ul.loginid=:loginid");
            Query query2 = session.createQuery(loginQuery.toString());
            query2.setString("loginid", emailId);
            List resultSetList = query2.list();
            Iterator it = resultSetList.iterator();
            if (resultSetList != null && !resultSetList.isEmpty()) {
                while (it.hasNext()) {
                    Map resultMap = (HashMap) it.next();
                    long userId = Integer.parseInt(resultMap.get("userId").toString());	
                    try {
                        // Create MessageDigest instance for MD5
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        //Add password bytes to digest
                        md.update(emailToHash.getBytes());
                        //Get the hash's bytes 
                        byte[] bytes = md.digest();
                        //This bytes[] has bytes in decimal format;
                        //Convert it to hexadecimal format
                        StringBuilder sb = new StringBuilder();
                        for(int i=0; i< bytes.length ;i++)
                        {
                            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                        }
                        //Get complete hashed password in hex format
                       generatedEmailHash = sb.toString();
                       System.out.println(generatedEmailHash);
                       commonServices.updateForgotPasswordHash(userId, generatedEmailHash);
                       String []emailIds = new String[1];
                       emailIds[0]=emailId;
                       String url = "http://"+stagingurl+"/eProcurement/resetpasswordbymail/"+userId+"/"+generatedEmailHash;
                       String href = "<a href=\""+url+"\" />";
                       StringBuilder mailContent = new StringBuilder();
//                       mailContent.append("<a href='/""http://localhost:8080/eProcurement/resetpasswordbymail/"'++'"/{hash}/"" />");
                       mailSender.sendMail("User", href, "eprocurement.help.gmail.com", emailId, "Password reset link");
                       redirectAttributes.addFlashAttribute(CommonKeywords.ERROR_MSG.toString(), "msg_check_mailid_for_reset_link");
                    } 
                    catch (NoSuchAlgorithmException e) 
                    {
                    	exceptionHandlerService.writeLog(e);
                    }
                }
            }else {
            	redirectAttributes.addFlashAttribute(CommonKeywords.ERROR_MSG.toString(), "msg_provide_valid_mailid");
            	 redirect = "redirect:/getforgotpassword";
            }
		}catch(Exception e) {
			
		}
	    return redirect;
	}
	
	
	@RequestMapping(value = {"/postresetpassword"}, method = RequestMethod.POST)
	public String postresetpassword(HttpServletRequest request,HttpServletResponse response) {
		String redirect="redirect:login";
		String txtPassword = request.getParameter("txtPassword")!=null ? request.getParameter("txtPassword"):"";
		long userId = request.getParameter("hdUserId")!=null ? Long.parseLong(request.getParameter("hdUserId")):0;
		boolean bSuccess = false;
		try 
		{
			bSuccess=commonServices.resetPassword(userId, encrptDecryptUtils.encrypt(txtPassword,passwordkey.substring(0, 16).toString().getBytes()));
        }catch (Exception e){
        	exceptionHandlerService.writeLog(e);
        }
	    return redirect;
	}
	
	@RequestMapping(value = "/user/getpasswordchange/{userId}/{usertype}", method = RequestMethod.GET)
	public String getPasswordChange(HttpServletRequest request,@PathVariable("userId") String userId,@PathVariable("usertype") String usertype,ModelMap modelMap,RedirectAttributes redirectAttributes) {
		String Redirect="ChangePassword";
		try {
			modelMap.addAttribute("userId",userId);
			modelMap.addAttribute("usertype",usertype);
		}catch(Exception e) {
			exceptionHandlerService.writeLog(e);
		}
	    return Redirect;
	}
	
	@RequestMapping(value = {"/user/postchangepassword"}, method = RequestMethod.POST)
	public String postChnagePassword(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
		String redirect="redirect:/changepasswordredirect";
		String txtPassword = request.getParameter("txtPassword")!=null ? request.getParameter("txtPassword"):"";
		String txtOldPassword = request.getParameter("txtOldPassword")!=null ? request.getParameter("txtOldPassword"):"";
		String userType = request.getParameter("hdUserType")!=null ? request.getParameter("hdUserType"):"";
		int userId = request.getParameter("hdUserId")!=null ? Integer.parseInt(request.getParameter("hdUserId")):0;
		List<Object[]> userLoginDtl = commonServices.getUserLoginDetailById(userId);
		if(userLoginDtl!=null) {
			if(encrptDecryptUtils.decrypt(userLoginDtl.get(0)[3].toString(),passwordkey.substring(0, 16).toString().getBytes()).equals(txtOldPassword.trim())) {
				commonServices.resetPassword(userId, encrptDecryptUtils.encrypt(txtPassword,passwordkey.substring(0, 16).toString().getBytes()));
				redirectAttributes.addFlashAttribute(CommonKeywords.SUCCESS_MSG.toString(), "msg_password_change_successfully");
			}else {
				redirect="redirect:/user/getpasswordchange/"+userId+"/"+userType;
				redirectAttributes.addFlashAttribute(CommonKeywords.ERROR_MSG.toString(), "msg_old_password_does_not_match");
			}
		}
	    return redirect;
	}
	
	
	

}
