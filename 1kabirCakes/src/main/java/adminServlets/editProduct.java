package adminServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.product;

import java.io.IOException;
import java.util.List;

import dao.getAllProducts;

/**
 * Servlet implementation class editProduct
 */
public class editProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public editProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int prodId = Integer.parseInt(request.getParameter("msg"));
		System.out.println(prodId);
		
		HttpSession session = request.getSession();
		List<product> lst1 = getAllProducts.editProductFetchData(prodId);
		List<product> lst2 =  getAllProducts.getProductsAdmin();
		
		session.setAttribute("editProductData", lst1);
		session.setAttribute("Allproducts", lst2);
		
		response.sendRedirect("AdminEditProduct.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
