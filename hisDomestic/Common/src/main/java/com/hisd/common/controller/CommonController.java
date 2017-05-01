package com.hisd.common.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hisd.common.model.CommonListing;
import com.hisd.common.model.TblMarquee;
import com.hisd.common.model.TblProcess;
import com.hisd.common.services.CommonService;


@Controller
public class CommonController {
	
	@Autowired
	CommonService commonService;
	
	/*@Value("#{etenderProperties['client_dateformate']}")
    private String client_dateformate;
	@Value("#{etenderProperties['client_dateformate_hhmm']}")
    private String client_dateformate_hhmm;
	@Value("#{etenderProperties['sql_dateformate']}")
    private String sql_dateformate;
	@Value("#{etenderProperties['msg_marquee_success']}")
    private String msg_marquee_success;
	@Value("#{etenderProperties['msg_bidder_message_success']}")
    private String msg_bidder_message_success;*/
	
	
/*    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage(HttpServletRequest request,HttpServletResponse response) {
    	if(request.getSession().getAttribute("sessionObject")!=null) {
    		return "redirect:etenderdashboard";
    	}else {
    		return "redirect:login";
    	}
    }*/


	
	    
   /* @ResponseBody
    @RequestMapping(value = "/etender/commonDataGrid",method = {RequestMethod.GET, RequestMethod.POST})
    public String commonDataGrid(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	String res = commonService.setListingData(request);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
    	return res;
    }*/
    
    @RequestMapping(value = "/listingDemo.htm",method = RequestMethod.GET)
    public ModelAndView listingDemo(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	 ModelAndView modelAndView = new ModelAndView("etender/ListingDemo");
    	return modelAndView;
    }
    
   /* @RequestMapping(value = "/etender/commonListPage/{listingId}",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView commonListPage(@PathVariable("listingId") int listingId, HttpServletRequest request,HttpServletResponse response) throws SQLException,ArrayIndexOutOfBoundsException,NullPointerException{
    	ModelAndView modelAndView = new ModelAndView("etender/CommonListingPage");
    	List<CommonListing> list = commonService.getCommonListPageData(listingId);
    	if(list != null && !list.isEmpty()){
    		modelAndView.addObject("listingDemo", list.get(0));
    	}
    	return modelAndView;
    }*/
    
    
    
    @RequestMapping(value = "/common/audittrial", method = RequestMethod.GET)
    public String getManageUser(ModelMap modelMap, HttpServletRequest request) {
		try {
		} catch (Exception ex) {
		    
		} finally {
		}
	return "etender/buyer/Audittrial";
    }
    
    @ResponseBody
    @RequestMapping(value = "/ajax/departments/{grandDeptId}/{parentDeptId}/{deptId}", method = RequestMethod.POST)
    public String getOfficerList(@PathVariable("grandDeptId") String grandDeptId,@PathVariable("parentDeptId") String parentDeptId,@PathVariable("deptId") String deptId,ModelMap modelMap, HttpServletRequest request) {
    	String jsonStr = "0";
	try {
		List<Integer> deptLSt = commonService.getDeptDetailByDeptIds(Integer.parseInt(grandDeptId), Integer.parseInt(parentDeptId), Integer.parseInt(deptId));
		for (Integer integer : deptLSt) {
			jsonStr=jsonStr+','+integer;
		}
		
	} catch (Exception ex) {
	} finally {
	}
	return jsonStr;
    }
    
    
    
}
