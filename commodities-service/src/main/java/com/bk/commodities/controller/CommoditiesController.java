package com.bk.commodities.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bk.commodities.model.Commodity;
import com.bk.commodities.model.CommodityHistory;
import com.bk.commodities.service.CommoditiesService;

@RestController("/commodities")
public class CommoditiesController {
	private CommoditiesService service;

	public CommoditiesController(CommoditiesService service) {
		this.service = service;
	}

	@GetMapping
	public List<Commodity> getCommodities() {
		return service.getCommodities();
	}

	@GetMapping("/{commodityId}/historicalPrice")
	public List<CommodityHistory> getHistoricalPrice(@PathVariable("commodityId") Long commodityId) {
		return service.getCommodityPriceHistory(commodityId);
	}
}
