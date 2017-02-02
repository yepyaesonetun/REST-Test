package com.eg.mgr;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eg.dao.EmployeeDao;
import com.eg.data.EmployeeData;
import com.eg.data.Result;


public class EmployeeMgr {
	
  
   public static Result saveEmployeeData(EmployeeData data){	

		Result ret=new Result(); 
	    try {
			
			DAOManager l_DAO = new DAOManager();
			Connection l_Conn = null;
			data.setSyskey(1);
			String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
			data.setCreatedDate(date);
			data.setModifiedDate(date);
			data.setUserId("admin");
			data.setUserName("Administrator");
			data.setRecordStatus(1);
			data.setSyncBatch(0);
			data.setSyncStatus(1);


			l_Conn=l_DAO.CreateConnection();
			ret = EmployeeDao.saveEmployee(data, l_Conn);
						
			if(!l_Conn.isClosed())
			    l_Conn.close();
			
		  } catch (SQLException e) {
			  
				e.printStackTrace();
		 }
			return ret;
	  }
   
	
   
	public static EmployeeData getEmployeeDataByName(String name) {
		
		EmployeeData ret=new EmployeeData(); 
		DAOManager l_DAO = new DAOManager();
		Connection l_Conn = null;
		
		try{
			
		    l_Conn = l_DAO.CreateConnection();
		    ret = EmployeeDao.getEmployeeDataByName(name, l_Conn);
		    if(!l_Conn.isClosed())
				l_Conn.close();
				
		}catch(SQLException e){
			
			e.printStackTrace();		
		}
		
		return ret;
	}
	
	
   
}
