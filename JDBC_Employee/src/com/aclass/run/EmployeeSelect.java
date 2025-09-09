package com.aclass.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeSelect {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
				     SELECT
                            EMP_ID
                          , EMP_NAME
                          , EMP_NO
                          , EMAIL
                          , PHONE
                          , DEPT_CODE
                          , JOB_CODE
                          , SAL_LEVEL
                          , SALARY
                          , BONUS
                          , MANAGER_ID
                          , HIRE_DATE
                          , ENT_YN
                       FROM 
                            EMPLOYEE
                      ORDER
                         BY
                            HIRE_DATE DESC
				    """;
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE",
					                            "BJG12",
					                            "BJG121234");
			 System.out.println("DB서버 접속 성공!");
			 
			 stmt = conn.createStatement();
			 
			 rset = stmt.executeQuery(sql);
			 
			 while(rset.next()) {
				 int empId = rset.getInt("EMP_ID");
		         String empName = rset.getString("EMP_NAME");
		         String empNo = rset.getString("EMP_NO");
		         String email = rset.getString("EMAIL");
				 
			 }
				 
			 
		} catch(ClassNotFoundException e) {
			System.out.println("ojdbc추가 했나요?");
			System.out.println("oracle.jdbc.driver.OracleDriver 오타없나요?");
		} catch(SQLException e) {
			 e.printStackTrace();
			 System.out.println("jdbc:oracle:thin:@115.90.212.20:10000:XE 오타 없나요?");
			 System.out.println("사용자 계정명 / 비밀번호가 올바른가요?");
			 System.out.println("SQL문 잘 작성했나요?");
		}finally {
			   
			   try{
				   if(rset != null && !rset.isClosed()) {
			            rset.close();
				   }
			   } catch(SQLException e) {
				   e.printStackTrace();
			   }
			   try {
				   if(stmt != null && !stmt.isClosed()) {
			        stmt.close(); 
				   }
			   } catch(SQLException e) {
				   e.printStackTrace();
			   }
			   try {
				   if(conn != null && !conn.isClosed()) {
					   conn.close(); 
				   }
			   } catch(SQLException e) {
				   e.printStackTrace();
			   }
		
		
        
        
	}
	

	}
}
