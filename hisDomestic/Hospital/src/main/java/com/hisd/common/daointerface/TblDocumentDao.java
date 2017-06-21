package com.hisd.common.daointerface;


import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblDocument;
public interface TblDocumentDao extends GenericDao<TblDocument>{
	 public void addTblDocument(TblDocument tblDocument);

	    public void deleteTblDocument(TblDocument tblDocument);

	    public void updateTblDocument(TblDocument tblDocument);

	    public List<TblDocument> getAllTblDocument();

	    public List<TblDocument> findTblDocument(Object... values) throws Exception;

	    public List<TblDocument> findByCountTblDocument(int firstResult,int maxResult,Object... values) throws Exception;

	    public long getTblDocumentCount();

	    public void saveUpdateAllTblDocument(List<TblDocument> tblDocument);

}
