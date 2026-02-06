// Location Management - Edit/Delete modals

document.addEventListener("DOMContentLoaded", function () {
    var errorToast = document.getElementById("errorToast");
    var successToast = document.getElementById("successToast");
    var toast = errorToast || successToast;
    if (toast) {
        setTimeout(function () {
            toast.style.transition = "opacity 0.5s ease, visibility 0.5s ease";
            toast.style.opacity = "0";
            toast.style.visibility = "hidden";
        }, 3000);
    }

    // Edit: bind click on elements with data attributes
    var editButtons = document.querySelectorAll(".btn-edit-location");
    for (var i = 0; i < editButtons.length; i++) {
        editButtons[i].addEventListener("click", function () {
            var id = this.getAttribute("data-id");
            var name = this.getAttribute("data-name") || "";
            var address = this.getAttribute("data-address") || "";
            var description = this.getAttribute("data-description") || "";
            var parent = this.getAttribute("data-parent") || "";
            var type = this.getAttribute("data-type") || "WAREHOUSE";
            var capacity = this.getAttribute("data-capacity") || "";
            openUpdateForm(id, name, address, description, parent, type, capacity);
        });
    }

    var deleteButtons = document.querySelectorAll(".btn-delete-location");
    for (var j = 0; j < deleteButtons.length; j++) {
        deleteButtons[j].addEventListener("click", function () {
            var id = this.getAttribute("data-id");
            var name = this.getAttribute("data-name") || "";
            openDeleteForm(id, name);
        });
    }
});

function openUpdateForm(id, name, address, description, parentId, locationType, maxCapacity) {
    document.getElementById("location-id").value = id;
    document.getElementById("location-name").value = name;
    document.getElementById("location-address").value = address;
    document.getElementById("location-description").value = description;
    document.getElementById("location-parent").value = parentId || "";
    document.getElementById("location-type").value = locationType || "WAREHOUSE";
    document.getElementById("location-capacity").value = maxCapacity;
    document.getElementById("errName").textContent = "";
    document.getElementById("errAddress").textContent = "";
    document.getElementById("errType").textContent = "";
    document.getElementById("updateModal").style.display = "block";
}

function openDeleteForm(id, name) {
    document.getElementById("deleteLocationId").value = id;
    document.getElementById("deleteLocationName").textContent = name;
    document.getElementById("deleteModal").style.display = "block";
}

function closeUpdateForm() {
    document.getElementById("updateModal").style.display = "none";
}

function closeDeleteForm() {
    document.getElementById("deleteModal").style.display = "none";
}
