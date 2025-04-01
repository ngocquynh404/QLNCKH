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

import DAO.baocaotiendo_giaidoanDAO;
import Models.baocaotiendo_giaidoan;


/**
 * Servlet implementation class baocaotiendogiaidoanControllers
 */
@WebServlet("/")
public class baocaotiendogiaidoanControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private baocaotiendo_giaidoanDAO  tiendo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public baocaotiendogiaidoanControllers() {
        this.tiendo = new baocaotiendo_giaidoanDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		tiendo = new baocaotiendo_giaidoanDAO();
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
                	insertbaocaogiaidoan(request, response);
                    break;
                case "/delete":
                	deletebaocaogiaidoan(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatebaocaogiaidoan(request, response);
                    break;            
                default:                   
                	listbaocaogiaidoan(request, response);
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
	private void listbaocaogiaidoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<baocaotiendo_giaidoan> Tiendo =tiendo.selectallTiendo();
		request.setAttribute("listtiendo", Tiendo);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletebaocaogiaidoan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaGiaDoan = request.getParameter("magiaidoan");
		tiendo.deleteTiendo(MaGiaDoan);
		response.sendRedirect("list");
	}
	private void insertbaocaogiaidoan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaGiaDoan = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String GiaiDoan = request.getParameter("lay txt");
		String NgayBatDau = request.getParameter("lay txt");
		String NgayKetThuc = request.getParameter("lay txt");
		String LinkDeTai = request.getParameter("lay txt");
		baocaotiendo_giaidoan TD = new baocaotiendo_giaidoan(MaGiaDoan,MaDeTai,GiaiDoan,NgayBatDau,NgayKetThuc,LinkDeTai);
		tiendo.insertTiendo(TD);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaGiaiDoan = request.getParameter("magiaidoan");
		baocaotiendo_giaidoanDAO dao = new baocaotiendo_giaidoanDAO();
		baocaotiendo_giaidoan s =dao.selectTiendo(MaGiaiDoan);
		request.setAttribute("tiendo", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatebaocaogiaidoan (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaGiaDoan = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String GiaiDoan = request.getParameter("lay txt");
		String NgayBatDau = request.getParameter("lay txt");
		String NgayKetThuc = request.getParameter("lay txt");
		String LinkDeTai = request.getParameter("lay txt");
		baocaotiendo_giaidoan TD = new baocaotiendo_giaidoan(MaGiaDoan,MaDeTai,GiaiDoan,NgayBatDau,NgayKetThuc,LinkDeTai);
		tiendo.updatetTiendo(TD);
		response.sendRedirect("list");		
	}

}
