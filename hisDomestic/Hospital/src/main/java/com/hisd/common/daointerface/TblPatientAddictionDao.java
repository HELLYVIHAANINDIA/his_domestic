package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblPatientAddiction;

public interface TblPatientAddictionDao extends GenericDao<TblPatientAddiction> {

	public void addTblPatientAddiction(TblPatientAddiction tblPatientAddiction);

	public void deleteTblPatientAddiction(
			TblPatientAddiction tblPatientAddiction);

	public void updateTblPatientAddiction(
			TblPatientAddiction tblPatientAddiction);

	public List<TblPatientAddiction> getAllTblPatientAddiction();

	public List<TblPatientAddiction> findTblPatientAddiction(Object... values)
			throws Exception;

	public List<TblPatientAddiction> findByCountTblPatientAddiction(
			int firstResult, int maxResult, Object... values) throws Exception;

	public long getTblPatientAddictionCount();

	public void saveUpdateAllTblPatientAddiction(
			List<TblPatientAddiction> tblPatientAddiction);

}
