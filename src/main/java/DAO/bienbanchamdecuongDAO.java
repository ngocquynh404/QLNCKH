package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.bienbanchamdecuong;
import Util.HandleExeption;
import Util.JDBCUtil;

public class bienbanchamdecuongDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Thembienban ="INSERT INTO bienbanchamdecuong" + "(MaBienBan,MaDeTai,Diem,DanhGia,LinkBienBan) VALUES"
			+ "(?,?,?,?,?);";
	private static final String Chonbienban ="SELECT * FROM bienbanchamdecuong where MaBienBan =? ;";
	private static final String Xoabienban ="DELETE FROM bienbanchamdecuong where MaBienBan=?;";
	private static final String Suabienban = "update bienbanchamdecuong set MaDeTai=?,Diem=?,DanhGia=?,LinkBienBan=? where MaBienBan=?;";
	private static final String Chonallbienban = "SELECT * FROM bienbanchamdecuong;";
	
	public void insertBienban (bienbanchamdecuong BienBan) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Thembienban);
			state.setString(1,BienBan.getMabienban());
			state.setString(2,BienBan.getMadetai());
			state.setString(3,BienBan.getDiem());
			state.setString(4,BienBan.getDanhgia());
			state.setString(5,BienBan.getLinkbienban());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetBienban(bienbanchamdecuong BienBan) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suabienban);
			state.setString(5,BienBan.getMabienban());
			state.setString(1,BienBan.getMadetai());
			state.setString(2,BienBan.getDiem());
			state.setString(3,BienBan.getDanhgia());
			state.setString(4,BienBan.getLinkbienban());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}	
	}
	
	public bienbanchamdecuong selectBienban(String MaHDNT)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonbienban);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				return new bienbanchamdecuong (
						rs.getString(1),
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
	public List<bienbanchamdecuong> selectallBienban()
	{
		List<bienbanchamdecuong> BienBan = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonallbienban);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaBienBan= rs.getString("MaBienBan");
				String MaDeTai = rs.getString("MaDeTai");
				String Diem = rs.getString("Diem");
				String DanhGia = rs.getString("NgayGiaHan");
				String LinkBienBan = rs.getString("NgayHoanThanhCu");
				BienBan.add(new bienbanchamdecuong(MaBienBan,MaDeTai,Diem,DanhGia,LinkBienBan));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return BienBan;
	}
	public void deleteBienban (String MaBienBan) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoabienban);		
			state.setString(1, MaBienBan);			
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}
}
