package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblDocumentDao;
import com.hisd.domestic.model.TblDocument;

@Repository
public class TblDocumentDaoImpl extends HibernateAbstractClass<TblDocument> implements TblDocumentDao {
	
    @Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void addTblDocument(TblDocument tblDocument){
        super.addEntity(tblDocument);
    }

    @Override
    public void deleteTblDocument(TblDocument tblDocument) {
        super.deleteEntity(tblDocument);
    }

    @Override
    public void updateTblDocument(TblDocument tblDocument) {
        super.updateEntity(tblDocument);
    }

    @Override
    public List<TblDocument> getAllTblDocument() {
        return super.getAllEntity();
    }

    @Override
    public List<TblDocument> findTblDocument(Object... values) throws Exception {
        return super.findEntity(values);
    }

    @Override
    public long getTblDocumentCount() {
        return super.getEntityCount();
    }

    @Override
    public List<TblDocument> findByCountTblDocument(int firstResult, int maxResult, Object... values) throws Exception {
        return super.findByCountEntity(firstResult, maxResult, values);
    }

    @Override
    public void saveUpdateAllTblDocument(List<TblDocument> tblDocument){
        super.updateAll(tblDocument);
    }

}
