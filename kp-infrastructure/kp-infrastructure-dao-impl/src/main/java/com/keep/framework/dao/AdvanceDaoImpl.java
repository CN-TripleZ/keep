package com.keep.framework.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdvanceDaoImpl<E extends Serializable, K extends Serializable>
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
	public E get(K key) throws DataAccessException {
		return (E) this.getHibernateTemplate().get(this.entityClass, key);
	}

	@SuppressWarnings("unchecked")
	public E load(K key) throws DataAccessException {
		return (E) this.getHibernateTemplate().load(this.entityClass, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> loadAll() throws DataAccessException {
		return (List<E>) this.getHibernateTemplate().loadAll(this.entityClass);
	}

	public void delete(E entity) throws DataAccessException {
		this.getHibernateTemplate().delete(entity);
	}

	public void deleteAll(Collection<E> entities) throws DataAccessException {
		this.getHibernateTemplate().deleteAll(entities);
	}

	public void update(E entity) throws DataAccessException {
		this.getHibernateTemplate().update(entity);
	}

	public void saveOrUpdate(E entity) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<E> entities)
			throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}

	@SuppressWarnings("rawtypes")
	public List find(String hql) throws DataAccessException {
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("rawtypes")
	public List find(String hql, List params)
			throws DataAccessException {
		return this.getHibernateTemplate().find(hql, params);
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String queryName)
			throws DataAccessException {
		return this.getHibernateTemplate().findByNamedQuery(queryName);
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String queryName, List params)
			throws DataAccessException {
		return this.getHibernateTemplate().findByNamedQuery(queryName, params);
	}

	public Integer bulkUpdate(String hql) throws DataAccessException {
		return this.getHibernateTemplate().bulkUpdate(hql);
	}

	@SuppressWarnings("rawtypes")
	public Integer bulkUpdate(String hql, List params)
			throws DataAccessException {
		return this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	@SuppressWarnings("rawtypes")
	public List findByPage(final String hql, final List params,
			final int offset, final int pageSize) throws DataAccessException {
		List col = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						for (int i = 0; i < params.size(); i++) {
							query.setParameter(i, params.get(i));
						}
						List result = query.setFirstResult(offset)
								.setMaxResults(pageSize).list();
						return result;
					}
				});
		return col;
	}

	public void executeSql(String sql) throws DataAccessException {
		this.getJdbcTemplate().execute(sql);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
