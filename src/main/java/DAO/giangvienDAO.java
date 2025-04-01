package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.giangvien;
import Util.HandleExeption;
import Util.JDBCUtil;

public class giangvienDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themgiangvien ="INSERT INTO giangvien" + "(MSGV,TenGiangVien,MaKhoa,TrinhDo,NgaySinh,CCCD,SDT,GioiTinh,DiaChi,MaTK) VALUES"
			+ "(?,?,?,?,?,?,?,?,?,?);";
	private static final String Chongiangvien ="SELECT * FROM giangvien where MSGV=?;";
	private static final String Xoagiangvien ="DELETE FROM giangvien where MSGV=?;";
	private static final String Suagiangvien = "update giangvien set TenGiangVien=?,MaKhoa=?,TrinhDo=?,NgaySinh=?,CCCD=?,SDT=?,GioiTinh=?,DiaChi=?,MaTK=? where MSGV=?;";
	private static final String Chonallgiangvien = "SELECT * FROM giangvien;";
	
	public void insertGiangvien (giangvien GiangVien) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themgiangvien);
			state.setString(1,GiangVien.getMsgv());
			state.setString(2,GiangVien.getTengiangvien());
			state.setString(3,GiangVien.getTrinhdo());
			state.setString(4,GiangVien.getTrinhdo());
			state.setString(5,GiangVien.getNgaysinh());
			state.setString(6,GiangVien.getCccd());
			state.setString(7,GiangVien.getSdt());
			state.setString(8,GiangVien.getGioitinh());
			state.setString(9,GiangVien.getDiachi());
			state.setString(10,GiangVien.getMatk());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetGiangvien (giangvien GiangVien) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suagiangvien);			
			state.setString(1,GiangVien.getTengiangvien());
			state.setString(2,GiangVien.getTrinhdo());
			state.setString(3,GiangVien.getTrinhdo());
			state.setString(4,GiangVien.getNgaysinh());
			state.setString(5,GiangVien.getCccd());
			state.setString(6,GiangVien.getSdt());
			state.setString(7,GiangVien.getGioitinh());
			state.setString(8,GiangVien.getDiachi());
			state.setString(9,GiangVien.getMatk());			
			state.setString(10,GiangVien.getMsgv());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}						
	}
	public giangvien selectGiangvien(String MSGV)
	{	
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chongiangvien);
			state.setString(1,MSGV);
			ResultSet rs = state.executeQuery();
			while (rs.next())
			{
				return new giangvien (
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		
		 return null;
	}
	public List<giangvien> selectallGiangvien()
	{
		List<giangvien> GiangVien = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonallgiangvien);
			ResultSet rs =state.executeQuery();
			while (rs.next())
			{
				String MSSV = rs.getString("MSGV");
				String TenGiangVien = rs.getString("TenGiangVien");
				String MaKhoa = rs.getString("MaKhoa");
				String TrinhDo = rs.getString("TrinhDo");
				String NgaySinh = rs.getString("NgaySinh");
				String CCCD = rs.getString("CCCD");
				String SDT = rs.getString("SDT");
				String GioiTinh = rs.getString("GioiTinh");
				String DiaChi = rs.getString("DiaChi");
				String MaTK = rs.getString("MaTK");
				GiangVien.add(new giangvien(MSSV,TenGiangVien,MaKhoa,TrinhDo,NgaySinh,CCCD,SDT,GioiTinh,DiaChi,MaTK));
				
			}
		
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return GiangVien;
	}
	public void deleteGiangvien (String MSGV) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();		
			PreparedStatement state = connection.prepareStatement(Xoagiangvien);		
			state.setString(1, MSGV);
			state.executeUpdate();
		}
			catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}	
		
	}
}
