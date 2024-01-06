package com.numetry.evoting.exception;

public class IdNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Invalid Id";
	}

}
