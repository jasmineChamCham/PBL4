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

public class AddHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddHostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hostname = request.getParameter("val-hostname");
		String ipaddress = request.getParameter("val-ipaddress");
		String port = request.getParameter("val-port");
		String auth = request.getParameter("auth");
		HttpSession session = request.getSession();
		HostBO addhostBO = new HostBO();
		String mesg = addhostBO.GreateHost(auth, hostname, ipaddress, port);
		if (mesg == null)
		{
			ArrayList<Host> hosts = addhostBO.getHosts(auth);
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
			System.out.println(mesg);
		}
	}

}
