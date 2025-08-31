package com.aclass.computer.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ComputerInsertRun {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("부품 등록 번호를 입력해주세요 > ");
		int partId = sc.nextInt();
		sc.nextLine();

		System.out.print("부품 이름을 입력해주세요 > ");
		String partName = sc.nextLine();

		System.out.print("부품의 종류를 입력해주세요 > ");
		String category = sc.nextLine();

		System.out.print("부품의 가격을 입력해주세요 > ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("제조사를 입력해주세요 > ");
		String manufacturer = sc.nextLine();

		// 부품 구매일 = SYSDATE로 대체

		String sql = "INSERT INTO TB_PC_PARTS (PART_ID, PART_NAME, CATEGORY, PRICE, MANUFACTURER, PURCHASE_DATE) "
				+ "VALUES (" + partId + ", '" + partName + "', '" + category + "', " + price + ", '" + manufacturer
				+ "', SYSDATE)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공!");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000", "BJG12", "BJG121234");
			System.out.println("DB서버 접속 성공");

			conn.setAutoCommit(false);

			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성! ");

			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공!");

			if (result > 0) {
				conn.commit();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
