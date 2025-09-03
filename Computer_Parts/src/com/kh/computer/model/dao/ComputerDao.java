package com.kh.computer.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.computer.model.dto.ComputerDTO;
import com.kh.computer.model.vo.Computer;

public class ComputerDao {
	
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "BJG12";
	private final String PASSWORD = "BJG121234"; 

	public int addPcPart(Connection conn, Computer computer) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql ="""
				     INSERT
		               INTO
				            TB_PC_PARTS 
				            (
		                    PART_ID
		                  , PART_NAME
		                  , CATEGORY
		                  , PRICE
		                  , MANUFACTURER
		                  , PURCHASEDATE)
		             VALUES
		                    (
		                    SEQ_PART_ID.NEXTVAL
				          , ?
				          , ?
				          , ?   
				          , ?
				          , SYSDATE
				            )
		              """;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, computer.getPartName());
			pstmt.setString(2, computer.getCategory());
			pstmt.setInt(3, computer.getPrice());
			pstmt.setString(4, computer.getManufacturer());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			 e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		} 
		
		return result;
	}
	
	public List<Computer> viewAll(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Computer> parts = new ArrayList();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(
					                      """
					                      SELECT
					                             PART_ID
					                           , PART_NAME
					                           , CATEGORY
					                           , PRICE
					                           , MANUFACTURER
					                           , PURCHASEDATE
					                        FROM
					                             TB_PC_PARTS
					                       ORDER
					                          BY
					                             PURCHASEDATE DESC            
					                      """
					                        ); 
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Computer computer = new Computer();
				
				computer.setPartId(rset.getInt("PART_ID"));
				computer.setPartName(rset.getString("PART_NAME"));
				computer.setCategory(rset.getString("CATEGORY"));
				computer.setPrice(rset.getInt("PRICE"));
				computer.setManufacturer(rset.getString("MANUFACTURER"));
				computer.setPurchaseDate(rset.getDate("PURCHASEDATE"));
				
				parts.add(computer);
			}
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
				rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return parts;
	}
	
	public Computer findCategory(String category) {
		Computer computer = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = """
				        SELECT
				               PART_ID
				             , PART_NAME
				             , CATEGORY
				             , PRICE
				             , MANUFACTURER
				             , PURCHASEDATE
				          FROM
				               TB_PC_PARTS
				         WHERE
				               CATEGORY = ?           
				     """;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				computer = new Computer(rset.getInt("PART_ID")
						               ,rset.getString("PART_NAME")
						               ,rset.getString("CATEGORY")
						               ,rset.getInt("PRICE")
						               ,rset.getString("MANUFACTURER")
						               ,rset.getDate("PURCHASEDATE"));
						
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
				rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} try {
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return computer;
	}

	public List<Computer> findByKeyword(String keyword) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Computer> parts = new ArrayList();
		
		String sql = """
				       SELECT
				              PART_ID
				            , PART_NAME
				            , CATEGORY
				            , PRICE
				            , MANUFACTURER
				            , PURCHASEDATE
				         FROM
				              TB_PC_PARTS
				        WHERE
				              CATEGORY LIKE '%'||?||'%'
				        ORDER
				           BY
				              PURCHASEDATE DESC                  
				      """;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				parts.add(new Computer(rset.getInt("PART_ID")
						              ,rset.getString("PART_NAME")
						              ,rset.getString("CATEGORY")
						              ,rset.getInt("PRICE")
						              ,rset.getString("MANUFACTURER")
						              ,rset.getDate("PURCHASEDATE")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
				rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return parts;
	}

	public int update(ComputerDTO cd) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = """
				  UPDATE
                         PARTS
                     SET
                         MANUFACTURER = ?
                   WHERE
                         CATEGORY = ?
                     AND
                         PART_NAME = ?     
				      """;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cd.getManufacturer());
			pstmt.setString(2, cd.getCategory());
			pstmt.setString(3, cd.getPartName());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 7)
			
			try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null){
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int delete(Computer computer) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = """
				       DELETE
				         FROM
				              TB_PC_PARTS
				        WHERE
				              PART_ID = ?
				          AND
				              PART_NAME = ?          
				""";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, computer.getPartId());
			pstmt.setString(2, computer.getPartName());
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
