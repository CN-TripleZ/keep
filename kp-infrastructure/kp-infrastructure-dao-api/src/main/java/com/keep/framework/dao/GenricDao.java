package com.keep.framework.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 通用的泛型DAO接口，提供数据访问最基本的方法
 * @author zhangchaozheng
 * 	
 */
public interface GenricDao<E extends Serializable, K extends Serializable> {

	/***
	 * 通过主键查找相应实体对象
	 * @param key	主键
	 * @return 		实体对象
	 */
	E get(K key) throws Throwable;
	
	/***
	 * 通过主键加载相应实体对象
	 * @param key	主键
	 * @return 		实体对象
	 */
	E load(K key) throws Throwable;
	
	/***
	 * @return	所有实体对象
	 */
	List<E> loadAll() throws Throwable; 
	
	/***
	 * 删除一个实体对象
	 * @param entity 修改实体
	 * @throws Throwable 异常
	 */
	void delete(E entity) throws Throwable;
	
	/***
	 * 批量删除实体对象
	 * @param entities 修改实体
	 * @throws Throwable 异常
	 */
	void deleteAll(Collection<E> entities) throws Throwable;
	
	/***
	 * 更新一个实体对象
	 * @param entity 更新实体
	 * @throws Throwable 异常
	 */
	void update(E entity) throws Throwable;
	
	
	/***
	 * 当不存存该实体对象时，则保存;否则更新一个实体对象
	 * @param entity 实体对象
	 * @throws Throwable 异常
	 */
	void saveOrUpdate(E entity) throws Throwable;
	
	/***
	 * 当不存存该实体对象时，则保存;否则更新一个实体对象
	 * @param entity 实体对象
	 * @throws Throwable 异常
	 */
	void saveOrUpdateAll(Collection<E> entities) throws Throwable;	
	
	/***
	 * @param hql 		使用hql,查询数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List find(String hql) throws Throwable;
	
	/***
	 * @param hql 		使用hql,查询数据
	 * @param params	hql语句参数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List find(String hql, List params) throws Throwable;
	
	 /***
     * @param queryName 	使用命名的hql语句进行查询 
     * @return 				实体对象list 
     */  
	@SuppressWarnings("rawtypes")
    List findByNamedQuery(String queryName) throws Throwable;  
  
    /***
     * @param queryName 	使用命名的hql语句进行查询 
     * @param params  		hql语句参数
     * @return 				实体对象list
     */  
	@SuppressWarnings("rawtypes")
    List findByNamedQuery(String queryName, List params) throws Throwable; 
    
    /** 
     *  
     * @param hql 			使用hql语句批量删除或更新
     * @return 				受影响行的记录数 
     */  
    Integer bulkUpdate(String hql) throws Throwable;  
  
    /** 
     *  
     * @param hql 			使用hql语句批量删除或更新 
     * @param params 		hql语句参数 
     * @return 				受影响行的记录数 
     */  
    @SuppressWarnings("rawtypes")
    Integer bulkUpdate(String hql, List params) throws Throwable;
    
    /***
     * 执行一段sql,如创建表 、添加删除等
     * @param sql
     */
    void executeSql(String sql) throws Throwable;
    
    /***
     * 查找一个
     * @param hql
     * @param params
     * @param offset
     * @param pageSize
     * @return
     * @throws Throwable
     */
    @SuppressWarnings("rawtypes")
	List findByPage(final String hql, final List params,
			final int offset, final int pageSize) throws Throwable;
}
