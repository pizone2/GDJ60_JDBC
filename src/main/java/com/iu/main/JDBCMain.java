package com.iu.main;

import javax.crypto.spec.DESedeKeySpec;
import javax.tools.DocumentationTool.Location;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeesController;
import com.iu.main.employees.EmployeesDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		FrontController fc = new FrontController();
		
		//↓ 객체선언
//		LocationDAO dao2 = new LocationDAO();
//		DepartmentDAO dao = new DepartmentDAO();
//		DepartmentController dc = new DepartmentController();
//		LocationController lc = new LocationController();
//		EmployeesController ec = new EmployeesController();
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		EmployeesDAO employeesDAO = new EmployeesDAO();
		
				
		
		
		try {
			fc.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		try {
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			departmentDTO.setDepartment_id(280);
//			
//			int result = departmentDAO.deleteData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		try {
//			DepartmentDTO departmentDTO = new DepartmentDTO();
//			
//			departmentDTO.setDepartment_name("TestIT");
//			departmentDTO.setManager_id(200);
//			departmentDTO.setLocation_id(1700);
//			int result = departmentDAO.setData(departmentDTO);
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	
		System.out.println("finish");
	
	}

}
