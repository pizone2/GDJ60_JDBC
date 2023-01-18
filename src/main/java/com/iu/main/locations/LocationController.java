package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	//↓의존성
	private Scanner sc;
	private LocationDAO locationDAO;
	
	//↓ 의존성 주입 , 생성자 재정의
	public LocationController() {
		//↓ this는 자기자신
		this.sc = new Scanner(System.in);
		this.locationDAO = new LocationDAO();
	}

	public void start() throws Exception{
		boolean check = true;
		ArrayList<LocationDTO> ar;
		
		while(check) {
			System.out.println("1. 위치 리스트");
			System.out.println("2. 위치상세정보");
			System.out.println("3. 주소검색");
			System.out.println("4. 종     료");
			int select  = sc.nextInt();
			
			switch(select) {
			case 1:
				//↓ 객체생성명.매소드
				locationDAO.getList();
				break;
			case 2:
				System.out.println("위치번호를 입력하세요");
				select = sc.nextInt();
				//↓ 객체생성명.매소드
				locationDAO.getDetail(select);
				break;
				
			case 3:
				System.out.println("검색할주소검색");
				String add = sc.next();
			 ar =  locationDAO.getFind(add);
			default:
				check = false;
			}
		}
		
	}











}
