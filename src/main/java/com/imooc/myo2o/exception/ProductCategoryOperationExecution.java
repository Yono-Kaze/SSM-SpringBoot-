package com.imooc.myo2o.exception;

public class ProductCategoryOperationExecution extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ProductCategoryOperationExecution(String msg) {
		super(msg);
	}
}
