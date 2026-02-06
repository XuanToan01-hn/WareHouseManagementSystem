package controller.purchase;

import dal.PurchaseOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;
import model.PurchaseOrder;

@WebServlet(name = "POlist", urlPatterns = {"/polist"})
public class POlist  extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PurchaseOrderDAO  purchaseOrderDAO = new PurchaseOrderDAO();
        List<PurchaseOrder> listPO= purchaseOrderDAO.getAll();
        request.setAttribute("listPO",listPO);
        request.getRequestDispatcher("view/purchase/purchase-list.jsp").forward(request,response);
    }
}
