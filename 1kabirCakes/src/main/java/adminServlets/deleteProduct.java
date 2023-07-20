package adminServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.product;

import java.io.IOException;
import java.util.List;

import adminDao.deleteProductDao;
import dao.getAllProducts;

/**
 * Servlet implementation class deleteProduct
 */
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside the servlets");

		int prodId = Integer.parseInt(request.getParameter("msg"));
		System.out.println("------------prodId------------" + prodId);
		HttpSession session = request.getSession();
//		String email = (String) session.getAttribute("email");

		int i = 0;
		i = deleteProductDao.removeProduct(prodId);

		List<product> lst = getAllProducts.getProductsAdmin();
		session.setAttribute("Allproducts", lst);
		if(i>0) {			
			response.sendRedirect("AdminAllProducts.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
