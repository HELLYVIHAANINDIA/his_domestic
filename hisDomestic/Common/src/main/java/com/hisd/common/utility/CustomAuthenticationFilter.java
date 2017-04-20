/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.common.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.expression.ParseException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 */
public class CustomAuthenticationFilter implements AuthenticationManager {

    private SessionFactory sessionFactory;
    private int failedattempt;
    private EncryptDecryptUtils encryptDecryptUtils;
    private int bidderstatus;
    private int actiontype;
    private int cstatusPending;
    private boolean isPerformanceInstance;

    public CustomAuthenticationFilter(SessionFactory sessionFactory, int failedattempt, EncryptDecryptUtils encryptDecryptUtils, int bidderstatus, int actiontype, int cstatusPending,boolean isPerformanceInstance) {
        this.sessionFactory = sessionFactory;
        this.failedattempt = failedattempt;
        this.encryptDecryptUtils = encryptDecryptUtils;
//        this.sendMessageUtil = sendMessageUtil;
        this.bidderstatus = bidderstatus;
        this.actiontype = actiontype;
        this.cstatusPending = cstatusPending;
        this.isPerformanceInstance = isPerformanceInstance;
        //        this.mailContentUtillity = (MailContentUtillity) context.getBean("mailContentUtillity");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Session session = sessionFactory.openSession();
        HttpServletRequest request = getServletRequest();
        HttpSession httpSession = request.getSession();
        int i = 0;
        int isEmailVerified=0;
        boolean Allow = false;
        StringBuilder loginWidEmailId = null;
        List resultSetList1 = null;
        try{
            loginWidEmailId = new StringBuilder();
            loginWidEmailId.append("select new map(ul.loginid as loginid,ul.password as password) ");
            loginWidEmailId.append("from TblUserLogin ul ");
            loginWidEmailId.append("where ul.loginid=:loginid");
            Query query1 = session.createQuery(loginWidEmailId.toString());
            query1.setString("loginid", authentication.getName());
            resultSetList1 = query1.list();
            if(resultSetList1!=null && !resultSetList1.isEmpty() && resultSetList1.size()>0){
                i = resultSetList1.size();
            }
                if (i != 0) {
                    Allow = true;
                }

        }catch(Exception e){
            e.printStackTrace();
        }
        if(Allow){
            String loginid = null;
            String password = null;
            String userType = null;
            int failedAttempts = 0;
            String userName = null;
            int userid = 0;            
            StringBuilder loginQuery = new StringBuilder();
            loginQuery.append("select new map(ul.loginid as loginid,ul.password as password,ul.failedattempt as failedattempt,ul.userId as userId )");
            loginQuery.append("from TblUserLogin ul ");
            loginQuery.append("where ul.loginid=:loginid");
            Query query1 = session.createQuery(loginQuery.toString());
            query1.setString("loginid", authentication.getName());
            List resultSetList = query1.list();
            Iterator it = resultSetList.iterator();
            if (resultSetList != null && !resultSetList.isEmpty()) {
                while (it.hasNext()) {
                    Map resultMap = (HashMap) it.next();
                    loginid = resultMap.get("loginid").toString();
                    if(isPerformanceInstance){
                        password = (resultMap.get("password")!=null && !"".equalsIgnoreCase(resultMap.get("password").toString()))?resultMap.get("password").toString():"";
                    }else{
                    	password = (resultMap.get("password")!=null && !"".equalsIgnoreCase(resultMap.get("password").toString()))?resultMap.get("password").toString():"";
//                        password = (resultMap.get("password")!=null && !"".equalsIgnoreCase(resultMap.get("password").toString()))?new SHA256HashEncryption().encodeStringSHA256(resultMap.get("password").toString() + httpSession.getAttribute("TEMP_RNDNO")):"";
                    }
                    failedAttempts = Integer.parseInt(resultMap.get("failedattempt").toString());
                    userid = Integer.parseInt(resultMap.get("userId").toString());
                    httpSession.removeAttribute("TEMP_RNDNO");
                    httpSession.setAttribute("userId", userid);
                }

                if (loginid != null && loginid.equalsIgnoreCase(authentication.getName())) {
                    if (failedAttempts == failedattempt) {
//                    	userType = setData(session,userid,isEmailVerified,request,userName,loginid);
                    	Authentication auth = new  UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials().toString().split("@@")[0].toString(), getAuthorities(userType));
                    	if(password.equals(auth.getCredentials().toString().split("@@")[0]))
                    	{
                    		Query updateQuery = session.createQuery("UPDATE EcommonTbluserloginEntity tblUserLogin SET tblUserLogin.failedattempt=:attampt WHERE tblUserLogin.loginid=:loginid");
                    		updateQuery.setString("loginid", authentication.getName());
                    		updateQuery.setInteger("attampt",0);
                    		updateQuery.executeUpdate();
//                    		 TblUserHistory tblUserHistory = new TblUserHistory();
//                             tblUserHistory.setActionType(8);
//                             tblUserHistory.setTblClient(new TblClient(clientId));
//                             tblUserHistory.setCreatedBy(0);
//                             tblUserHistory.setTblUserLogin(new TblUserLogin(userid));
//                             session.save(tblUserHistory);
//                             userType = setData(session,userid,clientId,isEmailVerified,clientBean,request,userName,loginid);
                         	return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials().toString().split("@@")[0].toString(), getAuthorities("admin"));
                    	}else{
                    		throw new LockedException("User is Locked");
                    	}
                    } else {
                    	boolean flag = false;
                    		flag = password.equals(authentication.getCredentials().toString().split("@@")[0]);//local check
                        if (flag){
//                        	userType = setData(session,userid,isEmailVerified,request,userName,loginid);
                        	request.setAttribute("userId", userid);
                        	httpSession.setAttribute("userId", userid);
                        	return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials().toString().split("@@")[0].toString(), getAuthorities("Officer"));
                        }else {
                            throw new BadCredentialsException("Bad credentials");
                        }
                    }
                } else {
                    throw new BadCredentialsException("Bad credentials");
                }
            } else {
                throw new BadCredentialsException("Bad credentials");
            }
        }else{
        	throw new BadCredentialsException("Bad credentials");	
        }
    }
    
    
    
    
    public HttpServletRequest getServletRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }

    public Collection<GrantedAuthority> getAuthorities(String access){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

        if (access.equals("Bidder")) {
            authList.add(new GrantedAuthorityImpl("ROLE_BIDDER"));
        }
        if (access.equals("Officer")) {
            authList.add(new GrantedAuthorityImpl("ROLE_OFFICER"));
        }
        if (access.equals("Admin")) {
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authList;
    }
    
    
    public Date getServerDateTime() throws ParseException {
    	Session session = sessionFactory.openSession();
    	Query blacklistQuery = session.createSQLQuery("select getutcdate()");
        List list = blacklistQuery.list();
        Date retVal = null;
        if (list != null && !list.isEmpty()) {
        	SimpleDateFormat clientDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            retVal = (Date) (Object)list.get(0).toString().split(" ")[0];
        }
        return retVal;
    }
    
    private String setData(Session session,int userid,int isEmailVerified,HttpServletRequest request,String userName,String loginid){

        //                        --status for bidder             --status for officer
        //                        0 - Pending                      0 - Pending
        //                        1 - Approved                     1 - Approved
        //                        2 - Disabled                     2 - Disabled
        //                        3 - Blacklisted
        //                        4 - Expired
    	String userType = null;
    	String compName = null;
        int status = 0;
        StringBuilder loginQuery = new StringBuilder();
        loginQuery.append("select endDate,cstatus,bidderId,tblRegistrationWorkflow.registrationWorkflowId from TblBidderStatus where tblUserLogin.userid=:userid and tblClient.clientId=:clientId");
        Query query2 = session.createQuery(loginQuery.toString());
        query2.setInteger("userid", userid);
        List<Object[]> list1 = query2.list();
        boolean neitherBidderNorOfficer = true;
        int bidderRegVerifiedBy = 0;
        int officerRegVerifiedBy = 0;
        if (!list1.isEmpty()) {
        	for (Object[] data : list1) {
                if (data[0] != null && ((Date) data[0]).before(new Date())) {
                    throw new CredentialsExpiredException("User Validity Expired");
                }
                status = (Integer) data[1];
                if (status == 0) {
                    throw new DisabledException("User Pending");
                } else if (status == 1) {
                    if (isEmailVerified == 0) {
                         throw new DisabledException("email not verified");
                    }
                    userType = "Bidder";
                } else if (status == 2) {
                    throw new DisabledException("User Disabled");
                } else if (status == 3) {
                    loginQuery.delete(0, loginQuery.length());
                    loginQuery.append("select tblUserBlackList.endDate,tblUserBlackList.type,tblUserBlackList.startDate,tblUserBlackList.userBlackListId from TblUserBlackList tblUserBlackList ");
                    loginQuery.append(" where tblUserBlackList.tblBidderStatus.bidderId=:bidderId and tblUserBlackList.cstatus=1 order by tblUserBlackList.userBlackListId desc");
                    Query blacklistQuery = session.createQuery(loginQuery.toString());
                    blacklistQuery.setInteger("bidderId", (Integer) data[2]);
                    blacklistQuery.setFirstResult(0);
                    blacklistQuery.setMaxResults(1);
                    List<Object[]> blackListUser = blacklistQuery.list();
                    if (!blackListUser.isEmpty()) {
                        for (Object[] user : blackListUser) {
                            if (user[1] != null && (Integer) user[1] == 2) {
                                throw new DisabledException("Your profile is permanently blacklisted");
                            } else if (user[1] != null && (Integer) user[1] == 1) {
                                try {
                                        Date serverDate=getServerDateTime();
                                        SimpleDateFormat clientDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        Date endDate=(Date)user[0];
                                        Date startDate=(Date)user[2];
                                        if (user[0] != null && (((endDate).after(serverDate) || (endDate).equals(serverDate)) && ((startDate).before(serverDate) || (startDate).equals(serverDate))) || (endDate).equals(serverDate)) {
                                            throw new CredentialsExpiredException("Your Profile has been blacklisted");//till + CommonUtility.convertTimezoneToClientTimezone(user[0].toString()));
                                        } else {
                                        	Query bidderQuery = session.createQuery("update TblBidderStatus tblBidderStatus set tblBidderStatus.cstatus=:cstatus where tblBidderStatus.bidderId=:bidderId ");
                                        	bidderQuery.setInteger("bidderId", (Integer) data[2]);
                                        	bidderQuery.setInteger("cstatus", 1);
                                        	
                                        	Query bidderBlackLstQuery = session.createQuery("update TblUserBlackList tblUserBlackList set tblUserBlackList.cstatus=:cstatus where tblUserBlackList.userBlackListId=:userBlackListId");                                                                                                            	
                                        	bidderBlackLstQuery.setInteger("cstatus", 2);
                                        	bidderBlackLstQuery.setInteger("userBlackListId", (Integer) user[3]);
                                            	bidderBlackLstQuery.executeUpdate();
                                                bidderQuery.executeUpdate();
                                                userType = "Bidder";
                                        }
                                        } catch (ParseException e) {
                                                e.printStackTrace();
                                        }
                            }
                        }
                    }
                } else if (status == 4) {
                    throw new DisabledException("User Expired");
                } else if (status == 5 || status == 6) {
                    if (isEmailVerified == 1) {
                        userType = "Bidder";
                    } else {
                        throw new DisabledException("email not verified");
                    }
                } else if (status == 7) {
                    throw new DisabledException("User Rejected");
                }
            }
            neitherBidderNorOfficer = false;
        } else {
        if(officerRegVerifiedBy == 0)
        isEmailVerified = 1;
        loginQuery.delete(0, loginQuery.length());
        loginQuery.append("select tblClient.clientId,cstatus,isAdmin from TblOfficer where tblUserLogin.userid=:userid");
        Query query3 = session.createQuery(loginQuery.toString());
        query3.setInteger("userid", userid);
        List<Object[]> list2 = query3.list();
        if (!list2.isEmpty()) {
            for (Object[] data : list2) {
                status = (Integer) data[1];
                if ((Integer) data[2] == 1) {
                    userType = "Admin";
                } else {
                    userType = "Officer";
                }
                	if (isEmailVerified == 0) {
                        throw new DisabledException("email not verified");
                    }
                    if (status == 0) {
                        throw new DisabledException("User Pending");
                    } else if (status == 2) {
                        throw new DisabledException("User Disabled");
                    }
            }
        }
        }
        return userType;
    }
        
        
        public int getCountary(String countary,Session session) throws Exception{
            int countryId = 0;
////            Criteria criteria = session.createCriteria(TblCountry.class).add(Restrictions.eq("lang1", countary));
////            List<TblCountry> list = criteria.list();
//            if(list!=null && !list.isEmpty()){
//                    countryId = list.get(0).getCountryId();
//            }else{
////                TblCountry tblCountry = new TblCountry();
//                tblCountry.setLang1(countary);
//                tblCountry.setIsoCode("0");
//                session.save(tblCountry);
//                countryId = tblCountry.getCountryId();
//            }
             return countryId;
        }
        public int getState(String state,int countaryId,Session session) throws Exception{
            int stateId = 0;
//            Criteria criteria = session.createCriteria(TblState.class).add(Restrictions.eq("lang1", state));
//            List<TblState> list = criteria.list();
//            if(list!=null && !list.isEmpty()){
//                    stateId = list.get(0).getStateId();
//            }else{
//                TblState tblState = new TblState();
//                tblState.setLang1(state);
//                tblState.setTblCountry(new TblCountry(countaryId));
//                session.save(tblState);
//                stateId = tblState.getStateId();
//             }
             return stateId;
        }
}
