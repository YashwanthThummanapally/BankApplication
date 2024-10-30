package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logoutadmin")
public class LogoutAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);									
		}else {
			hs.removeAttribute("abean");
			hs.removeAttribute("alist");
			hs.invalidate();
			req.setAttribute("message", "Loggedout Successfully...");
			req.getRequestDispatcher("LogoutAdmin.jsp").forward(req, res);
		}
	}
}