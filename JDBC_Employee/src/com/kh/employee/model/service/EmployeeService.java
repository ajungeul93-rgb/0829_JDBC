package com.kh.employee.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.vo.Employee;

public class EmployeeService {

	private Connection conn = null;

	public EmployeeService() {
		this.conn = getConnection();
	}

	private <T> T executeQuery(Function<Connection, T> daoFunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daoFunction.apply(conn);
		close(conn);
		return result;
	}

	public List<Employee> findAll() {
		return executeQuery(new EmployeeDao()::findAll);
	}

	public List<Employee> findByDept(String deptTitle) {

		List<Employee> emp = new EmployeeDao().findByDept(conn, deptTitle);

		close(conn);

		return emp;
	}

	public List<Employee> findByJob(String jobName) {
		
		List<Employee> emp = new EmployeeDao().findByJob(conn, jobName);

		close(conn);

		return emp;
	}

	public Employee findByEmployee(int empId) {

		Employee employee = new EmployeeDao().findByEmployee(conn, empId);
		
		close(conn);
		
		return employee;
	}

}
