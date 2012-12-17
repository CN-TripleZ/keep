package com.keep.framework.dao;

import java.io.Serializable;
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

/**
 * 高级DAO实现类。
 * @author zhangchaozheng
 */
public class AdvanceDaoImpl extends HibernateDaoSupport implements AdvanceDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object get(Class entityClass, Serializable id)
			throws DataAccessException {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object load(Class entityClass, Serializable id)
			throws DataAccessException {
		return this.getHibernateTemplate().load(entityClass, id);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List loadAll(Class entityClass) throws DataAccessException {
		return this.getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public void delete(Object entity) throws DataAccessException {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void deleteAll(Collection entities) throws DataAccessException {
		this.getHibernateTemplate().deleteAll(entities);
	}

	@Override
	public void update(Object entity) throws DataAccessException {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void saveOrUpdateAll(Collection entities) throws DataAccessException {
		this.getHibernateTemplate().saveOrUpdateAll(entities);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List find(String hql) throws DataAccessException {
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List find(String hql, List params) throws DataAccessException {
		return this.getHibernateTemplate().find(hql, params);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String queryName) throws DataAccessException {
		return this.getHibernateTemplate().findByNamedQuery(queryName);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String queryName, List params)
			throws DataAccessException {
		return this.getHibernateTemplate().findByNamedQuery(queryName, params);
	}

	@Override
	public Integer bulkUpdate(String hql) throws DataAccessException {
		return this.getHibernateTemplate().bulkUpdate(hql);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Integer bulkUpdate(String hql, List params)
			throws DataAccessException {
		return this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findByPage(final Class entityClass, final int offset,
			final int pageSize) throws DataAccessException {
		List col = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery("FROM "
								+ entityClass.getName());
						List result = query.setFirstResult(offset)
								.setMaxResults(pageSize).list();
						return result;
					}
				});
		return col;
	}

	@Override
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
