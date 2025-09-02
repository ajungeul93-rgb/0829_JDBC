package com.kh.computer.view;

import java.util.List;
import java.util.Scanner;

import com.kh.computer.controller.ComputerController;
import com.kh.computer.model.vo.Computer;

public class ComputerView {
	
	private Scanner sc = new Scanner(System.in);
	private ComputerController cc = new ComputerController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("======= 컴퓨터 부품 조회 프로그램 =======");
			System.out.println("1. 부품 추가 하기 ");
			System.out.println("2. 부품 전체 조회 ");
			System.out.println("3. 부품 종류로 조회");
			System.out.println("4. 제품 이름 키워드로 조회");
			System.out.println("5. 제품 정보 변경");
			System.out.println("6. 제품 정보 삭제");
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : addPcPart();break;
			case 2 : viewAll(); break;
			case 3 : findCategory(); break;
			case 4 : findByKeyword(); break;
			case 5 : update(); break;
			case 6 : delete(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못된 메뉴 선택입니다.");
			}
			
		}
	}
	
	private void addPcPart() {
		
		System.out.println("======= PC부품 추가 메뉴 ======");
		
		System.out.print("부품 이름을 입력해주세요 > ");
		String partName = sc.nextLine();
		System.out.print("부품 종류를 입력해주세요 > ");
		String category = sc.nextLine();
		System.out.print("부품 가격을 입력해주세요 > ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("제조사를 입력해주세요 > ");
		String manufacturer = sc.nextLine();
		
		int result = cc.addPcPart(partName, category, price, manufacturer);
		
		if(result > 0) {
			System.out.println("PC부품 정보등록 성공!");
		} else {
			System.out.println("PC부품 정보등록에 실패하였습니다.");
		}
	}
	
	private void viewAll() {
		
		System.out.println("\n====== 부품 전체 목록 조회결과 =======");
		
		List<Computer> parts = cc.viewAll();
		
		System.out.println("\n조회된 총 목록수는 " + parts.size()+ "개 입니다.");
		if(parts.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		} else {
			
			for(Computer computer : parts) {
				System.out.println("========================================\n");
				System.out.println(computer.getPartId() + "번 부품의 정보");
				System.out.print("제품 이름 : " + computer.getPartName() + ", ");
				System.out.print("부품 종류 : " + computer.getCategory() + ", ");
				System.out.print("부품 가격 : " + computer.getPrice() + ", ");
				System.out.print("부품 제조사 : " + computer.getManufacturer() + ", ");
				System.out.print("부품 구매일 : " + computer.getPurchaseDate());
				System.out.println("\n");
			}
			
		}
		
	}
	
	private void findCategory() {
		
		System.out.println("\n ======부품으로 항목을 찾는 서비스입니다.=====");
		System.out.print("부품의 종류를 입력해주세요 > ");
		String category = sc.nextLine();
		
		Computer computer = cc.findCategory(category);
		
		if(computer != null) {
			System.out.println("\n" + category + "의 검색 결과입니다.");
			System.out.println("\n================================");
			System.out.print("제품 등록번호 : " + computer.getPartId());
			System.out.print("제품 이름 : " + computer.getPartName());
			System.out.print("부품 종류 : " + computer.getCategory());
			System.out.print("부품 가격 : " + computer.getPrice());
			System.out.print("부품 제조사 : " + computer.getManufacturer());
			System.out.print("부품 구매일 : " + computer.getPurchaseDate());
			System.out.println("\n");
		} else {
			System.out.println("제품 정보가 존재하지 않습니다.");
		}
	}
	
	private void findByKeyword() {
		
		System.out.println("\n제품 이름 키워드로 검색");
		System.out.print("검색하실 부품 종류의 키워드를 입력해주세요 > ");
		String keyword = sc.nextLine();
		
		List<Computer> parts = cc.findByKeyword(keyword);
		
		if(parts.isEmpty()) {
			System.out.println("조회하신 결과가 존재하지 않습니다.");
		} else {
			for(int i = 0; i < parts.size(); i++) {
				System.out.println((i+1) + "번 째 조회 결과!");
				System.out.println(parts.get(i));
			}
		}
		
	}
	
	private void update() {
		
		System.out.println("====== 부품 정보 변경 서비스입니다 =======");
		System.out.print("");
		
	}

}
