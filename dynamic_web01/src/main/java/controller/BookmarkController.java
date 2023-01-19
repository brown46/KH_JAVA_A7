package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;


@WebServlet("/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
//		if( session.getAttribute("login")==null) {
//			resp.sendRedirect(req.getContextPath()+"/login");
//			return;
//		}//직접 접근 불가능하게 하기
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		BookmarkService service = new BookmarkService();
		BookmarkDTO bdto = new BookmarkDTO();
		bdto.setUserId(udto.getUserId());
		List<BookmarkDTO> data=service.getAllById(bdto);
//		List<BookmarkDTO> data=service.getAll();
		
		req.setAttribute("data", data);
		
		req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service =new BookmarkService();
		HttpSession session = req.getSession();
		
		UserDTO udto=  (UserDTO)session.getAttribute("user");
		dto.setUserId(udto.getUserId());
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
