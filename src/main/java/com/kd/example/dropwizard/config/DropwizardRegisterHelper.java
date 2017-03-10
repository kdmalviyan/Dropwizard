package com.kd.example.dropwizard.config;

import com.kd.example.dropwizard.healthcheck.APIHealthchecker;
import com.kd.example.dropwizard.healthcheck.HealthcheckResource;

import io.dropwizard.Configuration;
import io.dropwizard.jersey.DropwizardResourceConfig;
import io.dropwizard.setup.Environment;

public class DropwizardRegisterHelper {
	public static void registerResource(Configuration configuration, Environment environment) {
		DropwizardResourceConfig dropwizardResourceConfig = environment.jersey().getResourceConfig();
		dropwizardResourceConfig.setApplicationName("KUser Service Instance.");
		dropwizardResourceConfig.packages(true, "com.kd.example.dropwizard.resources");
	}

	public static void registerHealthChecker(KUserServiceRestConfiguration configuration, Environment environment) {
		DropwizardResourceConfig dropwizardResourceConfig = environment.jersey().getResourceConfig();
		// Jersey specific for our custom url
		dropwizardResourceConfig.register(new HealthcheckResource(environment.healthChecks()));
		// Dropwizard specific for default health check
		environment.healthChecks().register("APIHealthchecker", new APIHealthchecker());
	}
}
