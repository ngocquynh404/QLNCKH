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

import DAO.dangkyDAO;

import Models.dangky;


/**
 * Servlet implementation class dangkyControllers
 */
@WebServlet("/")
public class dangkyControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private dangkyDAO DangKyDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyControllers() {
        this.DangKyDAO = new dangkyDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		DangKyDAO= new dangkyDAO();
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
                	insertdangky(request, response);
                    break;
                case "/delete":
                	deletedangky(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatedangky(request, response);
                    break;            
                default:                   
                	listdangky(request, response);
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
	private void listdangky(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<dangky> DangKy = DangKyDAO.selectallDangky();
		request.setAttribute("listnguoiquanly", DangKy);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletedangky (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaDK = request.getParameter("madk");
		DangKyDAO.deleteDangky(MaDK);
		response.sendRedirect("list");
	}
	private void insertdangky (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaDK = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String MSGV = request.getParameter("lay txt");
		String MaNhom = request.getParameter("lay txt");
		String NgayDangKy = request.getParameter("lay txt");
		String LinkDeCuong = request.getParameter("lay txt");
		String GhiChu = request.getParameter("lay txt");
		dangky DK = new dangky(MaDK,MaDeTai,MSGV,MaNhom,NgayDangKy,LinkDeCuong,GhiChu);
		DangKyDAO.insertDangky(DK);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaDK = request.getParameter("madk");
		dangkyDAO dao = new dangkyDAO();
		dangky s =dao.selectDangky(MaDK);
		request.setAttribute("dangki", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatedangky (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaDK = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String MSGV = request.getParameter("lay txt");
		String MaNhom = request.getParameter("lay txt");
		String NgayDangKy = request.getParameter("lay txt");
		String LinkDeCuong = request.getParameter("lay txt");
		String GhiChu = request.getParameter("lay txt");
		dangky DK = new dangky(MaDK,MaDeTai,MSGV,MaNhom,NgayDangKy,LinkDeCuong,GhiChu);
		DangKyDAO.updatetDangky(DK);;
		response.sendRedirect("list");		
	}
}
