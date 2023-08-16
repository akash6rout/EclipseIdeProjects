package com.nt.service;

import com.nt.beans.Employee;

public class PayslipGeneratorService {
	
	public void generatePaySlip(Employee emp) {
		//claculate gross salary and netsalary
		float grossSalary=emp.getEmpSalary()+emp.getEmpSalary()*0.5f;//50% on basic salary
		float netSalary=grossSalary-(grossSalary*0.2f);//80% of Gross salary
		//set gross,net salaries back to emp object
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSalary);
	}
}
