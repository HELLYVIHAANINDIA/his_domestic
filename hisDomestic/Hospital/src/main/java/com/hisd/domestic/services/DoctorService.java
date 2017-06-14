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
		query.append("SELECT tblPatient.patientcrno, tblUser.firstname,tblUser.lastname,tblPatient.age,tblUser.gender,tblUser.countrycodemobileno,tblUser.mobileno,tblConsultingdoctor.consultingdoctorname ");
		query.append(" FROM TblPatient tblPatient INNER JOIN tblPatient.tblUser tblUser ");
		query.append(" INNER JOIN tblPatient.tblConsultingDoctor  tblConsultingdoctor");
		query.append(" WHERE tblPatient.patientid =:patientid");
		List<Object[]> tblpatient = hibernateQueryDao.createNewQuery(query.toString(), parameter);
		return tblpatient;
		
	}
}
