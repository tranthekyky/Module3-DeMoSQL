<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Quản lý thuê trọ</title>
</head>

<body>
<div class="container mt-5">
    <h2>Quản lý thuê trọ</h2>

    <!-- Ô tìm kiếm -->
    <div class="mb-3">
        <form action="" method="post">
            <input type="text" class="form-control" id="search" placeholder="Tìm kiếm...">
            <button type="submit"><a href="">Tìm kiếm</a></button>
        </form>
    </div>

    <!-- Bảng dữ liệu -->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>
                <input type="checkbox" id="select-all">
            </th>
            <th>Mã phòng trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
        <tr>
            <td><input type="checkbox" class="record-checkbox"></td>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.date}</td>
            <td>${item.payment}</td>
            <td>${item.note}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="d-flex justify-content-between">
        <button class="btn btn-danger" id="delete-button">Xóa đã chọn</button>
        <button class="btn btn-primary" id="add-button" data-toggle="modal" data-target="#addModal">Thêm
            mới</button>
    </div>

    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalLabel">Thêm mới phòng trọ</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Đóng">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addForm" action="http://localhost:8080/rentals" method="post">
                        <div class="form-group">
                            <label for="phone">Tên người thuê</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="phone">Số điện thoại</label>
                            <input type="text" class="form-control" id="phone" name="phone" required>
                        </div>
                        <div class="form-group">
                            <label for="start-date">Ngày bắt đầu thuê</label>
                            <input type="date" class="form-control" id="start-date" name="date" required>
                        </div>
                        <div class="form-group">
                            <label for="payment-method">Hình thức thanh toán</label>
                            <select class="form-control" id="payment-method" name="payment" required>
                                <option value="Monthly">Theo tháng</option>
                                <option value="Quarterly">Theo quý</option>
                                <option value="Yearly">Theo năm</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="note">Ghi chú</label>
                            <textarea class="form-control" id="note" name="note"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm mới</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById('select-all').addEventListener('change', function () {
        const checkboxes = document.querySelectorAll('.record-checkbox');
        checkboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    document.getElementById('delete-button').addEventListener('click', function () {
        const checkboxes = document.querySelectorAll('.record-checkbox:checked');
        checkboxes.forEach(checkbox => {
            const row = checkbox.closest('tr');
            row.remove(); g
        });
    })

</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>