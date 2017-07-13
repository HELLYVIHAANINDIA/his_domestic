package com.hisd.common.daointerface;
import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblMedicineSchedule;;

public interface TblMedicineScheduleDao extends GenericDao<TblMedicineSchedule> {
	public void addTblMedicineSedule(TblMedicineSchedule tblMedicineSedule);

	public void deleteTblMedicineSedule(TblMedicineSchedule tblMedicineSedule);

	public void updateTblMedicineSedule(TblMedicineSchedule tblMedicineSedule);

	public List<TblMedicineSchedule> getAllTblMedicineSedule();

	public List<TblMedicineSchedule> findTblMedicineSedule(Object... values)
			throws Exception;

	public List<TblMedicineSchedule> findByCountTblMedicineSedule(int firstResult,
			int maxResult, Object... values) throws Exception;

	public long getTblMedicineSeduleCount();

	public void saveUpdateAllTblMedicineSedule(List<TblMedicineSchedule> tblMedicineSedule);

}
