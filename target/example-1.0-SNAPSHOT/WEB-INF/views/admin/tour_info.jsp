<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>TRANG QUẢN LÝ | CHI TIẾT TOUR</title>
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
                QUẢN LÝ CHI TIẾT TOUR
            </h2>
        </div>
        <!-- Basic Examples -->
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>
                            BẢNG THÔNG TIN TOUR
                        </h2>
                    </div>
                    <div class="body">
                        <form id="form_validation" method="POST" action="/admin/tour/info">
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input type="text" class="form-control" name="tour_Name" value="${tour.tour_Name}"
                                           required>
                                    <label class="form-label">Tên tour</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input type="text" class="form-control" name="tour_Max"
                                           value="${tour.tour_Max}" required>
                                    <label class="form-label">Số người tối đa</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input type="text" class="form-control" name="tour_Price" value="${tour.tour_Price}"
                                           required>
                                    <label class="form-label">Giá tour</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input type="text" class="form-control" name="tour_Departurelocation" value="${tour.tour_Departurelocation}"
                                           required>
                                    <label class="form-label">Địa điểm khởi hành</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input type="text" pattern="dd/MM/yyyy" class="form-control" placeholder="dd/MM/yyyy" name="tour_Departureday" value="${tour.tour_Departureday}"
                                           required>
                                    <label class="form-label">Ngày khởi hành</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input type="text" pattern="dd/MM/yyyy" class="form-control" placeholder="dd/MM/yyyy" name="tour_Enddate" value="${tour.tour_Enddate}"
                                           required>
                                    <label class="form-label">Ngày kết thúc</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <textarea id="mytinymce" name="tour_Describe" required
                                              aria-required="true">${tour.tour_Describe}</textarea>
                                </div>
                            </div>
                            <input type="hidden" name="tour_Status" value="0">
                            <input type="hidden" name="user_ID" value="${dto.user_Id}">
                            <c:choose>
                                <c:when test="${not empty tour}">
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="tour_Id" value="${tour.tour_Id}">
                                    <input type="hidden" name="tour_Createdate" value="${tour.tour_Createdate}">
                                </c:when>
                                <c:otherwise>
                                    <input type="hidden" name="action" value="create">
                                </c:otherwise>
                            </c:choose>
<%--                            <div class="form-group">--%>
<%--                                <label for="mydropzone">Documents</label>--%>
<%--                                <div class="clsbox-1">--%>
<%--                                    <div class="dropzone clsbox" id="mydropzone">--%>
<%--                                        <div class="dz-message">--%>
<%--                                            <div class="drag-icon-cph">--%>
<%--                                                <i class="material-icons">touch_app</i>--%>
<%--                                            </div>--%>
<%--                                            <h3>Drop files here or click to upload.</h3>--%>
<%--                                            <em>(This is just a demo dropzone. Selected files are <strong>not</strong>--%>
<%--                                                actually uploaded.)</em>--%>
<%--                                        </div>--%>
<%--                                        <div class="fallback">--%>
<%--                                            <input name="file" type="file" id="images" />--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                            <button type="submit" id="btn-save" class="btn btn-primary" style="margin-top: 30px">Lưu thay đổi
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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