<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Material Request - ERPNext Clone</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f4f5f7; font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif; }
        .form-header { background-color: #fff; padding: 15px; border-bottom: 1px solid #ddd; margin-bottom: 20px; }
        .form-container { background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 1px 3px rgba(0,0,0,0.1); max-width: 900px; margin: 0 auto; }
        .section-title { font-size: 14px; font-weight: 600; color: #777; margin-bottom: 15px; border-bottom: 1px solid #eee; padding-bottom: 5px; }
        .btn-primary { background-color: #5e64ff; border-color: #5e64ff; }
        .btn-primary:hover { background-color: #4a50e0; }
        label { font-size: 12px; color: #555; margin-bottom: 5px; display: block; }
        .form-control { font-size: 13px; }
    </style>
</head>
<body>

<div class="form-header d-flex justify-content-between align-items-center">
    <div class="d-flex align-items-center">
        <h5 class="m-0 me-3">New Material Request</h5>
        <span class="badge bg-secondary">Draft</span>
    </div>
    <div>
        <button class="btn btn-sm btn-outline-secondary me-2">Discard</button>
        <button class="btn btn-sm btn-primary" onclick="submitForm()">Save</button>
    </div>
</div>

<div class="container pb-5">
    <form action="submit_material_request.jsp" method="post" class="form-container">

        <div class="row mb-4">
            <div class="col-12 section-title">DETAILS</div>

            <div class="col-md-6 mb-3">
                <label>Series</label>
                <input type="text" class="form-control" value="MAT-MR-.YYYY.-" readonly disabled>
                <small class="text-muted" style="font-size: 11px;">Mã sẽ được tạo tự động khi lưu.</small>
            </div>

            <div class="col-md-6 mb-3">
                <label>Type</label>
                <select name="requestType" class="form-select">
                    <option value="Purchase">Purchase (Mua hàng)</option>
                    <option value="Material Transfer">Material Transfer (Chuyển kho)</option>
                    <option value="Material Issue">Material Issue (Xuất kho)</option>
                    <option value="Manufacture">Manufacture (Sản xuất)</option>
                </select>
            </div>

            <div class="col-md-6 mb-3">
                <label>Transaction Date</label>
                <input type="date" name="transactionDate" class="form-control" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">
            </div>

            <div class="col-md-6 mb-3">
                <label>Required By Date</label>
                <input type="date" name="scheduleDate" class="form-control">
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-12 section-title">ITEMS</div>
            <table class="table table-bordered table-sm" style="font-size: 13px;">
                <thead class="table-light">
                <tr>
                    <th style="width: 30%">Item Code</th>
                    <th style="width: 15%">Quantity</th>
                    <th style="width: 15%">UOM</th>
                    <th style="width: 30%">Target Warehouse</th>
                    <th style="width: 10%">Action</th>
                </tr>
                </thead>
                <tbody id="itemsTableBody">
                <tr>
                    <td><input type="text" name="itemCode" class="form-control form-control-sm" placeholder="e.g., ITEM-001"></td>
                    <td><input type="number" name="qty" class="form-control form-control-sm" value="1"></td>
                    <td>
                        <select name="uom" class="form-select form-select-sm">
                            <option>Nos</option>
                            <option>Kg</option>
                            <option>Box</option>
                        </select>
                    </td>
                    <td><input type="text" name="warehouse" class="form-control form-control-sm" placeholder="Stores - D"></td>
                    <td class="text-center"><button type="button" class="btn btn-sm btn-danger" onclick="removeRow(this)">X</button></td>
                </tr>
                </tbody>
            </table>
            <div class="col-12">
                <button type="button" class="btn btn-sm btn-secondary w-100" onclick="addRow()">+ Add Row</button>
            </div>
        </div>

    </form>
</div>

<script>
    function addRow() {
        var table = document.getElementById("itemsTableBody");
        var row = table.insertRow(-1);
        row.innerHTML = `
                <td><input type="text" name="itemCode" class="form-control form-control-sm"></td>
                <td><input type="number" name="qty" class="form-control form-control-sm" value="1"></td>
                <td><select name="uom" class="form-select form-select-sm"><option>Nos</option><option>Kg</option></select></td>
                <td><input type="text" name="warehouse" class="form-control form-control-sm"></td>
                <td class="text-center"><button type="button" class="btn btn-sm btn-danger" onclick="removeRow(this)">X</button></td>
            `;
    }

    function removeRow(btn) {
        var row = btn.parentNode.parentNode;
        row.parentNode.removeChild(row);
    }

    function submitForm() {
        alert("Dữ liệu đang được gửi tới server (Mô phỏng)...");
        document.querySelector("form").submit();
    }
</script>
</body>
</html>