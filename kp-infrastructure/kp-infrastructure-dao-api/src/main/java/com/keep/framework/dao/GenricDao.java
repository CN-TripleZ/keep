package com.keep.framework.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * ͨ�õķ���DAO�ӿڣ��ṩ���ݷ���������ķ���
 * @author zhangchaozheng
 * 	
 */
public interface GenricDao<E extends Serializable, K extends Serializable> {

	/***
	 * ͨ������������Ӧʵ�����
	 * @param key	����
	 * @return 		ʵ�����
	 */
	E get(K key) throws Throwable;
	
	/***
	 * ͨ������������Ӧʵ�����
	 * @param key	����
	 * @return 		ʵ�����
	 */
	E load(K key) throws Throwable;
	
	/***
	 * @return	����ʵ�����
	 */
	List<E> loadAll() throws Throwable; 
	
	/***
	 * ɾ��һ��ʵ�����
	 * @param entity �޸�ʵ��
	 * @throws Throwable �쳣
	 */
	void delete(E entity) throws Throwable;
	
	/***
	 * ����ɾ��ʵ�����
	 * @param entities �޸�ʵ��
	 * @throws Throwable �쳣
	 */
	void deleteAll(Collection<E> entities) throws Throwable;
	
	/***
	 * ����һ��ʵ�����
	 * @param entity ����ʵ��
	 * @throws Throwable �쳣
	 */
	void update(E entity) throws Throwable;
	
	
	/***
	 * ��������ʵ�����ʱ���򱣴�;�������һ��ʵ�����
	 * @param entity ʵ�����
	 * @throws Throwable �쳣
	 */
	void saveOrUpdate(E entity) throws Throwable;
	
	/***
	 * ��������ʵ�����ʱ���򱣴�;�������һ��ʵ�����
	 * @param entity ʵ�����
	 * @throws Throwable �쳣
	 */
	void saveOrUpdateAll(Collection<E> entities) throws Throwable;	
	
	/***
	 * @param hql 		ʹ��hql,��ѯ����
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List find(String hql) throws Throwable;
	
	/***
	 * @param hql 		ʹ��hql,��ѯ����
	 * @param params	hql������
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List find(String hql, List params) throws Throwable;
	
	 /***
     * @param queryName 	ʹ��������hql�����в�ѯ 
     * @return 				ʵ�����list 
     */  
	@SuppressWarnings("rawtypes")
    List findByNamedQuery(String queryName) throws Throwable;  
  
    /***
     * @param queryName 	ʹ��������hql�����в�ѯ 
     * @param params  		hql������
     * @return 				ʵ�����list
     */  
	@SuppressWarnings("rawtypes")
    List findByNamedQuery(String queryName, List params) throws Throwable; 
    
    /** 
     *  
     * @param hql 			ʹ��hql�������ɾ�������
     * @return 				��Ӱ���еļ�¼�� 
     */  
    Integer bulkUpdate(String hql) throws Throwable;  
  
    /** 
     *  
     * @param hql 			ʹ��hql�������ɾ������� 
     * @param params 		hql������ 
     * @return 				��Ӱ���еļ�¼�� 
     */  
    @SuppressWarnings("rawtypes")
    Integer bulkUpdate(String hql, List params) throws Throwable;
    
    /***
     * ִ��һ��sql,�紴���� �����ɾ����
     * @param sql
     */
    void executeSql(String sql) throws Throwable;
    
    /***
     * ����һ��
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
