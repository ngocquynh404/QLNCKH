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
import DAO.hoidongnghiemthuDAO;
import Models.hoidongnghiemthu;

/**
 * Servlet implementation class hoidongnghiemthuControllers
 */
@WebServlet("/")
public class hoidongnghiemthuControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private hoidongnghiemthuDAO hdDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoidongnghiemthuControllers() {
       this.hdDAO = new hoidongnghiemthuDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		hdDAO = new hoidongnghiemthuDAO();
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
		List<hoidongnghiemthu> hoidong = hdDAO.selectallHoidong();
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
		String MaHDNT = request.getParameter("mahdnt");
		hdDAO.deleteHoidong(MaHDNT);;
		response.sendRedirect("list");
	}
	private void inserthoidong (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaHDNT = request.getParameter("lay txt");
		String TenHD = request.getParameter("lay txt");
		String ChuTich = request.getParameter("lay txt");
		String PhanBien1 = request.getParameter("lay txt");
		String PhanBien2 = request.getParameter("lay txt");
		String ThuKy = request.getParameter("lay txt");
		String NgayNghiemThu = request.getParameter("lay txt");
		hoidongnghiemthu HD = new hoidongnghiemthu(MaHDNT,TenHD,ChuTich,PhanBien1,PhanBien2,ThuKy,NgayNghiemThu);
		hdDAO.insertHoidong(HD);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaHDNT = request.getParameter("mahdnt");
		hoidongnghiemthuDAO dao = new hoidongnghiemthuDAO();
		hoidongnghiemthu s =dao.selectHoidong(MaHDNT);
		request.setAttribute("hoidong", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatehoidong (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaHDNT = request.getParameter("lay txt");
		String TenHD = request.getParameter("lay txt");
		String ChuTich = request.getParameter("lay txt");
		String PhanBien1 = request.getParameter("lay txt");
		String PhanBien2 = request.getParameter("lay txt");
		String ThuKy = request.getParameter("lay txt");
		String NgayNghiemThu = request.getParameter("lay txt");
		hoidongnghiemthu HD = new hoidongnghiemthu(MaHDNT,TenHD,ChuTich,PhanBien1,PhanBien2,ThuKy,NgayNghiemThu);
		hdDAO.updatetHoidong(HD);
		response.sendRedirect("list");		
	}
}
