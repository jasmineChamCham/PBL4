package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.HostBO;
import Model.Bean.Host;

/**
 * Servlet implementation class DeleteHostServlet
 */
public class DeleteHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String hostid = request.getParameter("hostid").toString();
		
		HttpSession session = request.getSession();	
		String auth = session.getAttribute("auth").toString();
		
		HostBO DeleteHostBO = new HostBO();

		String mesg = DeleteHostBO.DeleteHost(auth, hostid);
		if (mesg == null)
		{
			ArrayList<Host> hosts = DeleteHostBO.getHosts(auth);
			request.setAttribute("hosts", hosts);
			request.setAttribute("auth", auth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("display-hosts.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("mesg", mesg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("page-error-change-password.jsp");
			dispatcher.forward(request, response);
		}
	}

}
