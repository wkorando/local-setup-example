package com.bk.commodities;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.apache.catalina.util.ParameterMap;

import groovy.lang.Tuple;

/**
 * Extension of PreparedStatement that captures the parameters being passed into
 * it so that they can be printed out later if needed (i.e. an exception occurs
 * during statement execution).
 * 
 * @author williamkorando
 *
 */
public class ParameterAwarePreparedStatement implements PreparedStatement {
	private final PreparedStatement preparedStatement;
	private Map<Integer, Object> parameterMap = new ParameterMap<>();

	public ParameterAwarePreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	@Override
	public void addBatch() throws SQLException {
		preparedStatement.addBatch();
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		preparedStatement.addBatch(sql);
	}

	@Override
	public void cancel() throws SQLException {
		preparedStatement.cancel();
	}

	@Override
	public void clearBatch() throws SQLException {
		preparedStatement.clearBatch();
	}

	@Override
	public void clearParameters() throws SQLException {
		preparedStatement.clearParameters();
	}

	@Override
	public void clearWarnings() throws SQLException {
		preparedStatement.clearWarnings();
	}

	@Override
	public void close() throws SQLException {
		preparedStatement.close();
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		preparedStatement.closeOnCompletion();
	}

	@Override
	public boolean execute() throws SQLException {
		return preparedStatement.execute();
	}

	@Override
	public boolean execute(String sql) throws SQLException {
		return preparedStatement.execute(sql);
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		return preparedStatement.execute(sql, autoGeneratedKeys);
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return preparedStatement.execute(sql, columnIndexes);
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException {
		return preparedStatement.execute(sql, columnNames);
	}

	@Override
	public int[] executeBatch() throws SQLException {
		return preparedStatement.executeBatch();
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		return preparedStatement.executeQuery();
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		return preparedStatement.executeQuery(sql);
	}

	@Override
	public int executeUpdate() throws SQLException {
		return preparedStatement.executeUpdate();
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		return preparedStatement.executeUpdate(sql);
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		return preparedStatement.executeUpdate(sql, autoGeneratedKeys);
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		return preparedStatement.executeUpdate(sql, columnIndexes);
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		return preparedStatement.executeUpdate(sql, columnNames);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return preparedStatement.getConnection();
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return preparedStatement.getFetchDirection();
	}

	@Override
	public int getFetchSize() throws SQLException {
		return preparedStatement.getFetchSize();
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return preparedStatement.getGeneratedKeys();
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return preparedStatement.getMaxFieldSize();
	}

	@Override
	public int getMaxRows() throws SQLException {
		return preparedStatement.getMaxRows();
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return preparedStatement.getMetaData();
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		return preparedStatement.getMoreResults();
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		return preparedStatement.getMoreResults(current);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return preparedStatement.getParameterMetaData();
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return preparedStatement.getQueryTimeout();
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return preparedStatement.getResultSet();
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return preparedStatement.getResultSetConcurrency();
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return preparedStatement.getResultSetHoldability();
	}

	@Override
	public int getResultSetType() throws SQLException {
		return preparedStatement.getResultSetType();
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return preparedStatement.getUpdateCount();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return preparedStatement.getWarnings();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return preparedStatement.isClosed();
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return preparedStatement.isCloseOnCompletion();
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return preparedStatement.isPoolable();
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return preparedStatement.isWrapperFor(iface);
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setArray(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setAsciiStream(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "InputStream: ", x, "length: ", length }));
		preparedStatement.setAsciiStream(parameterIndex, x);
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "InputStream: ", x, "length: ", length }));
		preparedStatement.setAsciiStream(parameterIndex, x, length);
	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setBigDecimal(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setBinaryStream(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "InputStream: ", x, "length: ", length }));
		preparedStatement.setBinaryStream(parameterIndex, x);
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "InputStream: ", x, "length: ", length }));
		preparedStatement.setBinaryStream(parameterIndex, x, length);
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setBlob(parameterIndex, x);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		parameterMap.put(parameterIndex, inputStream);
		preparedStatement.setBlob(parameterIndex, inputStream);
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "InputStream: ", inputStream, "length: ", length }));
		preparedStatement.setBlob(parameterIndex, inputStream, length);
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setBoolean(parameterIndex, x);
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setByte(parameterIndex, x);
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setBytes(parameterIndex, x);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		parameterMap.put(parameterIndex, reader);
		preparedStatement.setCharacterStream(parameterIndex, reader);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Reader: ", reader, "length: ", length }));
		preparedStatement.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Reader: ", reader, "length: ", length }));
		preparedStatement.setCharacterStream(parameterIndex, reader, length);
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setClob(parameterIndex, x);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		parameterMap.put(parameterIndex, reader);
		preparedStatement.setClob(parameterIndex, reader);
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Reader: ", reader, "length: ", length }));
		preparedStatement.setClob(parameterIndex, reader, length);
	}

	@Override
	public void setCursorName(String name) throws SQLException {
		preparedStatement.setCursorName(name);
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setDate(parameterIndex, x);
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		preparedStatement.setDate(parameterIndex, x, cal);
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setDouble(parameterIndex, x);
	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		preparedStatement.setEscapeProcessing(enable);
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		preparedStatement.setFetchDirection(direction);
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		preparedStatement.setFetchSize(rows);
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setFloat(parameterIndex, x);
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setInt(parameterIndex, x);
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setLong(parameterIndex, x);
	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		preparedStatement.setMaxFieldSize(max);
	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		preparedStatement.setMaxRows(max);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		parameterMap.put(parameterIndex, value);
		preparedStatement.setNCharacterStream(parameterIndex, value);
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Reader: ", value, "length: ", length }));
		preparedStatement.setNCharacterStream(parameterIndex, value, length);
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		parameterMap.put(parameterIndex, value);
		preparedStatement.setNClob(parameterIndex, value);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		parameterMap.put(parameterIndex, reader);
		preparedStatement.setNClob(parameterIndex, reader);
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Reader: ", reader, "length: ", length }));
		preparedStatement.setNClob(parameterIndex, reader, length);
	}

	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		parameterMap.put(parameterIndex, value);
		preparedStatement.setNString(parameterIndex, value);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		parameterMap.put(parameterIndex, sqlType);
		preparedStatement.setNull(parameterIndex, sqlType);
	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "sqlType: ", sqlType, "typeName: ", typeName }));
		preparedStatement.setNull(parameterIndex, sqlType, typeName);
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setObject(parameterIndex, x);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Object: ", x, "targetSqlType: ", targetSqlType }));
		preparedStatement.setObject(parameterIndex, x, targetSqlType);
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(
				new Object[] { "Object: ", x, "targetSqlType: ", targetSqlType, "scaleOrLength: ", scaleOrLength }));
		preparedStatement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		preparedStatement.setPoolable(poolable);
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		preparedStatement.setQueryTimeout(seconds);
	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setRef(parameterIndex, x);
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setRowId(parameterIndex, x);
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setShort(parameterIndex, x);
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		parameterMap.put(parameterIndex, xmlObject);
		preparedStatement.setSQLXML(parameterIndex, xmlObject);
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setString(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setTime(parameterIndex, x);
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Time: ", x, "Calendar: ", cal }));
		preparedStatement.setTime(parameterIndex, x, cal);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setTimestamp(parameterIndex, x);
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "Timestamp: ", x, "Calendar: ", cal }));
		preparedStatement.setTimestamp(parameterIndex, x, cal);
	}

	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		parameterMap.put(parameterIndex, new Tuple(new Object[] { "InputStream: ", x, "length: ", length }));
		preparedStatement.setUnicodeStream(parameterIndex, x, length);
	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		parameterMap.put(parameterIndex, x);
		preparedStatement.setURL(parameterIndex, x);
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return preparedStatement.unwrap(iface);
	}

	public Map<Integer, Object> getParameterMap() {
		return parameterMap;
	}
}