package com.mit.day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {

		ArrayList<Employee> empList = new ArrayList<>();
		addEmployee(empList);

	}

	private static void addEmployee(ArrayList<Employee> empList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter employee ID:\t");
			Scanner addID = new Scanner(System.in);
			String id = addID.nextLine();

			System.out.println("Enter employee Name:\t");
			Scanner addName = new Scanner(System.in);
			String name = addName.nextLine();

			System.out.println("Enter employee Salary:\t");
			Scanner addSalary = new Scanner(System.in);
			double salary = addSalary.nextDouble();

			empList.add(new Employee(id, name, salary));
		}
		for (Employee e : empList) {
			e.print(e.getId(), e.getName(), e.getSalary());
		}
	}

	// employee.print(employee.getId(), employee.getName(),
	// employee.getSalary());

	// Employee e1 = new Employee("001", "E1", 400000.00);
	// Employee e2 = new Employee("002", "E2", 500000.00);
	// Employee e3 = new Employee("003", "E3", 600000.00);
	// Employee e4 = new Employee("004", "E4", 300000.00);
	// Employee e5 = new Employee("005", "E5", 400000.00);

	// java.util.List<Employee> list = new ArrayList<>();
	// list.add(e1);
	// list.add(e2);
	// list.add(e3);
	// list.add(e4);
	// list.add(e5);
	//
	// Iterator<Employee> iterator = list.iterator();
	// while (iterator.hasNext()) {
	// Employee employee = (Employee) iterator.next();
	// Employee.print(employee.getId(), employee.getName(),
	// employee.getSalary());
	// }

	// Employee.print(e1.getId(), e1.getName(), e1.getSalary());
}
