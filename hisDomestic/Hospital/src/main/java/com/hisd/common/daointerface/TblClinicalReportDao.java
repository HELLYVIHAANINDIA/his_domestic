package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblClinicalReport;


public interface TblClinicalReportDao extends GenericDao<TblClinicalReport> {
	
	public void addTblClinicalReport(TblClinicalReport tblClinicalReport);

	public void deleteTblClinicalReport(TblClinicalReport tblClinicalReport);

	public void updateTblClinicalReport(TblClinicalReport tblClinicalReport);

	public List<TblClinicalReport> getAllTblClinicalReport();

	public List<TblClinicalReport> findTblClinicalReport(Object... values) throws Exception;

	public List<TblClinicalReport> findByCountTblClinicalReport(int firstResult, int maxResult, Object... values) throws Exception;

	public long getTblClinicalReportCount();

	public void saveUpdateAllTblClinicalReport(List<TblClinicalReport> tblClinicalReport);

}
