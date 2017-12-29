package com.bk.commodities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface SqlRunner<T> {
	String sqlStatement();
	T resultMapper(ResultSet resultSet);
	PreparedStatement updateStatement(PreparedStatement preparedStatement);
}
