package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblFinding;

public interface TblFindingDao extends GenericDao<TblFinding> {
	public void addTblFinding(TblFinding tblFinding);

	public void deleteTblFinding(TblFinding tblFinding);

	public void updateTblFinding(TblFinding tblFinding);

	public List<TblFinding> getAllTblFinding();

	public List<TblFinding> findTblFinding(Object... values)
			throws Exception;

	public List<TblFinding> findByCountTblFinding(int firstResult,
			int maxResult, Object... values) throws Exception;

	public long getTblMedicineSeduleCount();

	public void saveUpdateAllTblFinding(List<TblFinding> tblFinding);

}
