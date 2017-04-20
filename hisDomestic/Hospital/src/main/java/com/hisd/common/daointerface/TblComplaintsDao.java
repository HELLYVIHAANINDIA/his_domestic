package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblComplaints;

public interface TblComplaintsDao extends GenericDao<TblComplaints> {
	public void addTblComplaints(TblComplaints tblComplaints);

	public void deleteTblComplaints(TblComplaints tblComplaints);

	public void updateTblComplaints(TblComplaints tblComplaints);

	public List<TblComplaints> getAllTblComplaints();

	public List<TblComplaints> findTblComplaints(Object... values)
			throws Exception;

	public List<TblComplaints> findByCountTblComplaints(int firstResult,
			int maxResult, Object... values) throws Exception;

	public long getTblComplaintsCount();

	public void saveUpdateAllTblComplaints(List<TblComplaints> tblComplaints);

}
