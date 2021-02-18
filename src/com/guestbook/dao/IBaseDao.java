package com.guestbook.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDao<T> {

	/**
	 * 批量处理的方法
	 * @param connection
	 * @param sql
	 * @param args: 填充占位符的 Object [] 类型的可变参数.
	 * @throws SQLException 
	 */  
	void batch(Connection conn, String sql, Object [] ... params) throws SQLException;
	/**
	 * 返回具体的一个值, 例如总人数, 平均工资, 某一个人的 email 等.
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	<E> E getForValue(Connection conn,String sql, Object ... params) throws SQLException;
	/**
	 * 返回 T 的一个集合
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	List<T> getForList(Connection conn,String sql,Object ...params)throws SQLException;
 
	/**
	 * 返回一个 T 的对象
	 * @param connection
	 * @param sql
	 * @param args
	 * @return
	 * @throws SQLException 
	 */
	T get(Connection conn,String sql,Object ...params)throws SQLException;
	
	/**
	 * INSRET, UPDATE, DELETE
	 * @param connection: 数据库连接
	 * @param sql: SQL 语句
	 * @param args: 填充占位符的可变参数.
	 * @throws SQLException 
	 * 
	 */
	void update(Connection conn,String sql,Object ...params)throws SQLException;
	
}
