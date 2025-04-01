package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.taikhoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class taikhoanDAO {
	
	Connection connection = JDBCUtil.getConnection();
	private static final String Themtaikhoan ="INSERT INTO taikhoan" + "(MaTK,UserName,Email,Password,MaLTK) VALUES"
			+ "(?,?,?,?,?);";
	private static final String Chontaikhoan ="SELECT * FROM taikhoan where MaTK=? ;";
	private static final String Xoataikhoan ="DELETE FROM taikhoan where MaTK=?;";
	private static final String Suataikhoan = "update taikhoan set UserName=?,Email=?,Password=?,MaLTK=?  where MaTK=?;";
	private static final String Chonalltaikhoan = "SELECT * FROM taikhoan;";
	
	public void insertTaikhoan (taikhoan TaiKhoan) throws SQLException
	{
		try { Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Themtaikhoan);
				state.setString(1,TaiKhoan.getMaTK());
				state.setString(2,TaiKhoan.getUserName());
				state.setString(3,TaiKhoan.getEmail());
				state.setString(4,TaiKhoan.getPassword());
				state.setString(5,TaiKhoan.getMaLTK());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	public taikhoan selecttaikhoan(String MaTK)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chontaikhoan);
			ResultSet rs =state.executeQuery();
			while (rs.next())
			{
				return new taikhoan(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		 return null;
	}
	public void updatetTaikhoan(taikhoan TaiKhoan) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suataikhoan);
			state.setString(5,TaiKhoan.getMaTK());
			state.setString(1,TaiKhoan.getUserName());
			state.setString(2,TaiKhoan.getEmail());
			state.setString(3,TaiKhoan.getPassword());
			state.setString(4,TaiKhoan.getMaLTK());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}	
	}
	
	public List<taikhoan> selectallTaikhoan()
	{
		List<taikhoan> TaiKhoan = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonalltaikhoan);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaTK= rs.getString("MaTK");
				String UserName = rs.getString("UserName");
				String Email = rs.getString("Email");
				String Password = rs.getString("Password");
				String MaLTK = rs.getString("MaLTK");
				TaiKhoan.add(new taikhoan(MaTK,UserName,Email,Password,MaLTK));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return TaiKhoan;
	}
	public void deleteTaiKhoan (String MaTK) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoataikhoan);		
			state.setString(1, MaTK);	
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		
	}
	
}
