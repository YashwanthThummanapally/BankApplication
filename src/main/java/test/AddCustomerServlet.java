package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/addcust")
public class AddCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			CustomerBean cust = new CustomerBean();
			cust.setAccountNumber(Long.parseLong(req.getParameter("accno")));
			cust.setHolderName(req.getParameter("name"));
			cust.setBalance(Double.parseDouble(req.getParameter("bal")));
			cust.setAccountType(req.getParameter("acctype"));
			int k = new AddCustomerDAO().insertCustomer(cust);
			if(k>0) {
				req.setAttribute("message", "Insertion Successful...");
			}else {
				req.setAttribute("message", "Insertion Operation Failed!");
			}
			req.getRequestDispatcher("AddCustomer.jsp").forward(req, res);
		}
	}
}