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

	public List<Employee> findAll(Connection conn) {

		List<Employee> emp = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("findAll");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID"),
						                         rset.getString("EMP_NAME"),
						                         rset.getInt("SALARY"),
						                         rset.getString("DEPT_TITLE"),
						                         rset.getString("JOB_NAME"));
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

			while (rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID"),
						                         rset.getString("EMP_NAME"),
						                         rset.getInt("SALARY"),
						                         rset.getString("DEPT_TITLE"),
						                         rset.getString("JOB_NAME"));
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

			while (rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID"),
						                         rset.getString("EMP_NAME"),
						                         rset.getInt("SALARY"),
						                         rset.getString("DEPT_TITLE"),
						                         rset.getString("JOB_NAME"));
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

	public EmployeeDto findByEmployee(Connection conn, String empId) {

		EmployeeDto ed = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findByEmployee");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				ed = new EmployeeDto(rset.getString("EMP_ID"),
						             rset.getString("EMP_NAME"),
						             rset.getString("EMP_NO"),
						             rset.getString("EMAIL"),
						             rset.getString("PHONE"),
						             rset.getString("DEPT_TITLE"),
						             rset.getString("JOB_NAME"),
						             rset.getString("SAL_LEVEL"),
						             rset.getInt("SALARY"),
						             rset.getDouble("BONUS"),
						             rset.getString("MANAGER_ID"),
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

	public List<Employee> findTop5Salaries(Connection conn) {

		List<Employee> emp = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("findTop5Salaries");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID"), 
						                         rset.getString("EMP_NAME"),
						                         rset.getInt("SALARY"), 
						                         rset.getString("DEPT_TITLE"), 
						                         rset.getString("JOB_NAME"));
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

	public List<Employee> findBottom5Salaries(Connection conn) {
		
		List<Employee> emp = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("findBottom5Salaries");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Employee employee = new Employee(rset.getString("EMP_ID"), 
						                         rset.getString("EMP_NAME"),
						                         rset.getInt("SALARY"), 
						                         rset.getString("DEPT_TITLE"), 
						                         rset.getString("JOB_NAME"));
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

	public int insertEmployee(Connection conn, EmployeeDto ed) {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertEmployee");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ed.getEmpId());
			pstmt.setString(2, ed.getEmpName());
			pstmt.setString(3, ed.getEmpNo());
			pstmt.setString(4, ed.getEmail());
			pstmt.setString(5, ed.getPhone());
			pstmt.setString(6, ed.getDeptTitle());
			pstmt.setString(7, ed.getJobName());
			pstmt.setString(8, ed.getSalLevel());
			pstmt.setInt(9, ed.getSalary());
			pstmt.setDouble(10, ed.getBonus());
			pstmt.setString(11, ed.getManagerId());
			pstmt.setString(12, ed.getEntYn());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	 public String getJobCodeByName(Connection conn, String jobName) {
	        String jobCode = null;
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        
	        // XML에 정의된 쿼리문을 사용한다면 다른 방식으로 구현
	        String sql = prop.getProperty("getJobCodeByName");
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, jobName);
	            rset = pstmt.executeQuery();
	            
	            if (rset.next()) {
	                jobCode = rset.getString("JOB_CODE");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // 실제 서비스에서는 로깅으로 대체
	        } finally {
	        	JDBCTemplate.close(rset);
	        	JDBCTemplate.close(pstmt);
	        }
	        return jobCode;
	    }
	    
	    public String getDeptCodeByTitle(Connection conn, String deptTitle) {
	        String deptCode = null;
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        
	        // XML에 정의된 쿼리문을 사용한다면 다른 방식으로 구현
	        String sql = prop.getProperty("getDeptCodeByTitle");
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, deptTitle);
	            rset = pstmt.executeQuery();
	            
	            if (rset.next()) {
	                deptCode = rset.getString("DEPT_ID");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCTemplate.close(rset);
	        	JDBCTemplate.close(pstmt);
	        }
	        return deptCode;
	    }

	    public int updateEmployee(Connection conn, String empId, int salary, String jobCode, String deptCode) {
	        int result = 0;
	        PreparedStatement pstmt = null;
	        
	        // XML에 정의된 쿼리문을 사용한다면 다른 방식으로 구현
	        String sql = prop.getProperty("updateEmployee");
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, salary);
	            pstmt.setString(2, jobCode);
	            pstmt.setString(3, deptCode);
	            pstmt.setString(4, empId);
	            
	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCTemplate.close(pstmt);
	        }
	        return result;
	    }

		public int retireEmployee(Connection conn, EmployeeDto ed) {

			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("retireEmployee");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ed.getEntYn());
				pstmt.setString(2, ed.getEntYn());
		        pstmt.setString(3, ed.getEmpId());
		        
		        result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}

}
