package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/depositamt")
public class DepositAmountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message2.jsp").forward(req, res);			
		}else {
			CustomerBean cust = (CustomerBean)hs.getAttribute("cbean");
			Double amount = Double.valueOf(Double.parseDouble(req.getParameter("amt")));
			if(amount>0) {
				int k = new DepositAmountDAO().deposit(amount, cust.getAccountNumber());
				if(k>0) {
					req.setAttribute("message", "Amount Deposited Successfully...");
				}else {
					req.setAttribute("message", "Amount Not Deposited! Transaction Failed!!!");
				}
			}else {
				req.setAttribute("message", "Amount Not Deposited! Transaction Failed!!!");
			}
			req.getRequestDispatcher("DepositAmount.jsp").forward(req, res);
		}
	}
}