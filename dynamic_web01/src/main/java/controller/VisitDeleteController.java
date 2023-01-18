package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.VisitDTO;
import model.service.VisitService;

public class VisitDeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		if( session.getAttribute("login")==null) {
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		}
		//되나?
		
		VisitDTO dto = new VisitDTO();
		VisitService service = new VisitService();
		//밀리세컨드로 받아야할듯
		System.out.println(req.getParameter("createdate"));

		Date date = new Date(Long.parseLong(req.getParameter("createdate")));
		dto.setCreateDate(date);
		System.out.println(dto);
		boolean result= service.delete(dto);
		if(result) {
			resp.sendRedirect("../visit");
		}else {
			resp.sendRedirect("../fail");
		}
		
	}
}
