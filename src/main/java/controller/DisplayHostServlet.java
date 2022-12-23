package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.HostBO;
import Model.Bean.Host;

public class DisplayHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayHostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auth = request.getParameter("auth");
		HostBO loginBO = new HostBO();
		ArrayList<Host> hosts = loginBO.getHosts(auth);
		request.setAttribute("hosts", hosts);
		request.setAttribute("auth", auth);
		RequestDispatcher dispatcher = request.getRequestDispatcher("display-hosts.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
