package com.keep.framework.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.keep.framework.dao.AdvanceDao;

public abstract class AdvanceDaoImpl<E extends Serializable, K extends Serializable>
		extends HibernateDaoSupport implements AdvanceDao<E, K> {
	
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 为E对应的实例类型
	 */
	private Class<?> entityClass;

	/**
	 * 获取E实例类的类型
	 */
	public AdvanceDaoImpl() {
		Class<?> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			this.entityClass = (Class<?>) ((ParameterizedType) t)
					.getActualTypeArguments()[0];
		}
	}

	@SuppressWarnings("unchecked")
	public E get(K key) {
		return (E) this.getHibernateTemplate().get(this.entityClass, key);
	}
	
	@SuppressWarnings("unchecked")
	public E load(K key) {
		return (E) this.getHibernateTemplate().load(this.entityClass, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> loadAll() {
		return (List<E>) this.getHibernateTemplate().loadAll(this.entityClass);
	}

	@SuppressWarnings("unchecked")
	public void delete(E entity) throws Throwable {
		this.getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public void update(E entity) throws Throwable {
		this.getHibernateTemplate().update(entity);
	}

	@SuppressWarnings("unchecked")
	public void saveOrUpdate(E entity) throws Throwable {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public List<E> find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<E> find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql, params);
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String queryName) {
		return this.getHibernateTemplate().findByNamedQuery(queryName);
	}

	@SuppressWarnings("unchecked")
	public List<E> findByNamedQuery(String queryName, Object... params) {
		return this.getHibernateTemplate().findByNamedQuery(queryName, params);
	}

	@SuppressWarnings("unchecked")
	public Integer bulkUpdate(String hql) {
		return this.getHibernateTemplate().bulkUpdate(hql);
	}

	@SuppressWarnings("unchecked")
	public Integer bulkUpdate(String hql, Object... params) {
		return this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	@SuppressWarnings("unchecked")
	public void executeSql(String sql) {
		this.getJdbcTemplate().execute(sql);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
