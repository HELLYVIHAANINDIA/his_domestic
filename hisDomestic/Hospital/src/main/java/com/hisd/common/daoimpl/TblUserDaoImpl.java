package com.hisd.common.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblUserDao;
import com.hisd.domestic.model.TblUser;

@Repository
public class TblUserDaoImpl extends HibernateAbstractClass<TblUser> implements TblUserDao  {
	@Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addTblUser(TblUser tblUser) {
		super.addEntity(tblUser);
		
	}

	@Override
	public void deleteTblUser(TblUser TblUser) {
		super.deleteEntity(TblUser);
		
	}

	@Override
	public void updateTblUser(TblUser TblUser) {
		super.updateEntity(TblUser);
		
	}

	@Override
	public List<TblUser> getAllTblUser() {
		
		 return super.getAllEntity();
	}

	@Override
	public List<TblUser> findTblUser(Object... values) throws Exception {
		return super.findEntity(values);
	}

	@Override
	public List<TblUser> findByCountTblUser(int firstResult, int maxResult,
			Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblUserCount() {
		return super.getEntityCount();
	}
   
	@Override
	public void saveUpdateAllTblUser(List<TblUser> TblUser) {
		 super.updateAll(TblUser);
		
	}

}
