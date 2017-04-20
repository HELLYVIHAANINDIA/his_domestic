package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblComplaints;
import com.hisd.common.daointerface.TblComplaintsDao;

@Repository
public class TblComplaintsDaoImpl extends HibernateAbstractClass<TblComplaints>
		implements TblComplaintsDao {

	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblComplaints(TblComplaints tblComplaints) {
		super.addEntity(tblComplaints);

	}

	@Override
	public void deleteTblComplaints(TblComplaints tblComplaints) {
		super.deleteEntity(tblComplaints);

	}

	@Override
	public void updateTblComplaints(TblComplaints tblComplaints) {
		super.updateEntity(tblComplaints);
	}

	@Override
	public List<TblComplaints> getAllTblComplaints() {
		return super.getAllEntity();
	}

	@Override
	public List<TblComplaints> findTblComplaints(Object... values)
			throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblComplaints> findByCountTblComplaints(int firstResult,
			int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblComplaintsCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblComplaints(List<TblComplaints> tblComplaints) {
		super.updateAll(tblComplaints);

	}
}
