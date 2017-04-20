package com.hisd.common.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.hisd.common.daogeneric.Operation_enum;

@Repository
public class CommonDAO extends HibernateTemplate{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonDAO.class);
	
	@Autowired 	 
	SessionFactory sessionFactory;
	@Autowired
	ExceptionHandlerService exceptionHandlerService; 
	
	
	@Autowired
	public CommonDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
	}
	
	public Serializable save(Object object){
		LOGGER.debug("save instance");
		
		Session session = null;
		Transaction transaction = null;
		Serializable serializable = null;
		LocalSessionManager manager = new LocalSessionManager();
		
		try {
			session = manager.getSession(sessionFactory);
			
			transaction = session.beginTransaction();
			serializable = session.save(object);
			
			session.flush();
			transaction.commit();
			
			LOGGER.debug("save successful");
			
		} catch (Exception re) {
			if(transaction != null) {
				transaction.rollback();
			}
			exceptionHandlerService.writeLog(re);
			LOGGER.error("save failed", re);
		} finally{
			manager.closeSession(session);			
		}
		
		return serializable;
	}
	
	public void update(Object object){
		LOGGER.debug("update instance");
		
		Session session = null;
		Transaction transaction = null;
		LocalSessionManager manager = new LocalSessionManager();
		
		try {
			session = manager.getSession(sessionFactory);
			
			transaction = session.beginTransaction();
			
			session.update(object);
			session.flush();
			
			transaction.commit();
			
			LOGGER.debug("update successful");
			
		} catch (Exception re) {
			if(transaction != null) {
				transaction.rollback();
			}
			exceptionHandlerService.writeLog(re);
			LOGGER.error("update failed", re);
		} finally{
			manager.closeSession(session);
		}
	}
	
	public void saveOrUpdate(Object object){
		LOGGER.debug("save or update instance");

		Session session = null;
		Transaction transaction = null;
		LocalSessionManager manager = new LocalSessionManager();
		
		try {
			session = manager.getSession(sessionFactory);
			
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(object);
			session.flush();
			
			transaction.commit();
			
			LOGGER.debug("save or update successful");
			
		} catch (Exception re) {
			if(transaction != null) {
				transaction.rollback();
			}
			exceptionHandlerService.writeLog(re);
			LOGGER.error("save or update failed", re);
			
			
			
		} finally{
			manager.closeSession(session);
		}
	}
	
	public <T> void saveOrUpdateAll(Collection<T> objects) {
		LOGGER.debug("save or update all instance");

		Session session = null;
		Transaction transaction = null;
		LocalSessionManager manager = new LocalSessionManager();
		
		try {
			session = manager.getSession(sessionFactory);
			
			transaction = session.beginTransaction();
			
			for (Object bean : objects) {
				session.saveOrUpdate(bean);
			}
			
			session.flush();
			
			transaction.commit();
			
			LOGGER.debug("save or update all successful");
			
		} catch (Exception re) {
			if(transaction != null) {
				transaction.rollback();
			}
			exceptionHandlerService.writeLog(re);
			LOGGER.error("save or update all failed", re);
			
			
			
		} finally{
			manager.closeSession(session);
		}
	}
	
	public void delete(Object object){
		LOGGER.debug("delete instance");

		Session session = null;
		Transaction transaction = null;
		LocalSessionManager manager = new LocalSessionManager();
		
		try {
			session = manager.getSession(sessionFactory);
			
			transaction = session.beginTransaction();
			
			session.delete(object);
			session.flush();
			
			transaction.commit();
			
			LOGGER.debug("delete successful");
			
		} catch (Exception re) {
			if(transaction != null) {
				transaction.rollback();
			}
			exceptionHandlerService.writeLog(re);
			LOGGER.error("delete failed", re);
			
			
			
		} finally{
			manager.closeSession(session);
		}
	}
	
	public <T> void deleteALL(Collection<T> objects) {
		LOGGER.debug("delete instance");
		
		Session session = null;
		Transaction transaction = null;
		LocalSessionManager manager = new LocalSessionManager();
		
		try {
			session = manager.getSession(sessionFactory);
			
			transaction = session.beginTransaction();
			
			for (Object bean : objects) {
				session.delete(bean);
			}
			
			session.flush();
			
			transaction.commit();
			
			
		} catch (Exception re) {
			if(transaction != null) {
				transaction.rollback();
			}
			exceptionHandlerService.writeLog(re);
			LOGGER.error("delete failed", re);
		} finally{
			manager.closeSession(session);
		}
	}

	/* Generic search method 
     * Example : 
    *    Map<String, Object> map = new HashMap<String, Object>(); 
		 map.put("hpiCaseTemplateId", 18l);
		 map.put("templateId", 13);
		 map.put("appointment.appointmentId", 165016l);
		 String columnNames[] = {"templateType","templateName"};
		 List<HPICaseTemplateTable> dataTables =  commonDAO.getListByRistrictions(HPICaseTemplateTable.class,map,columnNames,null);
    */
    
	public <T> List<T> getListByRistrictions(Class<T> c, Map<String, Object> map, String[] columnNames, Map<String, Object> others ) {
        LOGGER.debug("getListByRistrictions by class :"+c);
        
        Session session = null;
        Criteria criteria = null;
        List<T> list = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
        	session = manager.getSession(sessionFactory);
            
        	criteria = session.createCriteria(c);
            
        	if (map != null) {
                 criteria.add(Restrictions.allEq(map));
            }
            
            if(others != null){
            	if(others.containsKey("page")){
                    criteria.setFirstResult(Integer.parseInt(others.get("page").toString()));
                    criteria.setMaxResults(10);
                }
                
                if(others.containsKey("maxResults")){
                    criteria.setMaxResults(Integer.parseInt(others.get("maxResults").toString()));
                }
                
                if(others.containsKey("orderBy")) {
                	String orderBy = others.get("orderBy").toString();
                    
                	if(orderBy.contains(" desc")){
                        criteria.addOrder(Order.desc(orderBy.replace(" desc", "")));
                        
                    } else if(orderBy.contains(" asc")){
                        criteria.addOrder(Order.asc(orderBy.replace(" asc", "")));
                    }
                }
            }
            
            if(columnNames != null && columnNames.length > 0){
            	criteria.setProjection(getProjectionList(columnNames));
            	criteria.setResultTransformer(Transformers.aliasToBean(c));
            }
            
            list = criteria.list();
            //criteria.setCacheable(true);
            
            LOGGER.debug("getListByRistrictions");

        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);
            LOGGER.error("getListByRistrictions", e);
        } finally{
			manager.closeSession(session);
		}

        return list;
    }
    
	public ProjectionList getProjectionList(String[] columnNames) {
		ProjectionList projectionList = Projections.projectionList();
    	
		for (String column : columnNames) {
             projectionList.add(Projections.property(column), column);
        }

        return projectionList;
	}
/**
 * 
 * @author branpariya
 * @param sqlQuery
 * @param column
 * @return
 * column.put("alias",TblTender.class); or 
 * column.put("alias","map");
 */
	public <T> List<T> executeSqlSelect(String query, Map<String, Object> column) {
		List<T> list = null;
		Session session = null;
		LocalSessionManager manager = new LocalSessionManager();

		try {
			session = manager.getSession(sessionFactory);
			
			Query queryObj = session.createSQLQuery(query);
			
			setQueryParameter(queryObj, column);
			
			list = queryObj.list();
			
		} catch (Exception e) {
			exceptionHandlerService.writeLog(e);
			LOGGER.error("executeSqlSelect", e);
		}finally{
			manager.closeSession(session);
		}
		
		return list;
	}
/**
 * 
 * @author branpariya
 * @param sqlQuery
 * @param column
 * @return
 * column.put("alias",TblTender.class); or 
 * column.put("alias","map");
 * 
 */
	public <T> List<T> executeSelect(String query, Map<String, Object> column) {
		List<T> list = null;
		Session session = null;
		LocalSessionManager manager = new LocalSessionManager();

		try {
			session = manager.getSession(sessionFactory);
			
			Query queryObj = session.createQuery(query);
			
			setQueryParameter(queryObj, column);
			
			list = queryObj.list();
			
		} catch (Exception e) {
			exceptionHandlerService.writeLog(e);
			LOGGER.error("executeSelect", e);
		}finally{
			manager.closeSession(session);
		}

		return list;
	}
	
/**
 * 
 * @author branpariya
 * @param query
 * @param column
 * @return
 * column.put("alias",TblTender.class); or 
 * column.put("alias","map");
 * 
 */
	public Integer executeUpdate(String query, Map<String, Object> column) {
		Integer result = null;
		Session session = null;
		LocalSessionManager manager = new LocalSessionManager(); 

		try {
			session = manager.getSession(sessionFactory);
		
			Query queryObj = session.createQuery(query);
			
			setQueryUpdateParameter(queryObj, column);
			
			result = queryObj.executeUpdate();
			
		} catch (Exception e) {
			exceptionHandlerService.writeLog(e);
			LOGGER.error("executeSelect", e);
		}finally{
			manager.closeSession(session);
		}

		return result;
	}
		
/**
 * 
 * @author branpariya
 * @param query
 * @param column
 * @return
 * column.put("alias",TblTender.class); or 
 * column.put("alias","map");
 *  
 */
	public Integer executeSqlUpdate(String query, Map<String, Object> column) {
		Integer result = null;
		Session session = null;
		LocalSessionManager manager = new LocalSessionManager();

		try {
			session = manager.getSession(sessionFactory);
			
			Query queryObj = session.createSQLQuery(query);
			
			setQueryUpdateParameter(queryObj, column);
			
			result = queryObj.executeUpdate();
		
		} catch (Exception e) {
			exceptionHandlerService.writeLog(e);
			LOGGER.error("executeSqlUpdate", e);
		}finally{
			manager.closeSession(session);
		}
		
		return result;
	}
	/**
	 * column.put("alias",TblTender.class); or 
	 * column.put("alias","map");
	 * if you wish map as return object then pass alias and map, if you want bean as return then pass class name.
	 * if you want limited results then pass firstIndex and maxResult in this map, both this object must be Integer
	 * map.put("firstIndex", 0); map.put("maxResult", 10);
	 * @author branpariya
	 * @param query
	 * @param column
	 * @return
	 * column.put("alias",TblTender.class); or 
	 * 
	 */
	public void setQueryParameter(Query query, Map<String, Object> column) {
		if (column != null && !column.isEmpty()) {
			if (column.containsKey("alias")) {
				if (column.get("alias").equals("map")) {
					query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				
				} else {
					query.setResultTransformer(Transformers.aliasToBean((Class) column.get("alias")));
				}
			
				column.remove("alias");
			}

			if(column.containsKey("firstIndex")){
				query.setFirstResult((Integer)column.get("firstIndex"));
				
				column.remove("firstIndex");
			}
			
			if(column.containsKey("maxResult")){
				query.setMaxResults((Integer)column.get("maxResult"));
				
				column.remove("maxResult");
			}
			
			for (Map.Entry<String, Object> entity : column.entrySet()) {
				if(entity.getValue() instanceof Collection){
					query.setParameterList(entity.getKey(), (Collection) entity.getValue());
				}else{
					query.setParameter(entity.getKey(), entity.getValue());
				}
			}
		}
	}
	/**
	 * 
	 * @author branpariya
	 * @param query
	 * @param column
	 * @return
	 */
	public void setQueryUpdateParameter(Query query, Map<String, Object> column) {
		if (column != null && !column.isEmpty()) {
			for (Map.Entry<String, Object> entity : column.entrySet()) {
				if(entity.getValue() instanceof Collection){
					query.setParameterList(entity.getKey(),(Collection) entity.getValue());
				}else{
					query.setParameter(entity.getKey(), entity.getValue());
				}
			}
		}
	}
	 
	 public int executeCommonSP(String spName, String...param) {
         int updatedCount=0;
         LOGGER.debug("executeCommonSP spName="+spName+" param="+Arrays.toString(param));
           Session session = null;
           LocalSessionManager manager = new LocalSessionManager();

           try {
                session = manager.getSession(sessionFactory);
                StringBuilder queryStr = new StringBuilder("EXEC ");
                queryStr.append(spName + " ");
                StringBuilder paramBuilder = new StringBuilder();
                if(param!=null){
                     for(String p:param){
                    	 if(paramBuilder.length()>0){
                    		 paramBuilder.append(", ");
                    	 }
                    	 paramBuilder.append("'" + p + "'");
                     }
                     queryStr.append(paramBuilder.toString());
                }
                
                SQLQuery query = session.createSQLQuery(queryStr.toString());
                updatedCount = query.executeUpdate();
                
             }catch (Exception e) {
            	 exceptionHandlerService.writeLog(e);
             LOGGER.error("executeCommonSP", e);
             
             }finally{
                manager.closeSession(session);
             }
           return updatedCount;
     }


public <T> List<T> findEntity(Class classObj,Object... values) throws Exception {

    LocalSessionManager manager = new LocalSessionManager();
    Session session = manager.getSession(sessionFactory);
    Criteria criteria = null;
    List<T> lst = null;
    criteria = session.createCriteria(classObj);
    int len = values.length % 3;
    //boolean ordered = false;

    if (len != 0) {
        throw new Exception(
                "Arguments Must be triplet of [field, expression(e.g. eq,lt,gt...), value]");
    }

    len = values.length / 3;

    for (int i = 0, j = 0; i < len; i++, j += 3) {

        Operation_enum operation = (Operation_enum) values[j + 1];

        switch (operation) {
            case EQ:
            	criteria.add(Restrictions.eq(values[j].toString(),
                        values[j + 2]));
                break;
            case GE:
            	criteria.add(Restrictions.ge(values[j].toString(),
                        values[j + 2]));
                break;
            case GT:
            	criteria.add(Restrictions.gt(values[j].toString(),
                        values[j + 2]));
                break;
            case LE:
            	criteria.add(Restrictions.le(values[j].toString(),
                        values[j + 2]));
                break;
            case LT:
            	criteria.add(Restrictions.lt(values[j].toString(),
                        values[j + 2]));
                break;
            case NE:
            	criteria.add(Restrictions.ne(values[j].toString(),
                        values[j + 2]));
                break;
            case LIKE:
            	criteria.add(Restrictions.ilike(values[j].toString(),
                        values[j + 2]));
                break;
            case OR:
            	criteria
                        .add(Restrictions.or(Restrictions.ilike(
                        values[j].toString(), values[j + 2]),
                        Restrictions.ilike(values[j + 3].toString(),
                        values[j + 5])));
                j = j + 3;
                i++;
                break;
            case IN:
            	criteria.add(Restrictions.in(values[j].toString(),
                        (Object[]) values[j + 2]));
                break;
            case ORDERBY:
                //ordered = true;
                Operation_enum order = (Operation_enum) values[j + 2];
                if (order == Operation_enum.ASC) {
                	criteria.addOrder(Order.asc(values[j].toString()));
                } else if (order == Operation_enum.DESC) {
                	criteria.addOrder(Order.desc(values[j].toString()));
                } else {
                    throw new Exception(
                            "Order by can be ASC or DESC only. use Enum for to specify this.");
                }
                break;
            default:

        }
    }
    lst = criteria.list();
    return lst;
}


public <T> void evictAll(Collection<T> objects) {
	LOGGER.debug("delete instance");
	
	Session session = null;
	Transaction transaction = null;
	LocalSessionManager manager = new LocalSessionManager();
	try {
		session = manager.getSession(sessionFactory);
		transaction = session.beginTransaction();
		for (Object bean : objects) {
			session.evict(bean);
		}
		session.flush();
		transaction.commit();
	} catch (Exception re) {
		if(transaction != null) {
			transaction.rollback();
		}
		exceptionHandlerService.writeLog(re);
		LOGGER.error("delete failed", re);
	} finally{
		manager.closeSession(session);
	}
}	

}



class LocalSessionManager{
	private boolean isNew = false;
	
	public Session getSession(SessionFactory sessionFactory){
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			if(session == null || session.isOpen()){
				session = sessionFactory.openSession();
			} 
			
		}catch(Exception e){
			isNew = true;
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public void closeSession(Session session){
		if(isNew){
			SessionFactoryUtils.closeSession(session);
		}
	}
}