package com.bk.commodities.client.model;

public class Commodity {
	private long id;
	private String commodityName;
	private double commodityPrice;
	private long avaliableUnits;


	public void setId(long id) {
		this.id = id;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public void setAvaliableUnits(long avaliableUnits) {
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

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", commodityName=" + commodityName + ", commodityPrice=" + commodityPrice
				+ ", avaliableUnits=" + avaliableUnits + "]";
	}

}
