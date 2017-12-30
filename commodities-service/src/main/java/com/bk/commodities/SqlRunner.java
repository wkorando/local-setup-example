package com.bk.commodities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface SqlRunner<T> {
	String sqlStatement();

	T resultMapper(ResultSet resultSet) throws SQLException;

	PreparedStatement updateStatement(PreparedStatement preparedStatement) throws SQLException;
}
