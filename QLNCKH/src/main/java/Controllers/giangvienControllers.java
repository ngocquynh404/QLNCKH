package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.giangvienDAO;
import Models.giangvien;

/**
 * Servlet implementation class giangvienControllers
 */
@WebServlet("/")
public class giangvienControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private giangvienDAO GiangVienDAO;
       
    public giangvienControllers() {
        this.GiangVienDAO = new giangvienDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		GiangVienDAO = new giangvienDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/new":
                	showNewForm(request, response);
                    break;
                case "/insert":
                	insertgiangvien(request, response);
                    break;
                case "/delete":
                	deletegiangvien(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updategiangvien(request, response);
                    break;            
                default:                   
                	listgiangvien(request, response);
                    break;
            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("?");
		        dispatcher.forward(request, response);
		    }
	private void listgiangvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<giangvien> GiangVien = GiangVienDAO.selectallGiangvien();
		request.setAttribute("listgiangvien", GiangVien);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletegiangvien (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MSGV = request.getParameter("msgv");
		GiangVienDAO.deleteGiangvien(MSGV);
		response.sendRedirect("list");
	}
	private void insertgiangvien (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MSGV = request.getParameter("lay txt");
		String HoTenGiangVien = request.getParameter("lay txt");
		String MaKhoa = request.getParameter("lay txt");
		String TrinhDo = request.getParameter("lay txt");
		String NgaySinh = request.getParameter("lay txt");
		String CCCD = request.getParameter("lay txt");
		String SDT = request.getParameter("lay txt");
		String GioiTinh = request.getParameter("lay txt");
		String DiaChi = request.getParameter("lay txt");
		String MaTK = request.getParameter("lay txt");
		giangvien GV = new giangvien(MSGV,HoTenGiangVien,MaKhoa,TrinhDo,NgaySinh,CCCD,SDT,GioiTinh,DiaChi,MaTK);
		GiangVienDAO.insertGiangvien(GV);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MSGV = request.getParameter("msgv");
		giangvienDAO dao = new giangvienDAO();
		giangvien s =dao.selectGiangvien(MSGV);
		request.setAttribute("giangvien", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updategiangvien (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MSGV = request.getParameter("lay txt");
		String HoTenGiangVien = request.getParameter("lay txt");
		String MaKhoa = request.getParameter("lay txt");
		String TrinhDo = request.getParameter("lay txt");
		String NgaySinh = request.getParameter("lay txt");
		String CCCD = request.getParameter("lay txt");
		String SDT = request.getParameter("lay txt");
		String GioiTinh = request.getParameter("lay txt");
		String DiaChi = request.getParameter("lay txt");
		String MaTK = request.getParameter("lay txt");
		giangvienDAO dao = new giangvienDAO();
		giangvien GV = new giangvien(MSGV,HoTenGiangVien,MaKhoa,TrinhDo,NgaySinh,CCCD,SDT,GioiTinh,DiaChi,MaTK);
		dao.updatetGiangvien(GV);	
		response.sendRedirect("list");		
	}
}
