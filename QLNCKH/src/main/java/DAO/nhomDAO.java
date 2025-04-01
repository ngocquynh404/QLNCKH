package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.nhom;
import Util.HandleExeption;
import Util.JDBCUtil;

public class nhomDAO {
	
	Connection connection = JDBCUtil.getConnection();
	private static final String Themnhom ="INSERT INTO nhom" + "(MaNhom,MSSV1,MSSV2,MSSV3,MSSV4,MSSV5,MSGV) VALUES"
			+ "(?,?,?,?,?,?,?);";
	private static final String Chonnhom ="SELECT * FROM nhom where MaNhom =? ;";
	private static final String Xoanhom ="DELETE FROM nhom where MaNhom=?;";
	private static final String Suanhom = "update nhom set MSSV1=?,MSSV2=?,MSSV3=?,MSSV4=?,MSSV5=?,MSGV=? where MaNhom=?;";
	private static final String Chonallnhom = "SELECT * FROM nhom;";
	
	public void insertNhom (nhom Nhom) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themnhom);
			state.setString(1, Nhom.getManhom());
			state.setString(2, Nhom.getMssv1());
			state.setString(3, Nhom.getMssv2());
			state.setString(4, Nhom.getMssv3());
			state.setString(5, Nhom.getMssv4());
			state.setString(6, Nhom.getMssv5());
			state.setString(7, Nhom.getMsgv());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetNhom(nhom Nhom) throws SQLException
	{
		try{ 
				Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Suanhom);
				state.setString(1, Nhom.getManhom());
				state.setString(2, Nhom.getMssv1());
				state.setString(3, Nhom.getMssv2());
				state.setString(4, Nhom.getMssv3());
				state.setString(5, Nhom.getMssv4());
				state.setString(6, Nhom.getMssv5());
				state.setString(7, Nhom.getMsgv());
				state.executeUpdate();
		}	catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}						
	}
	public nhom selectNhom(String MaNhom)
	{	
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonnhom);
			state.setString(1, MaNhom);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				return new nhom(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7));	
							
			}
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		return null;
	}
	public List<nhom> selectallNhom()
	{
		List<nhom> Nhom = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonallnhom);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaNhom= rs.getString("MaNhom");
				String MSSV1 = rs.getString("MSSV1");
				String MSSV2 = rs.getString("MSSV2");
				String MSSV3 = rs.getString("MSSV3");
				String MSSV4 = rs.getString("MSSV4");
				String MSSV5 = rs.getString("MSSV5");
				String MSGV = rs.getString("MSGV");
				Nhom.add(new nhom(MaNhom,MSSV1,MSSV2,MSSV3,MSSV4,MSSV5,MSGV));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return Nhom;
	}
	public void deleteNhom (String MaNhom) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();	
			PreparedStatement state = connection.prepareStatement(Xoanhom);
			state.setString(1, MaNhom);			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
		
}
