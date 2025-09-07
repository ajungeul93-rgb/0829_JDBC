package com.kh.employee.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.vo.Employee;

public class EmployeeService {

	private final EmployeeDao employeeDao;

	public EmployeeService() {
		this.employeeDao = new EmployeeDao();
	}

	public List<Employee> findAll() {
		Connection conn = getConnection();
		List<Employee> emp = employeeDao.findAll(conn);
		close(conn);
		return emp;
	}

	public List<Employee> findByDept(String deptTitle) {
		Connection conn = getConnection();
		List<Employee> emp = employeeDao.findByDept(conn, deptTitle);
		close(conn);
		return emp;
	}

	public List<Employee> findByJob(String jobName) {
		Connection conn = getConnection();
		List<Employee> emp = employeeDao.findByJob(conn, jobName);
		close(conn);
		return emp;
	}

	public EmployeeDto findByEmployee(String empId) {
		Connection conn = getConnection();
		EmployeeDto ed = employeeDao.findByEmployee(conn, empId);
		close(conn);
		return ed;
	}

	public List<Employee> findTop5Salaries() {
		Connection conn = getConnection();
		List<Employee> emp = employeeDao.findTop5Salaries(conn);
		close(conn);
		return emp;
	}

	public List<Employee> findBottom5Salaries() {
		Connection conn = getConnection();
		List<Employee> emp = employeeDao.findBottom5Salaries(conn);
		close(conn);
		return emp;
	}

	public int insertEmployee(EmployeeDto ed) {
		Connection conn = getConnection();
		int result = employeeDao.insertEmployee(conn, ed);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateEmployee(String empId, int salary, String jobName, String deptTitle) {
		Connection conn = null;
		int result = 0;

		try {
			conn = getConnection();

			String jobCode = employeeDao.getJobCodeByName(conn, jobName);
			String deptCode = employeeDao.getDeptCodeByTitle(conn, deptTitle);

			if (jobCode == null) {
				throw new IllegalArgumentException("존재하지 않는 직급명입니다.");
			}

			if (deptCode == null) {
				throw new IllegalArgumentException("존재하지 않는 부서명입니다.");
			}

			result = employeeDao.updateEmployee(conn, empId, salary, jobCode, deptCode);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}

		} catch (Exception e) {
			if (conn != null) { // conn이 null이 아닐 때만 rollback 실행
				rollback(conn);
			}
			throw e;

		} finally {
			if (conn != null) { // conn이 null이 아닐 때만 close 실행
				close(conn);
			}
		}
		return result;
	}

	public int retireEmployee(EmployeeDto ed) {
		Connection conn = null;
		int result = 0;

		try {
			conn = getConnection();
			result = employeeDao.retireEmployee(conn, ed);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			if (conn != null) {
				rollback(conn);
			}
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

}
