package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.baocaotiendo_giaidoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class baocaotiendo_giaidoanDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themtiendo ="INSERT INTO baocaotiendo" + "(MaGiaiDoan,MaDeTai,GiaiDoan,NgayBatDau,NgayKetThuc,LinkBaoCao) VALUES"
			+ "(?,?,?,?,?,?);";
	private static final String Chontiendo ="SELECT * FROM baocaotiendo where MaGiaiDoan=?";
	private static final String Xoatiendo ="DELETE FROM baocaotiendo where MaGiaiDoan=? and MaDeTai =?;";
	private static final String Suatiendo = "update baocaotiendo set MaDeTai=?,GiaiDoan=?,NgayBatDau=?,NgayKetThuc=?,LinkBaoCao=? where MaGiaiDoan=?;";
	private static final String Chonalltiendo = "SELECT * FROM baocaotiendo;";
	
	public void insertTiendo (baocaotiendo_giaidoan TienDo) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themtiendo);
			state.setString(1,TienDo.getMagiaidoan());
			state.setString(2,TienDo.getMadetai());
			state.setString(3,TienDo.getGiaidoan());
			state.setString(4,TienDo.getNgaybatdau());
			state.setString(5,TienDo.getNgayketthuc());
			state.setString(6,TienDo.getLinkbaocao());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetTiendo(baocaotiendo_giaidoan TienDo) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suatiendo);
			state.setString(6,TienDo.getMagiaidoan());
			state.setString(1,TienDo.getMadetai());
			state.setString(2,TienDo.getGiaidoan());
			state.setString(3,TienDo.getNgaybatdau());
			state.setString(4,TienDo.getNgayketthuc());
			state.setString(5,TienDo.getLinkbaocao());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}	
	}
	
	public baocaotiendo_giaidoan selectTiendo(String MaGiaiDoan)
	{	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chontiendo);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				return new baocaotiendo_giaidoan (
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
	public List<baocaotiendo_giaidoan> selectallTiendo()
	{
		List<baocaotiendo_giaidoan> TienDo = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonalltiendo);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaGiaiDoan= rs.getString("MaGiaiDoan");
				String MaDeTai = rs.getString("MaDeTai");
				String GiaiDoan = rs.getString("GiaiDoan");
				String NgayBatDau = rs.getString("NgayBatDau");
				String NgayKetThuc = rs.getString("NgayKetThuc");
				String LinkBaoCao = rs.getString("LinkBaoCao");
				TienDo.add(new baocaotiendo_giaidoan(MaGiaiDoan,MaDeTai,GiaiDoan,NgayBatDau,NgayKetThuc,LinkBaoCao));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return TienDo;
	}
	public void deleteTiendo (String MaGiaiDoan) throws SQLException
	{
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoatiendo);
		
			state.setString(1, MaGiaiDoan);
			
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		
	}
}
