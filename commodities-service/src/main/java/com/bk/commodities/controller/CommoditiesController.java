package com.bk.commodities.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.commodities.model.Commodity;
import com.bk.commodities.model.CommodityHistory;
import com.bk.commodities.service.CommoditiesService;

@RestController
@RequestMapping("/commodities")
public class CommoditiesController {
	private CommoditiesService service;

	public CommoditiesController(CommoditiesService service) {
		this.service = service;
	}

	@GetMapping
	public List<Commodity> getCommodities() {
		return service.getCommodities();
	}

	@GetMapping("/{id}/historicalPrice")
	public List<CommodityHistory> getHistoricalPrice(@PathVariable("id") Long commodityId) {
		return service.getCommodityPriceHistory(commodityId);
	}
	
	@PostMapping
	public Commodity addCommodity(@RequestBody Commodity commodity) {
		return service.addCommodity(commodity);
	}
}
