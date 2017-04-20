package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblAppointmentDao;
import com.hisd.domestic.model.TblAppointment;

@Repository
public class TblAppointmentDaoImpl extends HibernateAbstractClass<TblAppointment> implements TblAppointmentDao {

	
	@Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addTblAppointment(TblAppointment tblAppointment) {
		super.addEntity(tblAppointment);
		
	}

	@Override
	public void deleteTblAppointment(TblAppointment tblAppointment) {
		super.deleteEntity(tblAppointment);
		
	}

	@Override
	public void updateTblAppointment(TblAppointment tblAppointment) {
		super.updateEntity(tblAppointment);
		
	}

	@Override
	public List<TblAppointment> getAllTblAppointment() {
		 return super.getAllEntity();
	}

	@Override
	public List<TblAppointment> findTblAppointment(Object... values)
			throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblAppointment> findByCountTblAppointment(int firstResult,
			int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblAppointmentCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblAppointment(List<TblAppointment> tblAppointment) {
		super.updateAll(tblAppointment);
		
	}
}
