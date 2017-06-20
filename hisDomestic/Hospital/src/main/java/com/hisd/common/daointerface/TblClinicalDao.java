package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblClinical;


public interface TblClinicalDao extends GenericDao<TblClinical> {
	public void addTblClinical(TblClinical tblClinical);

	public void deleteTblClinical(TblClinical tblClinical);

	public void updateTblClinical(TblClinical tblClinical);

	public List<TblClinical> getAllTblClinical();

	public List<TblClinical> findTblClinical(Object... values) throws Exception;

	public List<TblClinical> findByCountTblClinical(int firstResult, int maxResult, Object... values) throws Exception;

	public long getTblClinicalCount();

	public void saveUpdateAllTblClinical(List<TblClinical> tblClinical);

}
