package com.kh.statement.run;

import com.kh.statement.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {

		//JDBCTemplate.registDriver();
		
		//Template.getSqlSession();
		MemberView mv = new MemberView();
		mv.mainMenu();
		
	}

}
