<%--
    Document   : index
    Created on : Feb 6, 2026
    Author     : Hưng
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>WMS | Dashboard</title>

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/backend-plugin.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/backend.css?v=1.0.0">
</head>
<body class="">
<div class="wrapper">

    <%-- Lưu ý: Nếu index.jsp nằm cùng thư mục với sidebar.jsp thì dùng đường dẫn này.
         Tham số page="dashboard" để highlight menu tương ứng trong sidebar --%>
    <jsp:include page="view/sidebar.jsp">
        <jsp:param name="page" value="dashboard" />
    </jsp:include>

    <div class="content-page">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card card-block card-stretch card-height">
                        <div class="card-body">
                            <div class="d-flex align-items-center justify-content-between">
                                <div class="iq-cart-text">
                                    <h2 class="text-primary">Welcome to WMS System</h2>
                                    <p class="mb-0 font-size-16 mt-2">
                                        Xin chào, <strong>Hưng</strong>! Chúc bạn một ngày làm việc hiệu quả.
                                    </p>
                                </div>
                                <div class="iq-cart-image">
                                    <i class="las la-smile text-primary" style="font-size: 80px;"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/js/backend-bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</body>
</html>