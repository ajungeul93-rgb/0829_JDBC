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
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		} 
		
		return result;
	}
	
	public List<Computer> viewAll(Connection conn){
		
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
				 		ORDER
				      	   BY
				         	  PURCHASEDATE DESC            
				  		  """;
           try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				Computer computer = new Computer(rset.getInt("PART_ID")
						                        ,rset.getString("PART_NAME")
						                        ,rset.getString("CATEGORY")
						                        ,rset.getInt("PRICE")
						                        ,rset.getString("MANUFACTURER")
						                        ,rset.getDate("PURCHASEDATE"));
				parts.add(computer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
           return parts;
	}
	
	
	public Computer findCategory(Connection conn, String category) {
		Computer computer = null;
		
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
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return computer;
	}

	public List<Computer> findByKeyword(Connection conn, String keyword) {

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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return parts;
	}

	public int update(Connection conn, ComputerDTO cd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = """
				  UPDATE
                         TB_PC_PARTS
                     SET
                         MANUFACTURER = ?
                   WHERE
                         CATEGORY = ?
                     AND
                         PART_NAME = ?     
				      """;
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cd.getManufacturer());
			pstmt.setString(2, cd.getCategory());
			pstmt.setString(3, cd.getPartName());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int delete(Connection conn, Computer computer) {
		
		int result = 0;
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, computer.getPartId());
			pstmt.setString(2, computer.getPartName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
