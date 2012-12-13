package com.keep.framework.dao;

import java.io.Serializable;
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
	E get(K key);
	
	/***
	 * ͨ������������Ӧʵ�����
	 * @param key	����
	 * @return 		ʵ�����
	 */
	E load(K key);
	
	/***
	 * @return	����ʵ�����
	 */
	List<E> loadAll(); 
	
	/***
	 * �޸�һ��ʵ�����
	 * @param entity �޸�ʵ��
	 * @throws Throwable �쳣
	 */
	void delete(E entity) throws Throwable;
	
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
	 * @param hql 		ʹ��hql,��ѯ����
	 * @return
	 */
	List<E> find(String hql);
	
	/***
	 * @param hql 		ʹ��hql,��ѯ����
	 * @param params	hql������
	 * @return
	 */
	List<E> find(String hql, Object... params);
	
	 /***
     * @param queryName 	ʹ��������hql�����в�ѯ 
     * @return 				ʵ�����list 
     */  
    List<E> findByNamedQuery(String queryName);  
  
    /***
     * @param queryName 	ʹ��������hql�����в�ѯ 
     * @param params  		hql������
     * @return 				ʵ�����list
     */  
    List<E> findByNamedQuery(String queryName, Object... params); 
    
    /** 
     *  
     * @param hql 			ʹ��hql�������ɾ�������
     * @return 				��Ӱ���еļ�¼�� 
     */  
    Integer bulkUpdate(String hql);  
  
    /** 
     *  
     * @param hql 			ʹ��hql�������ɾ������� 
     * @param params 		hql������ 
     * @return 				��Ӱ���еļ�¼�� 
     */  
    Integer bulkUpdate(String hql, Object... params);
    
    /***
     * ִ��һ��sql,�紴���� �����ɾ����
     * @param sql
     */
    void executeSql(String sql);
}
