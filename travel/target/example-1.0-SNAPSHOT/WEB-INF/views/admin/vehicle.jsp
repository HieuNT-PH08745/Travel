<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>TRANG QUẢN LÝ | QUẢN LÝ PHƯƠNG TIỆN</title>
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

<body class="theme-red">
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
                         aria-expanded="false">${dto.vehicle_Name}</div>
                    <div class="email">${dto.vehicle_Name}</div>
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
                    <a href="/admin/home">
                        <i class="material-icons">list</i>
                        <span>Quản lý tài khoản</span>
                    </a>
                </li>
                <li class="header">Quản lý đăng ký tour</li>
                <li>
                    <a href="/admin/ordertour">
                        <i class="material-icons">list</i>
                        <span>Các tour mới được đăng ký</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/offertour">
                        <i class="material-icons">list</i>
                        <span>Các tour mới được đề xuất</span>
                    </a>
                </li>
                <li class="header">Quản lý tour</li>
                <li>
                    <a href="/admin/tours">
                        <i class="material-icons">list</i>
                        <span>Quản lý tour</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/image">
                        <i class="material-icons">list</i>
                        <span>Quản lý ảnh</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/topic">
                        <i class="material-icons">list</i>
                        <span>Quản lý chủ đề</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/location">
                        <i class="material-icons">list</i>
                        <span>Quản lý địa điểm</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/vehicle">
                        <i class="material-icons">list</i>
                        <span>Quản lý phương tiện</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/accommodation">
                        <i class="material-icons">list</i>
                        <span>Quản lý khách sạn</span>
                    </a>
                </li>
                <li>
                    <a href="/admin/restaurant">
                        <i class="material-icons">list</i>
                        <span>Quản lý nhà hàng</span>
                    </a>
                </li>
            </ul>
        </div>
        <!-- #Menu -->
        <!-- Footer -->
        <div class="legal">
            <div class="copyright">
                &copy; 2016 - 2017 <a href="javascript:void(0);">AdminBSB - Material Design</a>.
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
                QUẢN LÝ PHƯƠNG TIỆN
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
                    <div class="header">
                        <h2>
                            BẢNG PHƯƠNG TIỆN
                        </h2>
                        <button class="btn btn-circle pull-right" id="button-save">
                            <i class="fa fa-user-plus"></i>
                        </button>
                    </div>
                    <div class="body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                <thead>
                                <tr>
                                    <th>Tên phương tiện</th>
                                    <th>Loại phương tiện</th>
                                    <th>Số ghế</th>
                                    <th>Giá xe</th>
                                    <th>Số điện thoại</th>
                                    <th>Thời gian di chuyển(Tiếng)</th>
                                    <th>Ngày cập nhật</th>
                                    <th>Trạng thái</th>
                                    <th>Hành Động</th>
                                </tr>
                                </thead>
                                <tfoot>
                                </tfoot>
                                <tbody>
                                <c:forEach var="vehicle" items="${vehicles}">
                                    <tr>
                                        <td>${vehicle.vehicle_Name}</td>
                                        <td>${vehicle.vehicle_Types}</td>
                                        <td>${vehicle.vehicle_Seats}</td>
                                        <td>${vehicle.vehicle_Price}</td>
                                        <td>${vehicle.vehicle_Phone}</td>
                                        <td>${vehicle.vehicle_Deliverytime}</td>
                                        <td>${vehicle.vehicle_Time}</td>
                                        <td>${vehicle.vehicle_Status}</td>
                                        <td style="display: flex">
                                            <input type="hidden" name="vehicle_Time" value="${vehicle.vehicle_Time}">
                                            <button type="button" class="btn btn-circle" style="margin-right: 10px"
                                                    id="btn-edit" onclick="updateVehicle(${vehicle.vehicle_Id})">
                                                <i class="fa fa-edit"></i>
                                            </button>
<%--                                            <button class="btn btn-circle" type="button"--%>
<%--                                                    onclick="handleDelete(${qlphuongtien.maPhuongTien})">--%>
<%--                                                <i class="fa fa-trash"></i>--%>
<%--                                            </button>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- #END# Basic Examples -->
    </div>
</section>

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Thêm / Cập nhật thông tin phương tiện</h5>
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
                                        <input type="text" class="form-control" id="vehicle_Name" name="vehicle_Name" required>
                                        <label class="form-label">Tên phương tiện</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-inline">
                                        <select class="form-control show-tick" id="IDvehicle_Types" name="vehicle_Types" required>
                                            <option value="">-- Chọn loại xe --</option>
                                            <option value="0">Đường Bộ</option>
                                            <option value="1">Đường thủy</option>
                                            <option value="2">Đường hàng không</option>
                                            <option value="3">Loại hình di chuyển khác</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" class="form-control" id="vehicle_Seats" name="vehicle_Seats" required>
                                        <label class="form-label">Số chỗ ngồi</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" class="form-control" id="vehicle_Price" name="vehicle_Price" required>
                                        <label class="form-label">Giá xe</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" class="form-control" id="vehicle_Phone" name="vehicle_Phone" required>
                                        <label class="form-label">Số điện thoại liên lạc</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" class="form-control" id="vehicle_Deliverytime" name="vehicle_Deliverytime" required>
                                        <label class="form-label">Thời gian di chuyển</label>
                                    </div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-inline">
                                        <select class="form-control show-tick" id="IDvehicle_Status" name="vehicle_Status" required>
                                            <option value="">-- Chọn trạng thái của xe --</option>
                                            <option value="0">Hoạt động</option>
                                            <option value="1">Dừng hoạt động</option>
                                        </select>
                                    </div>
                                </div>
                                <input type="hidden" name="vehicle_Id" id="vehicle_Id" value="">
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

<!-- Custom Js -->
<script src="<c:url value="/resources/admin/js/admin.js"/>"></script>
<script src="<c:url value="/resources/admin/js/pages/tables/jquery-datatable.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<!-- Demo Js -->
<script src="<c:url value="/resources/admin/js/demo.js"/>"></script>
<script src="<c:url value="/resources/admin/js/pages/forms/form-validation.js"/>"></script>
<script>
    $(document).ready(function () {
        let form_validation = $('#form_validation');
        $('#btn-save').on('click', function () {
            let vehicle_Id = $('#vehicle_Id').val();
            if (vehicle_Id !== "") {
                form_validation.attr('action', '/admin/vehicle/update');
            } else {
                form_validation.attr('action', '/admin/vehicle/create');
            }
            form_validation.submit();
        });
        $('#button-save').on('click', function () {
            clearDataForInputText($('#vehicle_Name'), "");
            clearDataForInputText($('#vehicle_Seats'), "");
            clearDataForInputText($('#vehicle_Price'), "");
            clearDataForInputText($('#vehicle_Phone'), "");
            clearDataForInputText($('#vehicle_Deliverytime'), "");
            clearDataForInputText($('#vehicle_Time'), "");
            $('#IDvehicle_Status').val("");
            $('#IDvehicle_Status').selectpicker('refresh');
            $('#IDvehicle_Types').val("");
            $('#IDvehicle_Types').selectpicker('refresh');
            $('#exampleModalCenter').modal('toggle');
        });
    });

    function updateVehicle(id) {
        let vehicle_Name = $('#vehicle_Name');
        let vehicle_Types = $('#IDvehicle_Types');
        let vehicle_Seats = $('#vehicle_Seats');
        let vehicle_Price = $('#vehicle_Price');
        let vehicle_Phone = $('#vehicle_Phone');
        let vehicle_Deliverytime = $('#vehicle_Deliverytime');
        let vehicle_Time = $('#vehicle_Time');
        let vehicle_Status = $('#IDvehicle_Status');
        let vehicle_Id = $('#vehicle_Id');
        $.ajax({
            url: '/admin/vehicle/' + id,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: '',
            success: function (data) {
                setDataForInputText(vehicle_Name, data.vehicle_Name);
                setDataForInputText(vehicle_Seats, data.vehicle_Seats);
                setDataForInputText(vehicle_Price, data.vehicle_Price);
                setDataForInputText(vehicle_Phone, data.vehicle_Phone);
                setDataForInputText(vehicle_Deliverytime, data.vehicle_Deliverytime);
                setDataForInputText(vehicle_Time, data.vehicle_Time);
                setDataForInputText(vehicle_Id, data.vehicle_Id);
                vehicle_Status.val(data.vehicle_Status);
                vehicle_Status.selectpicker('refresh');
                vehicle_Types.val(data.vehicle_Types);
                vehicle_Types.selectpicker('refresh');
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

    // function handleDelete(maPhuongTien) {
    //     const swalWithBootstrapButtons = Swal.mixin({
    //         customClass: {
    //             confirmButton: 'btn btn-success',
    //             cancelButton: 'btn btn-danger'
    //         },
    //         buttonsStyling: "button-style"
    //     });
    //
    //     swalWithBootstrapButtons.fire({
    //         title: 'Are you sure?',
    //         text: "You won't be able to revert this!",
    //         icon: 'warning',
    //         showCancelButton: true,
    //         confirmButtonText: 'Yes, delete it!',
    //         cancelButtonText: 'No, cancel!',
    //     }).then((result) => {
    //         if (result.value) {
    //             window.location.href = "/admin/qlphuongtien?action=delete&id=" + maPhuongTien;
    //         } else if (result.dismiss === Swal.DismissReason.cancel) {
    //             swalWithBootstrapButtons.fire(
    //                 'Cancelled',
    //                 'Your imaginary file is safe :)',
    //                 'error'
    //             )
    //         }
    //     });
    // }
</script>
</body>

</html>