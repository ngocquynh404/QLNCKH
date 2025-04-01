package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.hoidongduyetdecuong;
import Util.HandleExeption;
import Util.JDBCUtil;

public class hoidongduyetdecuongDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themhoidong ="INSERT INTO hoidongduyetdecuong" + "(MaHDDDT,TenHD,MSGV1,MSGV2,MSGV3,MSGV4) VALUES"
			+ "(?,?,?,?,?,?);";
	private static final String Chonhoidong ="SELECT * FROM hoidongduyetdecuong where MaHDDDT =? ;";
	private static final String Xoahoidong ="DELETE FROM hoidongduyetdecuong where MaHDDDT=?;";
	private static final String Suahoidong = "update hoidongduyetdecuong set TenHD=?,MSGV1=?,MSGV2=?,MSGV3=?,MSGV4=? where MaHDNT=?;";
	private static final String Chonallhoidong = "SELECT * FROM hoidongduyetdecuong;";
	
	public void insertHoidong (hoidongduyetdecuong HoiDong) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themhoidong);
			state.setString(1, HoiDong.getMahdddt());
			state.setString(2, HoiDong.getTenhd());
			state.setString(3, HoiDong.getMsgv1());
			state.setString(4, HoiDong.getMsgv2());
			state.setString(5, HoiDong.getMsgv3());
			state.setString(6, HoiDong.getMsgv4());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetHoidong(hoidongduyetdecuong HoiDong) throws SQLException
	{
	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suahoidong);
			state.setString(6, HoiDong.getMahdddt());
			state.setString(1, HoiDong.getTenhd());
			state.setString(2, HoiDong.getMsgv1());
			state.setString(3, HoiDong.getMsgv2());
			state.setString(4, HoiDong.getMsgv3());
			state.setString(5, HoiDong.getMsgv4());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}					
		
	}
	
	public hoidongduyetdecuong selectHoidong(String MaHDDDT)
	{	
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonhoidong);
			state.setString(1, MaHDDDT);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				return new hoidongduyetdecuong (
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)	
						);	
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
            
			}
		
		 return null;
	}
	public List<hoidongduyetdecuong> selectallHoidong()
	{
		List<hoidongduyetdecuong> HoiDong = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonallhoidong);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
			String MaHDDDT= rs.getString("MaHDDDT");
			String TenHD = rs.getString("TenHD");
			String MSGV1= rs.getString("MSGV1");
			String MSGV2 = rs.getString("MSGV2");
			String MSGV3 = rs.getString("MSGV3");
			String MSGV4 = rs.getString("MSGV4");
			HoiDong.add(new hoidongduyetdecuong(MaHDDDT,TenHD,MSGV1,MSGV2,MSGV3,MSGV4) );
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return HoiDong;
	}
	public void deleteHoidong (String MaHDDDT) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoahoidong);
			state.setString(1, MaHDDDT);
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
	
	}
}
