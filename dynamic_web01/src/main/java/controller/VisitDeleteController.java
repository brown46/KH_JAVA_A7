package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.dto.VisitDTO;
import model.service.VisitService;

public class VisitDeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		VisitDTO dto = new VisitDTO();
		VisitService service = new VisitService();
//		System.out.println(req.getParameter("createdate"));

		Date date = new Date(Long.parseLong(req.getParameter("createdate")));
		dto.setCreateDate(date);
		dto= service.get(dto);
		
		
		HttpSession session = req.getSession();
		UserDTO udto= (UserDTO)(session.getAttribute("user"));
		
		if(session.getAttribute("login")==null) {
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		}else if(!((udto.getUserId()).equals(dto.getId()))){
			resp.sendRedirect(req.getContextPath()+"/");
			return;
		}
//		System.out.println(dto);
		boolean result= service.delete(dto);
		if(result) {
			resp.sendRedirect("../visit");
		}else {
			resp.sendRedirect("../fail");
		}
		
	}
}
