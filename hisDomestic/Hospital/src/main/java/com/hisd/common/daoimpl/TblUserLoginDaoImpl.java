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
import com.hisd.common.daointerface.TblUserLoginDao;
import com.hisd.domestic.model.TblUserLogin;

/**
 *
 */
@Repository
public class TblUserLoginDaoImpl extends HibernateAbstractClass<TblUserLogin> implements TblUserLoginDao {

    @Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public void addTblUserLogin(TblUserLogin TblUserLogin){
        super.addEntity(TblUserLogin);
    }

    @Override
    public void deleteTblUserLogin(TblUserLogin TblUserLogin) {
        super.deleteEntity(TblUserLogin);
    }

    @Override
    public void updateTblUserLogin(TblUserLogin TblUserLogin) {
        super.updateEntity(TblUserLogin);
    }

    @Override
    public List<TblUserLogin> getAllTblUserLogin() {
        return super.getAllEntity();
    }

    @Override
    public List<TblUserLogin> findTblUserLogin(Object... values) throws Exception {
        return super.findEntity(values);
    }

    @Override
    public long getTblUserLoginCount() {
        return super.getEntityCount();
    }

    @Override
    public List<TblUserLogin> findByCountTblUserLogin(int firstResult, int maxResult, Object... values) throws Exception {
        return super.findByCountEntity(firstResult, maxResult, values);
    }
     
    @Override
    public void saveUpdateAllTblUserLogin(List<TblUserLogin> TblUserLogin){
        super.updateAll(TblUserLogin);
    }
}
