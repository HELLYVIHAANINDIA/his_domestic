package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblReports;

public interface TblReportDao extends GenericDao<TblReports> {
	
	public void addTblReports(TblReports tblReports);

	public void deleteTblReports(TblReports tblReports);

	public void updateTblReports(TblReports tblReports);

	public List<TblReports> getAllTblReports();

	public List<TblReports> findTblReports(Object... values)
			throws Exception;

	public List<TblReports> findByCountTblReports(int firstResult,
			int maxResult, Object... values) throws Exception;

	public long getTblReportsCount();

	public void saveUpdateAllTblReports(List<TblReports> tblReports);

}
