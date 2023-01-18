package com.iu.main.departments;

import java.util.ArrayList;

public class DepartmentView {

	//view
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	
	public void view(DepartmentDTO departmentDTO) {
		System.out.println("DEPARTMENT_ID" + departmentDTO.getDepartment_id());
		System.out.println("DEPARTMENT_NAME" + departmentDTO.getDepartment_name());
		System.out.println("MANAGER_ID" + departmentDTO.getManager_id());
		System.out.println("LOCATION_ID" + departmentDTO.getLocation_id());
	}
	
	
	
	public void view(ArrayList<DepartmentDTO> al) {
		for(DepartmentDTO departmentDTO:al)
			this.view(departmentDTO);
		
	}
	
	
	
	
	
}
