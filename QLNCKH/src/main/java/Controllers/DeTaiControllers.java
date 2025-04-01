package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.detaiDAO;
import Models.detai;

@WebServlet("/")
public class DeTaiControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private detaiDAO DeTaiDAO;

    public DeTaiControllers() {
        this.DeTaiDAO = new detaiDAO();
    }


	public void init(ServletConfig config) throws ServletException {
		DeTaiDAO= new detaiDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/new":
                	shownewform(request, response);
                    break;
                case "/insert":
                	insertdetai(request, response);
                    break;
                case "/delete":
                	deletedetai(request, response);
                    break;
                case "/edit":
                	showeditform(request, response);
                    break;
                case "/update":
                	updatedetai(request, response);
                    break;            
                default:                   
                	listdetai(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listdetai (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<detai> DeTai = DeTaiDAO.selectalldetai();
		request.setAttribute("listdetai", DeTai);
		RequestDispatcher dis = request.getRequestDispatcher("DSDeTai.jsp");
		try {
			dis.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void shownewform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher pre = request.getRequestDispatcher("DSDeTai.jsp");
		pre.forward(request,response);
	}
	private void showeditform (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String MaDeTai = request.getParameter("madetai");
		detaiDAO dao = new detaiDAO();
		detai s =dao.selectdetai(MaDeTai);
		request.setAttribute("detai", s);
		request.getRequestDispatcher("DSDeTai.jsp")
		.forward(request, response);
	}
	private void deletedetai (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaDeTai = request.getParameter("MaDeTai");
		DeTaiDAO.deletedetai(MaDeTai);
		response.sendRedirect("list");
	}
	private void updatedetai (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaDeTai = request.getParameter("txtMaDT");
		String TenDeTai = request.getParameter("txtTenDT");
		String MaKhoa = request.getParameter("txtkhoa");
		String LinkDeTai = request.getParameter("txtLinkDT");
		String NgayThucHien = request.getParameter("txtNgayTH");
		String NgayKetThuc = request.getParameter("txtNgayKT");
		String KinhPhiDuKien = request.getParameter("txtKinhPhi");
		String MSGV = request.getParameter("txtgv");
		detai DeTai = new detai(MaDeTai,TenDeTai,MaKhoa,LinkDeTai,NgayThucHien,NgayKetThuc,KinhPhiDuKien,MSGV);
		DeTaiDAO.updatetDetai(DeTai);
		response.sendRedirect("list");
	}
	private void insertdetai (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		String MaDeTai = request.getParameter("txtMaDT");
		String TenDeTai = request.getParameter("txtTenDT");
		String MaKhoa = request.getParameter("txtkhoa");
		String LinkDeTai = request.getParameter("txtLinkDT");
		String NgayThucHien = request.getParameter("txtNgayTH");
		String NgayKetThuc = request.getParameter("txtNgayKT");
		String KinhPhiDuKien = request.getParameter("txtKinhPhi");
		String MSGV = request.getParameter("txtgv");
		detai DeTai = new detai(MaDeTai,TenDeTai,MaKhoa,MSGV,NgayThucHien,NgayKetThuc,KinhPhiDuKien,LinkDeTai);
		DeTaiDAO.insertDetai(DeTai);
		response.sendRedirect("list");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
