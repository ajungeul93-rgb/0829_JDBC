package com.kh.employee.run;

import com.kh.common.JDBCTemplate;
import com.kh.employee.view.EmployeeView;

public class EmployeeRun {

	public static void main(String[] args) {

		JDBCTemplate.registDriver();
		EmployeeView ev = new EmployeeView();
		ev.mainMeun();
		
	}

}
