package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/transaction")
public class ViewTransactionDetailsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("message", "Session Expired!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);			
		}else {
			ArrayList<TransactionBean> transactions = new ViewTransactionDetailsDAO().viewTransactions();
			hs.setAttribute("tlist", transactions);
			req.getRequestDispatcher("ViewTransactionDetails.jsp").forward(req, res);
		}
	}
}