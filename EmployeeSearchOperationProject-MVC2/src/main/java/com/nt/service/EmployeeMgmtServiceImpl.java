package com.nt.service;

import java.util.List;

import com.nt.beans.Employee;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	private IEmployeeDAO empDAO;

	public EmployeeMgmtServiceImpl() {
		empDAO = new EmployeeDAOImpl();
	}

	@Override
	public List<Employee> fetchEmployeeByDesg(String desg) throws Exception {
		// use DAO
		List<Employee> list = empDAO.searchEmployeesByDesg(desg);
		list.forEach(emp -> {
			// calculate gross,net salaries
			double grossSalary = emp.getSalary() + emp.getSalary() * 0.03f;
			double netSalary = grossSalary - (grossSalary * 0.1);
			// set gross salary,net salary to back to emp object
			emp.setGrossSalary(grossSalary);
			emp.setNetSalary(netSalary);
		});
		return list;
	}

}
