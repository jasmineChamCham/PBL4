<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Bean.Host" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Raspberry Monitoring Admin Dashboard</title>
    <!-- Custom Stylesheet -->
    <link href="./css/style.css" rel="stylesheet">

</head>

<body>
	<% ArrayList<Host> hosts = (ArrayList<Host>) request.getAttribute("hosts");
	%>
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
            <a href="Overview_Controller?auth=<%=session.getAttribute("auth")%>" class="brand-logo">
                <img class="logo-abbr" src="./images/raspberry-pi.png" alt="">
                <h2 style="color: #fff; margin-top: 12px; margin-left: 5px;">PBL4</h2>
            </a>

            <div class="nav-control">
                <div class="hamburger">
                    <span class="line"></span><span class="line"></span><span class="line"></span>
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
                                <h5 style="color: #593bdb; font: 20px Verdana; font-weight: 550; margin-top: 10px;">
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
                        <a href="Overview_Controller?auth=<%=session.getAttribute("auth")%>" aria-expanded="false"><i class="icon icon-globe-2"></i>
                        <span class="nav-text">Overview</span></a>
                    </li>
                    <li>
                        <a href="DisplayHostServlet?auth=<%=session.getAttribute("auth")%>" aria-expanded="false"><i class="icon icon-app-store"></i>
                        <span class="nav-text">Hosts</span></a>
                    </li>
                    <li class="nav-label first">Account</li>
                    <li>
                        <a href="change-password.jsp?auth=<%=session.getAttribute("auth")%>" aria-expanded="false"><i class="icon-key"></i>
                        <span class="nav-text">Change password</span></a>
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
        <div class="content-body">
            <div class="container-fluid">
            
                <div class="row page-titles mx-0">
                    <div class="col-sm-6 p-md-0">
                    </div>
                    <div class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                        <a href="create-host.jsp?auth=<%=request.getAttribute("auth")%>">
                        <button type="submit" class="btn btn-primary">Create new host</button>
                        </a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Hosts</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-responsive-sm">
                                        <thead>
                                            <tr style="color: #737373; font-weight: 500;">
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>IP address</th>
                                                <th>Availability</th>
                                                <th>Detail</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       		<% for (int i = 0; i < hosts.size(); i++) { %>
                                            <tr>
                                                <th><%=i+1%></th>
                                                <td><%=hosts.get(i).getHostName()%></td>
                                                <td><%=hosts.get(i).getIpAddress()%>:<%=hosts.get(i).getPort()%></td>
                                                <td>
                                                    <%if (hosts.get(i).getAvailability().equals("0")){%>
                                                    	<span class="badge badge-dark">Unknown</span>
                                                    <%} else if (hosts.get(i).getAvailability().equals("1")){ %>
                                                    	<span class="badge badge-success">Available</span>
                                                    <%} else if (hosts.get(i).getAvailability().equals("2")){ %>
                                                    	<span class="badge badge-danger">Not available</span>
                                                    <%} %>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="DetailHostServlet?auth=<%=request.getAttribute("auth")%>&hostid=<%=hosts.get(i).getHostID()%>" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="View detail">
                                                            <i class="fa fa-eye"></i> 
                                                        </a>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="UpdateHostServlet?hostid=<%=hosts.get(i).getHostID()%>" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="Edit">
                                                            <i class="fa fa-pencil color-muted"></i> 
                                                        </a>
                                                        <a href="confirm-delete-host.jsp?hostid=<%=hosts.get(i).getHostID()%>" data-toggle="tooltip"
                                                            data-placement="top" title="Delete">
                                                            <i class="fa fa-trash-o"></i>
                                                        </a>
                                                    </span>
                                                </td>
                                            </tr>
                                            <% } %>
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


        <!--**********************************
            Footer start
        ***********************************-->
        
        <!--**********************************
            Footer end
        ***********************************-->

        <!--**********************************
           Support ticket button start
        ***********************************-->

        <!--**********************************
           Support ticket button end
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