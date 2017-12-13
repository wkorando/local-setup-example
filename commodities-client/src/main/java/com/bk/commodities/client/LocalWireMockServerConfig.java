package com.bk.commodities.client;

import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
@EnableStubRunnerServer
public class LocalWireMockServerConfig {
}
