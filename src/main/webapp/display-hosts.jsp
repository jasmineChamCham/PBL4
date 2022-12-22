<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <a href="index.jsp" class="brand-logo">
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
                        <a href="index.jsp" aria-expanded="false"><i class="icon icon-globe-2"></i>
                        <span class="nav-text">Overview</span></a>
                    </li>
                    <li>
                        <a href="display-hosts.jsp" aria-expanded="false"><i class="icon icon-app-store"></i>
                        <span class="nav-text">Hosts</span></a>
                    </li>
                    <li class="nav-label first">Account</li>
                    <li>
                        <a href="change-password.jsp" aria-expanded="false"><i class="icon-key"></i>
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
                        <a href="create-host.jsp"></a>
                        <button type="submit" class="btn btn-primary" onclick="location.href='create-host.jsp'">Create new host</button>
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
                                            <tr>
                                                <th>1</th>
                                                <td>Zabbix Server</td>
                                                <td>127.0.0.1:10050</td>
                                                <td>
                                                    <span class="badge badge-success">Available</span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="detail-host.jspl" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="View detail">
                                                            <i class="fa fa-eye"></i> 
                                                        </a>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="update-host.jsp" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="Edit">
                                                            <i class="fa fa-pencil color-muted"></i> 
                                                        </a>
                                                        <a href="confirm-delete.jspl" data-toggle="tooltip"
                                                            data-placement="top" title="Delete">
                                                            <i class="fa fa-trash-o"></i>
                                                        </a>
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>2</th>
                                                <td>Zabbix Server</td>
                                                <td>192.168.1.44:10050</td>
                                                <td><span class="badge badge-danger">Not available</span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="detail-host.jsp" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="View detail">
                                                            <i class="fa fa-eye"></i> 
                                                        </a>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="update-host.jsp" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="Edit">
                                                            <i class="fa fa-pencil color-muted"></i> 
                                                        </a>
                                                        <a href="confirm-delete.jsp" data-toggle="tooltip"
                                                            data-placement="top" title="Delete">
                                                            <i class="fa fa-trash-o"></i>
                                                        </a>
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <th>3</th>
                                                <td>Zabbix Server</td>
                                                <td>192.168.1.48:10050</td>
                                                <td><span class="badge badge-dark">Unknown</span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="detail-host.jsp" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="View detail">
                                                            <i class="fa fa-eye"></i> 
                                                        </a>
                                                    </span>
                                                </td>
                                                <td>
                                                    <span>
                                                        <a href="update-host.jsp" class="mr-4" data-toggle="tooltip"
                                                            data-placement="top" title="Edit">
                                                            <i class="fa fa-pencil color-muted"></i> 
                                                        </a>
                                                        <a href="confirm-delete.jsp" data-toggle="tooltip"
                                                            data-placement="top" title="Delete">
                                                            <i class="fa fa-trash-o"></i>
                                                        </a>
                                                    </span>
                                                </td>
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