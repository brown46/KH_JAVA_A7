package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.BookmarkDTO;
import model.service.BookmarkService;

public class BookmarkDeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service = new BookmarkService();
		String id = req.getParameter("id");
		
		dto.setId(Integer.parseInt(id));
		boolean result= service.remove(dto);
		
		if(result) {
			resp.sendRedirect("../bookmark");
		}else {
			resp.sendRedirect("../fail");
		}
		
	}
}
