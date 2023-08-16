package com.nt.beans;

import java.io.Serializable;

public class Employee implements Serializable {
		private Integer empNo;
		private String empName;
		private String desg;
		private Double salary;
		private Double grossSalary;
		private Double netSalary;
		public Employee() {
			System.out.println("Employee::0-param constructor");
		}
		public Integer getEmpNo() {
			return empNo;
		}
		public void setEmpNo(Integer empNo) {
			this.empNo = empNo;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public String getDesg() {
			return desg;
		}
		public void setDesg(String desg) {
			this.desg = desg;
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public Double getGrossSalary() {
			return grossSalary;
		}
		public void setGrossSalary(Double grossSalary) {
			this.grossSalary = grossSalary;
		}
		public Double getNetSalary() {
			return netSalary;
		}
		public void setNetSalary(Double netSalary) {
			this.netSalary = netSalary;
		}
		
}
