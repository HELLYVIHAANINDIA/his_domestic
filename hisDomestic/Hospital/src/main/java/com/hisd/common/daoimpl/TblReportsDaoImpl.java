package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblReports;
import com.hisd.common.daointerface.TblReportDao;

@Repository
public class TblReportsDaoImpl extends HibernateAbstractClass<TblReports> implements TblReportDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblReports(TblReports tblReports) {
		super.addEntity(tblReports);

		
	}

	@Override
	public void deleteTblReports(TblReports tblReports) {
		super.deleteEntity(tblReports);
		
	}

	@Override
	public void updateTblReports(TblReports tblReports) {
		super.updateEntity(tblReports);
		
	}

	@Override
	public List<TblReports> getAllTblReports() {
		return super.getAllEntity();
	}

	@Override
	public List<TblReports> findTblReports(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblReports> findByCountTblReports(int firstResult, int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblReportsCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblReports(List<TblReports> tblReports) {
		super.updateAll(tblReports);
		
	}

	
	

}
