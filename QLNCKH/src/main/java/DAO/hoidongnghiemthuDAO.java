package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Models.hoidongnghiemthu;
import Util.HandleExeption;
import Util.JDBCUtil;

public class hoidongnghiemthuDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themhoidong ="INSERT INTO hoidongnghiemthu" + "(MaHDNT,TenHD,ChuTich,PhanBien1,PhanBien2,ThuKy,NgayNghiemThu) VALUES"
			+ "(?,?,?,?,?,?,?);";
	private static final String Chonhoidong ="SELECT * FROM hoidongnghiemthu where MaHDNT =? ;";
	private static final String Xoahoidong ="DELETE FROM hoidongnghiemthu where MaHDNT=?;";
	private static final String Suahoidong = "update hoidongnghiemthu set TenHD=?,ChuTich=?,PhanBien1=?,PhanBien2=?,ThuKy=?,NgayNghiemThu=?  where MaHDNT=?;";
	private static final String Chonallhoidong = "SELECT * FROM hoidongnghiemthu;";
	
	public void insertHoidong (hoidongnghiemthu HoiDong) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themhoidong);
			state.setString(1, HoiDong.getMahdnt());
			state.setString(2, HoiDong.getTenhd());
			state.setString(3, HoiDong.getChutich());
			state.setString(4, HoiDong.getPhanbien1());
			state.setString(5, HoiDong.getPhanbien2());
			state.setString(6, HoiDong.getThuky());
			state.setString(7, HoiDong.getNgaynghiemthu());
			
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetHoidong(hoidongnghiemthu HoiDong) throws SQLException
	{

		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suahoidong);
			state.setString(1, HoiDong.getMahdnt());
			state.setString(2, HoiDong.getTenhd());
			state.setString(3, HoiDong.getChutich());
			state.setString(4, HoiDong.getPhanbien1());
			state.setString(5, HoiDong.getPhanbien2());
			state.setString(6, HoiDong.getThuky());
			state.setString(7, HoiDong.getNgaynghiemthu());
			state.executeUpdate();
		}	catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}					
		
	}
	
	public hoidongnghiemthu selectHoidong(String MaHDNT)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonhoidong);
			state.setString(1, MaHDNT);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				return new hoidongnghiemthu (
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
	public List<hoidongnghiemthu> selectallHoidong()
	{
		List<hoidongnghiemthu> HoiDong = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonallhoidong);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaHDNT= rs.getString("MaHDNT");
				String TenHD = rs.getString("TenHD");
				String ChuTich = rs.getString("ChuTich");
				String PhanBien1 = rs.getString("PhanBien1");
				String PhanBien2 = rs.getString("PhanBien2");
				String ThuKy = rs.getString("ThuKy");
				String NgayNghiemThu = rs.getString("NgayNghiemThu");
				HoiDong.add(new hoidongnghiemthu(MaHDNT,TenHD,ChuTich,PhanBien1,PhanBien2,ThuKy,NgayNghiemThu) );
				
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return HoiDong;
	}
	public void deleteHoidong (String MaHDNT) throws SQLException
	{
	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoahoidong);
			state.setString(1, MaHDNT);
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	}

}
