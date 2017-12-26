package com.bk.commodities.model;

public class Commodity {
	private long id;
	private String commodityName;
	private double commodityPrice;
	private long availableUnits;

	public Commodity() {
	}

	public Commodity(long id, String commodityName, double commodityPrice, long availableUnits) {
		this.id = id;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.availableUnits = availableUnits;
	}

	public long getId() {
		return id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public double getCommodityPrice() {
		return commodityPrice;
	}

	public long getAvailableUnits() {
		return availableUnits;
	}

}
