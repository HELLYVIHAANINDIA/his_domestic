package com.hisd.domestic.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hisd.common.daogeneric.Operation_enum;
import com.hisd.common.daointerface.HibernateQueryDao;
import com.hisd.common.daointerface.TblAppointmentDao;
import com.hisd.common.daointerface.TblComplaintsDao;
import com.hisd.common.daointerface.TblPatientAddictionDao;
import com.hisd.common.daointerface.TblPatientDao;
import com.hisd.common.daointerface.TblPatientRefrenceDao;
import com.hisd.common.daointerface.TblReferenceDao;
import com.hisd.common.daointerface.TblUserDao;
import com.hisd.common.daointerface.TblUserLoginDao;
import com.hisd.common.services.CommonDAO;
import com.hisd.common.utility.EncryptDecryptUtils;
import com.hisd.domestic.databean.PatientBean;
import com.hisd.domestic.databean.UserDatabean;
import com.hisd.domestic.model.TblAppointment;
import com.hisd.domestic.model.TblComplaints;
import com.hisd.domestic.model.TblPatient;
import com.hisd.domestic.model.TblPatientAddiction;
import com.hisd.domestic.model.TblPatientRefrence;
import com.hisd.domestic.model.TblUser;
import com.hisd.domestic.model.TblUserLogin;

@Service
public class AdminService {

	@Autowired
	EncryptDecryptUtils encrptDecryptUtils;
	@Autowired
	CommonDAO commonDao;
	@Autowired
	TblUserLoginDao tblUserLoginDao;
	@Autowired
	TblUserDao tblUserDao;
	@Autowired
	TblPatientDao tblPatientDao;
	@Autowired
	TblPatientAddictionDao tblPatientaddictionDao;
	@Autowired
	HibernateQueryDao hibernateQueryDao;
	@Autowired
	TblAppointmentDao tblAppointmentDao;
	@Autowired
	TblReferenceDao tblReferenceDao;
	@Autowired
	TblPatientRefrenceDao tblPatientRefrenceDao;
    @Autowired
    TblComplaintsDao tblComplaintsDao;
    
	@Value("#{projectProperties['passwordkey']}")
	private String passwordkey;
	@Value("#{hospitalProperties['client_dateformate']}")
	private String clientDateFormate;
	@Value("#{hospitalProperties['sql_dateFormate']}")
	private String sqlDateFormate;
	
	private static final String PatientId = "patientid";
	

	public UserDatabean getUserDataBean(HttpServletRequest request)throws Exception {
		UserDatabean userdtbean = new UserDatabean();
			userdtbean.setTxtfirstname(request.getParameter("txtfirstname"));
			userdtbean.setTxtmiddlename(request.getParameter("txtmiddlename"));
			userdtbean.setTxtlastname(request.getParameter("txtlastname"));
			userdtbean.setDtgender(request.getParameter("dtgender"));
			userdtbean
					.setTxtdateofbirth(request.getParameter("txtdateofbirth"));
			Date birthdate = dateofBirth(userdtbean.getTxtdateofbirth());
			userdtbean.setTxtbod(birthdate);
			userdtbean.setTxtloginid(request.getParameter("txtloginid"));

			userdtbean.setTxtpassword(EncryptDecryptUtils.encrypt(
					request.getParameter("txtpassword"),
					passwordkey.substring(0, 16).getBytes()));
			userdtbean.setTxtcountrycodemobileno(request
					.getParameter("txtcountrycodemobile"));
			userdtbean.setTxtmobileno(request.getParameter("txtmobileno"));
			userdtbean.setTxtcountrycodelandline(request
					.getParameter("txtcountrycodelandline"));
			userdtbean.setTxtlandlineno(request.getParameter("txtlandlineno"));
			userdtbean.setTxtextentionlandline(request
					.getParameter("txtexentionlandline"));
			userdtbean.setTxtaddress(request.getParameter("txtaddress"));
			userdtbean.setTxtlandmark(request.getParameter("txtlandmark"));
			userdtbean.setTxtarea(request.getParameter("txtarea"));
			userdtbean.setDtcountryId(pInt(request, "selCountry"));
			userdtbean.setDtstateId(pInt(request, "selState"));
			userdtbean.setTxtcity(request.getParameter("txtcity"));
			userdtbean.setTxtpincode(request.getParameter("txtpincode"));
			userdtbean.setDtdesignation(pInt(request, "dtdesignationid"));
			userdtbean.setUsertypeid(1);
			userdtbean.setCasetypeid(1);
			userdtbean.setUserid(1);
		return userdtbean;
	}
//get Patient Details
	public PatientBean getPatientDatabean(HttpServletRequest request)throws Exception {
		PatientBean patientBean = new PatientBean();

		patientBean.setPatientId(pInt(request, "hdPatientId"));
		patientBean.setTxtpatientcrno(request.getParameter("txtpatientcrno"));
		patientBean.setTxtfirstname(request.getParameter("txtfirstname"));
		patientBean.setTxtmiddlename(request.getParameter("txtmiddlename"));
		patientBean.setTxtlastname(request.getParameter("txtlastname"));
		patientBean.setTxtregdate(request.getParameter("txtregdate"));
		patientBean.setRegdate(dateofBirth(patientBean.getTxtregdate()));
		patientBean.setDtgender(request.getParameter("dtgender"));

		patientBean.setTxtage(pInt(request, "txtage"));
		patientBean.setTxtaddress(request.getParameter("txtaddress"));
		patientBean.setTxtlandmark(request.getParameter("txtlandmark"));
		patientBean.setTxtarea(request.getParameter("txtarea"));
		patientBean.setDtcountryId(pInt(request, "selCountry"));
		patientBean.setDtstateId(pInt(request, "selState"));
		patientBean.setTxtcity(request.getParameter("txtcity"));
		patientBean.setTxtpincode(request.getParameter("txtpincode"));
		patientBean.setTxtcountrycodemobileno(request
				.getParameter("txtcountrycodemobile"));
		patientBean.setTxtmobileno(request.getParameter("txtmobileno"));
		patientBean.setTxtcountrycodelandline(request
				.getParameter("txtcountrycodelandline"));
		patientBean.setTxtlandlineno(request.getParameter("txtlandlineno"));
		patientBean.setTxtextentionlandline(request
				.getParameter("txtexentionlandline"));
		patientBean.setSelreferenceid(pInt(request, "selrefrence"));
		patientBean.setTxtreferencedetail(request
				.getParameter("txtrefrenceDetail"));
		patientBean.setTxtsocialeconomicstatusid(pInt(request, "selEconomic"));
		patientBean.setSelpaybyid(pInt(request, "selPayby"));
		patientBean.setTxtotherPayby(request.getParameter("txtother"));
		patientBean.setConsltingDoctorId(pInt(request, "selconsltingDoctor"));
		patientBean.setRdisdiabetic(pInt(request, "rdisDiabetic"));
		patientBean.setRdishignbp(pInt(request, "rdisHighbp"));
		patientBean
				.setAddictionList(request.getParameterValues("chkaddiction"));
		patientBean.setTxtOtheraddiction(request
				.getParameter("txtotheraddiction"));
		patientBean
				.setTxtOtherRefrencename(request.getParameter("txtotherRef"));
		if(!request.getParameter("txtdateofbirth").isEmpty()){
			Date bod = dateofBirth(request.getParameter("txtdateofbirth"));
			patientBean.setTxtbod(bod);
		}
	patientBean.setUserdetailid(pInt(request, "userDetailId"));
		
		if(!request.getParameter("txtappdate").isEmpty()){
			patientBean.setAppDate(request.getParameter("txtappdate"));
		}
		
		patientBean.setCasetype(1);
		patientBean.setAppid(pInt(request, "appointmentid"));
		patientBean.setReferenceid(pInt(request, "refrenceid"));
		patientBean.setAddictionother(request.getParameter("txtotheraddiction"));
		return patientBean;

	}

	// String to Integer
	public Integer pInt(HttpServletRequest request, String val) {
		if (request.getParameter(val) != null
				&& !"".equals(request.getParameter(val))) {
			return Integer.parseInt(request.getParameter(val));
		}
		return 0;
	}

	// Add User in database
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addUser(TblUserLogin tblUserLogin, TblUser tblUser) {

		boolean isSuccess = false;
		Long userId = (Long) commonDao.save(tblUserLogin);
		if (userId != 0) {
			tblUser.setUserid(userId);
			tblUserDao.saveOrUpdateEntity(tblUser);
			isSuccess = true;
		}
		return isSuccess;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public int addPatientReffrence(TblPatientRefrence tblPatientRefrence) {
		return (Integer) commonDao.save(tblPatientRefrence);
	}
	//Edit data in patient Reference Table
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void editPatientReference(TblPatientRefrence tblPatientRefrence){
		commonDao.update(tblPatientRefrence);
	}
    //Add data in Patient Addiction Table
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addPatientAddiction(TblPatientAddiction tblPatientAddiction) {
		boolean bSuceess;
		tblPatientaddictionDao.addEntity(tblPatientAddiction);
		bSuceess = true;
		return bSuceess;

	}
   
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public int addPatientAddiction(TblPatientRefrence tblPatientRefrence) {
		return (Integer) commonDao.save(tblPatientRefrence);
	}

	// Add Patient in Database
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Integer addPatient(TblUser tblUser, TblPatient tblPatient) {
		int userDetailid = (Integer) commonDao.save(tblUser);
		if (userDetailid != 0) {
			tblUser.setUserdetailid(userDetailid);
			tblPatient.setTblUser(tblUser);
			return (Integer) commonDao.save(tblPatient);
		}

		return userDetailid;
	}

	// Patient Edit in database
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean editPatientAppointment(TblUser tblUser, TblPatient tblPatient , TblAppointment tblAppointment) {
		boolean bSuceess;
		tblAppointmentDao.saveOrUpdateEntity(tblAppointment);
		tblUserDao.saveOrUpdateEntity(tblUser);
		tblPatientDao.saveOrUpdateEntity(tblPatient);
		bSuceess = true;
		return bSuceess;

	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addAppointmentDate(TblUser tblUser, TblPatient tblPatient , TblAppointment tblAppointment) {
		boolean bSuceess;
		Integer appointmentId = (Integer) commonDao.save(tblAppointment);
		tblPatient.setAppid(appointmentId);
		tblUserDao.saveOrUpdateEntity(tblUser);
		tblPatientDao.saveOrUpdateEntity(tblPatient);
		bSuceess = true;
		return bSuceess;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean editPatient(TblUser tblUser, TblPatient tblPatient ) {
		boolean bSuceess;
		tblUserDao.saveOrUpdateEntity(tblUser);
		tblPatientDao.saveOrUpdateEntity(tblPatient);
		bSuceess = true;
		return bSuceess;
	}
	
	// Appointment Save]
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addAppointment(TblAppointment tblAppointment,
			TblPatient tblPatient, TblUser tblUser) {
		boolean bSuccess;
		int userDetailid = (Integer) commonDao.save(tblUser);
		tblUser.setUserdetailid(userDetailid);
		tblPatient.setTblUser(tblUser);
		Integer appointmentId = (Integer) commonDao.save(tblAppointment);
		tblPatient.setAppid(appointmentId);
		tblPatientDao.addEntity(tblPatient);
		bSuccess = true;
		return bSuccess;

	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean editAppointment(TblAppointment tblAppointment,
			TblPatient tblPatient, TblUser tblUser){
		boolean bSuccess;
		tblUserDao.saveOrUpdateEntity(tblUser);
		tblPatientDao.saveOrUpdateEntity(tblPatient);
		tblAppointmentDao.saveOrUpdateEntity(tblAppointment);
		bSuccess = true;
		return bSuccess;
	}
	

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addpatientAddiction(List<TblPatientAddiction> patientAddictionList) {
		boolean bSuccess;
		tblPatientaddictionDao
				.saveUpdateAllTblPatientAddiction(patientAddictionList);
		bSuccess = true;
		return bSuccess;
	}

	public boolean isEmailIdExists(String emailId) throws Exception {
		boolean isEmailIdExist = false;
		List<TblUserLogin> tblUserLogins = tblUserLoginDao.findTblUserLogin(
				"loginid", Operation_enum.EQ, emailId, "cstatus",
				Operation_enum.IN, new Integer[] { 1, 0 });
		if (tblUserLogins != null && !tblUserLogins.isEmpty()) {
			isEmailIdExist = true;
		}
		return isEmailIdExist;
	}

	// Append Date
	public String appenddate(String date, String month, String year) {
		String str;
		str = date + "/" + month + "/" + year;
		return str;
	}

	// String to date
	public Date dateofBirth(String birthDate) throws ParseException {
		String dateOfBirth = birthDate;
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy");
		return simpleDate.parse(dateOfBirth);
	}

	// String to datetime
	public String appDate(String appDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(clientDateFormate);
		return simpleDateFormat.format(appDate);
	}

	// String to double
	public Double pdouble(HttpServletRequest request, String value) {
		if (request.getParameter(value) != null
				&& !"".equals(request.getParameter(value))) {
			return Double.parseDouble(request.getParameter(value));
		}
		return (double) 0;
	}

	@Transactional
	public List<Object[]> getPatientDetails(String searchPatient) {
		StringBuilder query = new StringBuilder();
		List<Object[]> list;
		query.append("Select tblPatient.patientid,tblPatient.patientcrno,tblUser.firstname,tblUser.lastname,tblPatient.regdate,tblUser.bod");
		query.append(" ,CONCAT(tblUser.address,',',tblUser.landmark,',',tblCountry.countryName,',',tblState.stateName,',',tblUser.city,'-',tblUser.pincode) AS address");// ',',countryName,',',stateName,
		query.append(" ,tblUser.mobileno , tblUser.userdetailid");
		query.append(" FROM TblPatient tblPatient");
		query.append(" INNER JOIN tblPatient.tblUser tblUser,TblCountry tblCountry,TblState tblState");
		query.append(" WHERE tblPatient.tblUser.countryId = tblCountry.countryId");
		query.append(" AND tblPatient.tblUser.stateId = tblState.stateId");
		query.append(" AND tblUser.status = 1" );
		
		if (!searchPatient.isEmpty()) {
			query.append(" AND (tblPatient.patientcrno Like '%"+searchPatient+"%'  OR tblUser.firstname Like '%"+searchPatient+"%'  OR tblUser.mobileno Like '%"+searchPatient+"%')");
			 list = hibernateQueryDao.createNewQuery(
					query.toString(), null);
			
		}
		else{
			 list = hibernateQueryDao.createNewQuery(
					query.toString(), null);
		}
		query.append(" ORDER BY tblPatient.regdate");
		return list;
	}

	@Transactional
	public Object[] getPatient(int patientid) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put(PatientId, patientid);

		query.append("SELECT tblpatient.patientid,tblpatient.patientcrno,tbluser.firstname,tbluser.middlename,tbluser.lastname,tblpatient.regdate,tbluser.gender");
		query.append(",tbluser.dob,tblpatient.age,tbluser.coutrycodemobile,tbluser.mobileno,tbluser.countrycodelandline,tbluser.landlineno");
		query.append(",tbluser.extlandline,tbluser.address,tbluser.landmark,tbluser.area,tblcountry.countryId,tblcountry.countryName,tblstate.stateId");
		query.append(",tblstate.stateName,tbluser.city,tbluser.pincode,patientReferece.referencedtl,referencetype.referencebytypeid,referencetype.referencebytypename");
		query.append(",economicstatus.socialeconomicstatusid,economicstatus.socialeconomicstatusname,payby.paybyid,payby.paybyname,consultingdoctor.consultingdoctorid");
		query.append(",consultingdoctor.consultingdoctorname,tblpatient.isdiabetic,tblpatient.ishignbp,tbluser.userdetailid,tblpatient.refothersname,tblpatient.patbyname");
		query.append(",tblappointment.appid,tblappointment.appdate,tblpatient.referenceid,tblpatient.addictionother");
		query.append(" FROM `tbl_patient` tblpatient");
		query.append(" INNER JOIN `tbl_user` tbluser ON tblpatient.userdetailid = tbluser.userdetailid");
		query.append(" LEFT JOIN `tbl_country` tblcountry ON tbluser.countryId = tblcountry.countryId");
		query.append(" LEFT JOIN `tbl_state` tblstate ON tbluser.stateId = tblstate.stateId");
		query.append(" LEFT JOIN `tbl_patientreference` patientReferece ON tblpatient.referenceid = patientReferece.referenceid");
		query.append(" LEFT JOIN  `tbl_referencebytype` referencetype  ON patientReferece.referencebytypeid = referencetype.referencebytypeid");
		query.append(" LEFT JOIN `tbl_socialeconomicstatus` economicstatus ON tblpatient.socialeconomicstatusid = economicstatus.socialeconomicstatusid");
		query.append(" LEFT JOIN `tbl_payby` payby ON tblpatient.paybyid = payby.paybyid");
		query.append(" INNER JOIN `tbl_consultingdoctor` consultingdoctor ON tblpatient.consultingdoctorid = consultingdoctor.consultingdoctorid");
	    query.append(" LEFT JOIN `tbl_appointment` tblappointment ON tblpatient.appid = tblappointment.appid");
		query.append(" WHERE tblpatient.patientid =:patientid");
		// query.append(" INNER JOIN `tbl_patientaddiction` patientaddiction ON patientaddiction.patientid = tblpatient.patientid");
		// query.append(" INNER JOIN `tbl_addiction` addiction ON patientaddiction.addictionid =addiction.addictionid ");

		List<Object[]> list = hibernateQueryDao.createSQLQuery(
				query.toString(), parameters);
		return list != null && !list.isEmpty() ? list.get(0) : null;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean cancelAppointment(int appointmentid, int status,String reseaon) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("appointmentid", appointmentid);
		parameter.put("status", status);
		parameter.put("reseaon", reseaon);
		query.append("UPDATE TblAppointment set status =:status, reseaon =:reseaon WHERE appid =:appointmentid");
		int flag = hibernateQueryDao.updateDeleteNewQuery(query.toString(),parameter);
		return flag != 0 ? true : false;

	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean UpdateAppointmnet(TblAppointment tblAppointment) {
		boolean bSuccess;
		tblAppointmentDao.saveOrUpdateEntity(tblAppointment);
		bSuccess = true;
		return bSuccess; 

	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean chageStatus(int appid, int status) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("appid", appid);
		parameter.put("status", status);
		query.append("UPDATE TblAppointment set status =:status WHERE appid =:appid");
		int flag = hibernateQueryDao.updateDeleteNewQuery(query.toString(),
				parameter);
		return flag != 0 ? true : false;

	}
	
	@Transactional
	public List<Object[]> appointmentList(String search, String currentDate) {
		StringBuilder query = new StringBuilder();
		Map<String, Object>parameter = null;
		List<Object[]> list ;
		query.append("SELECT tblcasetype.casetypename,tblpatient.patientcrno,tbluser.firstname,tbluser.lastname,tbluser.bod");
		query.append(" ,tblpatient.age,tbluser.countrycodemobileno,tbluser.mobileno,tblconsultingdoctor.consultingdoctorname,tblappointment.appdate,tblpatient.patientid,tblappointment.status,tblappointment.appid");
		query.append(" FROM  TblPatient tblpatient,TblAppointment tblappointment");
		query.append(" INNER JOIN tblpatient.tblUser tbluser");
		query.append(" INNER JOIN tblappointment.tblCaseType tblcasetype");
		query.append(" INNER JOIN tblpatient.tblConsultingDoctor tblconsultingdoctor");
		
		if(!search.isEmpty()){
			query.append(" WHERE tblpatient.appid = tblappointment.appid AND tblappointment.status IN(0,1)");
			query.append(" AND (tblpatient.patientcrno Like '%"+search+"%'  OR tbluser.firstname Like '%"+search+"%'  OR tbluser.mobileno Like '%"+search+"%')");
			
		}
		if(currentDate!=null && !currentDate.isEmpty()){
			parameter = new HashMap<String, Object>();
			parameter.put("currentDate", currentDate);
			parameter.put("dateFormate", sqlDateFormate);
			query.append(" WHERE tblpatient.appid = tblappointment.appid AND tblappointment.status IN(0)");
			query.append("AND DATE_FORMAT(tblappointment.appdate,:dateFormate) =DATE_FORMAT(:currentDate,:dateFormate)");
			
			
		}
		query.append(" ORDER BY tblpatient.patientid desc");
		list = hibernateQueryDao.createNewQuery(query.toString(), parameter);
		return list;

	}
	@Transactional
	public List<TblPatientAddiction> getAddiction(int patientid) throws Exception{
		return tblPatientaddictionDao.findTblPatientAddiction(PatientId,Operation_enum.EQ,patientid,"tblAddiction.addictionid",Operation_enum.ORDERBY, Operation_enum.ASC);
	}
	@Transactional
	public Object[] getAppoitment(int patientid) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put(PatientId, patientid);
		query.append("SELECT tblcasetype.casetypename,tblpatient.patientcrno,tbluser.firstname,tbluser.middlename,tbluser.lastname,tbluser.dob");
		query.append(",tblpatient.age,tbluser.coutrycodemobile,tbluser.mobileno,tblconsultingdoctor.consultingdoctorid,tblconsultingdoctor.consultingdoctorname,tblappointment.appdate,tblpatient.patientid,tbluser.userdetailid");
		query.append(" ,tblappointment.appid FROM  `tbl_patient` tblpatient");
		query.append(" INNER JOIN `tbl_user` tbluser ON tblpatient.userdetailid = tbluser.userdetailid");
		query.append(" INNER JOIN  `tbl_appointment` tblappointment ON tblpatient.appid = tblappointment.appid");
		query.append(" INNER JOIN `tbl_casetype` tblcasetype ON tblappointment.casetypeid =tblcasetype.casetypeid");
		query.append(" INNER JOIN `tbl_consultingdoctor` tblconsultingdoctor ON tblpatient.consultingdoctorid = tblconsultingdoctor.consultingdoctorid");
		query.append(" WHERE tblpatient.patientid =:patientid");
	
		List<Object[]> list = hibernateQueryDao.createSQLQuery(
				query.toString(), parameter);
		return list != null && !list.isEmpty() ? list.get(0) : null;
	}
	@Transactional
	public List<TblComplaints> complaintsList() throws Exception{
		return tblComplaintsDao.findTblComplaints("complaintsstatus",Operation_enum.EQ,1,"complaintsid",Operation_enum.ORDERBY,Operation_enum.DESC);
	}
	@Transactional
	public boolean deleteComplatints(int compid, int status) {
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("compid", compid);
		parameter.put("status", status);
		query.append("UPDATE TblComplaints set complaintsstatus =:status WHERE complaintsid =:compid");
		int flag = hibernateQueryDao.updateDeleteNewQuery(query.toString(),
				parameter);
		return flag != 0 ? true : false;
		
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void deleteAddiction(int patientId){
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("patientId", patientId);
		query.append("DELETE FROM TblPatientAddiction WHERE patientid =:patientId");
		hibernateQueryDao.updateDeleteNewQuery(query.toString(), parameter);
		
	}
	

}
