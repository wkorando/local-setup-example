package com.bk.commodities;

import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import com.bk.commodities.controller.CommoditiesController;
import com.bk.commodities.service.CommoditiesService;
import com.bk.commodities.service.CommoditiesServiceApplication;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest (classes = CommoditiesServiceApplication.class)
@RunWith(SpringRunner.class )
@AutoConfigureRestDocs(outputDir = "target/snippets")
@AutoConfigureMessageVerifier
public class BaseClass {
	@Autowired
    private CommoditiesController commoditiesController;

	@MockBean
	private CommoditiesService commodities;
	
    @Before
    public void before() throws Throwable {
        RestAssuredMockMvc.standaloneSetup(this.commoditiesController);
    }

}