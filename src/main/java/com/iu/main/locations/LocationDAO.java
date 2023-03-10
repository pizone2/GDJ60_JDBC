package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class LocationDAO {
	
		public ArrayList<LocationDTO> getFind(String search) throws Exception{
			ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
			LocationDTO locationDTO = new LocationDTO();
			Connection connection = DBConnection.getConnection();
			
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ? ";
			
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setString(1, "%"+search+"%");
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("LOCATION_ID"));
				System.out.println(rs.getString("STREET_ADDRESS"));
				System.out.println(rs.getString("POSTAL_CODE"));
				System.out.println(rs.getString("CITY"));
				System.out.println(rs.getString("STATE_PROVINCE"));
				System.out.println(rs.getString("COUNTRY_ID"));
				ar.add(locationDTO);
				
			}
			return ar;
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	    //↓ 					
		public void getDetail(int location_id) throws Exception {
			
			Connection connection = DBConnection.getConnection();
			//↓           											
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
			
			PreparedStatement st = connection.prepareStatement(sql);
			
			st.setInt(1, location_id);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt("LOCATION_ID"));
				System.out.println(rs.getString("STREET_ADDRESS"));
				System.out.println(rs.getString("POSTAL_CODE"));
				System.out.println(rs.getString("CITY"));
				System.out.println(rs.getString("STATE_PROVINCE"));
				System.out.println(rs.getString("COUNTRY_ID"));
			}else {
				System.out.println("Data가 없습니다.");
			}
			DBConnection.disConnect(rs, st, connection);
		}

		public ArrayList<LocationDTO> getList() throws Exception {
			ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
			//1.접속 정보 준비
			
//			String user = "hr";
//			String password = "hr";
//			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			
			//2.DB 접속
			
//			Connection connection = DriverManager.getConnection(url, user, password);
//			System.out.println(connection);
			
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			
			//3.Query문 생성
			
			String sql = "SELECT * FROM LOCATIONS";
			
			//4.Query문 미리 전송
			
			PreparedStatement st = connection.prepareStatement(sql);
			
			//5. ? 값 세팅 (옵션)

			//6.최종 전송 및 결과 처리
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				
			
				
			}
			
			//7.연결해제
			
			DBConnection.disConnect(rs, st, connection);
			
			return ar;
		
			
		}












		
	
	
}
