package com.eg.service;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest; 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import com.eg.data.EmployeeData;
import com.eg.data.Result;
import com.eg.mgr.DAOManager;
import com.eg.mgr.EmployeeMgr;


@Path("/empservice")
public class EmployeeService {
	
		@Context
		HttpServletRequest request;
		
		@Context
		HttpServletRequest response;
		
		@javax.ws.rs.core.Context 
		ServletContext context;
		

		@POST
		@Path("saveEmployeeData")
		@Produces(MediaType.APPLICATION_JSON)    
		@Consumes(MediaType.APPLICATION_JSON)
		public Result saveEmployeeData(EmployeeData data){
		
			Result res = new Result();
			DAOManager.AbsolutePath = context.getRealPath("");
			res= EmployeeMgr.saveEmployeeData(data);
			return res;	
					
		}
				
		
		@GET
		@Path("getEmployeeData")
		@Produces(MediaType.APPLICATION_JSON)
		public EmployeeData getEmployeeDataByName() { 
			
			EmployeeData res = new EmployeeData(); 
			DAOManager.AbsolutePath = context.getRealPath("");
			String nameval = request.getParameter("name");
			res = EmployeeMgr.getEmployeeDataByName(nameval);
			return res;
						
		}
		
		
		

}