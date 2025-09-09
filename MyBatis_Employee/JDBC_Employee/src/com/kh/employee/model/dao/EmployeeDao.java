package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.JDBCTemplate;
import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.vo.Employee;

public class EmployeeDao {

	public List<Employee> findAll(SqlSession session) {

		return session.selectList("employeeMapper.findAll");

	}

	public List<Employee> findByDept(SqlSession session, String deptTitle) {

		return session.selectList("employeeMapper.findByDept", deptTitle);
	}

	public List<Employee> findByJob(SqlSession session, String jobName) {

		return session.selectList("employeeMapper.findByJob", jobName);
	}

	public EmployeeDto findByEmployee(SqlSession session, String empId) {

		return session.selectOne("employeeMapper.findByEmployee", empId);
	}

	public List<Employee> findTop5Salaries(SqlSession session) {

		return session.selectList("employeeMapper.findTop5Salaries");

	}

	public List<Employee> findBottom5Salaries(SqlSession session) {

		return session.selectList("employeeMapper.findBottom5Salaries");
	}

	public int insertEmployee(SqlSession session, EmployeeDto ed) {

		return session.insert("employeeMapper.insertEmployee", ed);
	}

	public String getJobCodeByName(SqlSession session, String jobName) {
		// jobName 변수를 그대로 사용해야 합니다.
		return session.selectOne("employeeMapper.getJobCodeByName", jobName);
	}

	public String getDeptCodeByTitle(SqlSession session, String deptTitle) {
		// deptTitle 변수를 그대로 사용해야 합니다.
		return session.selectOne("employeeMapper.getDeptCodeByTitle", deptTitle);
	}

	public int updateEmployee(SqlSession session, Map<String, Object> param) {

		return session.update("employeeMapper.updateEmployee", param);
	}

	public int retireEmployee(SqlSession session, EmployeeDto ed) {

		return session.update("employeeMapper.retireEmployee", ed);
	}

}
