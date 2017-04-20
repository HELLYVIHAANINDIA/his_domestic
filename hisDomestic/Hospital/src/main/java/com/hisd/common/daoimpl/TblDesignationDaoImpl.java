/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.common.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.HibernateAbstractClass;
import com.hisd.common.daointerface.TblDesignationDao;
import com.hisd.domestic.model.TblDesignation;

/**
 *
 */
@Repository
public class TblDesignationDaoImpl extends HibernateAbstractClass<TblDesignation> implements TblDesignationDao {

    @Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void addTblDesignation(TblDesignation TblDesignation){
        super.addEntity(TblDesignation);
    }

    @Override
    public void deleteTblDesignation(TblDesignation TblDesignation) {
        super.deleteEntity(TblDesignation);
    }

    @Override
    public void updateTblDesignation(TblDesignation TblDesignation) {
        super.updateEntity(TblDesignation);
    }

    @Override
    public List<TblDesignation> getAllTblDesignation() {
        return super.getAllEntity();
    }

    @Override
    public List<TblDesignation> findTblDesignation(Object... values) throws Exception {
        return super.findEntity(values);
    }

    @Override
    public long getTblDesignationCount() {
        return super.getEntityCount();
    }

    @Override
    public List<TblDesignation> findByCountTblDesignation(int firstResult, int maxResult, Object... values) throws Exception {
        return super.findByCountEntity(firstResult, maxResult, values);
    }

    @Override
    public void saveUpdateAllTblDesignation(List<TblDesignation> TblDesignation){
        super.updateAll(TblDesignation);
    }
}
