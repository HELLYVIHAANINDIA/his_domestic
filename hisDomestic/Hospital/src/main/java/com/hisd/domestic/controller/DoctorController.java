package com.hisd.domestic.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hisd.common.services.CommonDAO;
import com.hisd.common.services.CommonService;
import com.hisd.common.services.ExceptionHandlerService;
import com.hisd.common.utility.CommonKeywords;
import com.hisd.common.utility.SessionBean;
import com.hisd.domestic.databean.Clinicalbean;
import com.hisd.domestic.databean.PatientBean;
import com.hisd.domestic.databean.UserDatabean;
import com.hisd.domestic.model.TblAddiction;
import com.hisd.domestic.model.TblAppointment;
import com.hisd.domestic.model.TblCaseType;
import com.hisd.domestic.model.TblClinical;
import com.hisd.domestic.model.TblClinicalReport;
import com.hisd.domestic.model.TblComplaints;
import com.hisd.domestic.model.TblConsultingDoctor;
import com.hisd.domestic.model.TblDesignation;
import com.hisd.domestic.model.TblFinding;
import com.hisd.domestic.model.TblMedicine;
import com.hisd.domestic.model.TblMedicineSchedule;
import com.hisd.domestic.model.TblPatient;
import com.hisd.domestic.model.TblPatientAddiction;
import com.hisd.domestic.model.TblPatientRefrence;
import com.hisd.domestic.model.TblReferenceType;
import com.hisd.domestic.model.TblReports;
import com.hisd.domestic.model.TblUser;
import com.hisd.domestic.model.TblUserLogin;
import com.hisd.domestic.model.TblUserType;
import com.hisd.domestic.services.AdminService;
import com.hisd.domestic.services.DoctorService;
import org.springframework.util.StringUtils;


@Controller
public class DoctorController {
	
	@Autowired
	private ExceptionHandlerService exceptionHandlerService;
	@Autowired
	private CommonService commonService;
	@Autowired
	AdminService adminService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	CommonDAO commonDAO;

	@Value("#{hospitalProperties['client_dateformate']}")
	private String clientDateFormate;
	@Value("#{hospitalProperties['client_dateformate_hhmm']}")
	private String clientdateformatehhmm;
	@Value("#{hospitalProperties['sql_dateformate_without_timestamp']}")
	private String sqldateformatewithouttimestamp;

	private static final String REDIRECT_SESSION_EXPIRED = "redirect:/notloggedin";
	
	@RequestMapping(value = "/domestic/doctor/tabcontent/{tabid}/{patientid}/{usertypeid}", method = {RequestMethod.POST, RequestMethod.GET })
	public String createUser(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("tabid") Integer tabid,
			@PathVariable("patientid") Integer patientid,@PathVariable("usertypeid") Integer usertypeid ,ModelMap modelMap) {
		
		String page = REDIRECT_SESSION_EXPIRED;
		try{
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			String countryJson;
			String designationJson;
			if (sessionBean != null) {
				switch (tabid) {
				case 0:
					System.out.println(sessionBean.getUserId());
					page = "admin/Userdashboad";
					modelMap.addAttribute("appointmentList",doctorService.appointmentList(commonService.convertStirngToUTCDateWithoutTimeStamp(new Date())));
					break;
					
			case 7:
					getNewPatientRegistration(patientid, modelMap);
					page = "admin/NewPatientRegistration";
					break;
					default:page = "admin/Userdashboad";
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
				return page;
		
	}
	private void getNewPatientRegistration(int patientId,  ModelMap modelMap) throws Exception{
		Object[] appObj = adminService.getPatient(patientId);
		String countryJson;
		if (appObj != null) {
			PatientBean patientbean = setPatientBean(appObj);
			modelMap.addAttribute("patient", patientbean);
		}
		List<Object[]> list = commonService.getAddiction();
		List<TblPatientAddiction> selAddictionList = adminService.getAddiction(patientId);
		Map<Integer,String> addictionMap = new LinkedHashMap<Integer,String>();
		int c = 0;
		for (Object[] objects : list) {
			for (TblPatientAddiction tblPatientAddiction : selAddictionList) {
				if(!addictionMap.containsKey(Integer.parseInt( objects[0].toString()))){
					if(Integer.parseInt(objects[0].toString()) == tblPatientAddiction.getTblAddiction().getAddictionid() ){
						c=0;
						break;
					}else{
						c=1;
					}
				}
			}	
			if(c==0){
				addictionMap.put(Integer.parseInt(objects[0].toString()),objects[1].toString()+"@@@checked");
			}else{
				addictionMap.put(Integer.parseInt(objects[0].toString()),objects[1].toString()+"@@@notchecked");
			}
			c=0;
		}
		modelMap.addAttribute("addictionMap",addictionMap);
		modelMap.addAttribute("pageStatus", "edit");
		countryJson = getContryJson();
		modelMap.addAttribute("countryJson", countryJson);
	}
	private PatientBean setPatientBean(Object[] patientObj)
			throws ParseException {
		PatientBean patientBean = new PatientBean();
		patientBean.setPatientId(Integer.parseInt(patientObj[0].toString()));
		patientBean.setTxtpatientcrno(patientObj[1].toString());
		patientBean.setTxtfirstname(patientObj[2].toString());
		patientBean.setTxtmiddlename(patientObj[3].toString());
		patientBean.setTxtlastname(patientObj[4].toString());
		String regDate = commonService.convertStirngToUTCDateWithoutTimeStamp(new Date());
		patientBean.setTxtregdate(commonService.convertSqlToClientDate(
				clientDateFormate,
				patientObj[5] != null ? patientObj[5].toString() : regDate));
		patientBean.setDtgender(patientObj[6].toString());
		patientBean.setBirthdate( patientObj[7]!= null ? commonService.convertSqlToClientDate(
				clientDateFormate, patientObj[7].toString()): "");
		patientBean.setTxtage(Integer.parseInt(patientObj[8].toString()));
		patientBean.setTxtcountrycodemobileno(patientObj[9].toString());
		patientBean.setTxtmobileno(patientObj[10].toString());
		patientBean
				.setTxtcountrycodelandline(patientObj[11] != null ? patientObj[11]
						.toString() : "");
		patientBean.setTxtlandlineno(patientObj[12] != null ? patientObj[12]
				.toString() : "");
		patientBean
				.setTxtextentionlandline(patientObj[13] != null ? patientObj[13]
						.toString() : "");
		patientBean.setTxtaddress(patientObj[14] != null ? patientObj[14]
				.toString() : "");
		patientBean.setTxtlandmark(patientObj[15] != null ? patientObj[15]
				.toString() : "");
		patientBean.setTxtarea(patientObj[16] != null ? patientObj[16]
				.toString() : "");
		patientBean.setDtcountryId(patientObj[17] != null ? Integer
				.parseInt(patientObj[17].toString()) : 0);
		patientBean.setCountryName(patientObj[18] != null ? patientObj[18]
				.toString() : "");
		patientBean.setDtstateId(patientObj[19] != null ? Integer
				.parseInt(patientObj[19].toString()) : 0);
		patientBean.setStatename(patientObj[20] != null ? patientObj[20]
				.toString() : "");
		patientBean.setTxtcity(patientObj[21] != null ? patientObj[21]
				.toString() : "");
		patientBean.setTxtpincode(patientObj[22] != null ? patientObj[22]
				.toString() : "");
		patientBean
				.setTxtreferencedetail(patientObj[23] != null ? patientObj[23]
						.toString() : "");
		patientBean.setSelreferenceid(patientObj[24] != null ? Integer
				.parseInt(patientObj[24].toString()) : 0);
		patientBean.setReferencename(patientObj[25] != null ? patientObj[25]
				.toString() : "");
		patientBean
				.setTxtsocialeconomicstatusid(patientObj[26] != null ? Integer
						.parseInt(patientObj[26].toString()) : 0);
		patientBean
				.setSocialecomonicstatusName(patientObj[27] != null ? patientObj[27]
						.toString() : "");
		patientBean.setSelpaybyid(patientObj[28] != null ? Integer
				.parseInt(patientObj[28].toString()) : 0);
		patientBean.setPaybyName(patientObj[29] != null ? patientObj[29]
				.toString() : "");
		patientBean.setConsltingDoctorId(Integer.parseInt(patientObj[30]
				.toString()));
		patientBean.setConsltingDoctorName(patientObj[31].toString());
		patientBean.setRdisdiabetic(Integer
				.parseInt(patientObj[32] != null ? patientObj[32].toString()
						.toString() : ""));
		patientBean.setRdishignbp(Integer
				.parseInt(patientObj[33] != null ? patientObj[33].toString()
						.toString() : ""));
		patientBean
				.setUserdetailid(Integer.parseInt(patientObj[34].toString()));
		patientBean.setRefothersname(patientObj[35] != null ? patientObj[35]
				.toString() : "");
		patientBean.setPaybyname(patientObj[36] != null ? patientObj[36]
				.toString() : "");
		patientBean.setAppid(patientObj[37] != null ? Integer
				.parseInt(patientObj[37].toString()) : 0);
		patientBean.setAppdatestring(commonService.convertSqlToClientDate(
				clientdateformatehhmm,
				patientObj[38] != null ? patientObj[38].toString() : ""));
		patientBean.setReferenceid(patientObj[39] != null ? Integer
				.parseInt(patientObj[39].toString()) : 0);
		patientBean.setAddictionother(patientObj[40] != null ? patientObj[40].toString() : "");

		return patientBean;
	}
	private String getContryJson() {
		String jsonStr = "";
		StringBuilder json = new StringBuilder("[");
		try {
			List<Object[]> tblCountries = commonService.getCountries();
			if (tblCountries != null && !tblCountries.isEmpty()) {
				for (Object[] object : tblCountries) {
					json.append(
							"{\"value\":\"" + object[0] + "\",\"label\":\""
									+ object[1] + "\"}").append(",");
				}
			}
			jsonStr = json.toString().replaceAll(",$", "");
			jsonStr = jsonStr + "]";
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		} finally {
		}
		return jsonStr;
	}
	@RequestMapping(value = "/domestic/doctor/getacknowlege/{patientid}", method = RequestMethod.GET)
	public String getacknowlege(@PathVariable("patientid") Integer patientid,HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) throws Exception{
	    String page = "admin/Patientpriscription";
	    modelMap.addAttribute("patient",doctorService.getpatientinfo(patientid));
	    modelMap.addAttribute("schedule", adminService.listSchedule());
	    modelMap.addAttribute("finding", adminService.listFinding());
	    List<TblComplaints> listAllComplaints = doctorService.getAllComplaints();
	    List<Object[]>listComplaints = doctorService.getReportName(patientid,1);
	    
	    Map<Integer,String> hashMapComplain = new LinkedHashMap<Integer, String>();
	    for (TblComplaints tblComplaints : listAllComplaints) {
	    	if(listComplaints.isEmpty()){
	    		hashMapComplain.put(tblComplaints.complaintsid, tblComplaints.complaintsname + "_notselected");
	    	}else{
	    		for (Object[] objects : listComplaints) {
					if(tblComplaints.complaintsid == Integer.parseInt(objects[3].toString())){
						hashMapComplain.put(tblComplaints.complaintsid, tblComplaints.complaintsname + "_checked");
						break;
					}else{
						hashMapComplain.put(tblComplaints.complaintsid, tblComplaints.complaintsname + "_notselected");
					}
				}
	    		
	    	}
			
		}
	    Map<Integer,String> hashMapMedicien = new LinkedHashMap<Integer, String>();
	   List<TblMedicine>listAllMedicine = doctorService.getAllMedicins();
	   List<TblMedicineSchedule>listAllSchedule = doctorService.getMedicindeSchedule();
	 List<Object[]>listMedicien = doctorService.getReportName(patientid,2);
	  for (TblMedicine tblMedicine : listAllMedicine) {
		  if(listMedicien.isEmpty()){//create
			  hashMapMedicien.put(tblMedicine.getMedicine_id(), tblMedicine.getMedicine_name() +"_notselected");
			  
		  }else{
			  for (Object[] objects : listMedicien) { //Edit
					if(tblMedicine.getMedicine_id() == Integer.parseInt(objects[5].toString())){
						hashMapMedicien.put(tblMedicine.getMedicine_id(), tblMedicine.getMedicine_name() +"_checked"+"@@"+Integer.parseInt(objects[3].toString()));
						break;
					}else{
						hashMapMedicien.put(tblMedicine.getMedicine_id(), tblMedicine.getMedicine_name() +"_notselected");
					}
				}
			  
		  }
		
		
	}
	  Map<Integer,String> hashMapReport = new LinkedHashMap<Integer, String>();
	  List<TblReports>listAllReport = doctorService.getAllReports();
	  List<Object[]>listReport = doctorService.getReportName(patientid,3);
	  for (TblReports tblReports : listAllReport) {
		  if(listReport.isEmpty()){
			  hashMapReport.put(tblReports.getReport_id(), tblReports.getReport_name() +"_notselected");
		  }else{
			  for (Object[] objects : listReport) {
					if(tblReports.getReport_id() == Integer.parseInt(objects[3].toString())){
						hashMapReport.put(tblReports.getReport_id(), tblReports.getReport_name() +"_checked");
						break;
					}else{
						hashMapReport.put(tblReports.getReport_id(), tblReports.getReport_name() +"_notselected");
						
					}
				}
		  }
		
	}
	  
	  Map<Integer, String>hashfindingMap = new LinkedHashMap<Integer, String>();
	  List<TblFinding>listFindingReport = doctorService.getFindingReport();
	  List<Object[]> listFinding = doctorService.getReportName(patientid, 4);
	  for(TblFinding tblFinding : listFindingReport){
		  if(listFinding.isEmpty()){
			  hashfindingMap.put(tblFinding.getFindingid(),tblFinding.getFindingname()+"_notselected");
		  }else{
			  for(Object[] object:listFinding){
				  if(tblFinding.getFindingid() == Integer.parseInt(object[3].toString())){
					  hashfindingMap.put(tblFinding.getFindingid(),tblFinding.getFindingname()+"_checked"+"@@"+(object[4].toString()));
					  break;
				  }else{
					  hashfindingMap.put(tblFinding.getFindingid(),tblFinding.getFindingname()+"_notselected");
				  }
			  }
		  }
	  }
	    modelMap.addAttribute("complaints", hashMapComplain);
	    modelMap.addAttribute("medicien", hashMapMedicien);
	    modelMap.addAttribute("report", hashMapReport);
	    modelMap.addAttribute("finding", hashfindingMap);
	    modelMap.addAttribute("clinicalDetail", doctorService.getClinicalDetail(patientid));
	    
	    //Document
	    
	    modelMap.addAttribute("objectId", patientid);
	    modelMap.addAttribute("childId", 0);
	    modelMap.addAttribute("subChildId", 0);
	    modelMap.addAttribute("otherSubChildId", 0);
        
	   // modelMap.addAttribute("clinicalCompliants", doctorService.getReportName(patientid,1));
		// modelMap.addAttribute("clinicalMedical", doctorService.getReportName(patientid,2));
		// modelMap.addAttribute("clinicalReport", doctorService.getReportName(patientid,3));
		return page;
		
	}
	@RequestMapping(value="/domestic/doctor/saveClinical/{patientid}",  method= RequestMethod.POST)
	public String saveClinical(@PathVariable("patientid") int patientid,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap,RedirectAttributes attributes){
		String page = REDIRECT_SESSION_EXPIRED;
		boolean success = false;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			Clinicalbean clinicalbean = doctorService.getClinicalDatabean(request);
			TblClinical tblClinical = new TblClinical();
		
			tblClinical.setTblPatient(new TblPatient(patientid));
			tblClinical.setHistory(clinicalbean.getTxthistory());
			tblClinical.setComments(clinicalbean.getTxtcomments());
			tblClinical.setRemark(clinicalbean.getTxtremark());
			List<TblClinicalReport>complainList = new ArrayList<TblClinicalReport>();
			         
			       if(clinicalbean.getComlaintsList() != null){
			           for(String obj:clinicalbean.getComlaintsList()){
			        	   TblClinicalReport tblClinicalReport = new TblClinicalReport();
			        	   tblClinicalReport.setTblPatient(new TblPatient(patientid));
			        	   tblClinicalReport.setClnicalreportid(Integer.parseInt(obj));
			        	   tblClinicalReport.setStatusid(1);
			        	  complainList.add(tblClinicalReport);
			           }
			       }
			      /* if(clinicalbean.getMedicineList() != null){
			           for(String obj:clinicalbean.getMedicineList()){
			        	   TblClinicalReport tblClinicalReport = new TblClinicalReport();
			        	   tblClinicalReport.setTblPatient(new TblPatient(patientid));
			        	   
			        	   //tblClinicalReport.setClnicalreportid(Integer.parseInt(obj));
			        	   tblClinicalReport.setStatusid(2);
			        	  complainList.add(tblClinicalReport);
			           }
			       }*/
			       
			       String medicineSchedile = request.getParameter("hdJsonValue");
					
					JSONArray jsonArray = new JSONArray(medicineSchedile);
					for (int i = 0; i < jsonArray.length(); i++) {
						TblClinicalReport tblClinicalReport = new TblClinicalReport();
						JSONObject jSONObject = jsonArray.getJSONObject(i);
						tblClinicalReport.setTblPatient(new TblPatient(patientid));
						for (Iterator it = jSONObject.keys(); it.hasNext();) {
							
							String key = it.next().toString();
							String jsonValue = jSONObject.getString(key);
							int json = Integer.parseInt(jsonValue);
							if( key.equals("schedule")){
								tblClinicalReport.setSchedualid(json);
							}else{
								tblClinicalReport.setClnicalreportid(json);
							}
							tblClinicalReport.setStatusid(2);
						}
						complainList.add(tblClinicalReport);
					}
					
					String findingReport = request.getParameter("hdfinding");
					 jsonArray = new JSONArray(findingReport);
					 for(int i =0;i< jsonArray.length();i++){
						 TblClinicalReport tblClinicalReport = new TblClinicalReport();
						 JSONObject jsonObject = jsonArray.getJSONObject(i);
						 tblClinicalReport.setTblPatient(new TblPatient(patientid));
						 for(Iterator it = jsonObject.keys();it.hasNext();){
							 String key = it.next().toString();
							 String value =jsonObject.getString(key);
							 if(key.equals("txtfinding")){
								 tblClinicalReport.setFindingReport(value);
							 }else{
								 int jsonvalue = Integer.parseInt(value);
								 tblClinicalReport.setClnicalreportid(jsonvalue);
							 }
							 tblClinicalReport.setStatusid(4);
						 }
						 complainList.add(tblClinicalReport);
					 }
					
			       if(clinicalbean.getReportList() != null){
			           for(String obj:clinicalbean.getReportList()){
			        	   TblClinicalReport tblClinicalReport = new TblClinicalReport();
			        	   tblClinicalReport.setTblPatient(new TblPatient(patientid));
			        	   tblClinicalReport.setClnicalreportid(Integer.parseInt(obj));
			        	   tblClinicalReport.setStatusid(3);
			        	  complainList.add(tblClinicalReport);
			           }
			       }
			         if(clinicalbean.getClinical_id() == 0){
			         success = doctorService.addComplaints(complainList);
			         success=   doctorService.addClinicalData(tblClinical);
			         }else{
			        	  tblClinical.setClinical_id(clinicalbean.getClinical_id());
			        	  success = doctorService.updateClinicalData(tblClinical);
			        	  success = doctorService.deleteClinicalReport(patientid);
			        	  success  = doctorService.addComplaints(complainList);
			         }
			         
			         attributes.addFlashAttribute(success ? CommonKeywords.SUCCESS_MSG.toString() : CommonKeywords.ERROR_MSG.toString(),"Information Submitted Successfully" );
			     
			        	page = "redirect:/domestic/doctor/getacknowlege/"+patientid;
			      
			           
	}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return page;
}
	@RequestMapping(value="/domestic/doctor/ViewPrescription/{patientid}",  method= RequestMethod.GET)
	public String ViewPrescription(@PathVariable("patientid") Integer patientid,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws Exception{
		String page;
		 modelMap.addAttribute("patient",doctorService.getpatientinfo(patientid));
		 modelMap.addAttribute("clinicalDetail", doctorService.getClinicalDetail(patientid));
		 modelMap.addAttribute("clinicalCompliants", doctorService.getReportName(patientid,1));
		 modelMap.addAttribute("clinicalMedical", doctorService.getReportName(patientid,2));
		 modelMap.addAttribute("clinicalReport", doctorService.getReportName(patientid,3));
		 modelMap.addAttribute("clinicalFinding", doctorService.getReportName(patientid, 4));
		 SimpleDateFormat newSimpleDateFormat = new SimpleDateFormat(clientDateFormate);
		 modelMap.addAttribute("currentDate",newSimpleDateFormat.format(commonService.getServerDateTime()));
		 
		 page = "admin/viewPrescription";
		return page;
	}
	
	
}
