package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	/**
	 * JDBC Driver를 등록하는 메소드
	 * 프로그램 실행 중 단 한번만 실행되면 됨
	 */
	public static void registDriver() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB의 연결정보를 가지고 있는 Connection 객체를 생성해서 반환해주는 메소드
	 * @return Connection
	 */
	public static Connection getConnection() {
		
		Properties prop = new Properties();
		
		try {
			
			prop.load(new FileInputStream("resources/driver.properties"));
			
			//String keyA = prop.getProperty("A");
			//System.out.println("A 키값의 Value : " + keyA);
			//System.out.println(prop.getProperty("URL"));
			
			Connection conn = DriverManager.getConnection(prop.getProperty("URL"),
					                                      prop.getProperty("USERNAME"),
					                                      prop.getProperty("PASSWORD"));
			conn.setAutoCommit(false);
			
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 트랜잭션 처리 메소드
	
	/**
	 *  Connection 객체를 이용해서 commit 시켜주는 메소드
	 */
	public static void commit(Connection conn) {
		
		try {
			if(conn != null) {
				conn.commit();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Connection 객체를 이용해서 rollback 시켜주는 메소드
	 */
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null) {
				conn.rollback();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// JDBC용 객체를 반납해주는 메소드 (각 개체별로)
	
	/**
	 * Connection 객체를 전달 받아서 반납해주는 메소드
	 */
	public static void close(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Statement 객체를 전달 받아서 반납해주는 메소드
	 * => 다형성을 적용하여 PreparedStatement객체도 Statement 타입으로 받을 수 있음
	 */
	public static void close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ResultSet 객체를 전달 받아서 반납해주는 메소드
	 */
	public static void close(ResultSet rset) {
		try {
			if(rset != null) {
				rset.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
