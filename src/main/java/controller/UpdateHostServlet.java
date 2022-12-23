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

/**
 * Servlet implementation class UpdateHostServlet
 */
public class UpdateHostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hostid = request.getParameter("hostid");
		
		HttpSession session = request.getSession();	
		String auth = session.getAttribute("auth").toString();

		HostBO UpdateHostBO = new HostBO();
		
		if (hostid != null)
		{
			Host host = UpdateHostBO.GetHostByHostID(auth,hostid);
			if (host != null)
			{
				request.setAttribute("host", host);
				request.setAttribute("auth", auth);
				RequestDispatcher dispatcher = request.getRequestDispatcher("update-host.jsp");
				dispatcher.forward(request, response);
//				System.out.println(host.getIpAddress());
			}
			else
			{
				System.out.println("hello?");
			}
		}
		
		String val_hostid = request.getParameter("val-hostid");
		if (val_hostid!= null)
		{
			String val_hostname = request.getParameter("val-hostname");
			String val_ipaddress = request.getParameter("val-ipaddress");
			String val_port = request.getParameter("val-port");
			String mesg = UpdateHostBO.UpdateHostname(auth, val_hostid, val_hostname);
			String mesg1 = UpdateHostBO.UpdateInterface(auth, val_hostid, val_ipaddress, val_port);
			if (mesg == null && mesg1 == null)
			{
				ArrayList<Host> hosts = UpdateHostBO.getHosts(auth);
				request.setAttribute("hosts", hosts);
				request.setAttribute("auth", auth);
				RequestDispatcher dispatcher = request.getRequestDispatcher("display-hosts.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("mesg", (mesg!=null)?(mesg+" "):("") +mesg1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("page-error-change-password.jsp");
				dispatcher.forward(request, response);
			}
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
