package com.kh.computer.view;

import java.util.Scanner;

import com.kh.computer.controller.ComputerController;

public class ComputerView {
	
	private Scanner sc = new Scanner(System.in);
	private ComputerController cc = new ComputerController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("======= 컴퓨터 부품 조회 프로그램 =======");
			System.out.println("1. 부품 추가 하기 ");
			System.out.println("2. 부품 전체 조회 ");
			System.out.println("3. 부품 순서로 조회");
			System.out.println("4. 부품 이름 키워드로 조회");
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : addPcPart();break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못된 메뉴 선택입니다.");
			}
			
		}
	}
	
	private void addPcPart() {
		
		System.out.println("======= PC부품 추가 메뉴 ======");
		
		System.out.print("부품 이름을 입력해주세요 > ");
		String partId = sc.nextLine();
		System.out.print("부품 종류를 입력해주세요 > ");
		String category = sc.nextLine();
		System.out.print("부품 가격을 입력해주세요 > ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("제조사를 입력해주세요 > ");
		String manufacturer = sc.nextLine();
		
		cc.addPcPart(partId, category, price, manufacturer);
		
	}

}
