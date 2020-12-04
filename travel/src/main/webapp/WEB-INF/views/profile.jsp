<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Trang quản lý | Quản lý tài khoản</title>
    <!-- Favicon-->
    <link rel="icon" href="<c:url value="/resources/admin/favicon.ico"/>" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="<c:url value="/resources/admin/plugins/bootstrap/css/bootstrap.css"/>" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="<c:url value="/resources/admin/plugins/node-waves/waves.css"/>" rel="stylesheet"/>

    <!-- Animation Css -->
    <link href="<c:url value="/resources/admin/plugins/animate-css/animate.css"/>" rel="stylesheet"/>

    <!-- JQuery DataTable Css -->
    <link href="<c:url value="/resources/admin/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css"/>"
          rel="stylesheet">

    <!-- Bootstrap Select Css -->
    <link href="<c:url value="/resources/admin/plugins/bootstrap-select/css/bootstrap-select.css"/>" rel="stylesheet"/>

    <!-- Custom Css -->
    <link href="<c:url value="/resources/admin/css/style.css"/>" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="<c:url value="/resources/admin/css/themes/all-themes.css"/>" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .modal {
            text-align: center;
            padding: 0 !important;
        }

        .modal:before {
            content: '';
            display: inline-block;
            height: 100%;
            vertical-align: middle;
            margin-right: -4px;
        }

        .modal-dialog {
            display: inline-block;
            text-align: left;
            vertical-align: middle;
        }

        .button-style {
            margin-right: 10px;
        }
    </style>
</head>

<body class="theme-red" onload="updateUser(${dto.user_Id})" >
<!-- Page Loader -->
<div class="page-loader-wrapper">
    <div class="loader">
        <div class="preloader">
            <div class="spinner-layer pl-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
        </div>
        <p>Please wait...</p>
    </div>
</div>
<!-- #END# Page Loader -->
<!-- Overlay For Sidebars -->
<div class="overlay"></div>
<!-- #END# Overlay For Sidebars -->
<!-- Search Bar -->
<div class="search-bar">
    <div class="search-icon">
        <i class="material-icons">search</i>
    </div>
    <input type="text" placeholder="START TYPING...">
    <div class="close-search">
        <i class="material-icons">close</i>
    </div>
</div>
<!-- #END# Search Bar -->
<!-- Top Bar -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse"
               data-target="#navbar-collapse" aria-expanded="false"></a>
            <a href="javascript:void(0);" class="bars"></a>
            <a class="navbar-brand" href="#">TRANG QUẢN LÝ </a>
        </div>
    </div>
</nav>
<!-- #Top Bar -->
<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">
        <!-- User Info -->
        <div class="user-info">
            <div class="image">
                <img src="<c:url value="/resources/admin/images/user.png"/>" width="48" height="48" alt="User"/>
            </div>
            <div class="info-container">
                <c:if test="${not empty dto}">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true"
                         aria-expanded="false">${dto.user_Name}</div>
                    <div class="email">${dto.user_Email}</div>
                </c:if>
                <div class="btn-group user-helper-dropdown">
                    <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                    <ul class="dropdown-menu pull-right">
                        <li><a href="javascript:void(0);"><i class="material-icons">person</i>Hồ sơ</a></li>
                        <li role="separator" class="divider"></li>
                        <%--                        <li><a href="javascript:void(0);"><i class="material-icons">group</i>Followers</a></li>--%>
                        <%--                        <li><a href="javascript:void(0);"><i class="material-icons">shopping_cart</i>Sales</a></li>--%>
                        <%--                        <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Likes</a></li>--%>
                        <%--                        <li role="separator" class="divider"></li>--%>
                        <li><a href="/logout"><i class="material-icons">input</i>Đăng xuất</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- #User Info -->
        <!-- Menu -->
        <div class="menu">
            <ul class="list">
                <li class="header"> Quản lý tài khoản </li>
                <li>
                    <a href="/home/profile">
                        <i class="material-icons">list</i>
                        <span>Hồ sơ cá nhân</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/home">
                        <i class="material-icons">list</i>
                        <span>Đổi mật khẩu</span>
                    </a>
                </li>
<%--                <li class="header">Quản lý đăng ký tour</li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/ordertour">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Các tour mới được đăng ký</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/offertour">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Các tour mới được đề xuất</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="header">Quản lý tour</li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/tours">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý tour</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/image">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý ảnh</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/topic">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý chủ đề</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/location">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý địa điểm</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/vehicle">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý phương tiện</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/accommodation">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý khách sạn</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/admin/restaurant">--%>
<%--                        <i class="material-icons">list</i>--%>
<%--                        <span>Quản lý nhà hàng</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
            </ul>
        </div>
        <!-- #Menu -->
        <!-- Footer -->
        <div class="legal">
            <div class="copyright">
                &copy; 2020 - 2021 <a href="javascript:void(0);">Trang quản lý</a>.
            </div>
            <div class="version">
                <b>Version: </b> 1.0.5
            </div>
        </div>
        <!-- #Footer -->
    </aside>
    <!-- #END# Left Sidebar -->
</section>


<section class="content">
    <div class="container-fluid">
        <div class="block-header">
            <h2>
                QUẢN LÝ TÀI KHOẢN
            </h2>
            <c:if test="${not empty status}">
                <div class="alert alert-success alert-dismissible" style="margin-top: 20px" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Thành công!</strong> Bạn nên kiểm tra lại dữ liệu bên dưới.
                </div>
            </c:if>
        </div>
        <!-- Basic Examples -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header" hidden>
                        <h2>
                            BẢNG TÀI KHOẢN
                        </h2>
                        <button class="btn btn-circle pull-right" id="button-save">
                            <i class="fa fa-user-plus"></i>
                        </button>
                    </div>
                    <div class="body" hidden>
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                <thead>
                                <tr>
                                    <th>HỌ tên</th>
                                    <th>Tên tài khoản</th>
                                    <th>Mật khẩu</th>
                                    <th>Vai trò</th>
                                    <th>Giới tính</th>
                                    <th>Số điện thoại</th>
                                    <th>Email</th>
                                    <th>Ngày tạo</th>
                                    <th>Ngày cập nhật cuối</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                </tfoot>
                                <tbody>
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <td>${user.user_Fullname}</td>
                                        <td>${user.user_Name}</td>
                                        <td>${user.user_Password}</td>
                                        <td>${user.user_Role}</td>
                                        <td>${user.user_Gender}</td>
                                        <td>${user.user_Phone}</td>
                                        <td>${user.user_Email}</td>
                                        <td>${user.user_Createdate}</td>
                                        <td>${user.user_Lastupdate}</td>
                                        <td>${user.user_Status}</td>
                                        <td style="display: flex">
                                            <input type="hidden" name="user_Createdate" value="${user.user_Createdate}">
                                            <button type="button" class="btn btn-circle" style="margin-right: 10px"
                                                    id="btn-edit" onclick="updateUser(${user.user_Id})">
                                                <i class="fa fa-edit"></i>
                                            </button>

                                                <%--                                            <button class="btn btn-circle" type="button"--%>
                                                <%--                                                    onclick="handleDelete(${user.user_Id})">--%>
                                                <%--                                                <i class="fa fa-trash"></i>--%>
                                                <%--                                            </button>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>


                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Cập nhật hồ sơ</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="body">
                                            <form id="form_validation" method="POST">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="user_Fullname" name="user_Fullname" required>
                                                        <label class="form-label">Họ tên</label>
                                                    </div>
                                                </div>
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="user_Name" name="user_Name" required>
                                                        <label class="form-label">Tên tài khoản</label>
                                                    </div>
                                                </div>
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="password" class="form-control" id="user_Password" name="user_Password"
                                                               required>
                                                        <label class="form-label">Mật khẩu</label>
                                                    </div>
                                                </div>
                                                <div class="form-group form-float">
                                                    <div class="form-inline">
                                                        <select class="form-control show-tick" id="IDuser_Role" name="user_Role" required>
                                                            <option value="">-- Vai trò --</option>
                                                            <option value="0">Thành viên</option>
                                                            <option value="1">Nhân viên</option>
                                                            <option value="2">Quản lý</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group form-float">
                                                    <div class="form-inline">
                                                        <select class="form-control show-tick" id="IDuser_Gender" name="user_Gender" required>
                                                            <option value="">-- Giới tính --</option>
                                                            <option value="0">Nữ</option>
                                                            <option value="1">Nam</option>
                                                            <option value="2">Khác</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="user_Phone" name="user_Phone"
                                                               required>
                                                        <label class="form-label">Số điện thoại</label>
                                                    </div>
                                                </div>
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="user_Email" name="user_Email"
                                                               required>
                                                        <label class="form-label">Email</label>
                                                    </div>
                                                </div>
                                                <%--                                <div class="form-group form-float">--%>
                                                <%--                                    <div class="form-line">--%>
                                                <%--                                        <input type="hidden" class="form-control" id="user_Createdate" name="user_Createdate"--%>
                                                <%--                                               required>--%>
                                                <%--                                        <label class="form-label">Createdate</label>--%>
                                                <%--                                    </div>--%>
                                                <%--                                </div>--%>
                                                <%--                                <div class="form-group form-float">--%>
                                                <%--                                    <div class="form-line">--%>
                                                <%--                                        <input type="hidden" class="form-control" id="user_Lastupdate" name="user_Lastupdate"--%>
                                                <%--                                               required>--%>
                                                <%--                                        <label class="form-label">Lastupdate</label>--%>
                                                <%--                                    </div>--%>
                                                <%--                                </div>--%>
                                                <div class="form-group form-float">
                                                    <div class="form-inline">
                                                        <select class="form-control show-tick" id="IDuser_Status" name="user_Status" required>
                                                            <option value="">-- Trạng thái tài khoản --</option>
                                                            <option value="0">Hoạt động</option>
                                                            <option value="1">Vô hiệu hóa</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <input type="hidden" name="user_Id" id="user_Id" value="">
                                                <button type="button" id="btn-save" class="btn btn-primary pull-right">Lưu thay đổi
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">

                            </div>
                        </div>
                    </div>

            </div>
        </div>
        <!-- #END# Basic Examples -->
    </div>
</section>




<!-- Jquery Core Js -->
<script src="<c:url value="/resources/admin/plugins/jquery/jquery.min.js"/>"></script>

<!-- Bootstrap Core Js -->
<script src="<c:url value="/resources/admin/plugins/bootstrap/js/bootstrap.js"/>"></script>

<!-- Select Plugin Js -->
<script src="<c:url value="/resources/admin/plugins/bootstrap-select/js/bootstrap-select.js"/>"></script>

<!-- Slimscroll Plugin Js -->
<script src="<c:url value="/resources/admin/plugins/jquery-slimscroll/jquery.slimscroll.js"/>"></script>

<!-- Waves Effect Plugin Js -->
<script src="<c:url value="/resources/admin/plugins/node-waves/waves.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-validation/jquery.validate.js"/>"></script>

<!-- Jquery DataTable Plugin Js -->
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/jszip.min.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/pdfmake.min.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/vfs_fonts.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"/>"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-datatable/extensions/export/buttons.print.min.js"/>"></script>
<!-- Ckeditor -->
<%--<script src="<c:url value="/resources/admin/plugins/ckeditor/ckeditor.js"/>"></script>--%>

<!-- TinyMCE -->
<script src="<c:url value='/resources/admin/tinymce/js/tinymce/tinymce.min.js' />"></script>
<!-- Dropzone Plugin Js -->
<script src="<c:url value='/resources/admin/plugins/dropzone/dropzone.js'/>"></script>

<!-- Custom Js -->
<script src="<c:url value="/resources/admin/js/admin.js"/>"></script>
<script src="<c:url value="/resources/admin/js/pages/forms/form-validation.js"/>"></script>
<script src="<c:url value="/resources/admin/js/pages/tables/jquery-datatable.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<!-- Demo Js -->
<script src="<c:url value="/resources/admin/js/demo.js"/>"></script>
<script>
    $(document).ready(function () {
        let form_validation = $('#form_validation');
        $('#btn-save').on('click', function () {
            let user_Id = $('#user_Id').val();
            if (user_Id !== "") {
                form_validation.attr('action', '/home/profile/update');
            } else {
                form_validation.attr('action', '/home/profile/create');
            }
            form_validation.submit();
        });
        $('#button-save').on('click', function () {
            clearDataForInputText($('#user_Fullname'), "");
            clearDataForInputText($('#user_Name'), "");
            clearDataForInputText($('#user_Password'), "");
            clearDataForInputText($('#user_Phone'), "");
            clearDataForInputText($('#user_Email'), "");
            clearDataForInputText($('#user_Createdate'), "");
            clearDataForInputText($('#user_Lastupdate'), "");
            clearDataForInputText($('#user_Id'), "");
            $('#IDuser_Role').val("");
            $('#IDuser_Role').selectpicker('refresh');
            $('#IDuser_Gender').val("");
            $('#IDuser_Gender').selectpicker('refresh');
            $('#IDuser_Status').val("");
            $('#IDuser_Status').selectpicker('refresh');
            $('#exampleModalCenter').modal('toggle');
        });
    });

    function updateUser(id) {
        let user_Fullname = $('#user_Fullname');
        let user_Name = $('#user_Name');
        let user_Password = $('#user_Password');
        let user_Phone = $('#user_Phone');
        let user_Email = $('#user_Email');
        let user_Createdate = $('#user_Createdate');
        let user_Lastupdate = $('#user_Lastupdate');
        let user_Gender = $('#IDuser_Gender');
        let user_Status = $('#IDuser_Status');
        let user_Role = $('#IDuser_Role');
        let user_Id = $('#user_Id');
        $.ajax({
            url: '/home/profile/' + id,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: '',
            success: function (data) {
                setDataForInputText(user_Fullname, data.user_Fullname);
                setDataForInputText(user_Name, data.user_Name);
                setDataForInputText(user_Password, data.user_Password);
                setDataForInputText(user_Phone, data.user_Phone);
                setDataForInputText(user_Email, data.user_Email);
                setDataForInputText(user_Createdate, data.user_Createdate);
                setDataForInputText(user_Lastupdate, data.user_Lastupdate);
                setDataForInputText(user_Id, data.user_Id);
                user_Role.val(data.user_Role);
                user_Role.selectpicker('refresh');
                user_Gender.val(data.user_Gender);
                user_Gender.selectpicker('refresh');
                user_Status.val(data.user_Status);
                user_Status.selectpicker('refresh');
                $('#exampleModalCenter').modal('toggle');
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

    function setDataForInputText(field, data) {
        field.closest('div').addClass('focused');
        field.val(data);
    }

    function clearDataForInputText(field, data) {
        field.closest('div').removeClass('focused');
        field.val(data);
    }
    tinymce.init({
        selector: 'textarea#mytinymce',
        plugins: 'print preview fullpage powerpaste casechange importcss tinydrive searchreplace autolink autosave save directionality advcode visualblocks visualchars fullscreen image link media mediaembed template codesample table charmap hr pagebreak nonbreaking anchor toc insertdatetime advlist lists checklist wordcount tinymcespellchecker a11ychecker imagetools textpattern noneditable help formatpainter permanentpen pageembed charmap tinycomments mentions quickbars linkchecker emoticons advtable',
        imagetools_cors_hosts: ['picsum.photos'],
        tinydrive_token_provider: function (success, failure) {
            success({token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJqb2huZG9lIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.Ks_BdfH4CWilyzLNk8S2gDARFhuxIauLa8PwhdEQhEo'});
        },
        tinydrive_demo_files_url: '/docs/demo/tiny-drive-demo/demo_files.json',
        tinydrive_dropbox_app_key: 'jee1s9eykoh752j',
        tinydrive_google_drive_key: 'AIzaSyAsVRuCBc-BLQ1xNKtnLHB3AeoK-xmOrTc',
        tinydrive_google_drive_client_id: '748627179519-p9vv3va1mppc66fikai92b3ru73mpukf.apps.googleusercontent.com',
        mobile: {
            plugins: 'print preview fullpage powerpaste casechange importcss tinydrive searchreplace autolink autosave save directionality advcode visualblocks visualchars fullscreen image link media mediaembed template codesample table charmap hr pagebreak nonbreaking anchor toc insertdatetime advlist lists checklist wordcount tinymcespellchecker a11ychecker textpattern noneditable help formatpainter pageembed charmap mentions quickbars linkchecker emoticons advtable'
        },
        menu: {
            tc: {
                title: 'TinyComments',
                items: 'addcomment showcomments deleteallconversations'
            }
        },
        menubar: 'file edit view insert format tools table tc help',
        toolbar: 'undo redo | bold italic underline strikethrough | fontselect fontsizeselect formatselect | alignleft aligncenter alignright alignjustify | outdent indent |  numlist bullist checklist | forecolor backcolor casechange permanentpen formatpainter removeformat | pagebreak | charmap emoticons | fullscreen  preview save print | insertfile image media pageembed template link anchor codesample | a11ycheck ltr rtl | showcomments addcomment',
        autosave_ask_before_unload: true,
        autosave_interval: "30s",
        autosave_prefix: "{path}{query}-{id}-",
        autosave_restore_when_empty: false,
        autosave_retention: "2m",
        image_advtab: true,
        content_css: [
            '//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
            '//www.tiny.cloud/css/codepen.min.css'
        ],
        link_list: [
            {title: 'My page 1', value: 'http://www.tinymce.com'},
            {title: 'My page 2', value: 'http://www.moxiecode.com'}
        ],
        image_list: [
            {title: 'My page 1', value: 'http://www.tinymce.com'},
            {title: 'My page 2', value: 'http://www.moxiecode.com'}
        ],
        image_class_list: [
            {title: 'None', value: ''},
            {title: 'Some class', value: 'class-name'}
        ],
        importcss_append: true,
        height: 400,
        file_picker_callback: function (callback, value, meta) {
            /* Provide file and text for the link dialog */
            if (meta.filetype === 'file') {
                callback('https://www.google.com/logos/google.jpg', {text: 'My text'});
            }

            /* Provide image and alt text for the image dialog */
            if (meta.filetype === 'image') {
                callback('https://www.google.com/logos/google.jpg', {alt: 'My alt text'});
            }

            /* Provide alternative source and posted for the media dialog */
            if (meta.filetype === 'media') {
                callback('movie.mp4', {source2: 'alt.ogg', poster: 'https://www.google.com/logos/google.jpg'});
            }
        },
        templates: [
            {
                title: 'New Table',
                description: 'creates a new table',
                content: '<div class="mceTmpl"><table width="98%%"  border="0" cellspacing="0" cellpadding="0"><tr><th scope="col"> </th><th scope="col"> </th></tr><tr><td> </td><td> </td></tr></table></div>'
            },
            {title: 'Starting my story', description: 'A cure for writers block', content: 'Once upon a time...'},
            {
                title: 'New list with dates',
                description: 'New List with dates',
                content: '<div class="mceTmpl"><span class="cdate">cdate</span><br /><span class="mdate">mdate</span><h2>My List</h2><ul><li></li><li></li></ul></div>'
            }
        ],
        template_cdate_format: '[Date Created (CDATE): %m/%d/%Y : %H:%M:%S]',
        template_mdate_format: '[Date Modified (MDATE): %m/%d/%Y : %H:%M:%S]',
        height: 600,
        image_caption: true,
        quickbars_selection_toolbar: 'bold italic | quicklink h2 h3 blockquote quickimage quicktable',
        noneditable_noneditable_class: "mceNonEditable",
        toolbar_drawer: 'sliding',
        spellchecker_dialog: true,
        spellchecker_whitelist: ['Ephox', 'Moxiecode'],
        tinycomments_mode: 'embedded',
        content_style: ".mymention{ color: gray; }",
        contextmenu: "link image imagetools table configurepermanentpen",
        mentions_selector: '.mymention'
    });
    //
    // $(() => {
    //     const options = {
    //         autoProcessQueue: false,
    //         url: "/file/post"
    //     };
    //     const myDropzone = new Dropzone($('#mydropzone').get(0), options);
    //
    //     $('#images').on('change',function () {
    //         myDropzone.addFile($('#images').get(0));
    //     });
    //
    //     console.log(myDropzone.files);
    //
    // });
</script>
</body>

</html>