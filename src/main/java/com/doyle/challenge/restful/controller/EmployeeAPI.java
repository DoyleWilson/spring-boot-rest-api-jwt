package com.doyle.challenge.restful.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doyle.challenge.restful.employee.Employee;
import com.doyle.challenge.restful.exception.EmployeeNotFoundExcepn;
import com.doyle.challenge.restful.repository.EmployeeRepo;

@RestController
public class EmployeeAPI {

	@Autowired
	private EmployeeRepo employeeRepo;

	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeRepo.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee retrieveEmployees(@PathVariable long id) throws EmployeeNotFoundExcepn  {
		Optional<Employee> employee = employeeRepo.findById(id);

		if (!employee.isPresent())
			throw new EmployeeNotFoundExcepn(id);

		return employee.get();
	}
	
	@GetMapping("/employees/shortname/{id}")
	public List<Employee> retrieveEmployeesByShortName(@PathVariable String shortName) throws EmployeeNotFoundExcepn  {
		List<Employee> employee = employeeRepo.findByShortName(shortName);

		if (employee.isEmpty())
			throw new EmployeeNotFoundExcepn(employee.get(0).getId());

		return employee;
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployees(@PathVariable long id) {
		employeeRepo.deleteById(id);
	}

	@PostMapping("/employees")
	public ResponseEntity<Object> createEmployees(@RequestBody Employee employee) {
		Employee savedEmployee = employeeRepo.save(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> updateEmployees(@RequestBody Employee employee, @PathVariable long id) {

		Optional<Employee> employeeOptional = employeeRepo.findById(id);

		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		employee.setId(id);
		
		employeeRepo.save(employee);

		return ResponseEntity.noContent().build();
	}
}