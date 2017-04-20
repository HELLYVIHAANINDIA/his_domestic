package com.hisd.common.services;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

	public void simpleMethod() {
		System.out.println("Inside simpleMethod");
	}

	public Object methodReturnsValue() {
		System.out.println("Inside methodReturnsValue");
		return new String("Hello from methodReturnsValue");
	}

	public void methodThrowsException() {
		System.out.println("Inside methodThrowsException");
		throw new RuntimeException("Exception from methodThrowsException");
	}

	public Object testAroundReturningResult() {
		System.out.println("Inside testAroundReturningResult");
		return new String("Hello from aroundReturningResult");
	}

	public void testAroundThrowingException() throws Exception {
		System.out.println("Inside testAroundThrowingException");
		throw new RuntimeException("Exception from testAroundThrowingException");
	}
}
