package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblAppointment;


public interface TblAppointmentDao extends GenericDao<TblAppointment> {
	public void addTblAppointment(TblAppointment tblAppointment);

    public void deleteTblAppointment(TblAppointment tblAppointment);

    public void updateTblAppointment(TblAppointment tblAppointment);

    public List<TblAppointment> getAllTblAppointment();

    public List<TblAppointment> findTblAppointment(Object... values) throws Exception;

    public List<TblAppointment> findByCountTblAppointment(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblAppointmentCount();

    public void saveUpdateAllTblAppointment(List<TblAppointment> tblAppointment);

}
