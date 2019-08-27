package com.doyle.challenge.restful.employee;

import java.io.Serializable;

public class Response implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwtAccesstoken;

	public Response(String jwtAccesstoken) {
		this.jwtAccesstoken = jwtAccesstoken;
	}

	public String getToken() {
		return this.jwtAccesstoken;
	}
}
