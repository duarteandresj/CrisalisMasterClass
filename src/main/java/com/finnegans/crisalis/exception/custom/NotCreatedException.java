package com.finnegans.crisalis.exception.custom;

public class NotCreatedException extends RuntimeException {
	private static final String DESCRIPTION = "Error in created element (400)";

	public NotCreatedException(String detail) {
		super(DESCRIPTION + ", " + detail);
	}

}
