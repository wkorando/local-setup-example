package com.bk.commodities.repo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bk.commodities.SqlRunner;
import com.bk.commodities.SqlRunnerProc;
import com.bk.commodities.model.Commodity;

public class CommoditiesCustomRepo {
	private SqlRunnerProc sqlRunnerProc;

	@SuppressWarnings("unchecked")
	public List<Commodity> aComplexQuery(double maximumCommodityPrice, double minimumCommodityPrice,
			long minimumAvaliableUnits) {
		return (List<Commodity>) sqlRunnerProc.executeSqlRunnerLookup(new SqlRunner<List<Commodity>>() {
			@Override
			public String sqlStatement() {
				return "Select * From Commodities WHERE commodity_price < ? AND commodity_price > ? AND avaliable_units > ?";
			}

			@Override
			public List<Commodity> resultMapper(ResultSet resultSet) throws SQLException {
				List<Commodity> commodities = new ArrayList<>();
				while (resultSet.next()) {
					Commodity commodity = new Commodity(resultSet.getLong("id"), //
							resultSet.getString("commodity_name"), //
							resultSet.getDouble("commodity_price"), //
							resultSet.getLong("available_units"));
					commodities.add(commodity);
				}
				return commodities;
			}

			@Override
			public PreparedStatement updateStatement(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setDouble(1, maximumCommodityPrice);
				preparedStatement.setDouble(2, minimumCommodityPrice);
				preparedStatement.setLong(3, minimumAvaliableUnits);
				return preparedStatement;
			}
		});
	}
}
