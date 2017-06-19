package com.hisd.common.daointerface;
import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblMedicine;
public interface TblMedicineDao extends GenericDao<TblMedicine> {
	public void addTblMedicine(TblMedicine tblMedicine);

	public void deleteTblMedicine(TblMedicine tblMedicine);

	public void updateTblMedicine(TblMedicine tblMedicine);

	public List<TblMedicine> getAllTblMedicine();

	public List<TblMedicine> findTblMedicine(Object... values)
			throws Exception;

	public List<TblMedicine> findByCountTblMedicine(int firstResult,
			int maxResult, Object... values) throws Exception;

	public long getTblMedicineCount();

	public void saveUpdateAllTblMedicine(List<TblMedicine> tblMedicine);

}
