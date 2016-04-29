package com.example.infrastructure.repository.shared;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.shared.BaseEntity;

@SuppressWarnings("serial")
@Transactional
public abstract class AbstractDAO<T extends BaseEntity> implements Serializable{

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> type;    
    
    public AbstractDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }    
    
    //Criteria Instance
    public Criteria createCriteria(Class persistenceClass){
    	return getSession().createCriteria(persistenceClass);
    }
    
    public Criteria createCriteria(Class persistenceClass, String alias){
    	return getSession().createCriteria(persistenceClass, alias);
    }    
    
    //Criteria Instance
    public Criteria createCriteria(String entityName){
    	return getSession().createCriteria(entityName);
    }
    
    public Criteria createCriteria(String entityName, String alias){
    	return getSession().createCriteria(entityName, alias);
    }    
    
    //Criteria Instance
    public Criteria createCriteria(){
    	return getSession().createCriteria(type);
    }
    
    public List executeCriteria(Criteria criteria){
    	return criteria.list();
    }
    
    public List executeCriteria(Criteria criteria, int firstResult, int maxResult){
    	criteria.setFirstResult(firstResult);
    	criteria.setMaxResults(maxResult);
    	return criteria.list();
    }
    
    public List executeCriteria(Criteria criteria, int limit){
    	criteria.setMaxResults(limit);
    	return criteria.list();
    }    
    
    public BaseEntity executeCriteriaUniqueResult(Criteria criteria){
    	return (BaseEntity) criteria.uniqueResult();
    }  
    
    public Long executeCriteriaCount(Criteria criteria){
    	criteria.setProjection(Projections.rowCount());
    	return (Long) criteria.uniqueResult();
    }    
    
    //Hibernate Query Instance
    public Query createQuery(String queryString){
    	return getSession().createQuery(queryString);
    }  
    
    //Hibernate Native SQL Query Instance
    public Query createSQLQuery(String queryString){
    	return getSession().createSQLQuery(queryString);
    }     
    
    //Hibernate Stored Procedures Instance
    public ProcedureCall createStoredProcedureCall(String procedureName){
    	return getSession().createStoredProcedureCall(procedureName);
    }    
    
    //Hibernate Stored Procedures Instance
    public ProcedureCall createStoredProcedureCall(String procedureName, Class... resultClasses){
    	return getSession().createStoredProcedureCall(procedureName, resultClasses);
    } 
    
    public BaseEntity findById(Class clazz, Long id){
    	return (BaseEntity) getSession().get(clazz, id);
    }
    
    public BaseEntity findById(Long id){
    	return (BaseEntity) getSession().get(type, id);
    }    

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}    
