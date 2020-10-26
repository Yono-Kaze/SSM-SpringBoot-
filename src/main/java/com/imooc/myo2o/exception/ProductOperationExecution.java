package com.imooc.myo2o.exception;

public class ProductOperationExecution extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ProductOperationExecution(String msg) {
		super(msg);
	}

}
