package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Models.detai;
import Util.HandleExeption;
import Util.JDBCUtil;

public class detaiDAO {   
	Connection connection = JDBCUtil.getConnection();
	private static final String Themdetai ="INSERT INTO detai" + "(MaDeTai,TenDeTai,Makhoa,MSGV,NgayThucHien,NgayKetThuc,KinhPhiDuKien,LinkDeTai) VALUES"
	+"(?,?,?,?,?,?,?,?);";
	
	private static final String Chondetai ="SELECT MaDeTai,TenDeTai,Makhoa,MSGV,NgayThucHien,NgayKetThuc,KinhPhiDuKien,LinkDeTai FROM detai where MaDeTai =?;";
	private static final String Xoadetai = "DELETE from detai where MaDeTai =?;";
	private static final String Chinhdetai = "update detai set TenDeTai=?,Makhoa=?,MSGV=?,NgayThucHien=?,NgayKetThuc=?,KinhPhiDuKien=?,LinkDeTai=? where MaDeTai=?;";
	private static final String Chonalldetai ="SELECT MaDeTai,TenDeTai,Makhoa,MSGV,NgayThucHien,NgayKetThuc,KinhPhiDuKien,LinkDeTai FROM detai;";
	
	public void insertDetai (detai DeTai) throws SQLException
	{
		 //System.out.println(Themdetai);
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement pre = connection.prepareStatement(Themdetai))
		{
			pre.setString(1, DeTai.getTendetai());
			pre.setString(2, DeTai.getmakhoa());
			pre.setString(3, DeTai.getMsgv());
			pre.setString(4,DeTai.getNgayketthuc());
			pre.setString(5, DeTai.getNgayketthuc());
			pre.setString(6, DeTai.getKinhphidukien());
			pre.setString(7, DeTai.getLinkdetai());
			//System.out.println(pre);
			pre.executeUpdate();
		} catch (SQLException e)
			{
			 HandleExeption.printSQLException(e);
			}
		}
	//update
	public boolean updatetDetai (detai DeTai) throws SQLException
	{
		boolean rowUpdate;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement pre = connection.prepareStatement(Chinhdetai);)
		{
			
			pre.setString(1, DeTai.getTendetai());
			pre.setString(2, DeTai.getmakhoa());
			pre.setString(3, DeTai.getMsgv());
			pre.setString(4,DeTai.getNgayketthuc());
			pre.setString(5, DeTai.getNgayketthuc());
			pre.setString(6, DeTai.getKinhphidukien());
			pre.setString(7, DeTai.getLinkdetai());
			pre.setString(8, DeTai.getMadetai());
			//System.out.println(pre);	
			 rowUpdate =  pre.executeUpdate()>0;
		} 
		
		return rowUpdate;
	}
	//select theo id
	public detai selectdetai(String MaDeTai)
	{
		detai DeTai =null;
		try {Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Chondetai);
		{
			state.setString(1, MaDeTai);
			//System.out.println(state);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				String MaDetai = rs.getString("MaDeTai");
				String TenDeTai = rs.getString("TenDeTai");
				String Makhoa = rs.getString("Makhoa");
				String MSGV = rs.getString("MSGV");
				String NgayThucHien = rs.getString("NgayThucHien");
				String NgayKetThuc = rs.getString("NgayKetThuc");
				String KinhPhiDuKien = rs.getString("KinhPhiDuKien");
				String LinkDeTai = rs.getString("LinkDeTai");
				DeTai = new detai(MaDetai,TenDeTai,Makhoa,MSGV,NgayThucHien,NgayKetThuc,KinhPhiDuKien,LinkDeTai);
				return DeTai;
			}
		}
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}	
		return null;	
	}
	public List<detai> selectalldetai()
	{
		List<detai> DeTai = new ArrayList<>();
		
		try {
			Connection connection = JDBCUtil.getConnection();		
			PreparedStatement state = connection.prepareStatement(Chonalldetai);			
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				String MaDeTai = rs.getString("MaDeTai");
				String TenDeTai = rs.getString("TenDeTai");
				String Makhoa = rs.getString("Makhoa");
				String LinkDeTai = rs.getString("LinkDeTai");
				String NgayThucHien = rs.getString("NgayThucHien");
				String NgayKetThuc = rs.getString("NgayKetThuc");
				String KinhPhiDuKien = rs.getString("KinhPhiDuKien");
				String MSGV = rs.getString("MSGV");
				DeTai.add(new detai(MaDeTai,TenDeTai,Makhoa,MSGV,NgayThucHien,NgayKetThuc,KinhPhiDuKien,LinkDeTai));
			}
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}	
		return DeTai;	
	}
	public boolean deletedetai (String MaDeTai) throws SQLException
	{
		boolean rowdelete;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Xoadetai);)
		{
			state.setString(1,MaDeTai);
			rowdelete = state.executeUpdate()>0;
		}
		return rowdelete;
	}
	
}
