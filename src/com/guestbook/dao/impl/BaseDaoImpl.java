package com.guestbook.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.guestbook.dao.IBaseDao;
import com.guestbook.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	private QueryRunner queryRunner=null;
	public Class<T> type;
	
	public BaseDaoImpl(){
		queryRunner=new QueryRunner();
		type= ReflectionUtils.getSuperGenericType(getClass());
	}
	
	
	@Override
	public void batch(Connection conn, String sql, Object[]... params)
			throws SQLException {
		queryRunner.batch(conn, sql, params);		
	}
 
	@Override
	public <E> E getForValue(Connection conn, String sql, Object... params)
			throws SQLException {
		return queryRunner.query(conn, sql, new ScalarHandler<>(), params);
	}
 
	@Override
	public List<T> getForList(Connection conn, String sql, Object... params)
			throws SQLException {
		return queryRunner.query(conn, sql,
				new BeanListHandler<>(type), params);
	}
 
	@Override
	public T get(Connection conn, String sql, Object... params)
			throws SQLException {
			return queryRunner.query(conn, sql,
					new BeanHandler<>(type), params);
	}
 
	@Override
	public void update(Connection conn, String sql, Object... params)
			throws SQLException {
		queryRunner.update(conn, sql, params);
	}

}
