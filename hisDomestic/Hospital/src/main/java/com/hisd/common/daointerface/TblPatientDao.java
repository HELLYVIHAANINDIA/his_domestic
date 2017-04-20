package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblPatient;



public interface TblPatientDao extends GenericDao<TblPatient> {
	public void addTblPatient(TblPatient tblPatient);

    public void deleteTblpatient(TblPatient tblPatient);

    public void updateTblTblpatient(TblPatient tblPatient);

    public List<TblPatient> getAllTblpatient();

    public List<TblPatient> findTblpatient(Object... values) throws Exception;

    public List<TblPatient> findByCountTblpatient(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblpatientCount();

    public void saveUpdateAllTblPatient(List<TblPatient> tblPatient);

}
