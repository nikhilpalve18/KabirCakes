package adminServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import adminDao.addNewProduct;
import adminDao.editProductDao;
import dao.getAllProducts;

/**
 * Servlet implementation class addProduct
 */
@MultipartConfig
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("msg"));
		String name = request.getParameter("prodName");
		String category = request.getParameter("category");
		String description = request.getParameter("prodDesc");
		int price = Integer.parseInt(request.getParameter("prodPrice"));
		
		Part file = request.getPart("image");
		String imageFileName = file.getSubmittedFileName();

		String uploadPath = "C:/Users/Nilesh/eclipse-workspace/1kabirCakes/src/main/webapp/images/" + imageFileName;

		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		product obj = new product();
		obj.setProdId(prodId);obj.setProdName(name);obj.setCategory(category);obj.setProdDesc(description);obj.setProdPrice(price);obj.setImageFileName(imageFileName);
		//edit
		int i = 0;
		HttpSession session = request.getSession();
		
		if(obj.getProdId() != 0) {
			System.out.println("-----------------control here----------------");
			i =  editProductDao.editProduct(obj);
			List<product> lst =  getAllProducts.getProductsAdmin();
			session.setAttribute("Allproducts", lst);
			response.sendRedirect("AdminAllProducts.jsp");
		}
		//add
		else {			
			System.out.println("----------------+++++++++++++++=-----------------");
			addNewProduct p = new addNewProduct();
			i =  p.insertProduct(obj);
			response.sendRedirect("addProducts.jsp");
		}
		
		
		
		
	}

}
