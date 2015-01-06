package com.example.apps.config;


import com.example.apps.service.SampleService;
import com.example.apps.service.SampleServiceImpl;
import com.google.inject.AbstractModule;

public class SampleModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(SampleService.class).to(SampleServiceImpl.class);
	}

}
