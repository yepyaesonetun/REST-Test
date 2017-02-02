package com.eg.mgr;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import password.DESedeEncryption;


public class DAOManager {
	public static 	String Driver="";
	public static	String URL="";
	public static	String UserName="";
	public static	String Password="";
	public static String ConnString="";
	public static String AbsolutePath = "";
	DESedeEncryption myEncryptor;
	
	public 	DAOManager()
	{
		try {
			myEncryptor = new DESedeEncryption();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Loading Connection From Config Files
		ReadConnectionString();
		
		if (Driver.equals("")) {
			Driver="net.sourceforge.jtds.jdbc.Driver";
		}
		if (URL.equals("")) {			
			URL="jdbc:jtds:sqlserver://localhost:1433/MyDB;";
		}
		if (UserName.equals("")) {
			UserName="sa";
		}
		if (Password.equals("")) {
			Password="123";
		}
		
		if (ConnString.equals("")) {
		ConnString = "jdbc:sqlserver://localhost:1433;" +
        "databaseName=MyDB;user=sa;password=123";
		}
	}

	public Connection CreateConnection()
	{
		Connection conn=null;
		try {
			try {
				Class.forName(Driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(URL,UserName,Password);
			//conn=DriverManager.getConnection(ConnString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	 
	private void ReadConnectionString()
	{
		String l_Driver = "";
		String l_URL = "";
		String l_UserName = "";
		String l_Password = "";
		try {
			ArrayList<String> arl = readList(DAOManager.AbsolutePath +"/data/"+ "ConnectionConfig.txt");
			for (int i=0;i<arl.size();i++) {
				if (!arl.get(i).equals("")){
					if (arl.get(i).startsWith("Driver:")){
						l_Driver = arl.get(i).split("Driver:")[1];
					} else if (arl.get(i).startsWith("URL:")){
						l_URL = arl.get(i).split("URL:")[1];
					} else if (arl.get(i).startsWith("UserName:")){
						l_UserName = arl.get(i).split("UserName:")[1];
					} else if (arl.get(i).startsWith("Password:")){
						l_Password = arl.get(i).split("Password:")[1];
					}
				}
			}
			
			if ((!l_Driver.equals("")) && (!l_URL.equals("")) && (!l_UserName.equals("")) && (!l_Password.equals(""))) {
				DAOManager.Driver = l_Driver.trim();
				DAOManager.URL = l_URL.trim();
				DAOManager.UserName = l_UserName.trim();
				DAOManager.Password = myEncryptor.decrypt(l_Password.trim());
				
				//X.say(DAOManager.Driver);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> readList(String strPath){
        ArrayList<String> arlTemp=new ArrayList<String> ();
        try {
            BufferedReader in = new BufferedReader(new FileReader(strPath));
            String str;
            while ((str = in.readLine()) != null) {
                String strOK= str;
                arlTemp.add(strOK);
            }
            in.close();
        }catch (Exception e) 
        { 
        	System.out.println(e.getMessage());
        }
        return arlTemp;
    }
    
	
   

}
