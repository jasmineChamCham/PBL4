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

public class DetailHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DetailHostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auth = request.getParameter("auth");
		String hostid = request.getParameter("hostid");
		HostBO detailHostBO = new HostBO();
		Host host = detailHostBO.GetHostByHostID(auth,hostid);
		if (host != null)
		{
			request.setAttribute("host", host);
			request.setAttribute("auth", auth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("detail-host.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("hello?");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
