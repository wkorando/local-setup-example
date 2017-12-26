package com.bk.commodities.model;

public class CommodityHistory {

	private String date;
	private int commodityId;
	private String commodityName;
	private double commodityPrice;
	private long availableUnits;

	public CommodityHistory(String date, int commodityId, String commodityName, double commodityPrice,
			long availableUnits) {
		this.date = date;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.availableUnits = availableUnits;
	}

	public String getDate() {
		return date;
	}

	public int getCommodityId() {
		return commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public double getCommodityPrice() {
		return commodityPrice;
	}

	public long getavailableUnits() {
		return availableUnits;
	}

}
