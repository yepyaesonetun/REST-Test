package com.eg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eg.data.EmployeeData;
import com.eg.data.Result;



public class EmployeeDao {
	
	
   public static Result saveEmployee(EmployeeData data, Connection l_Conn) {
		
		Result res = new Result();
		String query = "INSERT INTO Emp (syskey, createddate, modifieddate, userid,"
				+ "  username, recordStatus, syncStatus, syncBatch, id, name, address)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
				PreparedStatement ps = l_Conn.prepareStatement(query);
				ps.setLong(1,data.getSyskey());			
				ps.setString(2, data.getCreatedDate());
				ps.setString(3, data.getModifiedDate());
				ps.setString(4, data.getUserId());
				ps.setString(5, data.getUserName());
				ps.setInt(6, data.getRecordStatus());
				ps.setInt(7, data.getSyncStatus());
				ps.setLong(8, data.getSyncBatch());
				ps.setString(9, data.getId());
				ps.setString(10, data.getName());
				ps.setString(11, data.getAddress());
				
				if(ps.executeUpdate()>0){
					res.setState(true);
					res.setMsgDesc("Saved Successfully");
			
				}
				
				
		   }catch (SQLException e) {
				e.printStackTrace();
				res.setMsgDesc("Save Fail");	
		 }	
	   
		return res;

	}
	
	
	public static EmployeeData getEmployeeDataByName(String name, Connection l_Conn)throws SQLException {
		
		EmployeeData ret = new EmployeeData();
		String l_Query = "SELECT * FROM Emp WHERE name=?";
		PreparedStatement pstmt = l_Conn.prepareStatement(l_Query);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();	
		
		while(rs.next()){
			
			ret.setSyskey(rs.getLong("syskey"));
			ret.setCreatedDate(rs.getString("createdDate"));
			ret.setModifiedDate(rs.getString("modifiedDate"));
			ret.setId(rs.getString("id"));
			ret.setName(rs.getString("name"));
			ret.setAddress(rs.getString("address"));
			
	    }
		
		return ret;
	}
	
	
	
}

