package com.hisd.common.daogeneric;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.hisd.common.services.ExceptionHandlerService;

public abstract class HibernateAbstractClass<EntityType> extends HibernateDaoSupport
        implements GenericDao<EntityType> {

    private Class<EntityType> persistentClass;
    
    @Autowired
    ExceptionHandlerService exceptionHandlerService;

    public Class<EntityType> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<EntityType> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public HibernateAbstractClass() {
        super();
        this.persistentClass = (Class<EntityType>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void addEntity(EntityType entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void deleteEntity(EntityType entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void deleteAll(Collection entity) {
        getHibernateTemplate().deleteAll(entity);
    }

    @Override
    public void updateEntity(EntityType entity) {
        getHibernateTemplate().update(entity);
    }
    
    @Override
    public void updateEntityBySession(EntityType entity) {
        currentSession().update(entity);
    }

    @Override
    public void saveOrUpdateEntity(EntityType entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void saveAll(Collection<EntityType> collection) {
        for(Object entity : collection){
        	getHibernateTemplate().update(entity);
        }
    }
    
    @Override
    public void updateAll(Collection<EntityType> collection) {
        for(Object entity : collection){
        	getHibernateTemplate().save(entity);
        }
    }

    @Override
    public List<EntityType> getAllEntity() {

        List<EntityType> lst = null;
        lst = getHibernateTemplate().loadAll(getPersistentClass());
        return lst;
    }

    @Override
    public List<EntityType> findEntity(Object... values) throws Exception {

        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(persistentClass);
        List<EntityType> lst = new ArrayList<EntityType>();

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
                    detachedCriteria.add(Restrictions.eq(values[j].toString(),
                            values[j + 2]));
                    break;
                case GE:
                    detachedCriteria.add(Restrictions.ge(values[j].toString(),
                            values[j + 2]));
                    break;
                case GT:
                    detachedCriteria.add(Restrictions.gt(values[j].toString(),
                            values[j + 2]));
                    break;
                case LE:
                    detachedCriteria.add(Restrictions.le(values[j].toString(),
                            values[j + 2]));
                    break;
                case LT:
                    detachedCriteria.add(Restrictions.lt(values[j].toString(),
                            values[j + 2]));
                    break;
                case NE:
                    detachedCriteria.add(Restrictions.ne(values[j].toString(),
                            values[j + 2]));
                    break;
                case LIKE:
                    detachedCriteria.add(Restrictions.ilike(values[j].toString(),
                            values[j + 2]));
                    break;
                case OR:
                    detachedCriteria
                            .add(Restrictions.or(Restrictions.ilike(
                            values[j].toString(), values[j + 2]),
                            Restrictions.ilike(values[j + 3].toString(),
                            values[j + 5])));
                    j = j + 3;
                    i++;
                    break;
                case IN:
                    detachedCriteria.add(Restrictions.in(values[j].toString(),
                            (Object[]) values[j + 2]));
                    break;
                case ORDERBY:
                    //ordered = true;
                    Operation_enum order = (Operation_enum) values[j + 2];
                    if (order == Operation_enum.ASC) {
                        detachedCriteria.addOrder(Order.asc(values[j].toString()));
                    } else if (order == Operation_enum.DESC) {
                        detachedCriteria.addOrder(Order.desc(values[j].toString()));
                    } else {
                        throw new Exception(
                                "Order by can be ASC or DESC only. use Enum for to specify this.");
                    }
                    break;
                default:

            }
        }
        lst = (List<EntityType>) hibernateTemplate.findByCriteria(detachedCriteria);
        return lst;
    }

    @Override
    public List<EntityType> findByCountEntity(int firstResult, int maxResult,
            Object... values) throws Exception {

        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria detachedCriteria = DetachedCriteria
                .forClass(persistentClass);
        List<EntityType> lst = new ArrayList<EntityType>();
        int len = values.length % 3;
        boolean ordered = false;

        if (len != 0) {
            throw new Exception(
                    "Arguments Must be triplet of [field, expression(e.g. eq,lt,gt...), value]");
        }

        len = values.length / 3;

        for (int i = 0, j = 0; i < len; i++, j += 3) {

            Operation_enum operation = (Operation_enum) values[j + 1];

            switch (operation) {
                case EQ:
                    detachedCriteria.add(Restrictions.eq(values[j].toString(),
                            values[j + 2]));
                    break;
                case GE:
                    detachedCriteria.add(Restrictions.ge(values[j].toString(),
                            values[j + 2]));
                    break;
                case GT:
                    detachedCriteria.add(Restrictions.gt(values[j].toString(),
                            values[j + 2]));
                    break;
                case LE:
                    detachedCriteria.add(Restrictions.le(values[j].toString(),
                            values[j + 2]));
                    break;
                case LT:
                    detachedCriteria.add(Restrictions.lt(values[j].toString(),
                            values[j + 2]));
                    break;
                case NE:
                    detachedCriteria.add(Restrictions.ne(values[j].toString(),
                            values[j + 2]));
                    break;
                case LIKE:
                    detachedCriteria.add(Restrictions.ilike(values[j].toString(),
                            values[j + 2]));
                    break;
                case OR:
                    detachedCriteria
                            .add(Restrictions.or(Restrictions.ilike(
                            values[j].toString(), values[j + 2]),
                            Restrictions.ilike(values[j + 3].toString(),
                            values[j + 5])));
                    j = j + 3;
                    i++;
                    break;
                case IN:
                    detachedCriteria.add(Restrictions.in(values[j].toString(),
                            (Object[]) values[j + 2]));
                    break;
                case ORDERBY:
                    ordered = true;
                    Operation_enum order = (Operation_enum) values[j + 2];
                    if (order == Operation_enum.ASC) {
                        detachedCriteria.addOrder(Order.asc(values[j].toString()));
                    } else if (order == Operation_enum.DESC) {
                        detachedCriteria.addOrder(Order.desc(values[j].toString()));
                    } else {
                        throw new Exception(
                                "Order by can be ASC or DESC only. use Enum for to specify this.");
                    }

                    break;
            }
        }

        if (!ordered && !persistentClass.getSimpleName().startsWith("Vw")) {
            String firstFieldNameFull = persistentClass.getDeclaredFields()[0]
                    .toString();
            int intlastdot = firstFieldNameFull.lastIndexOf('.');
            String firstFieldName = firstFieldNameFull
                    .substring(intlastdot + 1);

            detachedCriteria.addOrder(Order.asc(firstFieldName));
        }
        lst = (List<EntityType>) hibernateTemplate.findByCriteria(detachedCriteria, firstResult,
                maxResult);
        return lst;
    }

    /*
     * Below is to create Projection Ex. count, rowcount, max, min etc See
     * Projection.Ctrl+Space
     */
    @Override
    public long getEntityCount() {
        long count = 0;
        Criteria c = currentSession().createCriteria(persistentClass)
                .setProjection(Projections.rowCount());
        count = (Long) c.list().get(0);
        return count;
    }

    @Override
    public List<Object[]> createQuery(String query, Map<String, Object> var) {
        Query q = null;
        q = currentSession().createQuery(query);
        setQueryMap(q, var);
        return q == null ? null : q.list();
    }

    @Override
    public List<Object[]> createSQLQuery(String query, Map<String, Object> var) {
        Query q = null;
        q = currentSession().createSQLQuery(query);        
        setQueryMap(q, var);
        return q == null ? null : q.list();
    }
    
    /**
     * Creating SQL query containing nvarchar columns
     * @param query Query to be executed where each column should be (c0,c1...)
     * @param var parameters containing values
     * @param ncharsIndex index(s) of columns which are nvarchar
     * @param colcount total columns count in query
     * @return 
     */
    @Override
    public List<Object[]> createSQLQuery(String query, Map<String, Object> var,int[] ncharsIndex,int colcount) {
        SQLQuery q = null;
        q = currentSession().createSQLQuery(query);
        for (int i=0;i<colcount;i++){
            boolean isNchar = false;
            for (int j : ncharsIndex) {
                if(i==j){
                    isNchar = true;
                    break;
                }
            }
            if(isNchar){
                q.addScalar("c"+i,StringType.INSTANCE);
            }else{
                q.addScalar("c"+i);
            }
        }        
        setQueryMap(q, var);
        return q == null ? null : q.list();
    } 

    @Override
    public List<Object[]> createByCountQuery(String query, Map<String, Object> var, int firstResult,
            int maxResult) {
        Query q = null;
        q = currentSession().createQuery(query);
        setQueryMap(q, var);    
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResult);
        return q == null ? null : q.list();
    }

    @Override
    public long countForQuery(String from, String countOn, String where, Map<String, Object> var) {
        Query q = null;
        StringBuilder query = new StringBuilder();
        query.append("select count(").append(countOn).append(") as count from ").append(from).append(" where ").append(where);
        q = currentSession().createQuery(query.toString());
        setQueryMap(q, var);
        return q == null ? 0 : (Long) q.list().get(0);
    }

    @Override
    public List<Object> singleColQuery(String query, Map<String, Object> var) {
        Query q = null;
        q = currentSession().createQuery(query);
        setQueryMap(q, var);
        return q == null ? null : q.list();
    }

    @Override
    public int updateDeleteQuery(String query, Map<String, Object> var) {
        Query q = null;
        q = currentSession().createQuery(query);
        setQueryMap(q, var);
        return q == null ? 0 : q.executeUpdate();
    }

    @Override
    public int updateDeleteSQLQuery(String query, Map<String, Object> var) {
        Query q = null;
        q = currentSession().createSQLQuery(query);
        setQueryMap(q, var);
        return q == null ? 0 : q.executeUpdate();
    }

    @Override
    public List nativeQueryToBean(String query, Class classAlias, Map<String, Object> var) throws DataAccessResourceFailureException, HibernateException, IllegalStateException, ClassNotFoundException {
        Query q = null;
        q = currentSession().createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(classAlias));
        setQueryMap(q, var);
        return q.list();
    }
    
    private void setQueryMap(Query q,Map<String, Object> var){
        if(var!=null){
            Set<String> varnames = var.keySet();
            for (String key : varnames) {
                Object val = var.get(key);
                if (val instanceof String) {
                    q.setString(key, val.toString());
                } else if (val instanceof Integer) {
                    q.setInteger(key, (Integer) val);
                } else if (val instanceof Date) {
                    q.setDate(key, (Date) val);
                }else if (val instanceof Long) {
                    q.setLong(key, (Long) val);
                }else if (val instanceof Object[]) {
                    q.setParameterList(key,(Object[]) val);
                }else if (val instanceof Collection) {
                    q.setParameterList(key,(Collection) val);
                }else if (val instanceof Double) {
                    q.setDouble(key, (Double) val);
                }else if (val instanceof BigDecimal) {
                    q.setBigDecimal(key, (BigDecimal) val);
                }
            }
        }
    }
    
    /**
     * 
     * @author branpariya
     * @param sqlQuery
     * @param column
     * @return
     * column.put("alias",Tender.class); or 
     * column.put("alias","map");
     */
    	public <T> List<T> executeSqlSelect(String query, Map<String, Object> column) {
    		List<T> list = null;
    		try {
    			Query queryObj = currentSession().createSQLQuery(query);
    			setQueryParameter(queryObj, column);
    			
    			list = queryObj.list();
    			
    		} catch (Exception e) {
    			exceptionHandlerService.writeLog(e);
    		}
    	return list;
    	}
    /**
     * 
     * @author branpariya
     * @param sqlQuery
     * @param column
     * @return
     * column.put("alias",Tender.class); or 
     * column.put("alias","map");
     * 
     */
	public <T> List<T> executeSelect(String query, Map<String, Object> column) {
		List<T> list = null;
		Query queryObj = currentSession().createQuery(query);

		setQueryParameter(queryObj, column);

		list = queryObj.list();

		return list;
	}
    	
    /**
     * 
     * @author branpariya
     * @param query
     * @param column
     * @return
     * column.put("alias",Tender.class); or 
     * column.put("alias","map");
     * 
     */
	public Integer executeUpdate(String query, Map<String, Object> column) {
		Integer result = null;
		Query queryObj = currentSession().createQuery(query);

		setQueryUpdateParameter(queryObj, column);

		result = queryObj.executeUpdate();
		return result;
	}
    		
    /**
     * 
     * @author branpariya
     * @param query
     * @param column
     * @return
     * column.put("alias",Tender.class); or 
     * column.put("alias","map");
     *  
     */
	public Integer executeSqlUpdate(String query, Map<String, Object> column) {
		Integer result = null;
		Query queryObj = currentSession().createSQLQuery(query);

		setQueryUpdateParameter(queryObj, column);

		result = queryObj.executeUpdate();

		return result;
	}

    	/**
    	 * column.put("alias",Tender.class); or 
    	 * column.put("alias","map");
    	 * if you wish map as return object then pass alias and map, if you want bean as return then pass class name.
    	 * if you want limited results then pass firstIndex and maxResult in this map, both this object must be Integer
    	 * map.put("firstIndex", 0); map.put("maxResult", 10);
    	 * @author branpariya
    	 * @param query
    	 * @param column
    	 * @return
    	 * column.put("alias",Tender.class); or 
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
    				query.setParameter(entity.getKey(), entity.getValue());
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
    				query.setParameter(entity.getKey(), entity.getValue());
    			}
    		}
    	}


	public <T> List<T> getListByRistrictions(Class<T> c, Map<String, Object> map, String[] columnNames, Map<String, Object> others ) {
        Criteria criteria = null;
        List<T> list = null;
        	criteria = currentSession().createCriteria(c);
            
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

        return list;
    }
    
	public ProjectionList getProjectionList(String[] columnNames) {
		ProjectionList projectionList = Projections.projectionList();
    	
		for (String column : columnNames) {
             projectionList.add(Projections.property(column), column);
        }

        return projectionList;
	}

}