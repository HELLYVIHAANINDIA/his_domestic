/* * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hisd.common.services.ExceptionHandlerService;
import com.hisd.common.utility.CommonKeywords;
import com.hisd.common.utility.SessionBean;

@Controller
public class DashboardContoller {
	
	@Autowired
	private ExceptionHandlerService exceptionHandlerService;

	private static final String REDIRECT_SESSION_EXPIRED = "redirect:/notloggedin";
	
	@RequestMapping(value ={"/domestic/user/dashboard"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String tenderListing(ModelMap modelMap,HttpServletRequest request,Model  model)  {
        String page = REDIRECT_SESSION_EXPIRED;
	    try{
			HttpSession session = request.getSession();
			int tabid = 0;
		    SessionBean sessionBean=(SessionBean)session.getAttribute(CommonKeywords.SESSION_OBJ.toString());
		    if(sessionBean!=null){
		    	modelMap.addAttribute("userType",sessionBean.getUserTypeId());
		    	modelMap.addAttribute("issuperadmin",sessionBean.getIsCTPLUser()==1?true:false);
		    	int hdPatientId = request.getParameter("hdPatientId") != null ? Integer.parseInt(request.getParameter("hdPatientId").toString()) : 0;
		    	
		    	if(sessionBean.getIsCTPLUser()==1){
		    		tabid = 1 ;
		    	}else{
		    		if(sessionBean.getUserTypeId() == 1){
		    			tabid = 0;
		    			if(model.asMap().get("redirectTabId")!=null){
		    				tabid = Integer.parseInt(model.asMap().get("redirectTabId").toString());
				    	}else if(hdPatientId != 0){
				    		tabid = 7;
				    	}else if(model.asMap().get("redirectPatientId")!=null){
				    		tabid = 7;
				    		hdPatientId = Integer.parseInt(model.asMap().get("redirectPatientId").toString());
				    	}
		    		}else if(sessionBean.getUserTypeId() == 2){
		    			tabid = 0;
		    		}
		    		else {
		    			tabid = 3;
		    		}
		    	}
		    	modelMap.addAttribute("hdPatientId", hdPatientId);
		    	modelMap.addAttribute("tabid", tabid);
		    	page = "/user/HomePage";
		    }
		}catch(Exception e){
			exceptionHandlerService.writeLog(e);
		}
        return page;
    }
	
}  