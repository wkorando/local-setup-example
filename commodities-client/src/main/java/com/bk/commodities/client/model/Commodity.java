package com.bk.commodities.client.model;

public class Commodity {
	private long id;
	private String commodityName;
	private double commodityPrice;
	private long availableUnits;


	public void setId(long id) {
		this.id = id;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public void setavailableUnits(long availableUnits) {
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

	public long getavailableUnits() {
		return availableUnits;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", commodityName=" + commodityName + ", commodityPrice=" + commodityPrice
				+ ", availableUnits=" + availableUnits + "]";
	}

}
