<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Model.Bean.Process"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Raspberry Monitoring Admin Dashboard</title>
<!-- Custom Stylesheet -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="./css/style.css" rel="stylesheet">

<script>
	$("a").on('click',function() {
	    var t = (this.id);
	    
	});  
</script>

</head>

<body>
	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="sk-three-bounce">
			<div class="sk-child sk-bounce1"></div>
			<div class="sk-child sk-bounce2"></div>
			<div class="sk-child sk-bounce3"></div>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<a href="Overview_Controller?auth=<%=session.getAttribute("auth")%>" class="brand-logo"> <img class="logo-abbr"
				src="./images/raspberry-pi.png" alt="">
				<h2 style="color: #fff; margin-top: 12px; margin-left: 5px;">PBL4</h2>
			</a>

			<div class="nav-control">
				<div class="hamburger">
					<span class="line"></span>
					<span class="line"></span>
					<span class="line"></span>
				</div>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<div class="header-content">
				<nav class="navbar navbar-expand">
					<div class="collapse navbar-collapse justify-content-between">
						<div class="header-left">
							<div class="welcome-text">
								<h5
									style="color: #593bdb; font: 20px Verdana; font-weight: 550; margin-top: 10px;">
									Hi, welcome back!</h5>
							</div>
						</div>

						<ul class="navbar-nav header-right">
							<li class="nav-item dropdown header-profile">
								<a class="nav-link" href="#" role="button" data-toggle="dropdown">
								<i class="mdi mdi-account"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right">
									<a href="./page-login.jsp" class="dropdown-item"> 
									<i class="fa fa-sign-out"></i> 
									<span class="ml-2">Log out</span>
									</a>
								</div>
							</li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<div class="quixnav">
			<div class="quixnav-scroll">
				<ul class="metismenu" id="menu">
					<li class="nav-label first">Main Menu</li>
					<li>
						<a href="Overview_Controller?auth=<%=session.getAttribute("auth")%>" aria-expanded="false">
						<i class="icon icon-globe-2"></i> 
						<span class="nav-text">Overview</span>
						</a>
					</li>
					<li>
						<a href="DisplayHostServlet?auth=<%=session.getAttribute("auth")%>" aria-expanded="false">
						<i class="icon icon-app-store"></i>
						<span class="nav-text">Hosts</span>
						</a>
					</li>
					<li class="nav-label first">Account</li>
					<li>
						<a href="change-password.jsp?auth=<%=session.getAttribute("auth")%>" aria-expanded="false">
						<i class="icon-key"></i>
						<span class="nav-text">Change password</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<%
			String username = session.getAttribute("username").toString();
			String password = session.getAttribute("password").toString();
			String host = session.getAttribute("host").toString();
        	List<Process> listProcessesWithHighMemory = (ArrayList) session.getAttribute("listProcesses"); 
			session.setAttribute("listProcessesWithHighMemory", listProcessesWithHighMemory);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("host", host);
			session.setAttribute("destination", "memory");
        %>

		<div class="content-body">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Process Utilizing Most Memory</h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-responsive-sm">
										<thead align="center">
											<tr style="color: #737373; font-weight: 500;">
												<th>Process ID</th>
												<th>Process name</th>
												<th>Process Memory</th>
												<th>Kill process</th>
											</tr>
										</thead>
										<tbody align="center">
											<%
											for (int i=0; i<listProcessesWithHighMemory.size(); i++){
												Process process = listProcessesWithHighMemory.get(i);
											%>
											<tr>
												<td><%= process.getProcessId() %></td>
												<td><%= process.getProcessName() %></td>
												<td><%= process.getProcessMemory() %></td>
												<td>
												<span> 
													<a href="confirm-delete-process.jsp?ProcessId=<%= process.getProcessId()%>"> 
														<i class="fa fa-times" style="color: rgb(215, 21, 21);"></i>
													</a>
												</span>
												</td>
											<%	
											}
											%> 
											
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--**********************************
            Content body end
        ***********************************-->

	</div>
	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<!-- Required vendors -->
	<script src="./vendor/global/global.min.js"></script>
	<script src="./js/quixnav-init.js"></script>
	<script src="./js/custom.min.js"></script>

</body>
</html>
