package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewcust")
public class ViewCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);						
		}else {
			long accno = Long.parseLong(req.getParameter("accno"));
			@SuppressWarnings("unchecked")
			ArrayList<CustomerBean> customers = (ArrayList<CustomerBean>)hs.getAttribute("alist");
			Iterator<CustomerBean> itr = customers.iterator();
			while(itr.hasNext()) {
				CustomerBean cust = itr.next();
				if(accno==cust.getAccountNumber()) {
					req.setAttribute("cbean", cust);
					break;
				}
			}
			req.getRequestDispatcher("ViewCustomer.jsp").forward(req, res);
		}
	}
}