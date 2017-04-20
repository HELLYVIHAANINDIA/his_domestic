package com.hisd.common.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblReferenceDao;
import com.hisd.domestic.model.TblReferenceType;

@Repository
public class TblReferencedaoImpl extends HibernateAbstractClass<TblReferenceType> implements TblReferenceDao {
	@Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

	@Override
	public void addTblReferenceType(TblReferenceType tblReferenceType) {
		super.addEntity(tblReferenceType);
		
	}

	@Override
	public void deleteTblReferenceType(TblReferenceType tblReferenceType) {
	super.deleteEntity(tblReferenceType);
		
	}

	@Override
	public void updateTblReferenceType(TblReferenceType tblReferenceType) {
		super.updateEntity(tblReferenceType);
		
	}

	@Override
	public List<TblReferenceType> getAllTblReferenceType() {
		// TODO Auto-generated method stub
		 return super.getAllEntity();
	}

	@Override
	public List<TblReferenceType> findTblReferenceType(Object... values)
			throws Exception {
		return super.findEntity(values);
		
	}

	@Override
	public List<TblReferenceType> findByCountTblReferenceType(int firstResult,
			int maxResult, Object... values) throws Exception {
		return super.findByCountEntity(firstResult, maxResult, values);
	}

	@Override
	public long getTblReferenceTypeCount() {
		return super.getEntityCount();
	}

	@Override
	public void saveUpdateAllTblReferenceType(
			List<TblReferenceType> tblReferenceType) {
		super.updateAll(tblReferenceType);
		
	}

}
