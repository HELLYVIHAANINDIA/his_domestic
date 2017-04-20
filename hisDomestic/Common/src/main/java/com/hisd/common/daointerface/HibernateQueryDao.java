package com.hisd.common.daointerface;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;

import com.hisd.common.daogeneric.GenericDao;

public interface HibernateQueryDao extends GenericDao<Object> {
     List<Object[]> createNewQuery(String query,Map<String,Object> var);
     
     List<Object[]> createByCountNewQuery(String query,Map<String,Object> var,int firstResult,int maxResult);

     public long countForNewQuery(String from,String countOn, String where,Map<String,Object> var) throws Exception;

     List<Object> getSingleColQuery(String query,Map<String,Object> var);

     int updateDeleteNewQuery(String query,Map<String,Object> var);

     int updateDeleteSQLNewQuery(String query,Map<String,Object> var);

     List<Object[]> nativeSQLQuery(String query, Map<String, Object> var);
     
     public List nativeNewQueryToBean(String query, Class classAlias, Map<String, Object> var) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ClassNotFoundException;
}
