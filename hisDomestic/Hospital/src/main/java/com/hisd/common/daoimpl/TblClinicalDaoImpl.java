package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblClinical;
import com.hisd.common.daointerface.TblClinicalDao;

@Repository
public class TblClinicalDaoImpl extends HibernateAbstractClass<TblClinical> implements TblClinicalDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblClinical(TblClinical tblClinical) {
		super.addEntity(tblClinical);
		
	}

	@Override
	public void deleteTblClinical(TblClinical tblClinical) {
		super.deleteEntity(tblClinical);
		
	}

	@Override
	public void updateTblClinical(TblClinical tblClinical) {
		super.updateEntity(tblClinical);
		
	}

	@Override
	public List<TblClinical> getAllTblClinical() {
		return super.getAllEntity();
	}

	@Override
	public List<TblClinical> findTblClinical(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblClinical> findByCountTblClinical(int firstResult, int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblClinicalCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblClinical(List<TblClinical> tblClinical) {
		super.updateAll(tblClinical);
		
	}
	

}
