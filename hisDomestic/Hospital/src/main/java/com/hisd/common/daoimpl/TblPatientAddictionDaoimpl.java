package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblPatientAddictionDao;
import com.hisd.domestic.model.TblPatientAddiction;
@Repository
public class TblPatientAddictionDaoimpl  extends HibernateAbstractClass<TblPatientAddiction> implements TblPatientAddictionDao {
	 @Autowired
	    @Qualifier("sessionFactory")
	    public void init(SessionFactory sessionFactory) {
	        setSessionFactory(sessionFactory);
	    }

	@Override
	public void addTblPatientAddiction(TblPatientAddiction tblPatientAddiction) {
		super.addEntity(tblPatientAddiction);
		
	}

	@Override
	public void deleteTblPatientAddiction(
			TblPatientAddiction tblPatientAddiction) {
		super.deleteEntity(tblPatientAddiction);
		
	}

	@Override
	public void updateTblPatientAddiction(
			TblPatientAddiction tblPatientAddiction) {
		super.updateEntity(tblPatientAddiction);
		
	}

	@Override
	public List<TblPatientAddiction> getAllTblPatientAddiction() {
		 return super.getAllEntity();
	}

	@Override
	public List<TblPatientAddiction> findTblPatientAddiction(Object... values)
			throws Exception {
		 return super.findEntity(values);
	}

	@Override
	public List<TblPatientAddiction> findByCountTblPatientAddiction(
			int firstResult, int maxResult, Object... values) throws Exception {
		 return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblPatientAddictionCount() {
		  return super.getEntityCount();
	}
		
	

	@Override
	public void saveUpdateAllTblPatientAddiction(
			List<TblPatientAddiction> tblPatientAddiction) {
		 super.updateAll(tblPatientAddiction);
		
	}

	

	
}
