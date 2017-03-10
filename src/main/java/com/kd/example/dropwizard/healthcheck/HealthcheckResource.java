package com.kd.example.dropwizard.healthcheck;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.health.HealthCheckRegistry;

@Produces(MediaType.APPLICATION_JSON)
@Path("/status")
public class HealthcheckResource {
	private HealthCheckRegistry registry;

	public HealthcheckResource(HealthCheckRegistry registry) {
		this.registry = registry;
	}

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity(registry.runHealthChecks().entrySet()).build();
	}
}