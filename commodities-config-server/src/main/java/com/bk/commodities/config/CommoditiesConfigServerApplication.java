package com.bk.commodities.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CommoditiesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommoditiesConfigServerApplication.class, args);
	}
}
