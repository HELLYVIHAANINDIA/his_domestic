/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblDesignation;

/**
 *
 */
public interface TblDesignationDao extends GenericDao<TblDesignation> {

    public void addTblDesignation(TblDesignation TblDesignation);

    public void deleteTblDesignation(TblDesignation TblDesignation);

    public void updateTblDesignation(TblDesignation TblDesignation);

    public List<TblDesignation> getAllTblDesignation();

    public List<TblDesignation> findTblDesignation(Object... values) throws Exception;

    public List<TblDesignation> findByCountTblDesignation(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblDesignationCount();

    public void saveUpdateAllTblDesignation(List<TblDesignation> TblDesignation);
}
