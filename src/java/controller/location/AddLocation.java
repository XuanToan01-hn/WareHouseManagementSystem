/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.location;

import dal.LocationDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Location;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddLocation", urlPatterns = {"/add-location"})
public class AddLocation extends HttpServlet {

    private static final String[] VALID_TYPES = {"REGION", "WAREHOUSE", "ZONE", "RACK", "BIN"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocationDAO locationDAO = new LocationDAO();
        request.setAttribute("listLocationParent", locationDAO.getAll());
        request.getRequestDispatcher("view/page-add-location.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String description = request.getParameter("description");
        String parentIdStr = request.getParameter("parentLocationID");
        String locationType = request.getParameter("locationType");
        String maxCapacityStr = request.getParameter("maxCapacity");

        String errorName = null;
        String errorAddress = null;
        String errorLocationType = null;

        if (name == null || name.trim().isEmpty()) {
            errorName = "Name is required.";
        }
        if (address == null || address.trim().isEmpty()) {
            errorAddress = "Address is required.";
        }
        if (locationType == null || locationType.trim().isEmpty()) {
            errorLocationType = "Location type is required.";
        } else {
            boolean valid = false;
            for (String t : VALID_TYPES) {
                if (t.equals(locationType)) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                errorLocationType = "Invalid location type.";
            }
        }

        if (errorName != null || errorAddress != null || errorLocationType != null) {
            request.setAttribute("errorName", errorName);
            request.setAttribute("errorAddress", errorAddress);
            request.setAttribute("errorLocationType", errorLocationType);
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("description", description);
            request.setAttribute("parentLocationID", parentIdStr);
            request.setAttribute("locationType", locationType);
            request.setAttribute("maxCapacity", maxCapacityStr);
            LocationDAO locationDAO = new LocationDAO();
            request.setAttribute("listLocationParent", locationDAO.getAll());
            request.getRequestDispatcher("view/page-add-location.jsp").forward(request, response);
            return;
        }

        Integer parentId = null;
        if (parentIdStr != null && !parentIdStr.trim().isEmpty()) {
            try {
                parentId = Integer.parseInt(parentIdStr.trim());
            } catch (NumberFormatException e) {
                // keep null
            }
        }
        Integer maxCapacity = null;
        if (maxCapacityStr != null && !maxCapacityStr.trim().isEmpty()) {
            try {
                maxCapacity = Integer.parseInt(maxCapacityStr.trim());
                if (maxCapacity < 0) maxCapacity = null;
            } catch (NumberFormatException e) {
                // keep null
            }
        }

        Location l = new Location();
        l.setName(name.trim());
        l.setAddress(address != null ? address.trim() : null);
        l.setDescription(description != null && !description.trim().isEmpty() ? description.trim() : null);
        l.setParentLocationID(parentId);
        l.setLocationType(locationType);
        l.setMaxCapacity(maxCapacity);

        LocationDAO locationDAO = new LocationDAO();
        boolean ok = locationDAO.insert(l);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/list-location?add=success");
        } else {
            request.setAttribute("message", "Add failed. Please try again.");
            request.setAttribute("listLocationParent", locationDAO.getAll());
            request.getRequestDispatcher("view/page-add-location.jsp").forward(request, response);
        }
    }
}
