/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblUserLogin;

/**
 *
 */
public interface TblUserLoginDao extends GenericDao<TblUserLogin> {

    public void addTblUserLogin(TblUserLogin TblUserLogin);

    public void deleteTblUserLogin(TblUserLogin TblUserLogin);

    public void updateTblUserLogin(TblUserLogin TblUserLogin);

    public List<TblUserLogin> getAllTblUserLogin();

    public List<TblUserLogin> findTblUserLogin(Object... values) throws Exception;

    public List<TblUserLogin> findByCountTblUserLogin(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblUserLoginCount();

    public void saveUpdateAllTblUserLogin(List<TblUserLogin> TblUserLogin);
}
