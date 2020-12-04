<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table class="table table-bordered table-striped table-hover js-basic-example dataTable"
       id="example">
    <thead>
    <tr>
        <th>Tên tour</th>
        <th>Ngày khởi hành</th>
        <th>Giá</th>
        <th>Ngày cập nhật cuối</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tfoot>
    </tfoot>
    <tbody>
    <c:forEach var="location" items="${locations}">
        <tr>
            <td>${location.provincial_Name}</td>
            <td>
                <button type="button" class="btn btn-circle" style="margin-right: 10px"
                        onclick="editTour(${location.provincial_Id})">
                    <i class="fa fa-edit"></i>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    $(document).ready(function () {
        $('#button-save').on("click", function () {
            window.location.href = "/admin/location/provincial";
        });
    });

    function editTour(id) {
        window.location.href = "/admin/provincial/" + id;
    }
</script>
</body>
</html>