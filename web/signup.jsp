<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Material Design for Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.0.0/css/all.css" />
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
    <!-- MDB -->
    <link rel="stylesheet" href="css/mdb.min.css" />
</head>
<body>
<!--Main Navigation-->
<header>
    <style>
        #intro {
            background-image: url(https://mdbootstrap.com/img/new/fluid/city/008.jpg);
            height: 100vh;
        }

        /* Height for devices larger than 576px */
        @media (min-width: 992px) {
            #intro {
                margin-top: -58.59px;
            }
        }

        .navbar .nav-link {
            color: #fff !important;
        }
    </style>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark d-none d-lg-block" style="z-index: 2000;">
        <div class="container-fluid">
            <!-- Navbar brand -->
            <button class="navbar-toggler" type="button" data-mdb-collapse-init data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="#intro">Home</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->

    <!-- Background image -->
    <%
        if (request.getSession().getAttribute("username") != null) {
            response.sendRedirect("welcome.jsp");
        }
    %>
    <div id="intro" class="bg-image shadow-2-strong">
        <div class="mask d-flex align-items-center h-100" style="background-color: rgba(0, 0, 0, 0.8);">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-5 col-md-8">
                        <form action="/sendOTP.do" method="post" class="bg-white rounded shadow-5-strong p-5">
                            <!-- Email input -->
                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="text" name="name" class="form-control" />
                                <label class="form-label">Name</label>
                            </div>

                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="text" name="family" class="form-control" />
                                <label class="form-label">Family</label>
                            </div>


                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="text" name="cellphone" class="form-control" />
                                <label class="form-label">Cell Phone</label>
                            </div>


                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="password" name="password" class="form-control" />
                                <label class="form-label">Password</label>
                            </div>

                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="password" name="rePassword" class="form-control" />
                                <label class="form-label">Renter Password</label>
                            </div>
                            <c:if test="${not empty errorMessage}">
                                <p style="color: red">${errorMessage}</p>
                            </c:if>
                            <!-- Submit button -->
                            <input type="submit" class="btn btn-primary btn-block" data-mdb-ripple-init value="sign up">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Background image -->
</header>
<!--Main Navigation-->

<!--Footer-->
<footer class="bg-light text-lg-start">
    <div class="py-4 text-center">
        <a role="button" class="btn btn-primary btn-lg m-2" data-mdb-ripple-init
           href="https://www.youtube.com/channel/UC5CF7mLQZhvx8O5GODZAhdA" rel="nofollow" target="_blank">
            Learn Bootstrap 5
        </a>
        <a role="button" class="btn btn-primary btn-lg m-2" data-mdb-ripple-init href="https://mdbootstrap.com/docs/standard/" target="_blank">
            Download MDB UI KIT
        </a>
    </div>

    <hr class="m-0" />

    <div class="text-center py-4 align-items-center">
        <p>Follow MDB on social media</p>
        <a href="https://www.youtube.com/channel/UC5CF7mLQZhvx8O5GODZAhdA" class="btn btn-primary m-1" role="button" data-mdb-ripple-init
           rel="nofollow" target="_blank">
            <i class="fab fa-youtube"></i>
        </a>
        <a href="https://www.facebook.com/mdbootstrap" class="btn btn-primary m-1" role="button" rel="nofollow" data-mdb-ripple-init
           target="_blank">
            <i class="fab fa-facebook-f"></i>
        </a>
        <a href="https://twitter.com/MDBootstrap" class="btn btn-primary m-1" role="button" rel="nofollow" data-mdb-ripple-init
           target="_blank">
            <i class="fab fa-twitter"></i>
        </a>
        <a href="https://github.com/mdbootstrap/mdb-ui-kit" class="btn btn-primary m-1" role="button" rel="nofollow" data-mdb-ripple-init
           target="_blank">
            <i class="fab fa-github"></i>
        </a>
    </div>

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2020 Copyright:
        <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>
<!--Footer-->
<!-- MDB -->
<script type="text/javascript" src="js/mdb.umd.min.js"></script>
</body>
</html>
