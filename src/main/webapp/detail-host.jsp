<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Bean.Host" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width,initial-scale=1" />
        <title>Raspberry Monitoring Admin Dashboard</title>
        <!-- Custom Stylesheet -->
        <link href="./css/style.css" rel="stylesheet" />
    </head>

    <body>
    	
	<% Host host = (Host) request.getAttribute("host");
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
            <img class="logo-abbr" src="./images/raspberry-pi.png" alt="" />
            <h2 style="color: #fff; margin-top: 12px; margin-left: 5px">PBL4</h2>
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
                        style="
                        color: #593bdb;
                        font: 20px Verdana;
                        font-weight: 550;
                        margin-top: 10px;
                        "
                    >
                        Hi, welcome back!
                    </h5>
                    </div>
                </div>

                <ul class="navbar-nav header-right">
                    <li class="nav-item dropdown header-profile">
                    <a
                        class="nav-link"
                        href="#"
                        role="button"
                        data-toggle="dropdown"
                    >
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
        <div class="content-body">
            <div class="container-fluid">
            <div class="row page-titles mx-0">
                <div class="col-sm-6 p-md-0">
                    <div class="welcome-text">
                        <h4 style="margin-top: 8px">Detail host</h4>
                    </div>
                </div>
                <div
                    class="col-sm-6 p-md-0 justify-content-sm-end mt-2 mt-sm-0 d-flex">
                    <a href="ssh-login.jsp?ip-address=<%=host.getIpAddress()%>">
                    	<button type="submit" class="btn btn-primary">Show processes</button>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">Host information</h4>
                        </div>
                        <div class="card-body">
                            <div class="basic-form">
                                <form>
                                    <div class="form-group row">
                                        <label class="col-lg-4 col-form-label" for="val-hostname">Host name</label>
                                        <div class="col-lg-6">
                                            <input
                                                type="text"
                                                class="form-control"
                                                id="val-hostname"
                                                name="val-hostname"
                                                value="<%=host.getHostName()%>"
                                                readonly
                                            />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-lg-4 col-form-label" for="val-ipaddress">IP address</label>
                                        <div class="col-lg-6">
                                            <input
                                                type="text"
                                                class="form-control"
                                                id="val-ipaddress"
                                                name="val-ipaddress"
                                                value="<%=host.getIpAddress()%>:<%=host.getPort()%>"
                                                readonly
                                            />
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-responsive-sm">
                                    <thead>
                                        <tr style="color: #737373; font-weight: 500">
                                            <th>Name</th>
                                            <th>Value</th>
                                            <th>Unit</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Load avarage (1m)</td>
                                            <td><%=host.getLoadAverage1m()%></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>Load avarage (5m)</td>
                                            <td><%=host.getLoadAverage5m()%></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>Load avarage (15m)</td>
                                            <td><%=host.getLoadAverage15m()%></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>Number of processes</td>
                                            <td><%=host.getNumberOfProcesses()%></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>Number of CPUs</td>
                                            <td><%=host.getNumberOfCPUs() %></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>CPU Utilization</td>
                                            <td><%=String.format("%,.2f",host.getCPUutilization()) %></td>
                                            <td>%</td>
                                        </tr>
                                        <tr>
                                            <td>System uptime</td>
                                            <td><%=host.getSystemUptime()%></td>
                                            <td>seconds</td>
                                        </tr>
                                        <tr>
                                            <td>Total Space</td>
                                            <td><%=String.format("%,.2f", (double)host.getTotalSpace()/1000000000)%></td>
                                            <td>GB</td>
                                        </tr>
                                        <tr>
                                            <td>Used Space</td>
                                            <td><%=String.format("%,.2f", (double)host.getUsedSpace()/1000000000)%></td>
                                            <td>GB</td>
                                        </tr>
                                        <tr>
                                            <td>Space Utilization</td>
                                            <td><%=String.format("%,.2f",host.getSpaceUtilization())%></td>
                                            <td>%</td>
                                        </tr>
                                        <tr>
                                            <td>Disk Utilization</td>
                                            <td><%=String.format("%,.2f",host.getDiskUtilization())%></td>
                                            <td>%</td>
                                        </tr>
                                        <tr>
                                            <td>Memory Utilization</td>
                                            <td><%=String.format("%,.2f",host.getMemoryUtilization())%></td>
                                            <td>%</td>
                                        </tr>
                                        <tr>
                                            <td>Available memory</td>
                                            <td><%=String.format("%,.2f", (double)host.getAvailableMemory()/1000000)%></td>
                                            <td>MB</td>
                                        </tr>
                                        <tr>
                                            <td>Available memory in %</td>
                                            <td><%=String.format("%,.2f",host.getAvailableMemoryInPS())%></td>
                                            <td>%</td>
                                        </tr>
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
