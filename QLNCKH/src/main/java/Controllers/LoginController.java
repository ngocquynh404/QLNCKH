package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Models.taikhoan;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		loginDAO =new LoginDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay data tu form nguoi dung
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String loaitk = request.getParameter("MaLTK");
        //khoi tao model
        taikhoan loginBean = new taikhoan();
        loginBean.setUserName(username);
        loginBean.setPassword(password);
        //loginBean.setMaTK(loaitk);
        // Ket noi CSDL -> tra kq
        try {
        	taikhoan tk = new taikhoan();
        	tk=	loginDAO.validate(loginBean);
            if (tk!=null) {
            	String userrole = tk.getMaLTK();
            	if("LTK001".equals(userrole))
            	{
            		response.sendRedirect("TrangAdmin.jsp");
            	}
            	else if ("LTK002".equals(userrole))
            	{
            		response.sendRedirect("TrangQuanLy.html");
            	}
            	else if ("LTK003".equals(userrole))
            	{
            		response.sendRedirect("TrangGiangVien.html");
            	}
            	else
            	{
            		response.sendRedirect("TrangSinhVien.html");
            	}
            	//HttpSession session = request.getSession();
                //session.setAttribute("user", tk);
                
            	//dispatcher.forward(request, response);
            } else {
               request.setAttribute("errMsg", "Thông tin đăng nhập không chính xác!");
               RequestDispatcher dispatcher= request.getRequestDispatcher("Login.jsp");
               dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	}

