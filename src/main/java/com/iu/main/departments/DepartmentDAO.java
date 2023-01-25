package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

import com.iu.main.employees.EmployeesDTO;
import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class DepartmentDAO {
	
	public void getInfos()throws Exception{
		Connection con = DBConnection.getConnection();
		//30번 부서에 근무하는 사원들의 이름과 부서이름을 한꺼번에 출력
		String sql = "SELECT E.FIRST_NAME , D.DEPARTMENT_NAME"
				+ "	FROM EMPLOYEES E"
				+ "		 INNER JOIN"
				+ "		 DEPARTMENTS D ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID)"
				+ "	WHERE  D.DEPARTMENT_ID  =30";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setEmployeesDTOs(new ArrayList<EmployeesDTO>());
		while (rs.next()) {
			if(departmentDTO.getDepartment_name() == null) {
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			}
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeesDTOs().add(employeesDTO);
		
		}
		
		
	}
	
	//join
	public DepartmentDTO getInfo() throws Exception{
		DepartmentDTO departmentDTO;
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT E.FITST_NAME, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "INNER JOIN "
				+ "DEPARTMENTS D "
				+ "ON (E.DEPARTMENT_ID = D.DEPARTMENT_ID) "
				+ "WHERE E.EMPLOYEE_ID = 100";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setEmployeesDTOs(new ArrayList<EmployeesDTO>());
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_ID"));
//			departmentDTO.getEmployeesDTOs().get(0)
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setFirst_name(rs.getString("FIRST_NAME"));
			departmentDTO.getEmployeesDTOs().add(employeesDTO);
			
		}
	}
	
	//update
	
	public int updateData(DepartmentDTO departmentDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?,MANAGER_ID=?,LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,departmentDTO.getDepartment_name() );
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//delete
	public int deleteData(DepartmentDTO departmentDTO) throws Exception{
		//연결
		Connection connection = DBConnection.getConnection();
		//sql문 작성
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
		
	}
	//1.Execute 
	// Boolean 타입의 값을 반환,모든 구문사용
	//2.ExecuteQuery
	// ResultSet 객체의 값을 반환,SELECT문에서 사용
	//3.ExecuteUpdate
	//int 타입의 값을 반환 ,SELECT를 제외한 다른 구문에서 사용
	
	
	
	
	
	
	
	
	
	
	//insert
	public int setData (DepartmentDTO departmentDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
//		String sql ="INSERT INTO DEPARTMENTS (DEPARTMENT_ID"
//				+ ",DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID)"
//				+ " VALUES(DEPARTMENT_SEQ.NEXTVAL,?,?,?)";
		
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID)"
				+ " VALUES (DEPARTMENTS_SEQ.NEXTVAL,?,?,?)";
		
		
		
		PreparedStatement st = con.prepareStatement(sql);
		//?순서에 따라서 번호기입, 매서드 매개변수로 받아옴
		st.setString(1, departmentDTO.getDepartment_name());
		st.setInt(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		public DepartmentDTO getDetail(int department_id) throws Exception{
			
			Connection connection = DBConnection.getConnection();
			
			String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
			
			PreparedStatement st  = connection.prepareStatement(sql);
			
			st.setInt(1, department_id);
			
			ResultSet rs = st.executeQuery();
			
			DepartmentDTO  departmentDTO = null;
			
			if(rs.next()) {
				 departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				departmentDTO.setManager_id(rs.getInt("Manager_ID"));
				departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				
			}
			
			DBConnection.disConnect(rs, st, connection);
			
			return departmentDTO;
		}

		public ArrayList<DepartmentDTO> getList () throws Exception {
			ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
			//1.접속 정보 준비
//			
//			String user = "hr";
//			String password = "hr";
//			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			
			//2.DB 접속
			
//			Connection connection = DriverManager.getConnection(url, user, password);
//			System.out.println(connection);
			
//			DBConnection dbConnection = new DBConnection();
			Connection connection = DBConnection.getConnection();
			
			//3.Query문 생성
			
			String sql = "SELECT * FROM DEPARTMENTS";
			
			//4.Query문 미리 전송
			
			PreparedStatement st = connection.prepareStatement(sql);
			
			//5. ? 값 세팅 (옵션)

			//6.최종 전송 및 결과 처리
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				departmentDTO.setManager_id(rs.getInt("Manager_ID"));
				departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				ar.add(departmentDTO);
			}
			
			//7.연결해제
		
			DBConnection.disConnect(rs, st, connection);
			
			return ar;
		
		}







}
