package com.hisd.common.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblPaybyDao;
import com.hisd.domestic.model.TblPayBy;

@Repository
public class TblPayByDaoImpl extends HibernateAbstractClass<TblPayBy> implements TblPaybyDao {
	@Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addTblPayBy(TblPayBy tblPayBy) {
		super.addEntity(tblPayBy);
		
	}

	@Override
	public void deleteTblPayBy(TblPayBy tblPayBy) {
	super.deleteEntity(tblPayBy);
		
	}

	@Override
	public void updateTblPayBy(TblPayBy tblPayBy) {
		super.updateEntity(tblPayBy);
		
	}

	@Override
	public List<TblPayBy> getAllTblPayBy() {
		return super.getAllEntity();
	}
	

	@Override
	public List<TblPayBy> findTblPayByr(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblPayBy> findByCountTblPayBy(int firstResult, int maxResult,
			Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblPayByCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblPayBy(List<TblPayBy> tblPayBy) {
		super.updateAll(tblPayBy);
		
	}

}
