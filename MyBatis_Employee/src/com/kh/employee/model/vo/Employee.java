package com.kh.employee.model.vo;

import java.util.Objects;

public class Employee {
	
	private String empId;
	private String empName;
	private int salary;
	private String deptTitle;
	private String jobName;
	
	public Employee() {
		super();
	}

	public Employee(String empId, String empName, int salary, String deptTitle, String jobName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptTitle = deptTitle;
		this.jobName = jobName;
	}

	public String getEmpId() {
		return empId;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", deptTitle=" + deptTitle
				+ ", jobName=" + jobName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptTitle, empId, empName, jobName, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(deptTitle, other.deptTitle) && empId == other.empId
				&& Objects.equals(empName, other.empName) && Objects.equals(jobName, other.jobName)
				&& salary == other.salary;
	}
	
	
	
	

}
