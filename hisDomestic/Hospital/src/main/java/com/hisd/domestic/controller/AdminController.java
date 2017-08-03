package com.hisd.domestic.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
import com.hisd.domestic.databean.PatientBean;
import com.hisd.domestic.databean.UserDatabean;
import com.hisd.domestic.model.TblAddiction;
import com.hisd.domestic.model.TblAppointment;
import com.hisd.domestic.model.TblCaseType;
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

@Controller
public class AdminController {

	@Autowired
	private ExceptionHandlerService exceptionHandlerService;
	@Autowired
	private CommonService commonService;
	@Autowired
	AdminService adminService;
	@Autowired
	CommonDAO commonDAO;

	@Value("#{hospitalProperties['client_dateformate']}")
	private String clientDateFormate;
	@Value("#{hospitalProperties['client_dateformate_hhmm']}")
	private String clientdateformatehhmm;
	@Value("#{hospitalProperties['sql_dateformate_without_timestamp']}")
	private String sqldateformatewithouttimestamp;
	@Value("#{hospitalProperties['sql_dateformate']}")
	private String sqldateformate;
	

	private static final String REDIRECT_SESSION_EXPIRED = "redirect:/notloggedin";

	// CreateUser
	@RequestMapping(value = "/domestic/user/tabcontent/{tabid}/{patientid}",  method = {RequestMethod.POST})
	public String createUser(HttpServletRequest request,HttpServletResponse response, @PathVariable("tabid") Integer tabid,@PathVariable("patientid") Integer patientid, ModelMap modelMap) {
		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			String countryJson;
			String designationJson;
			String userTypeJson;

			if (sessionBean != null) {
				switch (tabid) {
				case 0:
					page = "admin/Userdashboad";
					modelMap.addAttribute("appointmentList",adminService.appointmentList("", commonService.convertStirngToUTCDateWithoutTimeStamp(new Date())));
					break;
				case 1:
					page = "admin/CreateHospitalUser";
					countryJson = getContryJson();
					userTypeJson = getUserTypeJson();
					modelMap.addAttribute("countryJson", countryJson);
//					modelMap.addAttribute("designationJson", designationJson);
					modelMap.addAttribute("userType", userTypeJson);
					modelMap.addAttribute("objectId", -1);
				    modelMap.addAttribute("childId", 0);
				    modelMap.addAttribute("subChildId", 0);
				    modelMap.addAttribute("otherSubChildId", 0);
					break;
				case 2:
					page = "admin/PatientType";
					break;
				case 3:
					page = "admin/AppointmentType";
					break;
				case 4:
					getNewPatientRegistration(patientid, modelMap);
					page = "admin/NewPatientRegistration";
					break;
                           
				case 5: 
					  page ="admin/ComplaintsMaster";
					  modelMap.addAttribute("complaints", adminService.complaintsList());
					  break;
				case 6:
					  page ="admin/PatientReport";
					  break;
				case 7:
					getNewPatientRegistration(patientid, modelMap);
					page = "admin/NewPatientRegistration";
					break;
				case 8:
					 page = "admin/AppointmentReport";
					 break;
					 
				case 9:
					page="admin/Medicine";
					modelMap.addAttribute("medicine", adminService.medicineList());
					break;
				case 10:
					page="admin/Report";
					modelMap.addAttribute("report", adminService.reportList());
					break;
				case 11:
					page="admin/MedicineSchedule";
					modelMap.addAttribute("schedule", adminService.listSchedule());
					break;
				case 12:
					page="admin/Finding";
					modelMap.addAttribute("finding", adminService.listFinding());
				    break;
				case 13:
					page="admin/SearchUser";
					break;
				case 14:
					page = "admin/CreateHospitalUser";
					int userid =request.getParameter("hduserid")!= null && !request.getParameter("hduserid").toString().isEmpty()?Integer.parseInt(request.getParameter("hduserid")):0 ;
					getuserdetail(userid, modelMap);
					break;
					
				}
			}
		} catch (Exception e) {
			exceptionHandlerService.writeLog(e);
		}
		return page;
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

	@ResponseBody
	@RequestMapping(value = "/domestic/user/getreferencetype", method = RequestMethod.GET)
	public String getreferencetype(ModelMap modelMap, HttpServletRequest request) {
		String countryJson = "[]";
		try {
			List<Object[]> countryList = commonService.getRefrence();
			if (countryList != null && !countryList.isEmpty()) {
				countryJson = commonService.convertToGsonStr(countryList);
			}
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		} finally {
		}
		return countryJson;
	}

	@ResponseBody
	@RequestMapping(value = "/domestic/user/getConsltingDoctor", method = RequestMethod.GET)
	public String getConsltingDoctor(ModelMap modelMap,
			HttpServletRequest request) {
		String doctorJson = "[]";
		try {
			List<Object[]> doctorList = commonService.getConsultingDoctor();
			if (doctorList != null && !doctorJson.isEmpty()) {
				doctorJson = commonService.convertToGsonStr(doctorList);
			}
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		} finally {
		}
		return doctorJson;
	}

	@ResponseBody
	@RequestMapping(value = "/domestic/user/getSocialEconomicStatus", method = RequestMethod.GET)
	public String getSocialEconomicStatus(ModelMap modelMap,
			HttpServletRequest request) {
		String economicJson = "[]";
		try {
			List<Object[]> economicList = commonService
					.getSocialEconomicStatus();
			if (economicList != null && !economicJson.isEmpty()) {
				economicJson = commonService.convertToGsonStr(economicList);
			}
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		}
		return economicJson;
	}
	
	@ResponseBody
	@RequestMapping(value="/domestic/user/getDesignation",method = RequestMethod.GET)
	public String getDesignation(ModelMap modelMap, HttpServletRequest request){
		String designationJson ="[]";
		try{
			List<Object[]> designationList = commonService.getDesignation();
			if(designationList != null && !designationList.isEmpty()){
				designationJson = commonService.convertToGsonStr(designationList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return designationJson;
	}

	@ResponseBody
	@RequestMapping(value = "/domestic/user/getPayBy", method = RequestMethod.GET)
	public String getPayBy(ModelMap modelMap, HttpServletRequest request) {
		String payBy = "[]";
		try {
			List<Object[]> paybyList = commonService.getPayBy();
			if (paybyList != null && !payBy.isEmpty()) {
				payBy = commonService.convertToGsonStr(paybyList);
			}
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		} finally {
		}
		return payBy;
	}

	// Patient Type
	@RequestMapping(value = "/domestic/user/patientRegistrationType/{casetypeid}", method = RequestMethod.POST)
	public ModelAndView patientRegistration(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("casetypeid") String casetypeid) {
		ModelAndView modelAndView = null;
		try {

			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {
				if ("1".equals(casetypeid)) {
					modelAndView = new ModelAndView(
							"admin/NewPatientRegistration");
				} else {
					modelAndView = new ModelAndView("admin/Follow-UpPatient");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	// Save Create User
	@RequestMapping(value = "/domestic/user/SaveCreateUser", method = RequestMethod.POST)
	public String saveCreateUser(HttpServletRequest request,
			HttpServletResponse response,RedirectAttributes redirectAttributes) {
		String page = REDIRECT_SESSION_EXPIRED;
		boolean success;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {
				UserDatabean userDatabean = adminService
						.getUserDataBean(request);
                 
				TblUserLogin tblUserLogin = new TblUserLogin();
				tblUserLogin.setIsCTPLUser(0);
				tblUserLogin.setLoginid(userDatabean.getTxtloginid());
				tblUserLogin.setPassword(userDatabean.getTxtpassword());
				tblUserLogin.setCstatus(1);
				tblUserLogin.setTblDesignation(new TblDesignation(userDatabean
						.getDtdesignation()));
				tblUserLogin.setTblUserType(new TblUserType(userDatabean
						.getUsertypeid()));
				tblUserLogin.setOtherdesignation(userDatabean.getOtherDesignation());

				TblUser tblUser = new TblUser();
				tblUser.setUsercode("hosregno" + 1);// hardcode
				tblUser.setFirstname(userDatabean.getTxtfirstname());
				tblUser.setMiddlename(userDatabean.getTxtmiddlename());
				tblUser.setLastname(userDatabean.getTxtlastname());
				tblUser.setGender(userDatabean.getDtgender());
				tblUser.setBod(userDatabean.getTxtbod());
				tblUser.setMobileno(userDatabean.getTxtmobileno());
				tblUser.setCountrycodemobileno(userDatabean
						.getTxtcountrycodemobileno());
				tblUser.setLandlineno(userDatabean.getTxtlandlineno());
				tblUser.setCountrycodelandline(userDatabean
						.getTxtcountrycodelandline());
				tblUser.setAddress(userDatabean.getTxtaddress());
				tblUser.setLandmark(userDatabean.getTxtlandmark());
				tblUser.setArea(userDatabean.getTxtarea());
				tblUser.setcountryId(userDatabean.getDtcountryId());
				tblUser.setstateId(userDatabean.getDtstateId());
				tblUser.setCity(userDatabean.getTxtcity());
				tblUser.setPincode(userDatabean.getTxtpincode());

				tblUser.setExtlandline(userDatabean.getTxtextentionlandline());
				tblUser.setStatus(1);
				TblConsultingDoctor tblConsultingDoctor = null;
				if(userDatabean.getUsertypeid() == 2){
					tblConsultingDoctor= new TblConsultingDoctor();
					tblConsultingDoctor.setConsultingdoctorname(userDatabean.getTxtfirstname() +" "+userDatabean.getTxtlastname());
				}
				 if(userDatabean.getUserdetailid() == 0 ){
					 success = adminService.addUser(tblUserLogin, tblUser,tblConsultingDoctor);
                 }else{
                	 tblUser.setUserdetailid(userDatabean.getUserdetailid());
                	 tblUser.setUserid(userDatabean.getUserloginid());
                	 tblUserLogin.setUserId(userDatabean.getUserloginid());
                	 if(userDatabean.getUsertypeid() ==2){
                		tblConsultingDoctor.setUserid(userDatabean.getUserloginid());
                		 
                	 }
                	 success = adminService.edituser(tblUser, tblUserLogin,tblConsultingDoctor);
                 }
				
				if (success) {
					if(userDatabean.getUserdetailid() == 0){
						redirectAttributes.addFlashAttribute("message", "User Created Successfully");
					}else{
						redirectAttributes.addFlashAttribute("message", "User Updated Successfully");
					}
					
					page = "redirect:/domestic/user/dashboard";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	@ResponseBody
	@RequestMapping(value = "/domestic/user/isemailidexists/{searchValue}/", method = RequestMethod.POST)
	public String getIsEmailIdExists(
			@PathVariable("searchValue") String searchValue, ModelMap modelMap,
			HttpServletRequest request) {
		boolean isExist = false;
		String jsonStr = "[{";

		try {
			isExist = adminService.isEmailIdExists(searchValue);
			jsonStr = jsonStr + "\"isExists\":\"" + isExist + "\"}]";
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		}
		return jsonStr;
	}

	// Save Patient Registration
	@RequestMapping(value = "/domestic/user/SavePatient", method = RequestMethod.POST)
	public String savePatient(Object cammand, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) {
		String page = REDIRECT_SESSION_EXPIRED;
		boolean success = false;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			int patientId = 0;
			String caseid = request.getParameter("appoinmentPatientTabId");
			String tabid = request.getParameter("newAppointmenttabid");
			TblUser tblUser = new TblUser();
			PatientBean patientBean = adminService.getPatientDatabean(request);
			TblPatient tblPatient = new TblPatient();
			TblAppointment tblAppointment = new TblAppointment();
			if (sessionBean != null) {
				if ("1".equals(caseid) || "7".equals(tabid) || "4".equals(tabid)) {

					tblUser.setUsercode("hosregno" + 1);// hardcode
					tblUser.setFirstname(patientBean.getTxtfirstname());
					tblUser.setMiddlename(patientBean.getTxtmiddlename());
					tblUser.setLastname(patientBean.getTxtlastname());
					tblUser.setGender(patientBean.getDtgender());
					tblUser.setMobileno(patientBean.getTxtmobileno());
					tblUser.setCountrycodemobileno(patientBean
							.getTxtcountrycodemobileno());
					tblUser.setCountrycodelandline(patientBean
							.getTxtcountrycodelandline());
					tblUser.setLandlineno(patientBean
							.getTxtcountrycodelandline());
					tblUser.setExtlandline(patientBean
							.getTxtextentionlandline());
					tblUser.setAddress(patientBean.getTxtaddress());
					tblUser.setLandmark(patientBean.getTxtlandmark());
					tblUser.setArea(patientBean.getTxtarea());
					tblUser.setcountryId(patientBean.getDtcountryId());
					tblUser.setstateId(patientBean.getDtstateId());
					tblUser.setCity(patientBean.getTxtcity());
					tblUser.setPincode(patientBean.getTxtpincode());
					tblUser.setBod(patientBean.getTxtbod());
					tblUser.setStatus(1);
					if (patientBean.getUserdetailid() != 0) {
						tblUser.setUserdetailid(patientBean.getUserdetailid());
					}

					// Table Pay By
					if (patientBean.getSelpaybyid() == 1) {
						tblPatient.setPatbyname(patientBean.getTxtotherPayby());
					}

					// Table ReferenceType
					if (patientBean.getReferenceid() == 0) {
						TblReferenceType tblReferenceType;
						if (patientBean.getSelreferenceid() != 0) {

							if (patientBean.getSelreferenceid() == 1) {
								tblPatient.setRefothersname(patientBean
										.getTxtOtherRefrencename());
								tblReferenceType = new TblReferenceType(
										patientBean.getSelreferenceid());

							} else {
								tblReferenceType = new TblReferenceType(
										patientBean.getSelreferenceid());
							}
							// Table patientRefrencr
							TblPatientRefrence tblPatientReference = new TblPatientRefrence();
							tblPatientReference.setReferencedtl(patientBean
									.getTxtreferencedetail());
							tblPatientReference
									.setReferencebytypeid(tblReferenceType);
							int patientrefid = adminService
									.addPatientReffrence(tblPatientReference);
							tblPatient.setReferenceid(patientrefid);
						}
					} else {
						TblReferenceType tblReferenceType;
						TblPatientRefrence tblPatientRefrence = new TblPatientRefrence();
						tblPatientRefrence.setReferenceid(patientBean
								.getReferenceid());
						tblPatientRefrence.setReferencedtl(patientBean
								.getTxtreferencedetail());
						tblReferenceType = new TblReferenceType(
								patientBean.getSelreferenceid());
						tblPatientRefrence
								.setReferencebytypeid(tblReferenceType);
						tblPatient.setReferenceid(patientBean.getReferenceid());
						tblPatient.setRefothersname(patientBean
								.getTxtOtherRefrencename());
						adminService.editPatientReference(tblPatientRefrence);

					}

					tblPatient.setPatientcrno(patientBean.getTxtpatientcrno());
					tblPatient.setRegdate(patientBean.getRegdate());
					tblPatient.setSocialeconomicstatusid(patientBean
							.getTxtsocialeconomicstatusid());
					tblPatient.setTblConsultingDoctor(new TblConsultingDoctor(
							patientBean.getConsltingDoctorId()));
					tblPatient.setIsdiabetic(patientBean.getRdisdiabetic());
					tblPatient.setIshignbp(patientBean.getRdishignbp());
					tblPatient.setAge(patientBean.getTxtage());
					tblPatient.setPaybyid(patientBean.getSelpaybyid());
                     tblPatient.setAddictionother(patientBean.getAddictionother());
					if (patientBean.getPatientId() != 0) {
						if (patientBean.getAppDate() != null && patientBean.getAppid() != 0) {
							tblPatient.setPatientid(patientBean.getPatientId());
							tblPatient.setAppid(patientBean.getAppid());
							tblPatient.setTblUser(tblUser);
							tblAppointment.setAppid(patientBean.getAppid());
							tblAppointment.setStatus(1);
							tblAppointment.setAppdate(commonService
									.convertStirngToUTCDate(
											clientdateformatehhmm,
											patientBean.getAppDate()));
							tblAppointment.setTblCaseType(new TblCaseType(
									patientBean.getCasetype()));

							adminService.editPatientAppointment(tblUser, tblPatient, tblAppointment);
							redirectAttributes.addFlashAttribute(
									"redirectTabId", 3);
							page = "redirect:/domestic/user/dashboard";
						} else if (patientBean.getAppDate() == null
								&& patientBean.getAppid() == 0) {
							tblPatient.setTblUser(tblUser);
							tblPatient.setPatientid(patientBean.getPatientId());
							adminService.editPatient(tblUser,
									tblPatient);
							redirectAttributes.addFlashAttribute(
									"redirectTabId", 3);
							page = "redirect:/domestic/user/dashboard";

						} else if (patientBean.getAppDate() != null
								&& patientBean.getAppid() == 0) {
							tblPatient.setTblUser(tblUser);
							tblPatient.setPatientid(patientBean.getPatientId());
							tblAppointment.setAppdate(commonService.convertStirngToUTCDate(clientdateformatehhmm, patientBean.getAppDate()));
							tblAppointment.setTblCaseType(new TblCaseType(patientBean
									.getCasetype()));
							adminService.addAppointmentDate(tblUser, tblPatient, tblAppointment);
							redirectAttributes.addFlashAttribute(
									"redirectTabId", 3);
							page = "redirect:/domestic/user/dashboard";

						}
						patientId = patientBean.getPatientId();
					} else {
						patientId = adminService
								.addPatient(tblUser, tblPatient);
						redirectAttributes
								.addFlashAttribute("redirectTabId", 2);
						page = "redirect:/domestic/user/dashboard";
					}

					// Table Addiction
					
					if (patientId != 0 && patientBean.getAddictionList() != null) { 
						List<TblPatientAddiction> patientAddictionList = new ArrayList<TblPatientAddiction>(); 
						TblPatientAddiction tblPatientAddiction ;
						
						for (String obj : patientBean.getAddictionList()) { 
							tblPatientAddiction = new TblPatientAddiction(patientId); 
							tblPatientAddiction.setTblAddiction(new TblAddiction(Integer.parseInt(obj)));
							patientAddictionList.add(tblPatientAddiction); 
						}
						if( "7".equals(tabid) || "4".equals(tabid)){
							adminService.deleteAddiction(patientId);
						}
						
						adminService.addpatientAddiction(patientAddictionList); 
					}else{
						adminService.deleteAddiction(patientId);
					}
					 
				} else if (caseid.equals("2")) {
					tblUser.setFirstname(patientBean.getTxtfirstname());
					tblUser.setMiddlename(patientBean.getTxtmiddlename());
					tblUser.setLastname(patientBean.getTxtlastname());
					tblUser.setGender(patientBean.getDtgender());
					tblUser.setMobileno(patientBean.getTxtmobileno());
					tblUser.setCountrycodemobileno(patientBean
							.getTxtcountrycodemobileno());
					tblUser.setBod(patientBean.getTxtbod());
					tblPatient.setPatientcrno(patientBean.getTxtpatientcrno());
					tblPatient.setTblConsultingDoctor(new TblConsultingDoctor(
							patientBean.getConsltingDoctorId()));
					tblPatient.setAge(patientBean.getTxtage());
					tblAppointment.setTblCaseType(new TblCaseType(patientBean
							.getCasetype()));
					tblAppointment.setAppdate(commonService
							.convertStirngToUTCDate(clientdateformatehhmm,
									patientBean.getAppDate()));
					success = adminService.addAppointment(tblAppointment,
							tblPatient, tblUser);

					if (success) {
						
						redirectAttributes
								.addFlashAttribute("redirectTabId", 3);
						page = "redirect:/domestic/user/dashboard";

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}

	@Transactional
	@RequestMapping(value = "/domestic/patient/view", method = RequestMethod.GET)
	public String viewPatient(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {
				modelMap.addAttribute("patientData",
						adminService.getPatientDetails(""));
				page = "admin/ViewPatientRegistration";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}


	@RequestMapping(value = "/domestic/patient/searchPatient/{search}", method = RequestMethod.POST)
	public String search(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("search") String search, ModelMap modelMap) {
		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {
				modelMap.addAttribute("patientData",
						adminService.getPatientDetails(search));

				page = "admin/ViewPatientRegistrationDtl";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}

	@RequestMapping(value = "/domestic/patient/searchAppointment/{search}", method = RequestMethod.POST)
	public String searchAppointment(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("search") String Search, ModelMap modelMap) {
		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {

				List<Object[]> list = adminService
						.appointmentList(Search, null);
				if (list.isEmpty()) {
					modelMap.addAttribute("patientData",
							adminService.getPatientDetails(Search));

					page = "admin/ViewPatientRegistrationDtl";
				} else {
					modelMap.addAttribute("patientData", list);
					page = "admin/AppointmentDtl";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}

	@RequestMapping(value = "/domestic/patient/appointmentList", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String appointmentList(HttpServletRequest request,
			HttpServletResponse responce, ModelMap modelMap) {
		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {
				modelMap.addAttribute("patientData",
						adminService.appointmentList("", null));
				page = "admin/Appointment";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
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
	
	private String getUserTypeJson(){
		String jsonStr ="";
		StringBuilder json = new StringBuilder("[");
		try{
			List<Object[]> tblusertype = commonService.getUserType();
			if(tblusertype !=null && !tblusertype.isEmpty()){
				for(Object[] object :tblusertype){
					json.append(
							"{\"value\":\"" + object[0] + "\",\"label\":\""
									+ object[1] + "\"}").append(",");
					
				}
			}
			jsonStr = json.toString().replaceAll(",$", "");
			jsonStr = jsonStr + "]";
			
		}catch(Exception e){
			exceptionHandlerService.writeLog(e);
			
		}
		return jsonStr;
	}

	@ResponseBody
	@RequestMapping(value = "/domestic/user/getstatebycountry/{countryId}", method = RequestMethod.GET)
	public String getStatebyCountry(@PathVariable("countryId") int countryId,
			ModelMap modelMap, HttpServletRequest request) {
		String countryJson = "[]";
		try {
			List<Object[]> countryList = commonService.getStates(countryId);
			if (countryList != null && !countryList.isEmpty()) {
				countryJson = commonService.convertToGsonStr(countryList);
			}
		} catch (Exception ex) {
			exceptionHandlerService.writeLog(ex);
		} finally {
		}
		return countryJson;
	}

/*	private String getDesignationJson() {
		String jsonStr = "";
		StringBuilder json = new StringBuilder("[");
		try {
			List<Object[]> tblCountries = commonService.getDesignation();
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
	}*/

	@RequestMapping(value = "/domestic/user/getCaseType/{selectTabId}/{caseType}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getCaseTypeId(@PathVariable("selectTabId") int tabid,
			@PathVariable("caseType") int caseType, HttpServletRequest request,
			HttpServletResponse responce, ModelMap modelMap) {
		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			String countryJson;
		

			if (sessionBean != null) {
				switch (tabid) {
				case 1:
					if (caseType == 1) {
						page = "admin/NewPatientRegistration";
						countryJson = getContryJson();
						modelMap.addAttribute("countryJson", countryJson);
						modelMap.addAttribute("pageStatus", "create");
					List<Object[]>list =adminService.getlastpatient();
							modelMap.addAttribute("patientcount", list);
						DateFormat dateFormat = new SimpleDateFormat(
								clientDateFormate);
						Date date = new Date();
						modelMap.addAttribute("currentDate",
								dateFormat.format(date));
						List<Object[]> addictionList = commonService
								.getAddiction();
						 final AtomicInteger count = new AtomicInteger(0); 
						  final int jobID;
						  final String name;
						  boolean isFilled;
						  String title = null;
						  name = title;
						    isFilled = false;
						    jobID = count.incrementAndGet(); 
						   modelMap.addAttribute("crno", jobID);
						modelMap.addAttribute("addictionlist", addictionList);
					} else {
						page = "admin/Follow-UpPatient";
					}
					break;
				case 2:
					if (caseType == 1) {
						page = "admin/NewPatientRegistration";
						countryJson = getContryJson();
						modelMap.addAttribute("countryJson", countryJson);
						modelMap.addAttribute("pageStatus", "create");
						DateFormat dateFormat1 = new SimpleDateFormat(
								clientDateFormate);
						Date date1 = new Date();
						modelMap.addAttribute("currentDate",
								dateFormat1.format(date1));

					} else {
						page = "admin/Follow-UpAppointment";
					}
					break;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;

	}

	@RequestMapping(value = "/domestic/user/cancleAppointment", method = RequestMethod.POST)
	public String cancleAppointment(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap,
			RedirectAttributes redirectAttributes) throws ParseException {
		String page = REDIRECT_SESSION_EXPIRED;
		HttpSession session = request.getSession();
		SessionBean sessionBean = (SessionBean) session
				.getAttribute(CommonKeywords.SESSION_OBJ.toString());
		if (sessionBean != null) {
			int patientid = 0;
			String tabid;
				 patientid = request.getParameter("hdPatientid") != null && !"".equals(request.getParameter("hdPatientid")) ? Integer.parseInt(request.getParameter("hdPatientid")) :0 ;
		          tabid = request.getParameter("hdRecpPatFollowTabId");
			
			int appid = request.getParameter("hdAppointmentId") != null ? Integer.parseInt(request.getParameter("hdAppointmentId")) : 0 ;
			if(patientid== 0){
				//reschedule,cancel
				
				String date = request.getParameter("txtappdate" + appid) != null ? request.getParameter("txtappdate" + appid) : "";
				if(!date.isEmpty()){
					Date appdate = commonService.convertStirngToUTCDate(clientdateformatehhmm, date);
					TblAppointment tblAppointment = new TblAppointment();
					tblAppointment.setAppid(appid);
					tblAppointment.setAppdate(appdate);
					tblAppointment.setTblCaseType(new TblCaseType(1));
					adminService.UpdateAppointmnet(tblAppointment);
				}

				String reason = request.getParameter("txtreason" + appid) != null ? request
						.getParameter("txtreason" + appid) : "";
				if (!reason.isEmpty()) {
					adminService.cancelAppointment(appid, 2, reason);
				}
			} else {
				// acknowledge
				String countryJson;
				adminService.chageStatus(appid, 1);
				redirectAttributes.addFlashAttribute("redirectPatientId", patientid);
				redirectAttributes.addFlashAttribute("tabid", tabid);
				modelMap.addAttribute("pageStatus", "Ackedit");
				countryJson = getContryJson();
				modelMap.addAttribute("countryJson", countryJson);
			}
			page = "redirect:/domestic/user/dashboard";
		}
		return page;

	}

	@RequestMapping(value = "/domestic/appointment/view", method = RequestMethod.GET)
	public String appointmentView(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {

		String page = REDIRECT_SESSION_EXPIRED;
		try {
			HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) session
					.getAttribute(CommonKeywords.SESSION_OBJ.toString());
			if (sessionBean != null) {
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		int c = -1;
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
			if(!selAddictionList.isEmpty()){
				c=0;
			}
			
		}
		
		modelMap.addAttribute("addictionMap",addictionMap);
		modelMap.addAttribute("pageStatus", "edit");
		countryJson = getContryJson();
		modelMap.addAttribute("countryJson", countryJson);
	}
	@RequestMapping(value = "/domestic/complaints/deleteComplaints/{compaintsId}", method = RequestMethod.POST)
	
	public String deleteComplaints(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap,@PathVariable("compaintsId")int compaintsId) throws Exception{
		 adminService.deleteComplatints(compaintsId, 2);
		 modelMap.addAttribute("complaints", adminService.complaintsList());
		 String page ="admin/ComplaintsMaster";	
		return page;
		
	}
	@RequestMapping(value = "/domestic/complaints/deleteMedicine/{medicinId}", method = RequestMethod.POST)
	
	public String deleteMedicine(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap,@PathVariable("medicinId")int medicinId) throws Exception{
		 adminService.deleteMedicine(medicinId, 2);
		 modelMap.addAttribute("medicine", adminService.medicineList());
		 String page ="admin/Medicine";	
		return page;
		
	}
@RequestMapping(value = "/domestic/complaints/deleteReport/{reportId}", method = RequestMethod.POST)
	
	public String deleteReport(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap,@PathVariable("reportId")int reportId) throws Exception{
		 adminService.deleteReport(reportId, 2);
		 modelMap.addAttribute("report", adminService.reportList());
		 String page ="admin/Report";	
		return page;
		
	}
	@RequestMapping(value = "domestic/complaints/deleteMedicineSchedule/{scheduleId}")
	public String deleteMedicineSchedule(HttpServletRequest request,ModelMap modelMap,@PathVariable("scheduleId") int scheduleId) throws Exception{
		adminService.deleteMedicineSchedule(scheduleId, 1);
		modelMap.addAttribute("schedule", adminService.listSchedule());
		String page = "admin/MedicineSchedule";
		return page;
		
	}
	
	@RequestMapping(value = "domestic/complaints/deleteFinding/{findingId}")
	public String deleteFinding(HttpServletRequest request,ModelMap modelMap,@PathVariable("findingId") int findingId) throws Exception{
		String page = null;
		try{
		adminService.deleteFinding(findingId, 1);
		modelMap.addAttribute("finding", adminService.listFinding());
	   page="admin/Finding";
		}catch (Exception e) {
			e.printStackTrace();
		}
	  return page;
	}
	
	
	
	
	@RequestMapping(value = "/domestic/user/patientReport/{drid}", method = RequestMethod.POST)
	public String patientReport(@PathVariable("drid") Integer drid,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws ParseException{
		String page = null;
		try{
	     String startDate = null;
	     String endDate = null; 
         modelMap.addAttribute("patient", adminService.search(drid, startDate, endDate));
	      page="admin/searchPatient";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return page;
		
	}
	@RequestMapping(value = "/domestic/user/appointmentReport/{startdate}/{enddate}", method = RequestMethod.POST)
	public String appointmentReport(@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap) throws ParseException{
		String page = null;
		try{
			 String startDate = commonService.convertToDBDate(clientdateformatehhmm, sqldateformate,startdate);
			 String endDate = commonService.convertToDBDate(clientdateformatehhmm, sqldateformate,enddate);
		        modelMap.addAttribute("appointment", adminService.search(0, startDate, endDate));
			      page="admin/SearchAppointment";
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return page;
		
	}
	
	@RequestMapping(value = "/domestic/user/addComplaints/{complain}", method = RequestMethod.POST)
	
	public String addComplaints(HttpServletRequest request,ModelMap modelmap,@PathVariable("complain") String complain) throws Exception{
		boolean success;
		String page = null;
		try{
		System.out.println(complain);
		TblComplaints tblComplaints = new TblComplaints();
		tblComplaints.setComplaintsname(complain);
	success =	adminService.addComplaints(tblComplaints);
	if(success){
		modelmap.addAttribute("complaints", adminService.complaintsList());
		page = "admin/ComplaintsTable";
	}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return page;
		
	}
	
	
	
@RequestMapping(value = "/domestic/user/addMedicine/{medicine}", method = RequestMethod.POST)
	
	public String addMedicine(HttpServletRequest request,ModelMap modelmap,@PathVariable("medicine") String medicine) throws Exception{
		boolean success;
		String page = null;
		try{
			TblMedicine tblMedicine = new TblMedicine();
			tblMedicine.setMedicine_name(medicine);
		success =	adminService.addMedicine(tblMedicine);
		if(success){
			modelmap.addAttribute("medicine", adminService.medicineList());
			page="admin/MedicineTable";
		}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
		
	}
@RequestMapping(value = "/domestic/user/addReport/{report}", method = RequestMethod.POST)

public String addReport(HttpServletRequest request,ModelMap modelmap,@PathVariable("report") String report) throws Exception{
	boolean success;
	String page = null;
	try{
		TblReports tblReports = new TblReports();
		tblReports.setReport_name(report);
	success =	adminService.addReport(tblReports);
	if(success){
		modelmap.addAttribute("report", adminService.reportList());
		page="admin/ReportTable";
	}
	}catch (Exception e) {
		e.printStackTrace();
	}
	return page;
	
}

@RequestMapping(value ="/domestic/user/addMedicineSchedule/{txtschedule}",method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
public String addMedicineSchedule(HttpServletRequest request,@PathVariable("txtschedule")String txtschedule,ModelMap modelMap) throws Exception{
	String page= null;
	try{
		boolean success;
		
		TblMedicineSchedule tblMedicineSchedule = new TblMedicineSchedule();
		tblMedicineSchedule.setMedicineschedule(txtschedule);
		success = adminService.addMedicineSchedule(tblMedicineSchedule);
		if(success){
			
			modelMap.addAttribute("schedule", adminService.listSchedule());
			page="admin/MedicineScheduleTable";
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return page;
	
}

@RequestMapping(value ="/domestic/user/addFinding/{txtFinding}",method = RequestMethod.POST)
public String addFinding(HttpServletRequest request,@PathVariable("txtFinding")String txtFinding,ModelMap modelMap) throws Exception{
	String page= null;
	try{
		boolean success;
		TblFinding tblFinding = new TblFinding();
		tblFinding.setFindingname(txtFinding);
		success = adminService.addFinding(tblFinding);
		if(success){
			
			modelMap.addAttribute("finding", adminService.listFinding());
			page="admin/FindingTable";
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	return page;
	
}

@RequestMapping(value = "/domestic/patient/searchUser/{search}", method = RequestMethod.GET)
public String searchUser(HttpServletRequest request,
		HttpServletResponse response,
		@PathVariable("search") String search, ModelMap modelMap) {
	String page = REDIRECT_SESSION_EXPIRED;
	try {
		HttpSession session = request.getSession();
		SessionBean sessionBean = (SessionBean) session
				.getAttribute(CommonKeywords.SESSION_OBJ.toString());
		if (sessionBean != null) {
			modelMap.addAttribute("userData",
					adminService.getuserDetail(search));

			page = "admin/ViewUserDetail";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return page;

}

private void getuserdetail(int userid,ModelMap modelMap){
		 modelMap.addAttribute("user",adminService.getUserObject(userid) );
		 modelMap.addAttribute("pageStatus", "edit");
			modelMap.addAttribute("countryJson", getContryJson());
			modelMap.addAttribute("userType", getUserTypeJson());
			modelMap.addAttribute("objectId", -1);
		    modelMap.addAttribute("childId", 0);
		    modelMap.addAttribute("subChildId", 0);
		    modelMap.addAttribute("otherSubChildId", 0);
	
}
@RequestMapping(value = "/domestic/patient/deActiveUser/{userid}/{search}", method = RequestMethod.POST)
public String deActiveUser(@PathVariable("userid") int userid,@PathVariable("search") String search,HttpServletRequest request, ModelMap modelMap){
	String page = null;
	try{
		adminService.auctiveDeactiveUser(userid, 2);
		page = "redirect:/domestic/patient/searchUser/"+search;
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return page;
	
}
@RequestMapping(value = "/domestic/patient/activeUser/{userid}/{search}", method = RequestMethod.POST)
public String activeUser(@PathVariable("userid") int userid,@PathVariable("search") String search,HttpServletRequest request, ModelMap modelMap){
	String page = null;
	try{
		adminService.auctiveDeactiveUser(userid, 1);
		 page = "redirect:/domestic/patient/searchUser/"+search;
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return page;
	
}
	
	
}
