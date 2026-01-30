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
import java.util.ArrayList;
import java.util.List;
import model.Location;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListLocation", urlPatterns = {"/list-location"})
public class ListLocation extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocationDAO locationDAO = new LocationDAO();

        String search = request.getParameter("search");
        String locationType = request.getParameter("locationType");

        List<Location> listLocation = locationDAO.getAll();
        if (search != null && !search.trim().isEmpty()) {
            String s = search.trim().toLowerCase();
            List<Location> filtered = new ArrayList<>();
            for (Location l : listLocation) {
                if ((l.getName() != null && l.getName().toLowerCase().contains(s))
                        || (l.getAddress() != null && l.getAddress().toLowerCase().contains(s))) {
                    filtered.add(l);
                }
            }
            listLocation = filtered;
        }
        if (locationType != null && !locationType.trim().isEmpty()) {
            List<Location> filtered = new ArrayList<>();
            for (Location l : listLocation) {
                if (locationType.equals(l.getLocationType())) {
                    filtered.add(l);
                }
            }
            listLocation = filtered;
        }

        request.setAttribute("listLocation", listLocation);
        request.setAttribute("listLocationParent", locationDAO.getAll());
        request.getRequestDispatcher("view/page-list-location.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method (forward from update/delete with messages).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("showUpdateModal", request.getAttribute("showUpdateModal"));
        request.setAttribute("eName", request.getAttribute("errorName"));
        request.setAttribute("eAddress", request.getAttribute("errorAddress"));
        request.setAttribute("eLocationType", request.getAttribute("errorLocationType"));
        request.setAttribute("uId", request.getAttribute("updateid"));
        request.setAttribute("uName", request.getAttribute("updateName"));
        request.setAttribute("uAddress", request.getAttribute("updateAddress"));
        request.setAttribute("uDescription", request.getAttribute("updateDescription"));
        request.setAttribute("uParentLocationID", request.getAttribute("updateParentLocationID"));
        request.setAttribute("uLocationType", request.getAttribute("updateLocationType"));
        request.setAttribute("uMaxCapacity", request.getAttribute("updateMaxCapacity"));

        LocationDAO locationDAO = new LocationDAO();
        String search = request.getParameter("search");
        String locationType = request.getParameter("locationType");
        List<Location> listLocation = locationDAO.getAll();
        if (search != null && !search.trim().isEmpty()) {
            String s = search.trim().toLowerCase();
            List<Location> filtered = new ArrayList<>();
            for (Location l : listLocation) {
                if ((l.getName() != null && l.getName().toLowerCase().contains(s))
                        || (l.getAddress() != null && l.getAddress().toLowerCase().contains(s))) {
                    filtered.add(l);
                }
            }
            listLocation = filtered;
        }
        if (locationType != null && !locationType.trim().isEmpty()) {
            List<Location> filtered = new ArrayList<>();
            for (Location l : listLocation) {
                if (locationType.equals(l.getLocationType())) {
                    filtered.add(l);
                }
            }
            listLocation = filtered;
        }

        request.setAttribute("listLocation", listLocation);
        request.setAttribute("listLocationParent", locationDAO.getAll());
        request.getRequestDispatcher("view/page-list-location.jsp").forward(request, response);
    }
}
