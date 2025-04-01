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

import DAO.bienbannghiemthuDAO;
import Models.bienbannghiemthu;

/**
 * Servlet implementation class bienbannghiemthuControllers
 */
@WebServlet("/")
public class bienbannghiemthuControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bienbannghiemthuDAO  BienBanDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bienbannghiemthuControllers() {
       this.BienBanDAO = new bienbannghiemthuDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		BienBanDAO = new bienbannghiemthuDAO();
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
                	insertbienban(request, response);
                    break;
                case "/delete":
                	deletebienban(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatebienban(request, response);
                    break;            
                default:                   
                	listbienban(request, response);
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
	private void listbienban(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<bienbannghiemthu> bienban = BienBanDAO.selectallBienban();
		request.setAttribute("listbienban", bienban);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletebienban (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaBienBan = request.getParameter("mabienban");
		BienBanDAO.deleteBienban(MaBienBan);
		response.sendRedirect("list");
	}
	private void insertbienban (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaBienBan = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String Diem = request.getParameter("lay txt");
		String DanhGia = request.getParameter("lay txt");
		String LinkBienBan = request.getParameter("lay txt");
		bienbannghiemthu BB = new bienbannghiemthu(MaBienBan,MaDeTai,Diem,DanhGia,LinkBienBan);
		BienBanDAO.insertBienban(BB);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaBienBan = request.getParameter("mabienban");
		bienbannghiemthuDAO dao = new bienbannghiemthuDAO();
		bienbannghiemthu s =dao.selectBienban(MaBienBan);
		request.setAttribute("bienban", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatebienban (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaBienBan = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String Diem = request.getParameter("lay txt");
		String DanhGia = request.getParameter("lay txt");
		String LinkBienBan = request.getParameter("lay txt");
		bienbannghiemthu BB = new bienbannghiemthu(MaBienBan,MaDeTai,Diem,DanhGia,LinkBienBan);
		BienBanDAO.updatetBienban(BB);
		response.sendRedirect("list");		
	}

}
