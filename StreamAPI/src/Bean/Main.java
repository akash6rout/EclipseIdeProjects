package Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> emp=new ArrayList<Employee>();
		Employee e1=new Employee("raja", 21, 100);
		Employee e2=new Employee("lipu", 16, 150);
		Employee e3=new Employee("ullas", 28, 200);
		Employee e4=new Employee("biki", 22, 250);
		Employee e5=new Employee("rashmi", 26, 300);
		
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		emp.add(e4);
		emp.add(e5);
		
		System.out.println("Original Salary::"+emp);
		
		List<Employee> incrementedSalary= emp.stream().map(e->{
			if(e.getAge()>25)
			{
				e.setSalary(e.getSalary()*1.10);
			}
			return e;
		}).collect(Collectors.toList());
		System.out.println("Incremented Salary::");
	System.out.println(incrementedSalary);
	}

}
