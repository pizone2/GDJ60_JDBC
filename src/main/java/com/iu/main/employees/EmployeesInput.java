package com.iu.main.employees;

import java.util.Scanner;

import com.iu.main.departments.DepartmentDTO;

public class EmployeesInput {
	private Scanner sc;
	
	public EmployeesInput() {
		this.sc = new Scanner(System.in);
		
	}

	//수정
	public EmployeesDTO updateData() {
		EmployeesDTO employeesDTO = new EmployeesDTO();
		System.out.println("수정할 성을 입력해주세요");
		employeesDTO.setFirst_name(sc.next());
		System.out.println("수정할 이름을 입력해주세요");
		employeesDTO.setLast_name(sc.next());
		System.out.println("수정할 매니저번호를 입력해주세요");
		employeesDTO.setManager_id(sc.nextInt());
		System.out.println("수정할 직원번호를 입력해주세요  ");
		employeesDTO.setEmployee_id(sc.nextInt());
		
		return employeesDTO;
		
	}

	//추가
	public EmployeesDTO setData() {
		EmployeesDTO employeesDTO = new EmployeesDTO();
		
		System.out.println("추가할 직원번호를 입력해주세요  ");
		employeesDTO.setEmployee_id(sc.nextInt());
		System.out.println("추가할 성을 입력해주세요");
		employeesDTO.setFirst_name(sc.next());
		System.out.println("추가할 이름을 입력해주세요");
		employeesDTO.setLast_name(sc.next());
		System.out.println("추가할 이메일을 입력해주세요");
		employeesDTO.setEmail(sc.next());
		System.out.println("추가할 전화번호를 입력해주세요");
		employeesDTO.setPhone_number(sc.next());
		System.out.println("추가할 월급를 입력해주세요");
		employeesDTO.setSalary(sc.nextDouble());
		System.out.println("추가할 수당를 입력해주세요");
		employeesDTO.setCommission_pct(sc.nextDouble());
		System.out.println("수정할 매니저번호를 입력해주세요");
		employeesDTO.setManager_id(sc.nextInt());
		System.out.println("추가할를 회사입력해주세요");
		employeesDTO.setDepartment_id(sc.nextInt());
		
		
		
	
		return employeesDTO;

	}




	public EmployeesDTO deleteData() {
		EmployeesDTO employeesDTO = new EmployeesDTO();
		
		System.out.println("삭제할 직원번호를 입력해주세요  ");
		employeesDTO.setEmployee_id(sc.nextInt());


		return employeesDTO;
	}










}
