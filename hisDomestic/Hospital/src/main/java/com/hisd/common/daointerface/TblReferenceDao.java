package com.hisd.common.daointerface;

import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblReferenceType;

public interface TblReferenceDao extends GenericDao<TblReferenceType> {
	public void addTblReferenceType(TblReferenceType tblReferenceType);

    public void deleteTblReferenceType(TblReferenceType tblReferenceType);

    public void updateTblReferenceType(TblReferenceType tblReferenceType);

    public List<TblReferenceType> getAllTblReferenceType();

    public List<TblReferenceType> findTblReferenceType(Object... values) throws Exception;

    public List<TblReferenceType> findByCountTblReferenceType(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblReferenceTypeCount();

    public void saveUpdateAllTblReferenceType(List<TblReferenceType> tblReferenceType);

}
