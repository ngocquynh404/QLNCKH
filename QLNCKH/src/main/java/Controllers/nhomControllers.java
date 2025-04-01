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
import DAO.nhomDAO;
import Models.nhom;

/**
 * Servlet implementation class nhomControllers
 */
@WebServlet("/")
public class nhomControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private nhomDAO NhomDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nhomControllers() {
        this.NhomDAO =new nhomDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		NhomDAO = new nhomDAO();
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
                	insertnhom(request, response);
                    break;
                case "/delete":
                	deletenhom(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatenhom(request, response);
                    break;            
                default:                   
                	listnhom(request, response);
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
	private void listnhom(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<nhom> Nhom = NhomDAO.selectallNhom();
		request.setAttribute("listnhom", Nhom);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletenhom (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaNhom = request.getParameter("manhom");
		NhomDAO.deleteNhom(MaNhom);
		response.sendRedirect("list");
	}
	private void insertnhom (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaNhom = request.getParameter("lay txt");
		String MSSV1 = request.getParameter("lay txt");
		String MSSV2 = request.getParameter("lay txt");
		String MSSV3 = request.getParameter("lay txt");
		String MSSV4 = request.getParameter("lay txt");
		String MSSV5 = request.getParameter("lay txt");
		String MSGV = request.getParameter("lay txt");
		nhom N = new nhom(MaNhom,MSSV1,MSSV2,MSSV3,MSSV4,MSSV5,MSGV);
		NhomDAO.insertNhom(N);;
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaNhom = request.getParameter("manhom");
		nhomDAO dao = new nhomDAO();
		nhom s =dao.selectNhom(MaNhom);
		request.setAttribute("nhom", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatenhom (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaNhom = request.getParameter("lay txt");
		String MSSV1 = request.getParameter("lay txt");
		String MSSV2 = request.getParameter("lay txt");
		String MSSV3 = request.getParameter("lay txt");
		String MSSV4 = request.getParameter("lay txt");
		String MSSV5 = request.getParameter("lay txt");
		String MSGV = request.getParameter("lay txt");
		nhom N = new nhom(MaNhom,MSSV1,MSSV2,MSSV3,MSSV4,MSSV5,MSGV);
		NhomDAO.updatetNhom(N);;
		response.sendRedirect("list");		
	}
}
