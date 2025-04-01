package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.baocaotiendo;
import Models.thongbao;
import Util.HandleExeption;
import Util.JDBCUtil;

public class thongbaoDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themthongbao ="INSERT INTO thongbao" + "(MaTB,TenTB,NoiDung,NgayGui,MaTK) VALUES"
			+ "(?,?,?,?,?);";
	private static final String Chonthongbao ="SELECT MaTB,TenTB,NoiDung,NgayGui FROM thongbao where MaTK =? ;";
	private static final String Xoathongbao ="DELETE FROM thongbao where MaTB=?;";
	private static final String Chonallthongbao = "SELECT * FROM thongbao where MaTK=?;";
	
	public void insertThongbao (thongbao ThongBao) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themthongbao);
			state.setString(1,ThongBao.getMathongbao());
			state.setString(2,ThongBao.getTenthongbao());
			state.setString(3,ThongBao.getNoidung());
			state.setString(4,ThongBao.getNgaygui());
			state.setString(5,ThongBao.getMatk());
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	//public boolean updatetThongbao(thongbao Nhom) throws SQLException
	//{
	//	boolean rowUpdate;
	//	try (Connection connection = JDBCUtil.getConnection();
		//		PreparedStatement state = connection.prepareStatement(Suanhom);)
	//	{
		//	rowUpdate= state.executeUpdate()>0;
		//}						
		//return rowUpdate;
	//}
	// chon thong bao nay nen chon theo tai khoan
	public thongbao selectThongbao(String MaTB)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Chonthongbao);
				ResultSet rs =state.executeQuery();
				while (rs.next()) 
				{
					return new thongbao (
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(3),
							rs.getString(3));				
				}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		 return null;
	}
	public List<thongbao> selectallThongbao(String MaTK)
	{
		List<thongbao> ThongBao = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonallthongbao);
			state.setString(1, MaTK);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaTB= rs.getString("MaTB");
				String TenTB = rs.getString("TenTB");
				String NoiDung = rs.getString("NoiDung");
				String NgayGui = rs.getString("NgayGui");
				ThongBao.add(new thongbao(MaTB,TenTB,NoiDung,NgayGui,MaTK));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return ThongBao;
	}
	public void deleteThongbao (String MaTB) throws SQLException
	{
		
		try { Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Xoathongbao);		
			state.setString(1, MaTB);
			
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		
	}
}
