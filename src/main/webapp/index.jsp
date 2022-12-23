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
    <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="./vendor/owc:\Users\WIN 10\AppData\Local\Programs\Microsoft VS Code\resources\app\out\vs\code\electron-sandbox\workbench\workbench.htmll-carousel/css/owl.theme.default.min.css">
    <link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
    <link href="./css/style.css" rel="stylesheet">
</head>

<body>
	
	<% ArrayList<Host> hosts = (ArrayList<Host>) request.getAttribute("hosts");
	   ArrayList<ArrayList<Double>> CPUutilizations = (ArrayList<ArrayList<Double>>) request.getAttribute("CPUutilizations");
	   ArrayList<ArrayList<Double>> MemoryUtilizations = (ArrayList<ArrayList<Double>>) request.getAttribute("MemoryUtilizations");
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
            <a href="Overview_Controller?auth=<%=request.getAttribute("auth")%>" class="brand-logo">
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
                                    <a href="./page_login.jsp" class="dropdown-item">
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
                        <a href="Overview_Controller?auth=<%=request.getAttribute("auth")%>" aria-expanded="false"><i class="icon icon-globe-2"></i>
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
            <!-- row -->
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 col-sm-6">
                        <div class="card">
                            <div class="card-body text-center">
                                <h1 class="card-title">Availability</h1>
                            </div>
                            <div class="card-body">
                                <div id="morris_donught" class="morris_chart_height"></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-sm-6">
                        <div class="card">
                            <div class="card-body text-center">
                                <h1 class="card-title">CPU Load Average</h1>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-responsive-sm">
                                        <thead>
                                            <tr style="color: #737373; font-weight: 500;">
                                                <th>Device name</th>
                                                <th>1m</th>
                                                <th>5m</th>
                                                <th>15m</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       		<% for (int i = 0; i < hosts.size(); i++) { %>
                                            <tr>
                                                <td><%=hosts.get(i).getHostName()%></td>
                                                <td class="color-primary" style="color: #350480; font-weight: 500;"><%=String.format("%.5f", hosts.get(i).getLoadAverage1m())%></td>
                                                <td class="color-primary" style="color: #350480; font-weight: 500;"><%=String.format("%.5f", hosts.get(i).getLoadAverage5m())%></td>
                                                <td class="color-primary" style="color: #350480; font-weight: 500;"><%=String.format("%.5f", hosts.get(i).getLoadAverage15m())%></td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-6 col-sm-6">
                        <div class="card">
                            <div class="card-body text-center">
                                <h1 class="card-title">Devices by CPU Utilization</h1>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-responsive-sm">
                                        <thead>
                                            <tr style="color: #737373; font-weight: 500;">
                                                <th>Device name</th>
                                                <th>Value</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<% for (int i = 0; i < hosts.size(); i++) { %>
                                            <tr>
                                                <td><%=hosts.get(i).getHostName()%></td>
                                                <td class="color-primary" style="color: #350480; font-weight: 500;"><%=String.format("%.5f", hosts.get(i).getCPUutilization())%>%</td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-sm-6">
                    	<div class="card">
	                        <div class="card-header">
	                            <h4 class="card-title">CPU Utilization</h4>
	                        </div>
	                        <div class="card-body">
	                            <div id="flotLine1" class="flot-chart"></div>
	                        </div>
	                    </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-6 col-sm-6">
                        <div class="card">
                            <div class="card-body text-center">
                                <h1 class="card-title">Devices by Memory Utilization</h1>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-responsive-sm">
                                        <thead>
                                            <tr style="color: #737373; font-weight: 500;">
                                                <th>Device name</th>
                                                <th>Value</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       		<% for (int i = 0; i < hosts.size(); i++) { %>
                                            <tr>
                                                <td><%=hosts.get(i).getHostName()%></td>
                                                <td class="color-primary" style="color: #350480; font-weight: 500;"><%=String.format("%.5f", hosts.get(i).getMemoryUtilization())%>%</td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-sm-6">
                        <div class="card">
	                        <div class="card-header">
	                            <h4 class="card-title">Memory Utilization</h4>
	                        </div>
	                        <div class="card-body">
	                            <div id="flotLine2" class="flot-chart"></div>
	                        </div>
	                    </div>
                    </div>
                </div>
        </div>
        <!--**********************************
            Content body end
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
	
	<%
		int avai = 0, unavai = 0, unknown = 0;
		for (int i = 0; i < hosts.size(); i++)
		{
			if ((hosts.get(i).getAvailability()).equals("0"))
				unknown++;
			else if ((hosts.get(i).getAvailability()).equals("1"))
				avai++;
			else if ((hosts.get(i).getAvailability()).equals("2"))
				unavai++;
		}
	%>
	
	<input type="hidden" id="n" name="n" value="<%=CPUutilizations.size()%>">
	<% for (int i = 0; i < CPUutilizations.size(); i++){ 
		ArrayList<Double> CPUutilization = CPUutilizations.get(i);
		ArrayList<Double> MemoryUtilization = MemoryUtilizations.get(i);
		%>
		<input type = "hidden" id="hostname[<%=i%>]" name = "hostname[<%=i%>]" value = "<%=hosts.get(i).getHostName()%>">
		<%
			for (int j = CPUutilization.size()-1; j >=0; j--){
			int value = (CPUutilization.get(j)!=null)?(int)Math.round(CPUutilization.get(j)):0;%>
			<input type="hidden" id="CPUutilization[<%=i%>][<%=j%>]" name="CPUutilization[<%=i%>][<%=j%>]" value="<%=value%>">
			<% value = (MemoryUtilization.get(j)!=null)?(int)Math.round(MemoryUtilization.get(j)):0;%>
			<input type="hidden" id="MemoryUtilization[<%=i%>][<%=j%>]" name="MemoryUtilization[<%=i%>][<%=j%>]" value="<%=value%>">
	<%}}%>
		
	<input type="hidden" id="avai" name="avai" value="<%=avai%>">
	<input type="hidden" id="unavai" name="unavai" value="<%=unavai%>">
	<input type="hidden" id="unknown" name="unknown" value="<%=unknown%>">
    <!--**********************************
        Scripts
    ***********************************-->
    <!-- Required vendors -->
    <script src="./vendor/global/global.min.js"></script>
    <script src="./js/quixnav-init.js"></script>
    <script src="./js/custom.min.js"></script>

    <!-- Chart Morris plugin files -->
    <script src="./vendor/raphael/raphael.min.js"></script>
    <script src="./vendor/morris/morris.min.js"></script>
    <script language = "JavaScript">
	    (function($) {
	        "use strict"
	        
	        Morris.Donut({
	            element: 'morris_donught',
	            data: [{
	                label: "\xa0 \xa0 Available \xa0 \xa0",
	                value: document.getElementById("avai").value,
	
	            }, {
	                label: "\xa0 \xa0 Not available \xa0 \xa0",
	                value: document.getElementById("unavai").value,
	            }, {
	                label: "\xa0 \xa0 Unknown \xa0 \xa0",
	                value: document.getElementById("unknown").value,
	            }],
	            resize: true,
	            colors: ['rgb(104,185,132)', 'rgb(254, 102, 102)', 'rgb(197, 197, 197)']
	        });
	    })(jQuery);
    </script>

    <!-- Vectormap -->
    <script src="./vendor/raphael/raphael.min.js"></script>
    <script src="./vendor/morris/morris.min.js"></script>


    <script src="./vendor/circle-progress/circle-progress.min.js"></script>
    <script src="./vendor/chart.js/Chart.bundle.min.js"></script>
    <script src="./vendor/gaugeJS/dist/gauge.min.js"></script>

    <!--  flot-chart js -->
    <script src="./vendor/flot/jquery.flot.js"></script>
    <script src="./vendor/flot/jquery.flot.pie.js"></script>
    <script src="./vendor/flot/jquery.flot.resize.js"></script>
    <script src="./vendor/flot-spline/jquery.flot.spline.min.js"></script>
    <script>
    (function($) {
        "use strict"
        
    	var newCust = [[0, 2], [1, 3], [2, 6], [3, 5], [4, 7], [5, 8], [6, 10]];
    	var retCust = [[0, 1], [1, 2], [2, 5], [3, 3], [4, 5], [5, 6], [6, 9]];
    	var dt1 = [];
    	var dt2 = [];
    	for (var i = 0; i < document.getElementById("n").value; i+=1) {
    		var temp = [];
    		var temp1 = [];
    		for (var j = 6; j >=0; j-=1)
   			{
   				temp.push([j, document.getElementById("CPUutilization["+i+"]["+j+"]").value]);
   				temp1.push([j, document.getElementById("MemoryUtilization["+i+"]["+j+"]").value]);
   			}
    		dt1.push({
    			data: temp,
    			label: document.getElementById("hostname["+i+"]").value,
    		});
    		dt2.push({
    			data: temp1,
    			label: document.getElementById("hostname["+i+"]").value,
    		});
    	}
    	var dt = [
    		{
    			data: newCust,
    			label: 'New Customer',
    			color: '#f21780'
    		},
    		{
    			data: retCust,
    			label: 'Returning Customer',
    			color: '#fd712c'
    		}];
    	
    	var layout = {
    			series: {
    				lines: {
    					show: false
    				},
    				splines: {
    					show: true,
    					tension: 0.4,
    					lineWidth: 1,
    					//fill: 0.4
    				},
    				shadowSize: 0
    			},
    			points: {
    				show: false,
    			},
    			legend: {
    				noColumns: 1,
    				position: 'nw'
    			},
    			grid: {
    				hoverable: true,
    				clickable: true,
    				borderColor: '#ddd',
    				borderWidth: 0,
    				labelMargin: 5,
    				backgroundColor: 'transparent'
    			},
    			yaxis: {
    				min: 0,
    				max: 100,
    				color: 'transparent',
    				font: {
    					size: 10,
    					color: '#fff'
    				}
    			},
    			xaxis: {
    				color: 'transparent',
    				font: {
    					size: 10,
    					color: '#fff'
    				}
    			}
    		};
    	var plot = $.plot($('#flotLine1'), dt1,layout);

    	var plot = $.plot($('#flotLine2'), dt2, layout);

    })(jQuery);
    </script>


    <!-- Owl Carousel -->
    <script src="./vendor/owl-carousel/js/owl.carousel.min.js"></script>

    <!-- Counter Up -->
    <script src="./vendor/jqvmap/js/jquery.vmap.min.js"></script>
    <script src="./vendor/jqvmap/js/jquery.vmap.usa.js"></script>
    <script src="./vendor/jquery.counterup/jquery.counterup.min.js"></script>


    <script src="./js/dashboard/dashboard-1.js"></script>

</body>

</html>