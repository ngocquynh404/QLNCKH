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

import DAO.hoidongduyetdecuongDAO;
import Models.hoidongduyetdecuong;
/**
 * Servlet implementation class hoidongduyetdecuongControllers
 */
@WebServlet("/")
public class hoidongduyetdecuongControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hoidongduyetdecuongDAO hdDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoidongduyetdecuongControllers() {
        this.hdDAO = new hoidongduyetdecuongDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		hdDAO = new hoidongduyetdecuongDAO();
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
                	inserthoidong(request, response);
                    break;
                case "/delete":
                	deletehoidong(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatehoidong(request, response);
                    break;            
                default:                   
                	listhoidong(request, response);
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
	private void listhoidong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<hoidongduyetdecuong> hoidong = hdDAO.selectallHoidong();
		request.setAttribute("listnguoiquanly", hoidong);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletehoidong (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaHDDDT = request.getParameter("mahdddt");
		hdDAO.deleteHoidong(MaHDDDT);;
		response.sendRedirect("list");
	}
	private void inserthoidong (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaHDDDT = request.getParameter("lay txt");
		String TenHD = request.getParameter("lay txt");
		String MSGV1 = request.getParameter("lay txt");
		String MSGV2 = request.getParameter("lay txt");
		String MSGV3 = request.getParameter("lay txt");
		String MSGV4 = request.getParameter("lay txt");
		hoidongduyetdecuong HD = new hoidongduyetdecuong(MaHDDDT,TenHD,MSGV1,MSGV2,MSGV3,MSGV4);
		hdDAO.insertHoidong(HD);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaHDDDT = request.getParameter("mahdddt");
		hoidongduyetdecuongDAO dao = new hoidongduyetdecuongDAO();
		hoidongduyetdecuong s =dao.selectHoidong(MaHDDDT);
		request.setAttribute("hoidong", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatehoidong (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaHDDDT = request.getParameter("lay txt");
		String TenHD = request.getParameter("lay txt");
		String MSGV1 = request.getParameter("lay txt");
		String MSGV2 = request.getParameter("lay txt");
		String MSGV3 = request.getParameter("lay txt");
		String MSGV4 = request.getParameter("lay txt");
		hoidongduyetdecuong HD = new hoidongduyetdecuong(MaHDDDT,TenHD,MSGV1,MSGV2,MSGV3,MSGV4);
		hdDAO.insertHoidong(HD);
		response.sendRedirect("list");		
	}

}
