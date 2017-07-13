package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblMedicineSchedule;
import com.hisd.common.daointerface.TblMedicineScheduleDao;
@Repository
public class TblMedicineScheduleDaoImpl extends HibernateAbstractClass<TblMedicineSchedule> implements TblMedicineScheduleDao  {
	
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblMedicineSedule(TblMedicineSchedule tblMedicineSedule) {
		super.addEntity(tblMedicineSedule);
		
	}

	@Override
	public void deleteTblMedicineSedule(TblMedicineSchedule tblMedicineSedule) {
		super.deleteEntity(tblMedicineSedule);
		
	}

	@Override
	public void updateTblMedicineSedule(TblMedicineSchedule tblMedicineSedule) {
		super.updateEntity(tblMedicineSedule);
		
	}

	@Override
	public List<TblMedicineSchedule> getAllTblMedicineSedule() {
		return super.getAllEntity();
	}

	@Override
	public List<TblMedicineSchedule> findTblMedicineSedule(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblMedicineSchedule> findByCountTblMedicineSedule(int firstResult, int maxResult, Object... values)
			throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblMedicineSeduleCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblMedicineSedule(List<TblMedicineSchedule> tblMedicineSedule) {
		super.updateAll(tblMedicineSedule);
		
	}

}
