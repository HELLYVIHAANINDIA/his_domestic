package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblClinicalReport;
import com.hisd.common.daointerface.TblClinicalReportDao;

@Repository
public class TblClinicalReportDaoImpl extends HibernateAbstractClass<TblClinicalReport> implements TblClinicalReportDao {
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Override
	public void addTblClinicalReport(TblClinicalReport tblClinicalReport) {
		super.addEntity(tblClinicalReport);
		
	}

	@Override
	public void deleteTblClinicalReport(TblClinicalReport tblClinicalReport) {
		super.deleteEntity(tblClinicalReport);
		
	}

	@Override
	public void updateTblClinicalReport(TblClinicalReport tblClinicalReport) {
		super.updateEntity(tblClinicalReport);
		
	}

	@Override
	public List<TblClinicalReport> getAllTblClinicalReport() {
		return super.getAllEntity();
	}

	@Override
	public List<TblClinicalReport> findTblClinicalReport(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblClinicalReport> findByCountTblClinicalReport(int firstResult, int maxResult, Object... values)
			throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblClinicalReportCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblClinicalReport(List<TblClinicalReport> tblClinicalReport) {
		super.updateAll(tblClinicalReport);
		
	}

}
