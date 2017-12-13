package com.bk.commodities;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import com.bk.commodities.controller.CommoditiesController;
import com.bk.commodities.model.Commodity;
import com.bk.commodities.model.CommodityHistory;
import com.bk.commodities.service.CommoditiesService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;


@SpringBootTest (classes = CommoditiesServiceApplication.class)
@RunWith(SpringRunner.class )
@AutoConfigureRestDocs(outputDir = "target/snippets")
@AutoConfigureMessageVerifier
public class BaseClass {
	@Autowired
    private CommoditiesController commoditiesController;

	@MockBean
	private CommoditiesService commoditiesService;
	
    @Before
    public void before() throws Throwable {
        RestAssuredMockMvc.standaloneSetup(this.commoditiesController);
        when(commoditiesService.getCommodities()).thenReturn(Arrays.asList(
				new Commodity(1, "CORN", 2.00, 120210423), //
				new Commodity(2, "WHEAT", 1.30, 230481423), //
				new Commodity(3, "BARLEY", .85, 162210423), //
				new Commodity(4, "SOYBEAN", .77, 104210423), //
				new Commodity(5, "ORANGE", 2.31, 28210423) //
        		));
        
        when(commoditiesService.getCommodityPriceHistory(1)).thenReturn(Arrays.asList(
				new CommodityHistory("11/2017", 1, "CORN", 2.00, 1221423934), //
				new CommodityHistory("10/2017", 1, "CORN", 1.20, 1291423956), //
				new CommodityHistory("09/2017", 1, "CORN", 1.78, 1621423934), //
				new CommodityHistory("08/2017", 1, "CORN", 1.23, 2221427634L), //
				new CommodityHistory("07/2017", 1, "CORN", 1.44, 3221923934L) //
        		));
    }

}