package com.hisd.common.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblPatientDao;
import com.hisd.domestic.model.TblPatient;

@Repository
public class TblPatientDaoImpl extends HibernateAbstractClass<TblPatient> implements TblPatientDao {
	@Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addTblPatient(TblPatient tblPatient) {
		super.addEntity(tblPatient);
		
	}

	@Override
	public void deleteTblpatient(TblPatient tblPatient) {
		super.deleteEntity(tblPatient);
		
	}

	@Override
	public void updateTblTblpatient(TblPatient tblPatient) {
		super.updateEntity(tblPatient);
		
	}

	@Override
	public List<TblPatient> getAllTblpatient() {
		 return super.getAllEntity();
	}

	@Override
	public List<TblPatient> findTblpatient(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblPatient> findByCountTblpatient(int firstResult,
			int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblpatientCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblPatient(List<TblPatient> tblPatient) {
		super.updateAll(tblPatient);
		
	}

	

	
}
