<%--
    Document   : page-list-location
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
        <title>WMS | Location Management</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/backend-plugin.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/backend.css?v=1.0.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/productManagement.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/locationManagement.css">
    </head>
    <body class="">

        <div class="wrapper">
            <jsp:include page="sidebar.jsp">
                <jsp:param name="page" value="dashboard" />
            </jsp:include>
            <div class="content-page">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="d-flex flex-wrap align-items-center justify-content-between mb-4">
                                <div>
                                    <h4 class="mb-3">Location List</h4>
                                    <p class="mb-0">Manage warehouses and storage locations. List, add, edit and delete locations.</p>
                                </div>
                                <a style="color: #fff" href="${pageContext.request.contextPath}/add-location" class="btn btn-primary add-list">Add Location</a>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="rounded mb-3">
                                <div class="filter-section mb-4">
                                    <form method="get" action="${pageContext.request.contextPath}/list-location">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <select name="locationType" class="form-control" onchange="this.form.submit()">
                                                    <option value="">All Types</option>
                                                    <option value="REGION" ${param.locationType == 'REGION' ? 'selected' : ''}>Region</option>
                                                    <option value="WAREHOUSE" ${param.locationType == 'WAREHOUSE' ? 'selected' : ''}>Warehouse</option>
                                                    <option value="ZONE" ${param.locationType == 'ZONE' ? 'selected' : ''}>Zone</option>
                                                    <option value="RACK" ${param.locationType == 'RACK' ? 'selected' : ''}>Rack</option>
                                                    <option value="BIN" ${param.locationType == 'BIN' ? 'selected' : ''}>Bin</option>
                                                </select>
                                            </div>
                                            <div class="col-md-4">
                                                <input type="text" name="search" class="form-control" placeholder="Search by name or address" value="${param.search}">
                                            </div>
                                            <div class="col-md-1">
                                                <button type="submit" class="btn btn-primary">Search</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <c:if test="${param.add == 'success'}">
                                    <div id="successToast" class="toast-message">Location added successfully.</div>
                                </c:if>
                                <c:if test="${param.update == 'success'}">
                                    <div id="successToast" class="toast-message">Location updated successfully.</div>
                                </c:if>
                                <c:if test="${param.delete == 'success'}">
                                    <div id="successToast" class="toast-message">Location deleted successfully.</div>
                                </c:if>
                                <c:if test="${param.delete == 'fail'}">
                                    <div id="errorToast" class="toast-message">Cannot delete: location has children or is in use.</div>
                                </c:if>

                                <table class="table mb-0">
                                    <thead class="bg-white text-uppercase">
                                        <tr class="ligth ligth-data">
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Address</th>
                                            <th>Type</th>
                                            <th>Parent</th>
                                            <th>Max Capacity</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody class="ligth-body">
                                        <c:forEach items="${listLocation}" var="loc">
                                            <tr>
                                                <td>${loc.locationID}</td>
                                                <td class="data-name">${loc.name}</td>
                                                <td class="data-des">${loc.address}</td>
                                                <td>${loc.locationType}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${loc.parentLocationID != null}">
                                                            <c:forEach items="${listLocationParent}" var="parent">
                                                                <c:if test="${parent.locationID == loc.parentLocationID}">${parent.name}</c:if>
                                                            </c:forEach>
                                                        </c:when>
                                                        <c:otherwise>—</c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>${loc.maxCapacity != null ? loc.maxCapacity : '—'}</td>
                                                <td>
                                                    <div class="d-flex align-items-center list-action">
                                                        <a class="badge bg-success mr-2 btn-edit-location" href="javascript:void(0)"
                                                           data-id="${loc.locationID}"
                                                           data-name="${loc.name}"
                                                           data-address="${loc.address}"
                                                           data-description="${loc.description != null ? loc.description : ''}"
                                                           data-parent="${loc.parentLocationID != null ? loc.parentLocationID : ''}"
                                                           data-type="${loc.locationType}"
                                                           data-capacity="${loc.maxCapacity != null ? loc.maxCapacity : ''}">Edit</a>
                                                        <a class="badge bg-warning mr-2 btn-delete-location" href="javascript:void(0)"
                                                           data-id="${loc.locationID}"
                                                           data-name="${loc.name}">Delete</a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <c:if test="${empty listLocation}">
                                    <p class="text-center text-muted py-4">No locations found.</p>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Update Modal -->
                <div id="updateModal" class="modal modal-product">
                    <div class="modal-product-detail">
                        <div class="alert alert-primary">
                            <div class="media-body ms-3">
                                <h3 style="margin-bottom: 0; color: #0e5699;">Update Location</h3>
                            </div>
                        </div>
                        <form id="updateForm" action="${pageContext.request.contextPath}/update-location" method="post">
                            <div class="card-body">
                                <input type="hidden" name="id" id="location-id">
                                <div class="form-group">
                                    <label for="location-name">Name * <span style="color: red;" id="errName">${eName}</span></label>
                                    <input type="text" name="name" class="form-control" id="location-name" placeholder="Enter location name" required>
                                </div>
                                <div class="form-group">
                                    <label for="location-address">Address * <span style="color: red;" id="errAddress">${eAddress}</span></label>
                                    <input type="text" name="address" class="form-control" id="location-address" placeholder="Enter address" required>
                                </div>
                                <div class="form-group">
                                    <label for="location-description">Description</label>
                                    <textarea class="form-control" name="description" id="location-description" rows="2" placeholder="Optional"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="location-parent">Parent Location</label>
                                    <select name="parentLocationID" class="form-control" id="location-parent">
                                        <option value="">— None —</option>
                                        <c:forEach items="${listLocationParent}" var="p">
                                            <c:if test="${p.locationID != uId}">
                                                <option value="${p.locationID}">${p.name} (${p.locationType})</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="location-type">Type * <span style="color: red;" id="errType">${eLocationType}</span></label>
                                    <select name="locationType" class="form-control" id="location-type" required>
                                        <option value="REGION">Region</option>
                                        <option value="WAREHOUSE">Warehouse</option>
                                        <option value="ZONE">Zone</option>
                                        <option value="RACK">Rack</option>
                                        <option value="BIN">Bin</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="location-capacity">Max Capacity</label>
                                    <input type="number" name="maxCapacity" class="form-control" id="location-capacity" min="0" placeholder="Optional">
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="button" onclick="closeUpdateForm()" class="btn bg-danger">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>

                <!-- Delete Modal -->
                <div id="deleteModal" class="modal modal-product">
                    <div class="card modal-product-detail text-center">
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/delete-location" method="post">
                                <h2 class="card-title">Delete Confirmation</h2>
                                <input type="hidden" name="id" id="deleteLocationId">
                                <p class="card-text">Are you sure you want to delete location: <span id="deleteLocationName"></span>?</p>
                                <div class="confim-modal">
                                    <button type="submit" class="btn btn-primary btn-block">Delete</button>
                                    <a href="javascript:void(0)" onclick="closeDeleteForm()" class="btn bg-danger btn-block">Close</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/locationManagement.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/backend-bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

        <c:if test="${showUpdateModal == true}">
            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    document.getElementById('updateModal').style.display = 'block';
                });
            </script>
        </c:if>
    </body>
</html>
