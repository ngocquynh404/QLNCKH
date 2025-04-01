package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.baocaotiendo;
import Models.baocaotiendo_giaidoan;
import Util.HandleExeption;
import Util.JDBCUtil;

public class baocaotiendoDAO {
	Connection connection = JDBCUtil.getConnection();
	private static final String Themtiendo ="INSERT INTO baocaotiendo" + "(MaBaoCao,MaDeTai,MaGiaiDoan) VALUES"
			+ "(?,?,?,?,?,?);";
	private static final String Chontiendo ="SELECT * FROM baocaotiendo where =? ;";
	private static final String Xoatiendo ="DELETE FROM baocaotiendo where MaGiaiDoan=?;";
	private static final String Suatiendo = "update baocaotiendo set MaDeTai=?,MaGiaiDoan=? where MaBaoCao=?;";
	private static final String Chonalltiendo = "SELECT * FROM baocaotiendo;";
	
	public void insertTiendo (baocaotiendo TienDo) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Themtiendo);
			state.setString(1,TienDo.getMabaocao());
			state.setString(2,TienDo.getMadetai());
			state.setString(3,TienDo.getMagiaidoan());
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
	}
	
	public void updatetTiendo(baocaotiendo TienDo) throws SQLException
	{
	
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Suatiendo);
			state.setString(3,TienDo.getMabaocao());
			state.setString(1,TienDo.getMadetai());
			state.setString(2,TienDo.getMagiaidoan());
			state.executeUpdate();
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}						
	}
	
	public baocaotiendo selectTiendo(String MaBaoCao)
	{	
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chontiendo);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				return new baocaotiendo (
						rs.getString(1),
						rs.getString(2),
						rs.getString(3));				
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return null;
		
		
	}
	public List<baocaotiendo> selectallTiendo()
	{
		List<baocaotiendo> TienDo = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Chonalltiendo);
			ResultSet rs =state.executeQuery();
			while (rs.next()) 
			{
				String MaBaoCao= rs.getString("MaBaoCao");
				String MaDeTai = rs.getString("MaDeTai");
				String MaGiaiDoan = rs.getString("MaGiaiDoan");
				
				TienDo.add(new baocaotiendo(MaBaoCao,MaDeTai,MaGiaiDoan));
			}
			
		}catch (SQLException exception) {
            HandleExeption.printSQLException(exception);
					
			}
		return TienDo;
	}
	public void deleteTiendo (String MaBaoCao) throws SQLException
	{
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement state = connection.prepareStatement(Xoatiendo);		
			state.setString(1, MaBaoCao);	
		}catch(SQLException exception) {
			HandleExeption.printSQLException(exception);
		}
		
	}

}
