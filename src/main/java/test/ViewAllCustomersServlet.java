package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewallcust")
public class ViewAllCustomersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);			
		}else {
			ArrayList<CustomerBean> customers = new ViewAllCustomersDAO().selectAll();
			hs.setAttribute("alist", customers);
			req.getRequestDispatcher("ViewAllCustomers.jsp").forward(req, res);
		}
	}
}