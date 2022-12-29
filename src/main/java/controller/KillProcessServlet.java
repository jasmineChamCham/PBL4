package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.ProcessBO;
import Model.Bean.Process;

public class KillProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KillProcessServlet() {
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
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("host", host);		
			ProcessBO.killProcess(username, password, host, ProcessId);
			List<Process> listProcesses = new ArrayList<>();
			
			RequestDispatcher dispatcher = null;
		    String destination = session.getAttribute("destination").toString();
		    if (destination.equals("")) {
		    	listProcesses = ProcessBO.getAllProcesses(username, password, host);
		    	session.setAttribute("listProcesses", listProcesses);
		    	dispatcher = request.getRequestDispatcher("display-processes.jsp");
		    }
		    else if (destination.equals("cpu")) {
		    	listProcesses = ProcessBO.getProcessesWithHighCpu(username, password, host);
		    	session.setAttribute("listProcesses", listProcesses);
		    	dispatcher = request.getRequestDispatcher("display-processes-with-high-cpu.jsp");
		    }
		    else if (destination.equals("memory")) {
		    	listProcesses = ProcessBO.getProcessesWithHighMemory(username, password, host);
		    	session.setAttribute("listProcesses", listProcesses);
		    	dispatcher = request.getRequestDispatcher("display-processes-with-high-memory.jsp");
		    }
		    else {
		    	dispatcher = request.getRequestDispatcher("error-message.jsp");
		    }
		    System.out.println("kill servlet -> ");
		    for (int i=0; i<listProcesses.size(); i++) {
				System.out.println(listProcesses.get(i));
			}
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
