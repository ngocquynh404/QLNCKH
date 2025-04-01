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

import DAO.nguoiquanlyDAO;

import Models.nguoiquanly;


/**
 * Servlet implementation class nguoiquanlyControllers
 */
@WebServlet("/")
public class nguoiquanlyControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private nguoiquanlyDAO NQLDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nguoiquanlyControllers() {
        this.NQLDAO = new nguoiquanlyDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		NQLDAO = new nguoiquanlyDAO();
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
                	insertnguoiquanly(request, response);
                    break;
                case "/delete":
                	deletenguoiquanly(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatenguoiquanly(request, response);
                    break;            
                default:                   
                	listnguoiquanly(request, response);
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
	private void listnguoiquanly(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<nguoiquanly> NQL = NQLDAO.selectallNguoiquanly();
		request.setAttribute("listnguoiquanly", NQL);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletenguoiquanly (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaQL = request.getParameter("manql");
		NQLDAO.deleteNguoiquanly(MaQL);
		response.sendRedirect("list");
	}
	private void insertnguoiquanly (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaQL = request.getParameter("lay txt");
		String HoTen = request.getParameter("lay txt");
		String NgaySinh = request.getParameter("lay txt");
		String MaTK = request.getParameter("lay txt");
		nguoiquanly QL = new nguoiquanly(MaQL,HoTen,NgaySinh,MaTK);
		NQLDAO.insertNguoiquanly(QL);;
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaQL = request.getParameter("maql");
		nguoiquanlyDAO dao = new nguoiquanlyDAO();
		nguoiquanly s =dao.selectNguoiquanly(MaQL);
		request.setAttribute("nguoiquanly", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatenguoiquanly (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaQL = request.getParameter("lay txt");
		String HoTen = request.getParameter("lay txt");
		String NgaySinh = request.getParameter("lay txt");
		String MaTK = request.getParameter("lay txt");
		nguoiquanly QL = new nguoiquanly(MaQL,HoTen,NgaySinh,MaTK);
		NQLDAO.updatetNguoiquanly(QL);;
		response.sendRedirect("list");		
	}

}
