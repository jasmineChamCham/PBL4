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

public class DisplayProcessHighMemoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DisplayProcessHighMemoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String username = session.getAttribute("username").toString();
			String password = session.getAttribute("password").toString();
			String host = session.getAttribute("host").toString();
			List<Process> listProcessesWithHighMemory = ProcessBO.getProcessesWithHighMemory(username, password, host);
			session.setAttribute("listProcesses", listProcessesWithHighMemory);
			RequestDispatcher dispatcher = request.getRequestDispatcher("display-processes-with-high-memory.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("mesg", "Unable to display processes.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error-message.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
