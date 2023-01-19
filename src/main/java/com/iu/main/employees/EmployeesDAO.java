package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class EmployeesDAO {
	
	//월급의 평균
	public void getAvg() throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT AVG(SALARY),SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		System.out.println(rs.getDouble(1));
		System.out.println(rs.getDouble(2));
		
		DBConnection.disConnect(rs, st, con);
		
	}
	
	//update
	
	public int updataData(EmployeesDTO employeesDTO)throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "UPDATE EMPLOYEES  SET FIRST_NAME=?,LAST_NAME=?,MANAGER_ID =?"
				+ " WHERE EMPLOYEE_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, employeesDTO.getFirst_name());
		st.setString(1, employeesDTO.getLast_name());
		st.setInt(1, employeesDTO.getManager_id());
		st.setInt(1, employeesDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
	
		return result;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//delete
	public int deleteData(EmployeesDTO employeesDTO)throws Exception{
		Connection connection = DBConnection.getConnection();
		
		String sql = "DELETE EMPLOYEES WHERE EMPLOYEES_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, employeesDTO.getEmployee_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//insert
	public int setData (EmployeesDTO employeesDTO)throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql ="INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)"
				+ " VLAUES (EMPLOYEES_SEQ.NEXT,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(0, employeesDTO.getFirst_name());
		st.setString(0, employeesDTO.getLast_name());
		st.setString(0, employeesDTO.getEmail());
		st.setString(0, employeesDTO.getPhone_number());
		st.setDate(0, employeesDTO.getHire_date());
		st.setString(0, employeesDTO.getJob_id());
		st.setDouble(0, employeesDTO.getSalary());
		st.setDouble(0, employeesDTO.getCommission_pct());
		st.setInt(0, employeesDTO.getManager_id());
		st.setInt(0, employeesDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
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
			employeesDTO.setSalary(rs.getDouble("SALARY"));
			employeesDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
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
		
		String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID "
				+ "FROM EMPLOYEES ORDER BY HIRE_DATE DESC";
		
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
			employeesDTO.setSalary(rs.getDouble("SALARY"));
			employeesDTO.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			employeesDTO.setManager_id(rs.getInt("MANAGER_ID"));
			employeesDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			al.add(employeesDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return al;
		
	}
	
	
	
	
	
}
