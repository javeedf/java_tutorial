package edu.tutorial.exceptions;

public class TestCustomException {
	
	public void testRuntime() {
		throw new MyRuntimeException("My runtime exception");
	}
	
	public void testCheckedException() {
		throw new MyRuntimeException("My runtime exception");
	}
	
	public static void main(String[] args) {
		
	}
}
