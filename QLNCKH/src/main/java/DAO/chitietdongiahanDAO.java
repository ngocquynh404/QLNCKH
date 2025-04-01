package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.chitietdongiahan;
import Models.hoidongnghiemthu;
import Util.HandleExeption;
import Util.JDBCUtil;

public class chitietdongiahanDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themdongiahan ="INSERT INTO chitietdongiahan" + "(MaChiTiet,MSGV,MaDeTai,NgayGiaHan,NgayHoanThanhCu,NgayHoanThanhMoi,LinkDonXin,IsAccept) VALUES"
			+ "(?,?,?,?,?,?,?);";
	private static final String Chondongiahan ="SELECT * FROM chitietdongiahan where MaChitiet=?;";
	private static final String Xoadongiahan ="DELETE FROM chitietdongiahan where MaChiTiet=?;";
	private static final String Suadongiahan = "update chitietdongiahan set MSGV=?,MaDeTai=?,NgayGiaHan=?,NgayHoanThanhCu=?,NgayHoanThanhMoi=?,LinkDonXin=?,IsAccept=? where MaChiTiet=?;";
	private static final String Chonalldongiahan = "SELECT * FROM chitietdongiahan;";
	
	public void insertDongiahan (chitietdongiahan DonGiaHan) throws SQLException
	{
		try {Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Themdongiahan);
				state.setString(1, DonGiaHan.getMachitiet());
				state.setString(2, DonGiaHan.getMsgv());
				state.setString(3, DonGiaHan.getMadetai());
				state.setString(4, DonGiaHan.getNgaygiahan());
				state.setString(5, DonGiaHan.getNgaynhoanthanhcu());
				state.setString(6, DonGiaHan.getNgayhoanthanhmoi());
				state.setString(7, DonGiaHan.getLinkdonxin());
				state.setString(8, DonGiaHan.getIsaccept());
		
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetDongiahan(chitietdongiahan DonGiaHan) throws SQLException
	{
	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suadongiahan);
			state.setString(8, DonGiaHan.getMachitiet());
			state.setString(1, DonGiaHan.getMsgv());
			state.setString(2, DonGiaHan.getMadetai());
			state.setString(3, DonGiaHan.getNgaygiahan());
			state.setString(4, DonGiaHan.getNgaynhoanthanhcu());
			state.setString(5, DonGiaHan.getNgayhoanthanhmoi());
			state.setString(6, DonGiaHan.getLinkdonxin());
			state.setString(7, DonGiaHan.getIsaccept());
			state.executeUpdate();
		}	catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}					
		
	}
	
	public chitietdongiahan selectDongiahan(String MaChiTiet)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chondongiahan);
			state.setString(1, MaChiTiet);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				return new chitietdongiahan (
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						);		
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		 return null;
	}
	public List<chitietdongiahan> selectallDongiahan()
	{
		List<chitietdongiahan> DonGiaHan = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonalldongiahan);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaChiTiet= rs.getString("MaChiTiet");
				String MSGV = rs.getString("MSGV");
				String MaDeTai = rs.getString("MaDeTai");
				String NgayGiaHan = rs.getString("NgayGiaHan");
				String NgayHoanThanhCu = rs.getString("NgayHoanThanhCu");
				String NgayHoanThanhMoi = rs.getString("NgayHoanThanhMoi");
				String LinkDonXin = rs.getString("LinkDonXin");
				String IsAccept = rs.getString("IsAccept");
				DonGiaHan.add(new chitietdongiahan(MaChiTiet,MSGV,MaDeTai,NgayGiaHan,NgayHoanThanhCu,NgayHoanThanhMoi,LinkDonXin,IsAccept) );
				
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return DonGiaHan;
	}
	public void deleteDongiahan (String MaChiTiet) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoadongiahan);		
			state.setString(1, MaChiTiet);			
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}	
	}
}
