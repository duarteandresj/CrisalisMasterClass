package com.finnegans.crisalis.exception.custom;

public class UnauthorizedException extends RuntimeException {
	private static final String DESCRIPTION = "Credential invalid (401)";

	public UnauthorizedException(String detail) {
		super(DESCRIPTION + ", " + detail);
	}

}
