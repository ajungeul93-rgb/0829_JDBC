package com.kh.employee.view;

import java.util.List;
import java.util.Scanner;

import com.kh.employee.controller.EmployeeController;
import com.kh.employee.model.vo.Employee;

public class EmployeeView {
	
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public void mainMeun() {
		
		while(true) {
			System.out.println("========= 사원 관리 ============");
			System.out.println("1. 사원 전체 조회 ");
			System.out.println("2. 부서별 사원 조회 ");
			System.out.println("3. 직급별 사원 조회 ");
			System.out.println("4. 사원 상세 조회 ");
			System.out.println("5. 급여 상위 5명 조회 ");
			System.out.println("6. 급여 하위 5명 조회 ");
			System.out.println("7. 새 사원 정보 추가 ");
			System.out.println("8. 사원 정보 수정 ");
			System.out.println("9. 사원 정보 삭제 ");
			System.out.println("0. 프로그램 종료 ");
			System.out.print("메뉴 번호를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
			case 1 : findAll(); break;
			case 2 : findByDept(); break;
			case 3 : findByJob(); break;
			case 4 : findByEmployee(); break;
			case 5 : break;
			case 6 : break;
			case 7 : break;
			case 8 : break;
			case 9 : break;
			case 0 : System.out.println("프로그램을 종료합니다. "); return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
	}
	



	private void findAll() {
		
		System.out.println("============== 사원 전체 조회 ===============");
		
		List<Employee> emp = ec.findAll();
		
		System.out.println("\n조회된 총 사원수는 " + emp.size() + "명 입니다.");
		if(!emp.isEmpty()) {
			for(Employee employee : emp) {
				System.out.println("=============================================");
				System.out.println(employee.getEmpId() + "번의 사원 정보");
				System.out.print("사원 이름 : " + employee.getEmpName() + ", ");
				System.out.print("급여 : " + employee.getSalary() + ", ");
				System.out.print("부서명 : " + employee.getDeptTitle() + ", ");
				System.out.print("직급 : " + employee.getJobName());
				System.out.println("\n");
			}
		} else {
			System.out.println("조회 결과가 존재하지 않습니다.");
		}
		
	}
	
	
	private void findByDept() {
		
		System.out.println("\n부서별 사원 조회 서비스입니다.");
		System.out.print("검색할 부서를 입력해주세요 > ");
		String deptTitle = sc.nextLine();
		
		List<Employee> emp = ec.findByDept(deptTitle);
		
		if(!emp.isEmpty()) {
			
			for(Employee employee : emp) {
            System.out.println("\n======================================");
            System.out.print("사원 번호 : " + employee.getEmpId());
            System.out.print(" | 사원 이름 : " + employee.getEmpName());
            System.out.print(" | 급여 : " + employee.getSalary());
            System.out.print(" | 부서명 : " + employee.getDeptTitle());
            System.out.print(" | 직급 : " + employee.getJobName());
            System.out.println();
			}
		} else {
			System.out.println("존재하지 않는 부서입니다.");
		}
	}
	
	private void findByJob() {
		
		System.out.println("\n직급별 사원 조회 서비스입니다.");
		System.out.print("검색할 직급을 입력해주세요 > ");
		String jobName = sc.nextLine();
		
		List<Employee> emp = ec.findByJob(jobName);
		
		if(!emp.isEmpty()) {
			
			for(Employee employee : emp) {
            System.out.println("\n======================================");
            System.out.print("사원 번호 : " + employee.getEmpId());
            System.out.print(" | 사원 이름 : " + employee.getEmpName());
            System.out.print(" | 급여 : " + employee.getSalary());
            System.out.print(" | 부서명 : " + employee.getDeptTitle());
            System.out.print(" | 직급 : " + employee.getJobName());
            System.out.println();
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
	}
	private void findByEmployee() {

		System.out.println("\n 사원 상세 조회 항목입니다.");
		System.out.print("검색하실 사원 번호을 입력해주세요 > ");
		int empId = sc.nextLine();
		
		Employee employee = ec.findByEmployee(empId);
		
	}
	

}
