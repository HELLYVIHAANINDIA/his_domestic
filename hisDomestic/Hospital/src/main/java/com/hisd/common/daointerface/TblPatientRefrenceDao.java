package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblPatientRefrence;

public interface TblPatientRefrenceDao extends GenericDao<TblPatientRefrence> {
	public void addTblPatientRefrence(TblPatientRefrence tblPatientRefrence);

    public void deleteTblPatientRefrence(TblPatientRefrence tblPatientRefrence);

    public void updateTblPatientRefrence(TblPatientRefrence tblPatientRefrence);

    public List<TblPatientRefrence> getAllTblPatientRefrence();

    public List<TblPatientRefrence> findTblPatientRefrence(Object... values) throws Exception;

    public List<TblPatientRefrence> findByCountTblPatientRefrence(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblPatientRefrenceCount();

    public void saveUpdateAllTblPatientRefrence(List<TblPatientRefrence> tblPatientRefrence);

}
