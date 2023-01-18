package com.iu.main.employees;

import java.util.Scanner;



//Employees 
//
//하이얼데이 날짜 = java에서는 data타입으로 java.sql에 date 있음 getdate, set date
//
//1.사원정보리스트 - 신입사원 순으로 출력,(사원번호, 성 ,이름, 직급, 부서번호)
//
//2.개별사원정보   - 사원한명의 모든 정보 출력 (사원번호)
//
//3.사원검색         - 사원이름으로 검색 (라스트네임으로 검색)

public class EmployeesController {

	private Scanner sc;
	private EmployeesDAO employeesDAO;
	
	public EmployeesController() {
		this.sc = new Scanner(System.in);
		this.employeesDAO = new EmployeesDAO();
		
	}
	
	public void start() throws Exception{
		boolean check = true;
		
		
		while(check) {
			System.out.println("1.사원정보리스트");
			System.out.println("2.개별사원정보");
			System.out.println("3.사 원 검 색");
			System.out.println("4.종     료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				employeesDAO.getList();
				break;
				
			case 2:
				break;
				
			case 3:
				break;
			
			default:
				check = false;
				
			
			
			
			
			
			
			
			
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
