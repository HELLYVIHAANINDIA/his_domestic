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


	
	    
    @ResponseBody
    @RequestMapping(value = "/etender/commonDataGrid",method = {RequestMethod.GET, RequestMethod.POST})
    public String commonDataGrid(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	String res = commonService.setListingData(request);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
    	return res;
    }
    
    @RequestMapping(value = "/listingDemo.htm",method = RequestMethod.GET)
    public ModelAndView listingDemo(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	 ModelAndView modelAndView = new ModelAndView("etender/ListingDemo");
    	return modelAndView;
    }
    
    @RequestMapping(value = "/etender/commonListPage/{listingId}",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView commonListPage(@PathVariable("listingId") int listingId, HttpServletRequest request,HttpServletResponse response) throws SQLException,ArrayIndexOutOfBoundsException,NullPointerException{
    	ModelAndView modelAndView = new ModelAndView("etender/CommonListingPage");
    	List<CommonListing> list = commonService.getCommonListPageData(listingId);
    	if(list != null && !list.isEmpty()){
    		modelAndView.addObject("listingDemo", list.get(0));
    	}
    	return modelAndView;
    }
    
    @RequestMapping(value = "/common/addEditMarquee/{tenderId}",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView addEditMarquee(HttpServletRequest request,@PathVariable("tenderId") int tenderId,HttpServletResponse response) throws Exception{
    	ModelAndView modelAndView = new ModelAndView("/common/addEditMarquee");
    	List<TblMarquee> tblMarquee = commonService.getTblMarquee(tenderId,8,0);
    	if(tblMarquee != null && !tblMarquee.isEmpty()){
    		/*String startDate = commonService.convertSqlToClientDate(client_dateformate_hhmm, tbl.getStartDate());
    		String endDate = commonService.convertSqlToClientDate(client_dateformate_hhmm, tbl.getEndDate());
    		modelAndView.addObject("startDate",startDate);
    		modelAndView.addObject("endDate",endDate);*/
    		modelAndView.addObject("tblMarquee",tblMarquee.get(0));
    	}
    	return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/common/removeMarquee/{marqueeId}",method = {RequestMethod.GET, RequestMethod.POST})
    public String removeMarquee(@PathVariable("marqueeId") Integer marqueeId,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	commonService.deleteMarqueeById(marqueeId);
    	return "success";
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/common/viewMarquee/{tenderId}",method = {RequestMethod.GET, RequestMethod.POST})
    public String viewMarquee(@PathVariable("tenderId") int tenderId, HttpServletRequest request,HttpServletResponse response) throws Exception{
    	List<TblMarquee> tblMarquee = commonService.getTblMarquee(tenderId,8,0);
    	String marqueeText = "";
    	if(tblMarquee != null && !tblMarquee.isEmpty()){
    	}
    	return marqueeText;
    }
    
    @RequestMapping(value = "/common/submitMarquee",method = {RequestMethod.POST})
    public ModelAndView submitMarquee(HttpServletRequest request,HttpServletResponse response,final RedirectAttributes redirectAttributes) throws Exception{
    	ModelAndView modelAndView = null;
    	String marqueeId = request.getParameter("marqueeId");
    	String marequeeText = request.getParameter("txtaMarquee");
    	String tenderId = request.getParameter("tenderId");
    	TblMarquee tblMarquee = null;
    	if("0".equals(marqueeId)){
    		tblMarquee = new TblMarquee();
    	}else{
    		tblMarquee = new TblMarquee(Integer.parseInt(marqueeId));
    	}
//    	tblMarquee.setStartDate(commonService.convertStirngToUTCDate(client_dateformate_hhmm, startDate));
//    	tblMarquee.setEndDate(commonService.convertStirngToUTCDate(client_dateformate_hhmm, endDate));
    	tblMarquee.setMarqueeText(marequeeText);
    	tblMarquee.setCreatedBy(commonService.getSessionUserId(request));
    	tblMarquee.setCreatedOn(commonService.getServerDateTime());
    	tblMarquee.setIsActive(1);
    	tblMarquee.setTblProcess(new TblProcess(8));
    	tblMarquee.setTenderId(Integer.parseInt(tenderId));
    	commonService.saveMarquee(tblMarquee);
    	if(Integer.parseInt(tenderId) == 0){
//    		redirectAttributes.addFlashAttribute(CommonKeywords.SUCCESS_MSG.toString(),msg_marquee_success);
    		modelAndView = new ModelAndView("redirect:/common/addEditMarquee/0");
    	}else{
//    		redirectAttributes.addFlashAttribute(CommonKeywords.SUCCESS_MSG.toString(),msg_bidder_message_success);
    		modelAndView = new ModelAndView("redirect:/etender/buyer/tenderDashboard/"+tenderId);
    	}
    	//redirectAttributes.addFlashAttribute("message", "saved successfully");
    	return modelAndView;
    }
    
    
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
