package controller.request;


import dal.LocationDAO;
import dal.PurchaseOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Location;
import model.PurchaseOrder;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationForRequest", urlPatterns = {"/locationforrequest"})
public class LocationForRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocationDAO locationDAO = new LocationDAO();
        List<Location> listLocations = locationDAO.getAll();
        request.setAttribute("listLocations",listLocations);
        request.getRequestDispatcher("view/warehouse/receipt-create.jsp").forward(request,response);
    }
}
