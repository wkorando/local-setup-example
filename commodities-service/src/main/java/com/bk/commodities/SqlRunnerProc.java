package com.bk.commodities;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import groovy.lang.Tuple;

public class SqlRunnerProc {
	private static final Logger LOGGER = LoggerFactory.getLogger(SqlRunnerProc.class);
	private DataSource dataSource;

	public SqlRunnerProc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Method for executing a SQLRunner query statement.
	 * 
	 * @param sqlRunner
	 * @return throws {@link SqlRunnerException}
	 */
	public Object executeSqlRunnerLookup(SqlRunner<?> sqlRunner) {
		ParameterAwarePreparedStatement parameterAwarePreparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlRunner.sqlStatement());
			parameterAwarePreparedStatement = new ParameterAwarePreparedStatement(preparedStatement);
			sqlRunner.updateStatement(parameterAwarePreparedStatement);
			resultSet = parameterAwarePreparedStatement.executeQuery();
			return sqlRunner.resultMapper(parameterAwarePreparedStatement.executeQuery());
		} catch (SQLException e) {
			LOGGER.error("An error occurred while executing a sql statement.");
			LOGGER.error("Message returned: " + e.getMessage());
			LOGGER.error("Error code returned: " + e.getErrorCode());
			LOGGER.error("SQL state returned: " + e.getSQLState());
			LOGGER.error("Query ran: " + sqlRunner.sqlStatement());
			printParameters(parameterAwarePreparedStatement);
			LOGGER.error("Stacktrace: ", e);
			throw new SqlRunnerException(e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.error("An error occurred while executing a sql statement.");
			LOGGER.error("Message returned: " + e.getMessage());
			LOGGER.error("Query ran: " + sqlRunner.sqlStatement());
			printParameters(parameterAwarePreparedStatement);
			LOGGER.error("Stacktrace: ", e);
			throw new SqlRunnerException(e.getMessage(), e);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (parameterAwarePreparedStatement != null) {
					parameterAwarePreparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error("An error occurred while attempting to close the database connection.");
				throw new SqlRunnerException(e.getMessage(), e);
			}
		}
	}

	private void printParameters(ParameterAwarePreparedStatement preparedStatement) {
		LOGGER.error("Parameters used in query: ");
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
					LOGGER.error(builder.toString());
				} catch (Exception e) {
					LOGGER.error("An error occurred while attempting to print out a parameter value.", e);
				}
			}
		} catch (Exception e) {
			LOGGER.error("An error occurred while attempting to print out a parameters.", e);
		}
	}
}
