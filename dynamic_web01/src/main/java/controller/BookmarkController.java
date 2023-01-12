package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.BookmarkDTO;
import model.service.BookmarkService;


@WebServlet("/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookmarkService service = new BookmarkService();
		List<BookmarkDTO> data=service.getAll();
		req.setAttribute("data", data);
		
		req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service =new BookmarkService();
		
		dto.setName(req.getParameter("name"));
		dto.setUrl(req.getParameter("url"));
		boolean result=service.add(dto);
		if(result) {
			resp.sendRedirect("./bookmark");
		}else {
			resp.sendRedirect("./fail");
		}
	}

}
