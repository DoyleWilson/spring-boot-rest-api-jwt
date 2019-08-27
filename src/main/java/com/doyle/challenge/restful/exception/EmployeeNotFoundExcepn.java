package com.doyle.challenge.restful.exception;

public class EmployeeNotFoundExcepn extends Exception {
	private long emp_id;

	public EmployeeNotFoundExcepn(long id) {
		super(String.format("Employee is not found with id : '%s'", id));
	}
}
