package com.iu.main.departments;

import java.util.ArrayList;

import com.iu.main.employees.EmployeesDTO;

public class DepartmentDTO {

	
	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	//1:N 관계
	private ArrayList<EmployeesDTO> employeesDTOs;
	
	
	
	
	
	
	
	public ArrayList<EmployeesDTO> getEmployeesDTOs() {
		return employeesDTOs;
	}
	public void setEmployeesDTOs(ArrayList<EmployeesDTO> employeesDTOs) {
		this.employeesDTOs = employeesDTOs;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	
	
	
	
	
	
	
}
