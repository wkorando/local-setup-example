package com.bk.commodities;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import com.bk.commodities.controller.CommoditiesController;
import com.bk.commodities.model.Commodity;
import com.bk.commodities.model.CommodityHistory;
import com.bk.commodities.service.CommoditiesService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest(classes = CommoditiesServiceApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMessageVerifier
public class BaseClass {
	@Autowired
	private CommoditiesController commoditiesController;

	@MockBean
	private CommoditiesService commoditiesService;

	@Before
	public void before() throws Throwable {
		RestAssuredMockMvc.standaloneSetup(this.commoditiesController);
		when(commoditiesService.getCommodities()).thenReturn(Arrays.asList(new Commodity(1, "CORN", 2.00, 32219239), //
				new Commodity(2, "WHEAT", 1.30, 32219239), //
				new Commodity(3, "BARLEY", .85, 32219239), //
				new Commodity(4, "SOYBEAN", .77, 32219239), //
				new Commodity(5, "ORANGE", 2.31, 32219239), //
				new Commodity(6, "APPLE", 2.31, 32219239)//
		));

		when(commoditiesService.getCommodityPriceHistory(1))
				.thenReturn(Arrays.asList(new CommodityHistory("11/2017", 1, "CORN", 2.00, 32219239), //
						new CommodityHistory("10/2017", 1, "CORN", 1.20, 32219239), //
						new CommodityHistory("09/2017", 1, "CORN", 1.78, 32219239), //
						new CommodityHistory("08/2017", 1, "CORN", 1.23, 32219239), //
						new CommodityHistory("07/2017", 1, "CORN", 1.44, 32219239) //
		));
	}

}