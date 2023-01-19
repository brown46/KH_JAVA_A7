package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;

//@WebServlet("/bookmark/update")
public class BookmarkUpdateController extends HttpServlet {
	
	/**
	 * 사용자가 수정 요청한 id에 해당하는 데이터 조회 후 
	 * 수정 폼이 있는 JSP 페이지를 제공하여 사용자가 데이터를
	 * 수정할 수 있게 한다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
	
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service = new BookmarkService();
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		dto.setId(Integer.parseInt(req.getParameter("id")));
		dto.setUserId(udto.getUserId());
		dto= service.get(dto);//id만 가지고 있는 dto. 나머지 멤버들을 받아와야한다.
		req.setAttribute("data", dto);
		req.getRequestDispatcher("/WEB-INF/view/bookmarkupdate.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service = new BookmarkService();
		String id= req.getParameter("id");
		String url= req.getParameter("url");
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		UserDTO udto = (UserDTO)session.getAttribute("user");
		dto.setId(Integer.parseInt(id));
		dto.setUrl(url);
		dto.setName(name);
		dto.setUserId(udto.getUserId());
		
		boolean result=service.update(dto);
		
		if(result) {
			resp.sendRedirect("../bookmark");
		}else {
			resp.sendRedirect("../fail");
		}
		
		
	}
}
