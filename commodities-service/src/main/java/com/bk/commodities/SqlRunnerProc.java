package com.bk.commodities;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import groovy.lang.Tuple;

public class SqlRunnerProc {
	Logger logger = LoggerFactory.getLogger(SqlRunnerProc.class);
	Connection connection;

	Object executeSqlRunner(SqlRunner<?> sqlRunner) {
		ParameterAwarePreparedStatement parameterAwarePreparedStatement = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlRunner.sqlStatement());
			parameterAwarePreparedStatement = new ParameterAwarePreparedStatement(preparedStatement);
			sqlRunner.updateStatement(parameterAwarePreparedStatement);
			return sqlRunner.resultMapper(parameterAwarePreparedStatement.executeQuery());
		} catch (SQLException e) {
			logger.error("An error occurred while executing sql statement.");
			logger.error("Message returned: " + e.getMessage());
			logger.error("Error code returned: " + e.getErrorCode());
			logger.error("SQL state returned: " + e.getSQLState());
			logger.error("Query ran: " + sqlRunner.sqlStatement());
			printParameters(parameterAwarePreparedStatement);
			logger.error("Stacktrace: ", e);
			throw new SqlRunnerException();
		} catch (Exception e) {
			throw new SqlRunnerException();
		}
	}

	private void printParameters(ParameterAwarePreparedStatement preparedStatement) {
		logger.error("Parameters used in query: ");
		try {
			ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
			Map<Integer, Object> parameterMap = preparedStatement.getParameterMap();
			for (int i = 1; i <= parameterMetaData.getParameterCount(); i++) {
				try {
					StringBuilder builder = new StringBuilder("\t");
					builder.append("Parameter type:");
					builder.append(parameterMetaData.getParameterTypeName(i));
					Object parameterValue = parameterMap.get(i);
					if (parameterValue instanceof Tuple) {
						Tuple tuple = (Tuple) parameterValue;
						builder.append("\n\tParameter has complex value:");
						for (Object obj : tuple) {
							builder.append("\n\t\t");
							builder.append(obj.toString());
						}
					} else {
						builder.append("\n\tParameter value:");
						builder.append(parameterValue.toString());
					}
					logger.error(builder.toString());
				} catch (Exception e) {
					logger.error("An error occurred while attempting to print out a parameter value.", e);
				}
			}
		} catch (Exception e) {
			logger.error("An error occurred while attempting to print out a parameters.", e);
		}
	}
}
