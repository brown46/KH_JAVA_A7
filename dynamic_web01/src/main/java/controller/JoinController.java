package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.UserDTO;
import model.service.UserService;

public class JoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId= req.getParameter("userId");
		String password = req.getParameter("password");
		String email =req.getParameter("email");
		
		UserDTO dto = new UserDTO();
		dto.setUserId(userId);
		dto.setPassword(password);
		dto.setEmail(email);
		
		UserService service = new UserService();
		int result = service.add(dto);
		
		switch (result) {
		case 1:
			resp.sendRedirect(req.getContextPath()+"/login");  //로그인 페이지로 이동
			break;
		case -1:
			resp.sendRedirect(req.getContextPath()+"/error"); 
			break;
		case -2:
			req.setAttribute("error", "동일한 아이디가 사용중입니다.");
			
//			resp.sendRedirect("./join");// redirect 를 사용하면 사용자 입력값이 사라진다.
			req.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(req, resp);
			//입력했던값이 삭제되지 않음
		}
		

	}
}
