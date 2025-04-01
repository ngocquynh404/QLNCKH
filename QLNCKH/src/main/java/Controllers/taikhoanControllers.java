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

import DAO.taikhoanDAO;
import Models.taikhoan;

/**
 * Servlet implementation class taikhoanControllers
 */
@WebServlet("/")
public class taikhoanControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private taikhoanDAO TaiKhoanDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public taikhoanControllers() {
      this.TaiKhoanDAO = new taikhoanDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		TaiKhoanDAO = new taikhoanDAO();
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
                	inserttaikhoan(request, response);
                    break;
                case "/delete":
                	deletetaikhoan(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatetaikhoan(request, response);
                    break;            
                default:                   
                	listtaikhoan(request, response);
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
	private void listtaikhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<taikhoan> TaiKhoan = TaiKhoanDAO.selectallTaikhoan();
		request.setAttribute("listtaikhoan", TaiKhoan);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletetaikhoan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaTK = request.getParameter("matk");
		TaiKhoanDAO.deleteTaiKhoan(MaTK);
		response.sendRedirect("list");
	}
	private void inserttaikhoan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaTK = request.getParameter("lay txt");
		String UserName = request.getParameter("lay txt");
		String Email = request.getParameter("lay txt");
		String Password = request.getParameter("lay txt");
		String MaLTK = request.getParameter("lay txt");
		taikhoan BB = new taikhoan(MaTK,UserName,Email,Password,MaLTK);
		TaiKhoanDAO.insertTaikhoan(BB);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaTK = request.getParameter("matk");
		taikhoanDAO dao = new taikhoanDAO();
		taikhoan s =dao.selecttaikhoan(MaTK);
		request.setAttribute("taikhoan", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatetaikhoan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaTK = request.getParameter("lay txt");
		String UserName = request.getParameter("lay txt");
		String Email = request.getParameter("lay txt");
		String Password = request.getParameter("lay txt");
		String MaLTK = request.getParameter("lay txt");
		taikhoan BB = new taikhoan(MaTK,UserName,Email,Password,MaLTK);
		TaiKhoanDAO.insertTaikhoan(BB);
		response.sendRedirect("list");		
	}
}
