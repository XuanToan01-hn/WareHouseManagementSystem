package controller.purchase;
import java.io.IOException;
import dal.PurchaseOrderDAO;
import dal.PurchaseOrderDetailDAO;
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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import model.Product;
import model.PurchaseOrder;
import model.PurchaseOrderDetail;

@WebServlet(name = "PurchaseOrderController", urlPatterns = {"/pocontroller"})
public class PurchaseOrderController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // nhan data
        String supplierID = request.getParameter("supplierID");
        String createdDate = request.getParameter("createdDate");

        String[] productIDs = request.getParameterValues("productID");
        String[] quantities = request.getParameterValues("quantity");
        String[] prices = request.getParameterValues("price");
        // insert PO vào trước
        PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
        PurchaseOrder po = new PurchaseOrder();
        po.setOrderCode("AA");
        po.setSupplierID(Integer.parseInt(supplierID));
        po.setStatus(3);
        po.setTotalAmount(BigDecimal.valueOf(10000));// chưa truyền sum, để tạm 10000
        // po.setCreatedDate(Timestamp.valueOf(createdDate));
        po.setCreateBy(3);// để tạm, vì chưa login
        boolean statusOfPO= purchaseOrderDAO.insert(po);
        if(statusOfPO==false){
            request.setAttribute("statusofpo",statusOfPO);
            request.getRequestDispatcher("view/purchase/purchase-result-test.jsp").forward(request, response);
        }
        int lastestID= purchaseOrderDAO.getLatestPurchaseOrderID();
        // insert PO in detail
        PurchaseOrderDetailDAO poDetailDAO = new PurchaseOrderDetailDAO();
        for(int i=0;i<productIDs.length;i++){

            int tempQuanti=Integer.parseInt(quantities[i]);
            BigDecimal tempPrice=BigDecimal.valueOf(Integer.parseInt(prices[i]));
            PurchaseOrderDetail tempPO = new PurchaseOrderDetail();
            tempPO.setPurchaseOrderID(lastestID);
            tempPO.setProductID(Integer.parseInt(productIDs[i]));
            tempPO.setQuantity(tempQuanti);
            tempPO.setPrice(tempPrice);
            tempPO.setTaxID(1);// tạm thời chưa cho tax
            tempPO.setSubTotal(tempPrice.multiply(BigDecimal.valueOf(tempQuanti)));
            poDetailDAO.insert(tempPO); // nên có check tình trạng chỗ này i guess
        }
        //post
        request.setAttribute("res_supplierID", supplierID);
        request.setAttribute("res_createdDate", createdDate);

        request.setAttribute("res_productIDs", productIDs);
        request.setAttribute("res_quantities", quantities);
        request.setAttribute("res_prices", prices);

        request.getRequestDispatcher("view/purchase/purchase-result-test.jsp").forward(request, response);



    }
}