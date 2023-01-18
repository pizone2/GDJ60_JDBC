package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import com.iu.main.util.DBConnection;

public class EmployeesDAO {
	
	public EmployeesDTO getDetail(int employee_id) throws Exception{
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employee_id);
		
		ResultSet rs = st.executeQuery();
		
		EmployeesDTO employeesDTO = new EmployeesDTO();
		
		if(rs.next()) {
			employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeesDTO.setLast_name(rs.getString("LAST_NAME"));
			employeesDTO.setEmail(rs.getString("EMAIL"));
			employeesDTO.setPhone_number(rs.getString("PHONE_NAMBER"));
			employeesDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeesDTO.setJob_id(rs.getString("JOB_ID"));
			employeesDTO.setSalary(rs.getInt("SALARY"));
			employeesDTO.setCommission_pct(rs.getInt("COMMISSION_PCT"));
			employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
		}else {
			System.out.println("사원의 정보가 없습니다.");
		}
		
		return employeesDTO;
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<EmployeesDTO> getList () throws Exception{
		ArrayList<EmployeesDTO> al = new ArrayList<EmployeesDTO>();
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeesDTO.setLast_name(rs.getString("LAST_NAME"));
			employeesDTO.setEmail(rs.getString("EMAIL"));
			employeesDTO.setPhone_number(rs.getString("PHONE_NAMBER"));
			employeesDTO.setHire_date(rs.getDate("HIRE_DATE"));
			employeesDTO.setJob_id(rs.getString("JOB_ID"));
			employeesDTO.setSalary(rs.getInt("SALARY"));
			employeesDTO.setCommission_pct(rs.getInt("COMMISSION_PCT"));
			employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			al.add(employeesDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return al;
		
	}
	
	
	
	
	
}
