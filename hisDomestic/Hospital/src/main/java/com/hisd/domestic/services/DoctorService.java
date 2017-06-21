package com.hisd.domestic.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hisd.common.daogeneric.Operation_enum;
import com.hisd.common.daointerface.HibernateQueryDao;
import com.hisd.common.daointerface.TblAppointmentDao;
import com.hisd.common.daointerface.TblClinicalDao;
import com.hisd.common.daointerface.TblClinicalReportDao;
import com.hisd.common.daointerface.TblComplaintsDao;
import com.hisd.common.daointerface.TblMedicineDao;
import com.hisd.common.daointerface.TblPatientAddictionDao;
import com.hisd.common.daointerface.TblPatientDao;
import com.hisd.common.daointerface.TblPatientRefrenceDao;
import com.hisd.common.daointerface.TblReferenceDao;
import com.hisd.common.daointerface.TblReportDao;
import com.hisd.common.daointerface.TblUserDao;
import com.hisd.common.daointerface.TblUserLoginDao;
import com.hisd.common.services.CommonDAO;
import com.hisd.common.utility.EncryptDecryptUtils;
import com.hisd.domestic.databean.Clinicalbean;
import com.hisd.domestic.databean.PatientBean;
import com.hisd.domestic.databean.UserDatabean;
import com.hisd.domestic.model.TblAppointment;
import com.hisd.domestic.model.TblClinical;
import com.hisd.domestic.model.TblClinicalReport;
import com.hisd.domestic.model.TblComplaints;
import com.hisd.domestic.model.TblMedicine;
import com.hisd.domestic.model.TblPatient;
import com.hisd.domestic.model.TblPatientAddiction;
import com.hisd.domestic.model.TblPatientRefrence;
import com.hisd.domestic.model.TblReports;
import com.hisd.domestic.model.TblUser;
import com.hisd.domestic.model.TblUserLogin;

@Service
public class DoctorService {

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
    @Autowired
    TblMedicineDao tblMedicineDao;
    @Autowired
    TblReportDao tblReportDao;
    @Autowired
    TblClinicalDao tblClinicalDao;
    @Autowired
    TblClinicalReportDao tblClinicalReportDao;
    
	@Value("#{projectProperties['passwordkey']}")
	private String passwordkey;
	@Value("#{hospitalProperties['client_dateformate']}")
	private String clientDateFormate;
	@Value("#{hospitalProperties['sql_dateFormate']}")
	private String sqlDateFormate;
	
	private static final String PatientId = "patientid";
	
	
	@Transactional
	public List<Object[]> appointmentList( String currentDate) {
		StringBuilder query = new StringBuilder();
		Map<String, Object>parameter = null;
		parameter = new HashMap<String, Object>();
		parameter.put("currentDate", currentDate);
		List<Object[]> list ;
		query.append("SELECT tblcasetype.casetypename,tblpatient.patientcrno,tbluser.firstname,tbluser.lastname,tbluser.bod");
		query.append(" ,tblpatient.age,tbluser.countrycodemobileno,tbluser.mobileno,tblconsultingdoctor.consultingdoctorname,tblappointment.appdate,tblpatient.patientid,tblappointment.status,tblappointment.appid");
		query.append(" FROM  TblPatient tblpatient,TblAppointment tblappointment");
		query.append(" INNER JOIN tblpatient.tblUser tbluser");
		query.append(" INNER JOIN tblappointment.tblCaseType tblcasetype");
		query.append(" INNER JOIN tblpatient.tblConsultingDoctor tblconsultingdoctor");
			parameter.put("dateFormate", sqlDateFormate);
			query.append(" WHERE tblpatient.appid = tblappointment.appid AND tblappointment.status IN(1)");
			query.append("AND DATE_FORMAT(tblappointment.appdate,:dateFormate) =DATE_FORMAT(:currentDate,:dateFormate)");
		query.append(" ORDER BY tblpatient.patientid desc");
		list = hibernateQueryDao.createNewQuery(query.toString(), parameter);
		return list;

	}
	@Transactional
	public List<Object[]> getpatientinfo(int patientid){
		StringBuilder query = new StringBuilder();
		Map<String, Object>parameter = null;
		parameter = new HashMap<String, Object>();
		parameter.put("patientid", patientid);
		query.append("SELECT tblPatient.patientcrno, tblUser.firstname,tblUser.lastname,tblPatient.age,tblUser.gender,tblUser.countrycodemobileno,tblUser.mobileno,tblConsultingdoctor.consultingdoctorname,tblPatient.patientid");
		query.append(" FROM TblPatient tblPatient INNER JOIN tblPatient.tblUser tblUser ");
		query.append(" INNER JOIN tblPatient.tblConsultingDoctor  tblConsultingdoctor");
		query.append(" WHERE tblPatient.patientid =:patientid");
		List<Object[]> tblpatient = hibernateQueryDao.createNewQuery(query.toString(), parameter);
		return tblpatient;
		
	}
	@Transactional
	public List<TblComplaints> getAllComplaints(){
	    return	tblComplaintsDao.getAllTblComplaints();
		
	}
	@Transactional
	public List<TblMedicine> getAllMedicins(){
		return tblMedicineDao.getAllTblMedicine();
	}
	@Transactional
	public List<TblReports> getAllReports(){
		return tblReportDao.getAllTblReports();
	}
	
	public Clinicalbean getClinicalDatabean(HttpServletRequest request) throws Exception{
		Clinicalbean clinicalbean = new Clinicalbean();
		
		clinicalbean.setTxthistory(request.getParameter("txthistory"));
		clinicalbean.setTxtcomments(request.getParameter("txtcomments"));
		clinicalbean.setComlaintsList(request.getParameterValues("chkcomplain"));
		clinicalbean.setMedicineList(request.getParameterValues("chkmedicien"));
		clinicalbean.setReportList(request.getParameterValues("ctkreport"));
		clinicalbean.setTxtremark(request.getParameter("txtremark"));
		clinicalbean.setClinical_id(Integer.parseInt(request.getParameter("hdclinicalDetailid")));
		
		return clinicalbean;
		
	}
	
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addComplaints(List<TblClinicalReport> complainList){
		boolean bSuccess;
		tblClinicalReportDao.saveUpdateAllTblClinicalReport(complainList);
		bSuccess = true;
		return bSuccess;
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean addClinicalData(TblClinical tblClinical){
		boolean bSuccess = false;
		tblClinicalDao.addEntity(tblClinical);
		return bSuccess;
	}
	
	@Transactional
	public List<TblClinical> getClinicalDetail(int patientid) throws Exception{
		return tblClinicalDao.findTblClinical("tblPatient.patientid",Operation_enum.EQ,patientid);
		
	}
	@Transactional
	public List<TblClinicalReport> getClinicalReport(int patientid) throws Exception{
		 tblClinicalReportDao.findTblClinicalReport("tblPatient.patientid",Operation_enum.EQ,patientid);
		 
		 return null;
	}
	@Transactional
	public List<Object[]> getReportName(int patientid ,int status){
		StringBuilder query = new StringBuilder();
		Map<String, Object>parameter = null;
		parameter = new HashMap<String, Object>();
		parameter.put("patientid", patientid);
		parameter.put("status", status);
		query.append("SELECT tblPatient.patientid,tblClinicalReport.clinicalreport_id");
		if(status == 1){
			query.append(" ,tblComplaints.complaintsname,tblComplaints.complaintsid ");
		}
		else if(status == 2){
			query.append(" ,tblMedicine.medicine_name,tblMedicine.medicine_id");
		}else{
			query.append(" ,tblReports.report_name,tblReports.report_id");
		}
		query.append(" FROM TblClinicalReport tblClinicalReport");
		query.append(" INNER JOIN tblClinicalReport.tblPatient tblPatient");
		if(status == 1){
			query.append(" ,TblComplaints tblComplaints");	
		}else if(status == 2){
			query.append(" ,TblMedicine tblMedicine");
		}else{
			query.append(" ,TblReports tblReports");	
		}
		query.append(" WHERE tblPatient.patientid=:patientid AND tblClinicalReport.statusid=:status");
		if(status == 1){
			query.append(" AND tblComplaints.complaintsid=tblClinicalReport.clnicalreportid");
		}else if(status == 2){
			query.append(" AND tblMedicine.medicine_id=tblClinicalReport.clnicalreportid");
		}
		else{
			query.append(" AND tblReports.report_id=tblClinicalReport.clnicalreportid");
		}
		return hibernateQueryDao.createNewQuery(query.toString(), parameter);
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean updateClinicalData(TblClinical tblClinical){
		boolean bSuccess = false;
		tblClinicalDao.saveOrUpdateEntity(tblClinical);
		bSuccess = true;
		return bSuccess;
		
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean deleteClinicalReport(Integer patientid){
		boolean bSuccess = false;
		StringBuilder query = new StringBuilder();
		Map<String,Object>parameter = null;
		parameter = new HashMap<String, Object>();
		parameter.put("patientid", patientid);
		query.append("delete from TblClinicalReport tblClinicalReport WHERE tblPatient.patientid=:patientid ");
		hibernateQueryDao.updateDeleteQuery(query.toString(), parameter);
		bSuccess = true;
		
		return bSuccess ;
		
	}
	
}
