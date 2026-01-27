<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Role</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <style>
        /* Tận dụng Style Card bạn đã gửi ở trên */
        body { font-family: sans-serif; background: #f4f7fb; padding: 20px; }
        .role-card {
            background: white; margin: 10px auto; padding: 15px;
            max-width: 500px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            display: flex; justify-content: space-between;
        }
        .id-badge { background: #3498db; color: white; padding: 2px 8px; border-radius: 4px; }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Hệ thống Quản lý Quyền</h1>

    <c:forEach items="${data}" var="r">
        <div class="role-card">
            <div>
                <span class="id-badge">ID: ${r.roleID}</span>
                <strong style="margin-left: 10px;">${r.roleName}</strong>
            </div>
            <div>
                <i class="fas fa-edit" style="color: orange; cursor: pointer;"></i>
                <i class="fas fa-trash" style="color: red; margin-left: 10px; cursor: pointer;"></i>
            </div>
        </div>
    </c:forEach>

    <c:if test="${empty data}">
        <p style="text-align: center;">Đang tải dữ liệu hoặc không có Role nào...</p>
    </c:if>
</body>
</html>