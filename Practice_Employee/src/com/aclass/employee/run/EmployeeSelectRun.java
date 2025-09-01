package com.aclass.employee.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeSelectRun {

	public static void main(String[] args) {


		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; 

		String sql = "SELECT * FROM EMPLOYEE";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000", "BJG12", "BJG121234");
			stmt = conn.createStatement();

			// SQL 실행 후 ResultSet에 결과 저장
			rset = stmt.executeQuery(sql);

			// 결과가 없을 때까지 반복
			while (rset.next()) {
				// 컬럼별로 데이터 가져와서 출력
				System.out.println(rset.getInt("EMP_ID") + " | "
						   + rset.getString("EMP_NAME") + " | "
						   + rset.getString("EMP_NO") + " | "
						   + rset.getString("EMAIL") + " | "
						   + rset.getInt("PHONE") + " | "
						   + rset.getString("DEPT_CODE") + " | "
						   + rset.getString("JOB_CODE") + " | "
						   + rset.getString("SAL_LEVEL") + " | "
						   + rset.getInt("SALARY") + " | "
						   + rset.getDouble("BONUS") + " | "
						   + rset.getInt("MANAGER_ID") + " | "
						   + rset.getDate("HIRE_DATE") + " | "
						   + rset.getDate("ENT_DATE") + " | "
						   + rset.getString("ENT_YN") + " | ");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 역순으로 닫기
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
