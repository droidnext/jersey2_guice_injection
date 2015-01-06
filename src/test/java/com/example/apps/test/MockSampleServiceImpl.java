package com.example.apps.test;

import com.example.apps.service.SampleService;

public class MockSampleServiceImpl implements SampleService{

	public String getMessage(String name) {
		return "Hello... "+name+" ! - From Mock service";
	}

	
}
