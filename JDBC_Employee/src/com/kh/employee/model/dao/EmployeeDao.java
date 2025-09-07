package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.vo.Employee;

public class EmployeeDao {
	
	private Properties prop = new Properties();
	
	public EmployeeDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("resources/employee-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> findAll(Connection conn){
		
		List<Employee> emp = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
						                   ,rset.getString("EMP_NAME")
						                   ,rset.getInt("SALARY")
						                   ,rset.getString("DEPT_TITLE")
						                   ,rset.getString("JOB_NAME"));
				emp.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return emp;
		
	}

	public List<Employee> findByDept(Connection conn, String deptTitle) {
		
		List<Employee> emp = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByDept");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptTitle);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
		                                        ,rset.getString("EMP_NAME")
		                                        ,rset.getInt("SALARY")
		                                        ,rset.getString("DEPT_TITLE")
		                                        ,rset.getString("JOB_NAME"));
				emp.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return emp;
	}

	public List<Employee> findByJob(Connection conn, String jobName) {
		
		List<Employee> emp = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findByJob");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobName);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee(rset.getInt("EMP_ID")
		                                        ,rset.getString("EMP_NAME")
		                                        ,rset.getInt("SALARY")
		                                        ,rset.getString("DEPT_TITLE")
		                                        ,rset.getString("JOB_NAME"));
				emp.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return emp;
	}

	public Employee findByEmployee(Connection conn, int empId) {
		
		EmployeeDto ed = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findByEmployee");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			ed = new EmployeeDto(rset.getInt("EMP_ID"),
					             rset.getString("EMP_NAME"),
					             rset.getInt("EMP_NO"),
					             rset.getString("EMAIL"),
					             rset.getString("PHONE"),
					             rset.getString("DEPT_TITLE"),
					             rset.getString("JOB_NAME"),
					             rset.getString("SAL_LEVEL"),
					             rset.getInt("SALARY"),
					             rset.getDouble("BONUS"),
					             rset.getInt("MANAGER_ID"),
					             rset.getDate("HIRE_DATE"),
					             rset.getString("ENT_YN"));
			}		
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return ed;
	}

}
