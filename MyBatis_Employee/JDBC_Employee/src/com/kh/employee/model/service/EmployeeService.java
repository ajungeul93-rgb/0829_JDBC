package com.kh.employee.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.vo.Employee;

public class EmployeeService {

	private final EmployeeDao employeeDao = new EmployeeDao();

	public List<Employee> findAll() {

		SqlSession session = Template.getSqlSession();

		List<Employee> emp = employeeDao.findAll(session);

		session.close();

		return emp;
	}

	public List<Employee> findByDept(String deptTitle) {

		SqlSession session = Template.getSqlSession();

		List<Employee> emp = employeeDao.findByDept(session, deptTitle);

		session.close();

		return emp;

	}

	public List<Employee> findByJob(String jobName) {

		SqlSession session = Template.getSqlSession();

		List<Employee> emp = employeeDao.findByJob(session, jobName);

		return emp;
	}

	public EmployeeDto findByEmployee(String empId) {

		SqlSession session = Template.getSqlSession();

		EmployeeDto ed = employeeDao.findByEmployee(session, empId);

		return ed;
	}

	public List<Employee> findTop5Salaries() {

		SqlSession session = Template.getSqlSession();

		List<Employee> emp = employeeDao.findTop5Salaries(session);

		return emp;
	}

	public List<Employee> findBottom5Salaries() {

		SqlSession session = Template.getSqlSession();

		List<Employee> emp = employeeDao.findBottom5Salaries(session);

		return emp;
	}

	public int insertEmployee(EmployeeDto ed) {

		SqlSession session = Template.getSqlSession();

		int result = employeeDao.insertEmployee(session, ed);

		return result;
	}

	public int updateEmployee(String empId, int salary, String jobName, String deptTitle) {

		SqlSession session = Template.getSqlSession();
		int result = 0;

		try {
			String jobCode = employeeDao.getJobCodeByName(session, jobName);
			String deptCode = employeeDao.getDeptCodeByTitle(session, deptTitle);

			Map<String, Object> param = new HashMap<>();
			param.put("empId", empId);
			param.put("salary", salary);
			param.put("jobCode", jobCode);
			param.put("deptId", deptCode);

			result = employeeDao.updateEmployee(session, param);

			if (result > 0) {
				session.commit();
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public int retireEmployee(EmployeeDto ed) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = employeeDao.retireEmployee(session, ed);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
		
	}

}
