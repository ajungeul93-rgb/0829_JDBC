package com.kh.employee.model.dto;

import java.sql.Date;

public class EmployeeDto {

	private int empId;
	private String empName;
	private int empNo;
	private String email;
	private String phone;
	private String deptTitle;
	private String jobName;
	private String salLevel;
	private int salary;
	private double bonus;
	private String managerId;
	private Date hireDate;
	private Date entDate;
	private String entYn;
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(String empName) {
		super();
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public int getEmpNo() {
		return empNo;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getDeptTitle() {
		return deptTitle;
	}
	public String getJobName() {
		return jobName;
	}
	public String getSalLevel() {
		return salLevel;
	}
	public int getSalary() {
		return salary;
	}
	public double getBonus() {
		return bonus;
	}
	public String getManagerId() {
		return managerId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public Date getEntDate() {
		return entDate;
	}
	public String getEntYn() {
		return entYn;
	}
	
	
}
