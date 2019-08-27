package com.doyle.challenge.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doyle.challenge.restful.employee.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findByShortName(String shortName);
	List<Employee> findByFullName(String fullName);
}

