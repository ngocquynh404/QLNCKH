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

import DAO.chitietdongiahanDAO;
import Models.chitietdongiahan;

/**
 * Servlet implementation class chitietdongiahanControllers
 */
@WebServlet("/")
public class chitietdongiahanControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private chitietdongiahanDAO dongiahanDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitietdongiahanControllers() {
        this.dongiahanDAO = new chitietdongiahanDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dongiahanDAO = new chitietdongiahanDAO();
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
                	insertgiahan(request, response);
                    break;
                case "/delete":
                	deletegiahan(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updategiahan(request, response);
                    break;            
                default:                   
                	listgiahan(request, response);
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
	private void listgiahan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<chitietdongiahan> donxin = dongiahanDAO.selectallDongiahan();
		request.setAttribute("listnguoiquanly", donxin);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletegiahan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaChiTiet = request.getParameter("machitiet");
		dongiahanDAO.deleteDongiahan(MaChiTiet);;
		response.sendRedirect("list");
	}
	private void insertgiahan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaChiTiet = request.getParameter("lay txt");
		String MSGV = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String NgayGiaHan = request.getParameter("lay txt");
		String NgayHoanThanhCu = request.getParameter("lay txt");
		String NgayHoanThanhMoi = request.getParameter("lay txt");
		String LinkDonXin = request.getParameter("lay txt");
		String IsAccept = request.getParameter("lay txt");
		chitietdongiahan GH = new chitietdongiahan(MaChiTiet,MSGV,MaDeTai,NgayGiaHan,NgayHoanThanhCu,NgayHoanThanhMoi,LinkDonXin,IsAccept);
		dongiahanDAO.insertDongiahan(GH);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaChiTiet = request.getParameter("machitiet");
		chitietdongiahanDAO dao = new chitietdongiahanDAO();
		chitietdongiahan s =dao.selectDongiahan(MaChiTiet);
		request.setAttribute("giahan", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updategiahan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaChiTiet = request.getParameter("lay txt");
		String MSGV = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String NgayGiaHan = request.getParameter("lay txt");
		String NgayHoanThanhCu = request.getParameter("lay txt");
		String NgayHoanThanhMoi = request.getParameter("lay txt");
		String LinkDonXin = request.getParameter("lay txt");
		String IsAccept = request.getParameter("lay txt");
		chitietdongiahan GH = new chitietdongiahan(MaChiTiet,MSGV,MaDeTai,NgayGiaHan,NgayHoanThanhCu,NgayHoanThanhMoi,LinkDonXin,IsAccept);
		dongiahanDAO.updatetDongiahan(GH);
		response.sendRedirect("list");		
	}
	

}
