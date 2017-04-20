package com.hisd.common.daointerface;
import java.util.List;

import com.hisd.common.daogeneric.GenericDao;
import com.hisd.domestic.model.TblUser;

public interface TblUserDao extends GenericDao<TblUser>  {
	public void addTblUser(TblUser TblUser);

    public void deleteTblUser(TblUser TblUser);

    public void updateTblUser(TblUser TblUser);

    public List<TblUser> getAllTblUser();

    public List<TblUser> findTblUser(Object... values) throws Exception;

    public List<TblUser> findByCountTblUser(int firstResult,int maxResult,Object... values) throws Exception;

    public long getTblUserCount();

    public void saveUpdateAllTblUser(List<TblUser> TblUser);

}
