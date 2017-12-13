package com.bk.commodities.client.model;

public class CommodityHistory {

	private String date;
	private int commodityId;
	private String commodityName;
	private double commodityPrice;
	private long avaliableUnits;

	public CommodityHistory(String date, int commodityId, String commodityName, double commodityPrice,
			long avaliableUnits) {
		this.date = date;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.avaliableUnits = avaliableUnits;
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

	public long getAvaliableUnits() {
		return avaliableUnits;
	}

}
