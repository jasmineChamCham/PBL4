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

public class Overview_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Overview_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auth = request.getParameter("auth");
		HttpSession session = request.getSession();
		HostBO overviewBO = new HostBO();
		session.setAttribute("auth", auth);
		ArrayList<Host> hosts = overviewBO.getHosts(auth);
		ArrayList<ArrayList<Double>> CPUutilizations = overviewBO.getCPUutilization(auth);
		ArrayList<ArrayList<Double>> MemoryUtilizations = overviewBO.getMemoryUtilization(auth);
		request.setAttribute("CPUutilizations", CPUutilizations);
		request.setAttribute("MemoryUtilizations", MemoryUtilizations);
		request.setAttribute("hosts", hosts);
		request.setAttribute("auth", auth);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
