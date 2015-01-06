package com.example.apps.service;

public class SampleServiceImpl implements SampleService{

	public String getMessage(String name) {
		return "Hello... "+name+" ! - From Real service";
	}
}
