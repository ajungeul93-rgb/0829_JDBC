package com.kh.employee.controller;

import java.util.List;

import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.service.EmployeeService;
import com.kh.employee.model.vo.Employee;

public class EmployeeController {

	public List<Employee> findAll() {

		List<Employee> emp = new EmployeeService().findAll();

		return emp;
	}

	public List<Employee> findByDept(String deptTitle) {

		List<Employee> emp = new EmployeeService().findByDept(deptTitle);

		return emp;
	}

	public List<Employee> findByJob(String jobName) {
		
		List<Employee> emp = new EmployeeService().findByJob(jobName);

		return emp;
	}

	public Employee findByEmployee(int empId) {
		
		Employee employee = new EmployeeService().findByEmployee(empId);
		
		return employee;
	}

}
