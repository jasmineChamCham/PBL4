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

public class DeleteHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteHostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-message.jsp");
			dispatcher.forward(request, response);
		}
	}
}
