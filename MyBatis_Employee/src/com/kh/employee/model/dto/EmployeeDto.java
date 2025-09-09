package com.kh.employee.model.dto;

import java.sql.Date;

public class EmployeeDto {

	private String empId;
	private String empName;
	private String empNo;
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


	
	public EmployeeDto(String empId, String empName, String empNo, String email, String phone, String deptTitle,
			String jobName, String salLevel, int salary, double bonus, String managerId, Date hireDate, String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptTitle = deptTitle;
		this.jobName = jobName;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entYn = entYn;
	}
	
	public EmployeeDto(String empId, String entYn) {
		super();
		this.empId = empId;
		this.entYn = entYn;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptTitle() {
		return deptTitle;
	}

	public void setDeptTitle(String deptTitle) {
		this.deptTitle = deptTitle;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	public String getEmpId() {
		return empId;
	}
	

	

}
