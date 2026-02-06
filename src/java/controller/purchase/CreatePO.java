package controller.purchase;

import dal.ProductDAO;
import dal.SupplierDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

import jakarta.servlet.http.HttpServlet;

import java.util.List;
import model.Product;
import model.Supplier;

@WebServlet(name = "CreatePO", urlPatterns = {"/createpo"})
public class CreatePO extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SupplierDAO supplierDAO = new SupplierDAO();
        List<Supplier> listSuppliers= supplierDAO.getAll();
        ProductDAO productDAO = new ProductDAO();
        List<Product> listProducts = productDAO.getAllProducts();
        request.setAttribute("listSupplier",listSuppliers);
        request.setAttribute("listProduct",listProducts);
        request.getRequestDispatcher("view/purchase/purchase-create.jsp").forward(request,response);
    }
}
