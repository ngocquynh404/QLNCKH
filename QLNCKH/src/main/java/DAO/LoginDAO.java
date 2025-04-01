package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.taikhoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class LoginDAO {
	public taikhoan validate(taikhoan loginBean) throws ClassNotFoundException{
		 taikhoan tk =null;
		 
	        try (
	        	Connection connection = JDBCUtil.getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from taikhoan where UserName = ? and Password = ? ")) {	        	
	        	preparedStatement.setString(1, loginBean.getUserName());	  
	            preparedStatement.setString(2, loginBean.getPassword());   
	            //System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            while(rs.next())
	            {
	            	tk =new taikhoan();
	            	tk.setUserName(rs.getString(2));
	            	//tk.setPassword(rs.getString(4));
	            	tk.setMaLTK(rs.getString(5));
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            HandleExeption.printSQLException(e);
	        }
	        return tk;
	}
}
