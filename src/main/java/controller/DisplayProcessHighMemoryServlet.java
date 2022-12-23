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

/**
 * Servlet implementation class DisplayProcessHighMemoryServlet
 */
public class DisplayProcessHighMemoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProcessHighMemoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			String username = session.getAttribute("username").toString();
			String password = session.getAttribute("password").toString();
			String host = session.getAttribute("host").toString();
			List<Process> listProcessesWithHighMemory = ProcessBO.getProcessesWithHighMemory(username, password, host);
			session.setAttribute("listProcessesWithHighMemory", listProcessesWithHighMemory);
			RequestDispatcher dispatcher = request.getRequestDispatcher("display-processes-with-high-memory.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("page-error-login-ssh.jsp");
			e.printStackTrace();
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
