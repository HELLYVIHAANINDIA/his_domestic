package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblConsultingDoctor;;

public interface TblConsultingDoctorDao extends GenericDao<TblConsultingDoctor> {
	public void addTblConsultingDoctor(TblConsultingDoctor tblConsultingDoctor);

	public void deleteTblConsultingDoctor(TblConsultingDoctor tblConsultingDoctor);

	public void updateTblConsultingDoctor(TblConsultingDoctor tblConsultingDoctor);

	public List<TblConsultingDoctor> getAllTblConsultingDoctor();

	public List<TblConsultingDoctor> findTblConsultingDoctor(Object... values)
			throws Exception;

	public List<TblConsultingDoctor> findByCountTblConsultingDoctor(int firstResult,
			int maxResult, Object... values) throws Exception;

	public long getTblConsultingDoctorCount();

	public void saveUpdateAllTblConsultingDoctor(List<TblConsultingDoctor> tblConsultingDoctor);

}
