package com.kh.computer.run;

import com.kh.common.JDBCTemplate;
import com.kh.computer.view.ComputerView;

public class ComputerRun {

	public static void main(String[] args) {
		
        JDBCTemplate.registDriver();
		ComputerView cv = new ComputerView();
		cv.mainMenu();
		
	}

}
