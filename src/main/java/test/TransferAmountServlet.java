package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/transferamt")
public class TransferAmountServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message2.jsp").forward(req, res);						
		}else {
			Long targetAccNo = Long.valueOf(Long.parseLong(req.getParameter("accno")));
			Double amount = Double.valueOf(Double.parseDouble(req.getParameter("amt")));
			CustomerBean homeAccount = (CustomerBean)hs.getAttribute("cbean");
			int k = new TransferAmountDAO().transfer(amount, homeAccount, targetAccNo);
			if(k>0) {
				req.setAttribute("message", "Amount Transfered Successfully...");
			}else {
				req.setAttribute("message", "Amount Not Transfered! Transaction Failed!!!");
			}
			req.getRequestDispatcher("TransferAmount.jsp").forward(req, res);
		}
	}
}