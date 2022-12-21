<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Raspberry Monitoring Admin Dashboard </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
    <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="./vendor/owc:\Users\WIN 10\AppData\Local\Programs\Microsoft VS Code\resources\app\out\vs\code\electron-sandbox\workbench\workbench.htmll-carousel/css/owl.theme.default.min.css">
    <link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
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
                <img class="logo-abbr" src="./images/logo.png" alt="">
                <h2 style="color: #fff; tab-size: 2; vertical-align: middle;">PBL4</h2>
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
                            <div class="testimonial-content">
                                <div class="testimonial-text">
                                    <i class="fa fa-quote-left"></i> Welcome you to our project!
                                    <i class="fa fa-quote-right"></i>
                                </div>
                            </div>
                        </div>

                        <ul class="navbar-nav header-right">
                            <li class="nav-item dropdown header-profile">
                                <a class="nav-link" href="#" role="button" data-toggle="dropdown">
                                    <i class="mdi mdi-account"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <a href="page-profile.jsp" class="dropdown-item">
                                        <i class="icon-user"></i>
                                        <span class="ml-2">Profile</span>
                                    </a>
                                    <a href="./page-login.jsp" class="dropdown-item">
                                        <i class="icon-key"></i>
                                        <span class="ml-2">Log Out</span>
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
                        <!-- chinh lai duong dan -->
                        <a href="page-display-hosts.jsp" aria-expanded="false"><i class="icon icon-app-store"></i>
                        <span class="nav-text">Hosts</span></a>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                            class="icon icon-single-04"></i><span class="nav-text">Account</span></a>
                        <ul aria-expanded="false">
                            <li><a href="page-profile.jsp">Profile</a></li>
                            <li><a href="page-change-password.jsp">Change password</a></li>
                        </ul>
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
                            <h4>Hi, welcome to our project PBL4!</h4>
                        </div>
                    </div>
                </div>
                <!-- row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Profile</h4>
                            </div>
                            <div class="card-body">
                                <div class="form-validation">
                                    <form class="form-valide" action="#" method="post">
                                        <div class="row">
                                            <div class="col-xl-12">
                                                <div class="form-group row">
                                                    <label class="col-lg-2 col-form-label" for="val-username">Username</label>
                                                    <div class="col-lg-7">
                                                        <input type="text" class="form-control" name="val-username" value="Admin">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-lg-2 col-form-label" for="val-lang">Language</label>
                                                    <div class="col-lg-7">
                                                        <input type="text" class="form-control" name="val-lang" value="English" readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="autologin" class="col-lg-2">Auto-login</label>
                                                    <div class="col-lg-2 col-form-label">                                                        
                                                        <input type="radio" name="autolog" value="autologin" />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label for="autologout" class="col-lg-2">Auto-logout</label>
                                                    <div class="col-lg-2 col-form-label">
                                                        <input type="radio" name="autolog" value="autologout" />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-lg-2 col-form-label" for="val-refresh">Refresh</label>
                                                    <div class="col-lg-7">
                                                        <input type="text" class="form-control"name="val-refresh" value="30s">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                                <button type="submit" class="btn btn-light">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
    <!-- Jquery Validation -->
    <script src="./vendor/jquery-validation/jquery.validate.min.js"></script>
    <!-- Form validate init -->
    <script src="./js/plugins-init/jquery.validate-init.js"></script>

</body>

</html>