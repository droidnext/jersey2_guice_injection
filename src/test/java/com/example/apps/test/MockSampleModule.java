package com.example.apps.test;

import com.example.apps.service.SampleService;
import com.google.inject.AbstractModule;

public class MockSampleModule  extends AbstractModule{

	@Override
	protected void configure() {
			bind(SampleService.class).to(MockSampleServiceImpl.class);
	}
	
	

}
