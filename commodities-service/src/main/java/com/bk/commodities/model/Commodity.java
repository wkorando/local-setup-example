package com.bk.commodities.model;

public class Commodity {
	private long id;
	private String commodityName;
	private double commodityPrice;
	private long avaliableUnits;

	public Commodity(long id, String commodityName, double commodityPrice, long avaliableUnits) {
		this.id = id;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.avaliableUnits = avaliableUnits;
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

	public long getAvaliableUnits() {
		return avaliableUnits;
	}

}
