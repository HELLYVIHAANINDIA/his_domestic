package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblPayBy;

public interface TblPaybyDao extends GenericDao<TblPayBy>{
	public void addTblPayBy(TblPayBy tblPayBy);

    public void deleteTblPayBy(TblPayBy tblPayBy);

    public void updateTblPayBy(TblPayBy tblPayBy);

    public List<TblPayBy> getAllTblPayBy();

    public List<TblPayBy> findTblPayByr(Object... values) throws Exception;

    public List<TblPayBy> findByCountTblPayBy(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblPayByCount();

    public void saveUpdateAllTblPayBy(List<TblPayBy> tblPayBy);

}
