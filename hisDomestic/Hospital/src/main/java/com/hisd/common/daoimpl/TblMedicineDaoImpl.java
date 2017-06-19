package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblMedicine;
import com.hisd.common.daointerface.TblMedicineDao;
@Repository
public class TblMedicineDaoImpl extends HibernateAbstractClass<TblMedicine> implements TblMedicineDao {
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblMedicine(TblMedicine tblMedicine) {
		super.addEntity(tblMedicine);
		
	}

	@Override
	public void deleteTblMedicine(TblMedicine tblMedicine) {
		super.deleteEntity(tblMedicine);
		
	}

	@Override
	public void updateTblMedicine(TblMedicine tblMedicine) {
		super.updateEntity(tblMedicine);
		
	}

	@Override
	public List<TblMedicine> getAllTblMedicine() {
		return super.getAllEntity();
	}

	@Override
	public List<TblMedicine> findTblMedicine(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblMedicine> findByCountTblMedicine(int firstResult, int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblMedicineCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblMedicine(List<TblMedicine> tblMedicine) {
		super.updateAll(tblMedicine);
		
	}

}
