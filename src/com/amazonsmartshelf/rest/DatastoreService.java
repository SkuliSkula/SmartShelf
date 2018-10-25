package com.amazonsmartshelf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/datastore")
public class DatastoreService {

	@GET
	@Path("/orders")
	public Response getAllOrders() {
		
		String order = "Here are all the orders you asked for";
		System.out.println("getAllOrders called...");
		return Response.status(200).entity(order).build();
	}
}
