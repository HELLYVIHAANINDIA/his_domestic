package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblConsultingDoctor;
import com.hisd.common.daointerface.TblConsultingDoctorDao;

@Repository
public class TblConsultingDoctorImpl extends HibernateAbstractClass<TblConsultingDoctor>
		implements TblConsultingDoctorDao {

	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblConsultingDoctor(TblConsultingDoctor tblConsultingDoctor) {
		super.addEntity(tblConsultingDoctor);

	}

	@Override
	public void deleteTblConsultingDoctor(TblConsultingDoctor tblConsultingDoctor) {
		super.deleteEntity(tblConsultingDoctor);

	}

	@Override
	public void updateTblConsultingDoctor(TblConsultingDoctor tblConsultingDoctor) {
		super.updateEntity(tblConsultingDoctor);
	}

	@Override
	public List<TblConsultingDoctor> getAllTblConsultingDoctor() {
		return super.getAllEntity();
	}

	@Override
	public List<TblConsultingDoctor> findTblConsultingDoctor(Object... values)
			throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblConsultingDoctor> findByCountTblConsultingDoctor(int firstResult,
			int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblConsultingDoctorCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblConsultingDoctor(List<TblConsultingDoctor> tblConsultingDoctor) {
		super.updateAll(tblConsultingDoctor);

	}
}
