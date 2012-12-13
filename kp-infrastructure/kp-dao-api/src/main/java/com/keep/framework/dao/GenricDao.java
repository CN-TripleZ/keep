package com.keep.framework.dao;

import java.io.Serializable;
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
	E get(K key);
	
	/***
	 * 通过主键加载相应实体对象
	 * @param key	主键
	 * @return 		实体对象
	 */
	E load(K key);
	
	/***
	 * @return	所有实体对象
	 */
	List<E> loadAll(); 
	
	/***
	 * 修改一个实体对象
	 * @param entity 修改实体
	 * @throws Throwable 异常
	 */
	void delete(E entity) throws Throwable;
	
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
	 * @param hql 		使用hql,查询数据
	 * @return
	 */
	List<E> find(String hql);
	
	/***
	 * @param hql 		使用hql,查询数据
	 * @param params	hql语句参数
	 * @return
	 */
	List<E> find(String hql, Object... params);
	
	 /***
     * @param queryName 	使用命名的hql语句进行查询 
     * @return 				实体对象list 
     */  
    List<E> findByNamedQuery(String queryName);  
  
    /***
     * @param queryName 	使用命名的hql语句进行查询 
     * @param params  		hql语句参数
     * @return 				实体对象list
     */  
    List<E> findByNamedQuery(String queryName, Object... params); 
    
    /** 
     *  
     * @param hql 			使用hql语句批量删除或更新
     * @return 				受影响行的记录数 
     */  
    Integer bulkUpdate(String hql);  
  
    /** 
     *  
     * @param hql 			使用hql语句批量删除或更新 
     * @param params 		hql语句参数 
     * @return 				受影响行的记录数 
     */  
    Integer bulkUpdate(String hql, Object... params);
    
    /***
     * 执行一段sql,如创建表 、添加删除等
     * @param sql
     */
    void executeSql(String sql);
}
