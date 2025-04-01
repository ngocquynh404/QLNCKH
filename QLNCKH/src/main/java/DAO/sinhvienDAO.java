package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.sinhvien;
import Util.HandleExeption;
import Util.JDBCUtil;

public class sinhvienDAO {

	Connection connection = JDBCUtil.getConnection();
	private static final String Themsinhvien ="INSERT INTO sinhvien" + "(MSSV,HoTen,NgaySinh,GioiTinh,CCCD,SDT,Email,DiaChi,MaNganh,Lop,NienKhoa,MaTK) VALUES"
			+ "(?,?,?,?,?,?,?,?,?,?,?,?);";
	private static final String Chonsinhvien ="SELECT * FROM sinhvien where MSSV=?;";
	private static final String Xoasinhvien ="DELETE FROM sinhvien where MSSV=?;";
	private static final String Suasinhvien = "update sinhvien set HoTen=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=?,Email=?,DiaChi=?,MaNganh=?,Lop=?,NienKhoa=?,MaTK =? where MSSV=?;";
	private static final String Chonallsinhvien = "SELECT * FROM sinhvien;";
	
	public void insertSinhvien (sinhvien SinhVien) throws SQLException
	{
		try {Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Themsinhvien);
				state.setString(1,SinhVien.getMssv());
				state.setString(2,SinhVien.getHoten());
				state.setString(3,SinhVien.getNgaysinh().toString());
				state.setString(4,SinhVien.getGioitinh());
				state.setString(5,SinhVien.getCccd());
				state.setString(6,SinhVien.getSdt());
				state.setString(7,SinhVien.getEmail());
				state.setString(8,SinhVien.getDiachi());
				state.setString(9,SinhVien.getManganh());
				state.setString(10,SinhVien.getLop());
				state.setString(11,SinhVien.getNienkhoa());
				state.setString(12,SinhVien.getMatk());
				state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetSinhvien (sinhvien SinhVien) throws SQLException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suasinhvien);
			state.setString(1, SinhVien.getHoten());
			String ngaySinhStr = sdf.format(SinhVien.getNgaysinh());
			state.setString(2, ngaySinhStr);
			state.setString(3, SinhVien.getGioitinh());
			state.setString(4, SinhVien.getCccd());
			state.setString(5, SinhVien.getSdt());
			state.setString(6, SinhVien.getEmail());
			state.setString(7, SinhVien.getDiachi());
			state.setString(8, SinhVien.getManganh());
			state.setString(9, SinhVien.getLop());
			state.setString(10, SinhVien.getNienkhoa());
			state.setString(11, SinhVien.getMatk());
			state.setString(12, SinhVien.getMssv());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}							
	}
	public sinhvien selectSinhvien(String MSSV)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonsinhvien);
			state.setString(1, MSSV);
			ResultSet rs = state.executeQuery();
			while(rs.next())
			{
				return new sinhvien(
						rs.getString(1),
						rs.getString(2),
						rs.getDate(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return null;
		 
	}
	public List<sinhvien> selectallSinhvien()
	{
		List<sinhvien> SinhVien = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
				PreparedStatement state = connection.prepareStatement(Chonallsinhvien);
				ResultSet rs =state.executeQuery();
				while (rs.next()) 
				{
					String MSSV = rs.getString("MSSV");
					String HoTen = rs.getString("HoTen");
					Date NgaySinh = rs.getDate("NgaySinh");
					String GioiTinh = rs.getString("GioiTinh");
					String CCCD = rs.getString("CCCD");
					String SDT = rs.getString("SDT");
					String Email = rs.getString("Email");
					String DiaChi = rs.getString("DiaChi");
					String MaNganh = rs.getString("MaNganh");
					String Lop = rs.getString("Lop");
					String NienKhoa = rs.getString("NienKhoa");
					String MaTK = rs.getString("MaTK");
					SinhVien.add(new sinhvien(MSSV,HoTen,NgaySinh,
							GioiTinh,CCCD,SDT,Email,DiaChi,MaNganh,
							Lop,NienKhoa,MaTK));
				
				}
			}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return SinhVien;
	}
	public void deleteSinhvien (String MSSV) throws SQLException
	{
	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoasinhvien);
		
			state.setString(1, MSSV);
			state.executeUpdate();
		} catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}	
		
	}
}
