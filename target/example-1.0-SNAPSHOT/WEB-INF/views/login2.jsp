<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="checkLoginUrl" value="/login2"/>

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>Travel Agency Sign In Form A Flat Responsive Widget Template :: W3layouts</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Travel Agency Sign In Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Custom-Styleheet-Links -->
    <link href="<c:url value="/resources/home/css/style.css"/>" rel="stylesheet" />
    <link href="<c:url value="/resources/home/css/animate-custom.css"/>" rel="stylesheet" />
    <!-- //Custom-Styleheet-Links -->

    <!-- Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" type="text/css" media="all">
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Montserrat:400,700" 		  type="text/css" media="all">
    <!-- //Fonts -->

</head>
<!-- //Head -->



<!-- Body -->
<body>

<h1 class="w3layouts agileits">POLY TRAVEL</h1>

<div class="container w3layouts agileits">

    <div class="content-left w3layouts agileits">
        <img src="/resources/home/images/lgimage/background.jpg" alt="W3layouts Agileits">
        <p>Plan your next dream trip. Select your destination and leave the rest to us.</p>
        <a class="more w3layouts agileits" href="#">Xem thêm</a>

    </div>

    <div class="content-right w3layouts agileits">
        <section>
            <div id="container_demo">
                <a class="hiddenanchor w3layouts agileits" id="tologin"></a>
                <a class="hiddenanchor w3layouts agileits" id="toregister"></a>
                <div id="wrapper">
                    <div id="login" class="animate w3layouts agileits form">
                        <h2 class="w3layouts agileits">Đăng nhập</h2>
                        <form  id="sign_in" method="post" action="${checkLoginUrl}">
                            <c:if test="${not empty error}">
                                <span class="text-danger">
                                    ${error}
                                </span>
                            </c:if>
                            <label>Tên tài khoản</label>
                            <input type="text" Name="user_Name" required="">
                            <label>Mật khẩu</label>
                            <input type="password" Name="user_Password" required="">
                            <div class="send-button w3layouts agileits">
                                <p><a href="#">Quên mật khẩu</a></p>
                                <form>
                                    <input type="submit" value="ĐĂNG NHẬP">
                                </form>
                                <div class="clear"></div>
                            </div>
                            <p class="change_link w3layouts agileits">
                                Bạn chưa có tài khoản? <a href="registration" class="to_register">Đăng ký!</a>
                            </p>
                            <div class="clear"></div>
                        </form>
<%--                        <div class="social-icons w3layouts agileits">--%>
<%--                            <p>OR USE YOUR SOCIAL ACCOUNTS</p>--%>
<%--                            <ul>--%>
<%--                                <li class="fb w3ls w3layouts agileits"><a href="#"><span class="icons w3layouts agileits"></span><span class="text w3layouts agileits">Facebook</span></a></li>--%>
<%--                                <li class="twt w3ls w3layouts agileits"><a href="#"><span class="icons w3layouts agileits"></span><span class="text w3layouts agileits">Twitter</span></a></li>--%>
<%--                                <div class="clear"></div>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </section>
    </div>
    <div class="clear"></div>

</div>

<div class="footer w3layouts agileits">
    <p> &copy; 2020 - 2021 Đăng nhập | Thiết kế <a href="#" target="_blank">Dự án 2</a></p>
</div>

</body>
<!-- //Body -->

</html>