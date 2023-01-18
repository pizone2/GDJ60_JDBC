package com.iu.main;

import javax.tools.DocumentationTool.Location;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.employees.EmployeesController;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		
		//↓ 객체선언
		LocationDAO dao2 = new LocationDAO();
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentController dc = new DepartmentController();
		LocationController lc = new LocationController();
		EmployeesController ec = new EmployeesController();
		
		try {
			ec.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			dao2.getList();
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
////			dao.getList();
//			dao.getDetail(20);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			dc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//↓ throws Exception을 받아서 try catch	
//		try {
//			lc.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		System.out.println("finish");
	
	}

}
