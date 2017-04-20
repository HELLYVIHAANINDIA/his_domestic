package com.hisd.common.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblPatientRefrenceDao;
import com.hisd.domestic.model.TblPatientRefrence;

@Repository
public class TblPatientRefrenceDaoImpl extends HibernateAbstractClass<TblPatientRefrence> implements TblPatientRefrenceDao{
	@Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addTblPatientRefrence(TblPatientRefrence tblPatientRefrence) {
		super.addEntity(tblPatientRefrence);
		
	}

	@Override
	public void deleteTblPatientRefrence(TblPatientRefrence tblPatientRefrence) {
		super.deleteEntity(tblPatientRefrence);
		
	}

	@Override
	public void updateTblPatientRefrence(TblPatientRefrence tblPatientRefrence) {
		super.updateEntity(tblPatientRefrence);
		
	}

	@Override
	public List<TblPatientRefrence> getAllTblPatientRefrence() {

		 return super.getAllEntity();
	}

	@Override
	public List<TblPatientRefrence> findTblPatientRefrence(Object... values)
			throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblPatientRefrence> findByCountTblPatientRefrence(
			int firstResult, int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblPatientRefrenceCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblPatientRefrence(
			List<TblPatientRefrence> tblPatientRefrence) {
		super.updateAll(tblPatientRefrence);
		
	}

	
}
