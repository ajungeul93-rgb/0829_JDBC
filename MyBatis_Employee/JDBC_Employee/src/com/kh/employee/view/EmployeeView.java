package com.kh.employee.view;

import java.util.List;
import java.util.Scanner;

import com.kh.employee.controller.EmployeeController;
import com.kh.employee.model.dto.EmployeeDto;
import com.kh.employee.model.vo.Employee;

public class EmployeeView {

	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	public void mainMeun() {

		while (true) {
			System.out.println("========= 사원 관리 ============");
			System.out.println("1. 사원 전체 조회 ");
			System.out.println("2. 부서별 사원 조회 ");
			System.out.println("3. 직급별 사원 조회 ");
			System.out.println("4. 사원 상세 조회 ");
			System.out.println("5. 급여 상위 5명 조회 ");
			System.out.println("6. 급여 하위 5명 조회 ");
			System.out.println("7. 새 사원 정보 추가 ");
			System.out.println("8. 사원 정보 수정 ");
			System.out.println("9. 재직여부 수정 ");
			System.out.println("0. 프로그램 종료 ");
			System.out.print("메뉴 번호를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			switch (menuNo) {
			case 1:	findAll(); break;
			case 2:	findByDept(); break;
			case 3:	findByJob(); break;
			case 4:	findByEmployee(); break;
			case 5:	findTop5Salaries(); break;
			case 6:	findBottom5Salaries(); break;
			case 7:	insertEmployee(); break;
			case 8:	updateEmployee(); break;
			case 9:	retireEmployee(); break;
			case 0:	System.out.println("프로그램을 종료합니다. ");	return;
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}

		}
	}

	private void findAll() {

		System.out.println("============== 사원 전체 조회 ===============");

		List<Employee> emp = ec.findAll();

		System.out.println("\n조회된 총 사원수는 " + emp.size() + "명 입니다.");
		if (!emp.isEmpty()) {
			for (Employee employee : emp) {
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

		if (!emp.isEmpty()) {

			for (Employee employee : emp) {
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

		if (!emp.isEmpty()) {

			for (Employee employee : emp) {
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
		String empId = sc.nextLine();

		EmployeeDto ed = ec.findByEmployee(empId);

		if (ed != null) {
			System.out.println("\n" + empId + "사번의 사원 정보입니다.");
			System.out.println("\n===========================================");
			System.out.println("사원 이름 : " + ed.getEmpName());
			System.out.println("사원 주민등록번호 : " + ed.getEmpNo());
			System.out.println("이메일 : " + ed.getEmail());
			System.out.println("휴대폰 : " + ed.getPhone());
			System.out.println("부서 : " + ed.getDeptTitle());
			System.out.println("직급 : " + ed.getJobName());
			System.out.println("급여 등급 : " + ed.getSalLevel());
			System.out.println("급여 : " + ed.getSalary());
			System.out.println("보너스(율) : " + ed.getBonus());
			System.out.println("사수 사원번호 : " + ed.getManagerId());
			System.out.println("입사일 : " + ed.getHireDate());
			System.out.println("재직 상태 : " + ed.getEntYn());
		} else {
			System.out.println("잘못된 사원 번호를 입력하셨습니다.");
		}

	}

	private void findTop5Salaries() {
		
		System.out.println("============== 급여 상위 5명 조회 ===============");
	    
	    // 컨트롤러의 메서드를 호출하여 급여 상위 5명 목록을 가져옵니다.
	    List<Employee> emp = ec.findTop5Salaries();
	    
	    if (!emp.isEmpty()) {
	        System.out.println("\n급여 상위 5명 목록입니다.");
	        for(Employee employee : emp) {
	            System.out.println("=============================================");
	            System.out.print("사원 번호 : " + employee.getEmpId() + ", ");
	            System.out.print("사원 이름 : " + employee.getEmpName() + ", ");
	            System.out.print("급여 : " + employee.getSalary() + ", ");
	            System.out.print("부서명 : " + employee.getDeptTitle() + ", ");
	            System.out.print("직급 : " + employee.getJobName());
	            System.out.println();
	        }
	    } else {
	        System.out.println("조회 결과가 존재하지 않습니다.");
	    }

	}

	private void findBottom5Salaries() {
		System.out.println("============== 급여 하위 5명 조회 ===============");
	    
	    // 컨트롤러의 메서드를 호출하여 급여 하위 5명 목록을 가져옵니다.
	    List<Employee> emp = ec.findBottom5Salaries();
	    
	    if (!emp.isEmpty()) {
	        System.out.println("\n급여 하위 5명 목록입니다.");
	        for(Employee employee : emp) {
	            System.out.println("=============================================");
	            System.out.print("사원 번호 : " + employee.getEmpId() + ", ");
	            System.out.print("사원 이름 : " + employee.getEmpName() + ", ");
	            System.out.print("급여 : " + employee.getSalary() + ", ");
	            System.out.print("부서명 : " + employee.getDeptTitle() + ", ");
	            System.out.print("직급 : " + employee.getJobName());
	            System.out.println();
	        }
	    } else {
	        System.out.println("조회 결과가 존재하지 않습니다.");
	    }

	}

	private void insertEmployee() {

		System.out.println("======= 사원 추가 =======");
		
		System.out.print("사원번호를 입력해주세요 >");
		String empId = sc.nextLine();
		System.out.print("사원 이름을 입력해주세요 > ");
		String empName = sc.nextLine();
		System.out.print("사원 주민등록번호를 입력해주세요 > ");
		String empNo = sc.nextLine();
		System.out.print("이메일을 입력해주세요 > ");
		String email = sc.nextLine();
		System.out.print("휴대폰 '-'을 제외한 번호를 입력해주세요   > ");
		String phone = sc.nextLine();
		System.out.print("부서코드를 입력해주세요 (D1 ~ D9)> ");
		String deptTitle = sc.nextLine();
		System.out.print("직급코드를 입력해주세요 (J1 ~ J8)> ");
		String jobName = sc.nextLine();
		System.out.print("급여등급을 입력해주세요 (S1 ~ S6)> ");
		String salLevel = sc.nextLine();
		System.out.print("급여를 입력해주세요(숫자만) >");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("보너스율을 입력해주세요 > ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		System.out.print("사수 사원번호를 입력해주세요 > ");
		String managerId = sc.nextLine();
		String entYn = "";
		while(true) {
		     System.out.print("재직여부 (N = 재직중 / Y = 퇴사) >");
		     entYn = sc.nextLine().toUpperCase();
		        if(entYn.equals("N")||entYn.equals("Y")) {
			       break;
		        } System.out.println("잘못된 입력입니다. N또는 Y를 입력해주세요.");
		}
		
		int result = ec.insertEmployee(empId, empName, empNo, email, phone, deptTitle, jobName
				                      ,salLevel, salary, bonus, managerId, entYn);
		
		if(result > 0) {
			System.out.println("사원등록에 성공하셨습니다. "); // 여기가 실패??
		} else {
			System.out.println("사원등록에 실패하였습니다. "); // 여기가 성공?
		}
		
		
	}

	private void updateEmployee() {
		
		System.out.println("사원 정보수정 서비스입니다.(급여, 직급, 부서)");
		System.out.print("수정할 사원의 사원번호를 입력해주세요 > ");
		String empId = sc.nextLine();
		
		System.out.print("새로운 급여를 입력해주세요 > ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.print("새로운 직급명을 입력해주세요 (예 : 사원, 대리, 과장 등) > ");
		String jobName = sc.nextLine();
		
		System.out.print("새로운 부서명을 입력해주세요 (예 : 인사관리부, 회계관리부, 마케팅부 등) > ");
		String deptTitle = sc.nextLine();
		
		int result = ec.updateEmployee(empId, salary, jobName, deptTitle);
		
		if(result > 0) {
			System.out.println("사원정보 수정에 성공하였습니다.");
		} else {
			System.out.println("사원정보 수정에 실패하셨습니다. ");
		}

	}

	private void retireEmployee() {

		System.out.println("==========사원 재직여부 변경==========");
		System.out.print("재직여부 변경할 사원 번호를 입력해주세요 > ");
		String empId = sc.nextLine();
		
		String entYn = "";
		while(true) {
		     System.out.print("재직중 or 퇴사처리 (N = 재직중 / Y = 퇴사) >");
		     entYn = sc.nextLine().toUpperCase();
		        if(entYn.equals("N")||entYn.equals("Y")) {
			       break;
		        } System.out.println("잘못된 입력입니다. N또는 Y를 입력해주세요.");
		}
		
		int result = ec.retireEmployee(empId, entYn);
		
		if(result > 0) {
			System.out.println("재직여부 정보수정에 성공하셨습니다.");
		} else {
			System.out.println("재직여부 정보수정에 실패하셨습니다. ");
		}
		
	}

}
