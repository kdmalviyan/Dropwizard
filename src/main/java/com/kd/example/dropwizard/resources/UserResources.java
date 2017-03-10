package com.kd.example.dropwizard.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kd.example.dropwizard.external.UserService;
import com.kd.example.dropwizard.external.UserServiceImpl;
import com.kd.example.dropwizard.models.KUser;

@Path("/kusers")
public class UserResources {
	private UserService userService = new UserServiceImpl();

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") long id) {
		KUser kUser = userService.getUserById(id);
		if (kUser == null)
			return Response.status(Response.Status.NOT_FOUND).entity("User not found with provided id.").build();
		return Response.status(Response.Status.OK).entity(userService.getUserById(id)).build();
	}

	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(KUser kUser) {
		userService.createUser(kUser);
		return Response.status(Response.Status.OK).entity(userService.getUserByUsername(kUser.getUsername())).build();
	}

}
