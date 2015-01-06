package com.example.apps.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class TestSampleResource extends JerseyTest
{
	@Override
	protected Application configure() {
		return new MockMyApplication();
	}

	@Test
	public void messageTest()
	{
		final Response response = target().path("/message")
				.queryParam("name","Karthik" )
				.request()
				.get();
		assertNotNull(response);
		
		String message = (String)response.readEntity(String.class);
		assertNotNull(message);
        assertEquals(response.getStatus(), 200);
	}
}
