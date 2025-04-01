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

import DAO.baocaotiendoDAO;
import Models.baocaotiendo;

/**
 * Servlet implementation class baocaotiendoControllers
 */
@WebServlet("/")
public class baocaotiendoControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private baocaotiendoDAO baocaoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public baocaotiendoControllers() {
        this.baocaoDAO = new baocaotiendoDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		baocaoDAO = new baocaotiendoDAO();
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
                	insertbaocao(request, response);
                    break;
                case "/delete":
                	deletebaocao(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);// hien thi len form
                    break;
                case "/update":
                	updatebaocao(request, response);
                    break;            
                default:                   
                	listbaocao(request, response);
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
	private void listbaocao(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<baocaotiendo> baocao = baocaoDAO.selectallTiendo();
		request.setAttribute("listbaocao", baocao);
		RequestDispatcher dis = request.getRequestDispatcher("?");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void deletebaocao (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{// dung mssv 
		String MaBaoCao = request.getParameter("mabaocao");
		baocaoDAO.deleteTiendo(MaBaoCao);
		response.sendRedirect("list");
	}
	private void insertbaocao (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaBaoCao = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String MaGiaiDoan = request.getParameter("lay txt");
		baocaotiendo BB = new baocaotiendo(MaBaoCao,MaDeTai,MaGiaiDoan);
		baocaoDAO.insertTiendo(BB);
		response.sendRedirect("list");
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaBaoCao = request.getParameter("mabaocao");
		baocaotiendoDAO dao = new baocaotiendoDAO();
		baocaotiendo s =dao.selectTiendo(MaBaoCao);
		request.setAttribute("baocao", s);// value sinhvien.
		request.getRequestDispatcher("?")
		.forward(request, response);
	}
	private void updatebaocao (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaBaoCao = request.getParameter("lay txt");
		String MaDeTai = request.getParameter("lay txt");
		String MaGiaiDoan = request.getParameter("lay txt");
		baocaotiendo BB = new baocaotiendo(MaBaoCao,MaDeTai,MaGiaiDoan);
		baocaoDAO.updatetTiendo(BB);
		response.sendRedirect("list");		
	}

}
