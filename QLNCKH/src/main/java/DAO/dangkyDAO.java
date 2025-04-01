package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.dangky;
import Util.HandleExeption;
import Util.JDBCUtil;

public class dangkyDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themdangky ="INSERT INTO dangky" + "(MaDK,MaDeTai,MSGV,MaNhom,NgayDangKy,LinkDeCuong,GhiChu) VALUES"
			+ "(?,?,?,?,?,?,?);";
	private static final String Chondangky ="SELECT * FROM dangky where MaDK=?;";
	private static final String Xoadangky ="DELETE FROM dangky where MaQL=?;";
	private static final String Suadangky = "update dangky set HoTen=?,NgaySinh=?,MaTK=? where MaQL=?;";
	private static final String Chonalldangky = "SELECT * FROM dangky;";
	
	public void insertDangky (dangky DangKy) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themdangky);
			state.setString(1, DangKy.getMadk());
			state.setString(2, DangKy.getMadetai());
			state.setString(3, DangKy.getMsgv());
			state.setString(4, DangKy.getManhom());
			state.setString(5, DangKy.getNgaydangky());
			state.setString(6, DangKy.getLinkdecuong());
			state.setString(7, DangKy.getGhichu());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetDangky (dangky DangKy) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suadangky);
			state.setString(1,DangKy.getMadetai());		
			state.setString(2, DangKy.getMsgv());
			state.setString(3, DangKy.getManhom());
			state.setString(4, DangKy.getNgaydangky());
			state.setString(5, DangKy.getLinkdecuong());
			state.setString(6, DangKy.getGhichu());
			state.setString(7, DangKy.getMadk());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}	
	}
	public dangky selectDangky(String MaDK)
	{	
		
		try {Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Chondangky);
				state.setString(1, MaDK);
				ResultSet rs = state.executeQuery();
				while (rs.next())
				{
					return new dangky(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7)
							);		
				}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		 return null;
	}
	public List<dangky> selectallDangky()
	{
		List<dangky> DangKy = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonalldangky);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaDK= rs.getString("MaDK");
				String MaDeTai = rs.getString("MaDeTai");
				String MSGV = rs.getString("MSGV");
				String MaNhom = rs.getString("MaNhom");
				String NgayDangKy = rs.getString("NgayDangKy");
				String LinkDeCuong = rs.getString("LinkDeCuong");
				String GhiChu = rs.getString("GhiChu");
				DangKy.add(new dangky(MaDK,MaDeTai,MSGV,MaNhom,NgayDangKy,LinkDeCuong,GhiChu));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return DangKy;
	}
	public void deleteDangky (String MaDK) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoadangky);		
			state.setString(1, MaDK);
			
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		
	}
}
