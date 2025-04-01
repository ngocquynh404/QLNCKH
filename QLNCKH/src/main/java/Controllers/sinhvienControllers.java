package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.sinhvienDAO;

import Models.sinhvien;


@WebServlet("/")
public class sinhvienControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private sinhvienDAO SinhVienDAO;
    public sinhvienControllers() {
        this.SinhVienDAO = new sinhvienDAO();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		SinhVienDAO= new sinhvienDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/new":
                	showNewForm(request, response);
                    break;
                case "/insert":
                	insertsinhvien(request, response);
                    break;
                case "/delete":
                	deletesinhvien(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatesinhvien(request, response);
                    break;            
                default:                   
                	listsinhvien(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo-form.jsp");
		        dispatcher.forward(request, response);
		    }
	private void listsinhvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<sinhvien> SinhVien = SinhVienDAO.selectallSinhvien();
		request.setAttribute("listsinhvien", SinhVien);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletesinhvien (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MSSV = request.getParameter("mssv");
		SinhVienDAO.deleteSinhvien(MSSV);
		response.sendRedirect("list");
	}
	private void insertsinhvien (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MSSV = request.getParameter("lay txt");
		String HoTen = request.getParameter("lay txt");
		String ngaySinhStr = request.getParameter("lay txt");
		Date NgaySinh = null;

		if (ngaySinhStr != null && !ngaySinhStr.isEmpty()) {
		    try {
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        NgaySinh = sdf.parse(ngaySinhStr);
		    } catch (ParseException e) {
		        e.printStackTrace(); // Xử lý lỗi chuyển đổi chuỗi thành ngày tháng
		    }
		}
		String GioiTinh = request.getParameter("lay txt");
		String CCCD = request.getParameter("lay txt");
		String SDT = request.getParameter("lay txt");
		String Email = request.getParameter("lay txt");
		String DiaChi = request.getParameter("lay txt");
		String MaNganh = request.getParameter("lay txt");
		String Lop = request.getParameter("lay txt");
		String NienKhoa = request.getParameter("lay txt");
		String MaTK = request.getParameter("lay txt");
		sinhvien SV = new sinhvien(MSSV,HoTen,NgaySinh,GioiTinh,CCCD,SDT,Email,DiaChi,MaNganh,Lop,NienKhoa,MaTK);
		SinhVienDAO.insertSinhvien(SV);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MSSV = request.getParameter("mssv");
		sinhvienDAO dao = new sinhvienDAO();
		sinhvien s =dao.selectSinhvien(MSSV);
		request.setAttribute("sinhvien", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatesinhvien (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MSSV = request.getParameter("lay txt");
		String HoTen = request.getParameter("lay txt");
		String ngaySinhStr = request.getParameter("lay txt");
		Date NgaySinh = null;

		if (ngaySinhStr != null && !ngaySinhStr.isEmpty()) {
		    try {
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        NgaySinh = sdf.parse(ngaySinhStr);
		    } catch (ParseException e) {
		        e.printStackTrace(); // Xử lý lỗi chuyển đổi chuỗi thành ngày tháng
		    }
		}
		String GioiTinh = request.getParameter("lay txt");
		String CCCD = request.getParameter("lay txt");
		String SDT = request.getParameter("lay txt");
		String Email = request.getParameter("lay txt");
		String DiaChi = request.getParameter("lay txt");
		String MaNganh = request.getParameter("lay txt");
		String Lop = request.getParameter("lay txt");
		String NienKhoa = request.getParameter("lay txt");
		String MaTK = request.getParameter("lay txt");
		sinhvienDAO dao = new sinhvienDAO();
		sinhvien SV = new sinhvien(MSSV,HoTen,NgaySinh,GioiTinh,CCCD,SDT,Email,DiaChi,MaNganh,Lop,NienKhoa,MaTK);
		dao.updatetSinhvien(SV);
		response.sendRedirect("list");		
	}
}
