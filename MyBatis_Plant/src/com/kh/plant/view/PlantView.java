package com.kh.plant.view;

import java.util.List;
import java.util.Scanner;

import com.kh.plant.controller.PlantController;
import com.kh.plant.model.vo.Plant;

public class PlantView {
	
	private Scanner sc = new Scanner(System.in);
	private PlantController pc = new PlantController();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("======= 식물 관리 프로그램 =======");
			System.out.println("1. 식물 전체 조회 ");
			System.out.println("2. 식물 추가 ");
			System.out.println("3. 식물 종류별 조회 ");
			System.out.println("4. 식물 상태 변경 ");
			System.out.println("5. 식물 삭제 ");
			System.out.println("6. 식물 상제 정보 조회 ");
			System.out.println("9. 프로그램 종료 ");
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : findAll(); break;
			case 2 : insertPlant(); break;
			case 3 : findByPlnatType(); break;
			case 4 : updateStatus(); break;
			case 5 : deletePlant(); break;
			case 6 : findByPlant(); break;
			case 9 : System.out.println("프로그램을 종료합니다. "); return;
			default : System.out.println("잘못된 메누 선택입니다. ");
			}
		}
	}
	
	private void findAll() {
		
		System.out.println("\n====== 식물 전체 목록조회 =======");
		
		List<Plant> plant = pc.findAll();
		
		System.out.println("\n조회된 식물수는 " + plant.size()+"개 입니다.");
		if(plant.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다. ");
		} else {
			for(Plant plan : plant) {
				System.out.println("================================\n");
				System.out.println(plan.getPlantId() + "번 식물의 정보");
				System.out.print("| 식물 이름 : " + plan.getPlantName());
				System.out.print(" | 식물 종류 : " + plan.getPlantType());
				System.out.print(" | 심은 날짜 : " + plan.getPlantedDate());
				System.out.print(" | 물주는 주기 : " + plan.getWateringCycle());
				System.out.print(" | 식물 성장 상태 : " + plan.getPlantStatus() +"\n");
				
			}
		}
	}

	private void insertPlant() {

		System.out.println("========= 식물 추가 ==========");
		
		System.out.print("식물 이름을 입력해주세요 > ");
		String plantName = sc.nextLine();
		System.out.print("식물 종류를 입력해주세요 > ");
		String plantType = sc.nextLine();
		System.out.print("물을 주는 주기를 입력해주세요 > ");
		String wateringCycle = sc.nextLine();
		System.out.print("식물의 성장 상태를 입력해주세요 > ");
		String plantStatus = sc.nextLine();
		
		int result = pc.insertPlant(plantName, plantType, wateringCycle, plantStatus);
		
		if(result > 0) {
			System.out.println("식물 정보등록에 성공하셨습니다.");
		} else {
			System.out.println("식물 정보등록에 실패하셨습니다.");
		}
		
	}

	private void findByPlnatType() {

		System.out.println("========== 식물 종류별 검색 =========");
		System.out.print("찾으실 식물의 종류를 입력해주세요 > ");
		String plantType = sc.nextLine();
		
		List<Plant> plant = pc.findByPlantType(plantType);
		
		System.out.println("\n" + plantType + "의 검색 결과입니다. ");
		if(plant.isEmpty()) {
			System.out.println("검색 조회결과가 존재하지 않습니다. ");
		} else {
			for(Plant p : plant) {
				System.out.println("\n================================");
				System.out.print("식물 식별번호 : " + p.getPlantId());
				System.out.print(" | 식물 이름 : " + p.getPlantName());
				System.out.print(" | 식물 종류 : " + p.getPlantType());
				System.out.print(" | 심은 날짜 : " + p.getPlantedDate());
				System.out.print(" | 물주는 주기 : " + p.getWateringCycle());
				System.out.println(" | 식물 성장 상태 : " + p.getPlantStatus());
			}
		}
	}

	private void updateStatus() {

		System.out.println("======= 식물 성장상태 변경 ========");
		System.out.print("성장상태 변경을 할 식물 이름을 입력해주세요 > ");
		String plantName = sc.nextLine();
	}

	private void deletePlant() {
		// TODO Auto-generated method stub
		
	}

	private void findByPlant() {
		// TODO Auto-generated method stub
		
	}


}
