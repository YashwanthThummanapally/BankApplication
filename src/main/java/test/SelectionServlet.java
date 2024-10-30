package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/selection")
public class SelectionServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message2.jsp").forward(req, res);
		}else {
			String select = req.getParameter("select");
			if(select.equals("DEPOSIT")) {
				req.getRequestDispatcher("deposit.html").forward(req, res);
			}else {
				req.getRequestDispatcher("transfer.html").forward(req, res);
			}
		}
	}
}