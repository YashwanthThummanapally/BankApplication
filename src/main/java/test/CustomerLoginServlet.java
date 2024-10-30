package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/custlogin")
public class CustomerLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		Long accountNumber = Long.valueOf(Long.parseLong(req.getParameter("accno")));
		String holderName = req.getParameter("name");
		CustomerBean customer = new CustomerLoginDAO().customerLogin(accountNumber, holderName);
		if(customer==null) {
			req.setAttribute("message", "Invalid Login Process!");
			req.getRequestDispatcher("Message2.jsp").forward(req, res);
		}else {
			HttpSession hs = req.getSession(true);
			hs.setAttribute("cbean", customer);
			req.setAttribute("message", "Login Successful...");
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
	}
}