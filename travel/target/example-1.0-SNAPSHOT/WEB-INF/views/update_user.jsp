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

    .profile-edit-btn {
        border: none;
        border-radius: 1.5rem;
        width: 50%;
        padding: 2%;
        font-weight: 600;
        color: #6c757d;
        cursor: pointer;
    }
</style>

<head>
    <title>User Info</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>">
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"/>"></script>
    <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/>"></script>
    <script>
        $(document).ready(function () {
            (function (document) {
                var input = document.getElementById("files"),
                    output = document.getElementById("result"),
                    fileData; // We need fileData to be visible to getBuffer.

                // Eventhandler for file input.
                function openfile(evt) {
                    var files = input.files;
                    // Pass the file to the blob, not the input[0].
                    fileData = new Blob([files[0]]);
                    // Pass getBuffer to promise.
                    var promise = new Promise(getBuffer);
                    // Wait for promise to be resolved, or log error.
                    promise.then(function (data) {
                        // Here you can pass the bytes to another function.
                        output.value = data.toString();
                        console.log(data);
                    }).catch(function (err) {
                        console.log('Error: ', err);
                    });
                }

                /*
                  Create a function which will be passed to the promise
                  and resolve it when FileReader has finished loading the file.
                */
                function getBuffer(resolve) {
                    var reader = new FileReader();
                    reader.readAsArrayBuffer(fileData);
                    reader.onload = function () {
                        var arrayBuffer = reader.result
                        var bytes = new Uint8Array(arrayBuffer);
                        resolve(bytes);
                    }
                }

                // Eventlistener for file input.
                input.addEventListener('change', openfile, false);
            }(document));
        })
    </script>
</head>

<!--Main-->
<hr>
<form:form method="POST" modelAttribute="dto" enctype="multipart/form-data">
    <div class="container bootstrap snippet">
        <div class="row">
            <div class="col-sm-3">
                <!--left col-->

                <div class="text-center">
                    <div class="profile-img">
                        <img src="data:image;base64,${dto.base64Image}"
                             class="avatar img-circle img-thumbnail"
                             alt="avatar">
                        <div class="file btn btn-lg btn-primary">
                            Đổi ảnh đại diện
                            <input type="file" name="file" id="file" class="in text-center center-block file-upload"/>
                            <input type="hidden" name="imageByte" id="result">
                        </div>
                    </div>
                </div>
                <br>

            </div>
            <!--/col-3-->
            <div class="col-sm-9">

                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <form class="form" action="##" method="post" id="registrationForm">
                            <div class="form-group">

                                <div class="col-xs-12">
                                    <label>
                                        <h4>Họ và tên</h4>
                                    </label>
                                    <form:input type="text" class="form-control" path="user_Fullname" placeholder="*"/><br/>
                                    <form:input type="hidden" class="form-control" path="user_Id" placeholder="*"/>
                                    <form:input type="hidden" class="form-control" path="image" placeholder="*"/>
                                    <form:input type="hidden" class="form-control" path="user_Createdate" placeholder="*"/>
                                    <form:input type="hidden" class="form-control" path="user_Role" placeholder="*"/>
                                    <form:input type="hidden" class="form-control" path="user_Name" placeholder="*"/>
                                    <form:input type="hidden" class="form-control" path="user_Password" placeholder="*"/>
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-12">
                                    <label>
                                        <h4>Giới tính</h4>
                                    </label>
                                    <form:select path="user_Gender" class="form-control" style="height: 34px;">
                                        <option value="1">Nam</option>
                                        <option value="2">Nữ</option>
                                        <option value="3">Khác</option>
                                    </form:select><br/>
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-12">
                                    <label>
                                        <h4>Số điện thoại</h4>
                                    </label>
                                    <form:input type="text" class="form-control" path="user_Phone" placeholder="*"/><br/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12">
                                    <label>
                                        <h4>Email</h4>
                                    </label>
                                    <form:input type="text" class="form-control" path="user_Email" placeholder="*"/><br/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button class="btn btn-lg btn-success" type="submit"><i
                                            class="glyphicon glyphicon-ok-sign"></i> Save
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/col-9-->
</form:form>

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
</script>