package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(true);
		AdminBean admin = new AdminLoginDAO().login(req.getParameter("uname"), req.getParameter("pwd"));
		if(admin==null) {
			req.setAttribute("message", "Invalid Login Process!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			hs.setAttribute("abean", admin);
			req.setAttribute("message", "Login Successful...");
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}
	}
}