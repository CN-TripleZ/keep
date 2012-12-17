package com.keep.framework.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * ͨ�õķ���DAO�ӿڣ��ṩ���ݷ���������ķ���
 * @author zhangchaozheng
 * 	
 */
public interface GenricDao {

	/***
	 * ͨ������������Ӧʵ�����
	 * @param entityClass ʵ�����class
	 * @param id	����
	 * @return 		ʵ�����
	 */
	@SuppressWarnings("rawtypes") 
	Object get(Class entityClass, Serializable id) throws Throwable;
	
	/***
	 * ͨ������������Ӧʵ�����
	 * @param entityClass ʵ�����class
	 * @param id	����
	 * @return 		ʵ�����
	 */
	@SuppressWarnings("rawtypes")
	Object load(Class entityClass, Serializable id) throws Throwable;
	
	/***
	 * @param entityClass ʵ�����class
	 * @return	����ʵ�����
	 */
	@SuppressWarnings("rawtypes") 
	List loadAll(Class entityClass) throws Throwable; 
	
	/***
	 * ɾ��һ��ʵ�����
	 * @param entity �޸�ʵ��
	 * @throws Throwable �쳣
	 */
	void delete(Object entity) throws Throwable;
	
	/***
	 * ����ɾ��ʵ�����
	 * @param entities �޸�ʵ��
	 * @throws Throwable �쳣
	 */
	@SuppressWarnings("rawtypes")
	void deleteAll(Collection entities) throws Throwable;
	
	/***
	 * ����һ��ʵ�����
	 * @param entity ����ʵ��
	 * @throws Throwable �쳣
	 */
	void update(Object entity) throws Throwable;
	
	
	/***
	 * ��������ʵ�����ʱ���򱣴�;�������һ��ʵ�����
	 * @param entity ʵ�����
	 * @throws Throwable �쳣
	 */
	void saveOrUpdate(Object entity) throws Throwable;
	
	/***
	 * ��������ʵ�����ʱ���򱣴�;�������һ��ʵ�����
	 * @param entity ʵ�����
	 * @throws Throwable �쳣
	 */
	@SuppressWarnings("rawtypes")
	void saveOrUpdateAll(Collection entities) throws Throwable;	
	
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
     * ��ҳ���Ҷ���
     * @param hql			ʹ��hql���в�ѯ
     * @param params		hql������ 
     * @param offset		��ʼ��¼
     * @param pageSize		ÿҳ��¼����
     * @return				���󼯺�
     */
    @SuppressWarnings("rawtypes")
	List findByPage(final String hql, final List params,
			final int offset, final int pageSize) throws Throwable;
    
    /***
     * ��ҳ���Ҷ���
     * @param entityClass	ʵ�����class
     * @param offset		��ʼ��¼
     * @param pageSize		ÿҳ��¼����
     * @return				���󼯺�
     */
    @SuppressWarnings("rawtypes")
    List findByPage(Class entityClass, final int offset, final int pageSize) throws Throwable;
}
