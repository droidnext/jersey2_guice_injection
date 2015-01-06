package com.example.apps.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.apps.service.SampleService;


@Path("/message")
public class SampleResource {
	
	@Inject
	SampleService service;
	

	Logger log = LoggerFactory.getLogger(SampleResource.class);
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getMessage(@QueryParam(value = "name") String name)
	{
		log.info("name="+name);
		String message = service.getMessage(name);
		return Response.ok(message).build();
	}
}
