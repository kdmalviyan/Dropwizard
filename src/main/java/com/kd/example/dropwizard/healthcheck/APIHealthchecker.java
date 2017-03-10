package com.kd.example.dropwizard.healthcheck;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.health.HealthCheck;

public class APIHealthchecker extends HealthCheck {
	private final Client client;

	public APIHealthchecker() {
		super();
		Client client = ClientBuilder.newClient();
		this.client = client;
	}

	@Override
	protected Result check() throws Exception {
		WebTarget webTarget = client.target("http://localhost:8080/kusers/get/1");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			return Result.healthy();
		}
		return Result.unhealthy("API Failed");
	}
}