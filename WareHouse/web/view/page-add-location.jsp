<%--
    Document   : page-add-location
    Created on : Jan 30, 2025
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>WMS | Add Location</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/backend-plugin.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/backend.css?v=1.0.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/productManagement.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/locationManagement.css">
    </head>
    <body class="">
        <div class="wrapper">
            <div class="content-page">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="d-flex flex-wrap align-items-center justify-content-between mb-4">
                                <div>
                                    <h4 class="mb-3">Add Location</h4>
                                    <p class="mb-0">Create a new warehouse or storage location.</p>
                                </div>
                                <a style="color: #fff" href="${pageContext.request.contextPath}/list-location" class="btn btn-secondary">Back to List</a>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <c:if test="${not empty message}">
                                        <div id="errorToast" class="toast-message">${message}</div>
                                    </c:if>
                                    <form action="${pageContext.request.contextPath}/add-location" method="post">
                                        <div class="form-group">
                                            <label for="name">Name * <span style="color: red;">${errorName}</span></label>
                                            <input type="text" name="name" class="form-control" id="name" placeholder="Enter location name" value="${name}" required
                                                   style="${not empty errorName ? 'border: 1px solid red;' : ''}">
                                        </div>
                                        <div class="form-group">
                                            <label for="address">Address * <span style="color: red;">${errorAddress}</span></label>
                                            <input type="text" name="address" class="form-control" id="address" placeholder="Enter address" value="${address}" required
                                                   style="${not empty errorAddress ? 'border: 1px solid red;' : ''}">
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Description</label>
                                            <textarea class="form-control" name="description" id="description" rows="2" placeholder="Optional">${description}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="parentLocationID">Parent Location</label>
                                            <select name="parentLocationID" class="form-control" id="parentLocationID">
                                                <option value="">— None —</option>
                                                <c:forEach items="${listLocationParent}" var="p">
                                                    <option value="${p.locationID}" ${parentLocationID == p.locationID ? 'selected' : ''}>${p.name} (${p.locationType})</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="locationType">Type * <span style="color: red;">${errorLocationType}</span></label>
                                            <select name="locationType" class="form-control" id="locationType" required
                                                    style="${not empty errorLocationType ? 'border: 1px solid red;' : ''}">
                                                <option value="REGION" ${locationType == 'REGION' ? 'selected' : ''}>Region</option>
                                                <option value="WAREHOUSE" ${locationType == 'WAREHOUSE' ? 'selected' : ''}>Warehouse</option>
                                                <option value="ZONE" ${locationType == 'ZONE' ? 'selected' : ''}>Zone</option>
                                                <option value="RACK" ${locationType == 'RACK' ? 'selected' : ''}>Rack</option>
                                                <option value="BIN" ${locationType == 'BIN' ? 'selected' : ''}>Bin</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="maxCapacity">Max Capacity</label>
                                            <input type="number" name="maxCapacity" class="form-control" id="maxCapacity" min="0" placeholder="Optional" value="${maxCapacity}">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Add Location</button>
                                        <a href="${pageContext.request.contextPath}/list-location" class="btn bg-danger">Cancel</a>
                                    </form>
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
