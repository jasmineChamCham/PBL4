package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.ProcessBO;
import Model.Bean.Process;

public class KillProcessHighMemoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KillProcessHighMemoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			String ProcessId = request.getParameter("ProcessId");
			String username = session.getAttribute("username").toString();
			String password = session.getAttribute("password").toString();
			String host = session.getAttribute("host").toString();
			ProcessBO.killProcess(username, password, host, ProcessId);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			System.out.println("host : " + host);
			System.out.println("ProcessId : " + ProcessId);
			List<Process> listProcesses = ProcessBO.getAllProcesses(username, password, host);
			session.setAttribute("listProcesses", listProcesses);
			RequestDispatcher dispatcher = request.getRequestDispatcher("display-processes-with-high-memory.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			String mesg = "Unable to kill process!";
			request.setAttribute("mesg", mesg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-message.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}
}
