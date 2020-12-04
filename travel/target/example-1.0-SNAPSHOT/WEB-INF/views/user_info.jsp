<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/login" var="loginUrl"/>
<c:url value="/logout" var="logoutUrl"/>
<link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"/>" rel="stylesheet"
      id="bootstrap-css">
<script src="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>" rel="stylesheet"
      id="bootstrap-css">
<script src="<c:url value="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>"></script>
<!------ Include the above in your HEAD tag ---------->
<head>
    <title>User Info</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"/>"></script>
    <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>
    <style>
        .profile-img .file {
            position: relative;
            overflow: hidden;
            margin-top: 3%;
            width: 70%;
            border: none;
            border-radius: 0;
            font-size: 15px;
            background: #212529b8;
        }

        .profile-img .file .in {
            position: absolute;
            opacity: 0;
            right: 0;
            top: 0;
        }

        #bookTour {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #bookTour td,
        #bookTour th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #bookTour tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #bookTour tr:hover {
            background-color: #ddd;
        }

        #bookTour th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #fa9e1b;
            color: white;
        }
    </style>

</head>

<!--Main-->
<br/>
<h2 style="padding-left: 10%;">HỒ SƠ TÀI KHOẢN</h2>
<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-3">
            <!--left col-->

            <div class="text-center">
                <div class="profile-img">
                    <img src="data:image;base64,${dto.base64Image}" class="avatar img-circle img-thumbnail"
                         alt="avatar">
                    <h3>${dto.user_Fullname}</h3>
                </div>
            </div>
            <br>

        </div>
        <!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Thông tin</a></li>
                <li><a data-toggle="tab" href="#list">Danh sách các tour đã đăng ký</a></li>
            </ul>


            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <form class="form" action="##" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-12">
                                <label>
                                    <h4>Họ và tên: ${dto.user_Fullname}</h4>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-12">
                                <label>
                                    <input type="hidden" id="gender" value="${dto.user_Gender}">
                                    <h4 id="gender_value" onload="load()"></h4>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-12">
                                <label>
                                    <h4>Số điện thoại: ${dto.user_Phone}</h4>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-12">
                                <label>
                                    <h4>Email: ${dto.user_Email}</h4>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <a class="btn btn-lg" style="background-color: #fa9e1b; color: white;"
                                   href="/home/user_info/update"><i
                                        class="glyphicon glyphicon-wrench"></i> Chỉnh sửa thông tin</a>
                            </div>
                        </div>
                    </form>
                </div>

                <!--settings-->
                <div class="tab-pane" id="list">
                    <form class="form" action="##" method="post">
                        <br/><br/>
                        <table id="bookTour">
                            <thead>
                            <tr>
                                <th>Giá</th>
                                <th>Ngày đăng ký</th>
                                <th>Số lượng trẻ em</th>
                                <th>Số lượng người lớn</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${listBookTour}">
                                <tr>
                                    <td>${list.price}</td>
                                    <td>${list.createDate}</td>
                                    <td>${list.numChild}</td>
                                    <td>${list.numAdult}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<script>
    $(document).ready(function () {


        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('.avatar').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }


        $(".file-upload").on('change', function () {
            readURL(this);
        });
    });

    window.onload = function () {
        var gender = document.getElementById("gender").value;
        var gender_value = document.getElementById("gender_value");

        if (gender == 1) {
            gender_value.innerHTML = "Giới tính: Nam";
        }
        if (gender == 2) {
            gender_value.innerHTML = "Giới tính: Nữ";
        }
        if (gender == 3) {
            gender_value.innerHTML = "Giới tính: Khác";
        }
    }
</script>
