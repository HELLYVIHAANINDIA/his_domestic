package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.domestic.model.TblFinding;
import com.hisd.common.daointerface.TblFindingDao;;

@Repository
public class TblFindingDaoImpl extends HibernateAbstractClass<TblFinding> implements TblFindingDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	public void init(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public void addTblFinding(TblFinding tblFinding) {
		super.addEntity(tblFinding);
		
	}

	@Override
	public void deleteTblFinding(TblFinding tblFinding) {
		super.deleteEntity(tblFinding);
		
	}

	@Override
	public void updateTblFinding(TblFinding tblFinding) {
		super.updateEntity(tblFinding);
		
	}

	@Override
	public List<TblFinding> getAllTblFinding() {
		return super.getAllEntity();
	}

	@Override
	public List<TblFinding> findTblFinding(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblFinding> findByCountTblFinding(int firstResult,
			int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblMedicineSeduleCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblFinding(List<TblFinding> tblFinding) {
		super.updateAll(tblFinding);
		
	}

}
