package com.bk.commodities.service;

import java.util.List;

import com.bk.commodities.model.Commodity;
import com.bk.commodities.model.CommodityHistory;

public interface CommoditiesService {
	public List<Commodity> getCommodities();
	
	public List<CommodityHistory> getCommodityPriceHistory(long id);

	public Commodity addCommodity(Commodity commodity);
}
