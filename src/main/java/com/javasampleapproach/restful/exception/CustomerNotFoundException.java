package com.javasampleapproach.restful.exception;

public class CustomerNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String id){
		
		super(""+id);
	}
}
