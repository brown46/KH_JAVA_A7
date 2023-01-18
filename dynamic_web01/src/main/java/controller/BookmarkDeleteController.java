package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;

public class BookmarkDeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if( session.getAttribute("login")==null) {
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		}
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service = new BookmarkService();
		String id = req.getParameter("id");
		
		
		dto.setUserId(udto.getUserId());
		dto.setId(Integer.parseInt(id));
		boolean result= service.remove(dto);
		
		if(result) {
			resp.sendRedirect("../bookmark");
		}else {
			resp.sendRedirect("../fail");
		}
		
	}
}
