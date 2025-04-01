package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.nguoiquanly;
import Util.HandleExeption;
import Util.JDBCUtil;

public class nguoiquanlyDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themnguoiquanly ="INSERT INTO nguoiquanly" + "(MaQL,HoTen,NgaySinh,MaTK) VALUES"
			+ "(?,?,?);";
	private static final String Chonnguoiquanly ="SELECT * FROM nguoiquanly where MaQL;";
	private static final String Xoanguoiquanly ="DELETE FROM nguoiquanly where MaQL=?;";
	private static final String Suanguoiquanly = "update nguoiquanly set HoTen=?,NgaySinh=?,MaTK=? where MaQL=?;";
	private static final String Chonallnguoiquanly = "SELECT * FROM nguoiquanly;";
	
	public void insertNguoiquanly (nguoiquanly NguoiQuanLy) throws SQLException
	{
		try{ 
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themnguoiquanly);
			state.setString(1, NguoiQuanLy.getMaql());
			state.setString(2, NguoiQuanLy.getHoten());
			state.setString(3, NguoiQuanLy.getNgaysinh());
			state.setString(4, NguoiQuanLy.getMaql());
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetNguoiquanly (nguoiquanly NguoiQuanLy) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suanguoiquanly);
			state.setString(1,NguoiQuanLy.getHoten());		
			state.setString(2, NguoiQuanLy.getNgaysinh());
			state.setString(3, NguoiQuanLy.getMaql());
			state.setString(4, NguoiQuanLy.getMaql());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);				
			}							
	}
	public nguoiquanly selectNguoiquanly(String MaQL)
	{	
	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonnguoiquanly);
			state.setString(1, MaQL);
			ResultSet rs = state.executeQuery();
			while(rs.next())
			{
				return new nguoiquanly (
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
						
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		 return null;
	}
	public List<nguoiquanly> selectallNguoiquanly()
	{
		List<nguoiquanly> NguoiQuanLy = new ArrayList<>();
		try {
				Connection connection = JDBCUtil.getConnection();	
				PreparedStatement state = connection.prepareStatement(Chonallnguoiquanly);
				ResultSet rs =state.executeQuery();
				while (rs.next()) 
				{
					String MaQL = rs.getString("MaQL");
					String HoTen = rs.getString("HoTen");
					String NgaySinh = rs.getString("NgaySinh");
					String MaTK = rs.getString("MaTK");
					NguoiQuanLy.add(new nguoiquanly(MaQL,HoTen,NgaySinh,MaTK));
				}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return NguoiQuanLy;
	}
	public void deleteNguoiquanly (String MaQL) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoanguoiquanly);		
			state.setString(1, MaQL);			
			}catch(SQLException exception) {
				HandleExeption.printSQLException(exception);
			}
	}
}
