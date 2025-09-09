package com.kh.employee.controller;

import java.util.List;

import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.service.EmployeeService;
import com.kh.employee.model.vo.Employee;

public class EmployeeController {

	private final EmployeeService employeeService = new EmployeeService();

	public List<Employee> findAll() {

		return employeeService.findAll();

	}

	public List<Employee> findByDept(String deptTitle) {

		return employeeService.findByDept(deptTitle);

	}

	public List<Employee> findByJob(String jobName) {

		return employeeService.findByJob(jobName);
	}

	public EmployeeDto findByEmployee(String empId) {

		return employeeService.findByEmployee(empId);

	}

	public List<Employee> findTop5Salaries() {

		return employeeService.findTop5Salaries();

	}

	public List<Employee> findBottom5Salaries() {

		return employeeService.findBottom5Salaries();

	}

	public int insertEmployee(String empId, String empName, String empNo, String email, String phone, String deptTitle,
			String jobName, String salLevel, int salary, double bonus, String managerId, String entYn) {

		EmployeeDto ed = new EmployeeDto(empId, empName, empNo, email, phone, deptTitle, jobName, salLevel, salary,
				bonus, managerId, null, entYn);

		return employeeService.insertEmployee(ed);

	}

	public int updateEmployee(String empId, int salary, String jobName, String deptTitle) {

		try {
			return employeeService.updateEmployee(empId, salary, jobName, deptTitle);
		} catch (Exception e) {
			System.err.println("사원 정보 수정 중 오류가 발생했습니다. ");
			e.printStackTrace();
			return 0;
		}
	}

	public int retireEmployee(String empId, String entYn) {

		try {
			EmployeeDto ed = new EmployeeDto();
			ed.setEmpId(empId);
			ed.setEntYn(entYn);

			return employeeService.retireEmployee(ed);
		} catch (Exception e) {
			System.err.println("사원 퇴사 처리 중 오류가 발생했습니다.");
			e.printStackTrace();
			return 0;
		}

	}
}
