package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.ZabbixBO;
import Model.Bean.Host;

/**
 * Servlet implementation class DetailHostServlet
 */
public class DetailHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String auth = request.getParameter("auth");
		String hostid = request.getParameter("hostid");
//		System.out.println(hostid);
		ZabbixBO detailHostBO = new ZabbixBO();
		Host host = detailHostBO.GetHostByHostID(auth,hostid);
		if (host != null)
		{
			request.setAttribute("host", host);
			request.setAttribute("auth", auth);
			RequestDispatcher dispatcher = request.getRequestDispatcher("detail-host.jsp");
			dispatcher.forward(request, response);
//			System.out.println(host.getIpAddress());
		}
		else
		{
			System.out.println("hello?");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
