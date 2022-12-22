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
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Update host</h4>
                    </div>
                    <div class="card-body">
                        <div class="basic-form">
                            <form>
                                <div class="form-group row">
                                    <label class="col-lg-4 col-form-label" for="val-hostname">Host name
                                        <span class="text-danger">*</span>
                                    </label>
                                    <div class="col-lg-12">
                                        <input type="text" class="form-control" name="val-hostname" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-lg-4 col-form-label" for="val-templates">Templates
                                        <span class="text-danger">*</span>
                                    </label>
                                    <div class="col-lg-12" class="bootstrap-badge">
                                        <span class="badge badge-pill badge-info" style="background-color: #FFCAC8;">Linux by Zabbix agent</span>
                                        <span class="badge badge-pill badge-info" style="background-color: #FFDBA4;">Linux by Zabbix agent active</span>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-lg-4 col-form-label" for="val-groups">Groups
                                        <span class="text-danger">*</span>
                                    </label>
                                    <div class="col-lg-12" class="bootstrap-badge">
                                        <span class="badge badge-pill badge-info" style="background-color: #C4DFAA;">Discovered hosts</span>
                                        <span class="badge badge-pill badge-info" style="background-color: #C1EFFF;">Templates/Operating systems</span>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-lg-4 col-form-label" for="val-ipaddress">IP Address
                                        <span class="text-danger">*</span>
                                    </label>
                                    <div class="col-lg-12">
                                        <input type="text" class="form-control" name="val-ipaddress" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-lg-4 col-form-label" for="val-port">Port
                                        <span class="text-danger">*</span>
                                    </label>
                                    <div class="col-lg-12">
                                        <input type="text" class="form-control" name="val-port" value="">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                        <button type="reset" class="btn btn-light">Cancel</button>
                                    </div>
                                </div>
                            </form>
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

</html>/html>