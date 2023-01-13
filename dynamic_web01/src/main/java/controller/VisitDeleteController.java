package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.VisitDTO;
import model.service.VisitService;

public class VisitDeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VisitDTO dto = new VisitDTO();
		VisitService service = new VisitService();
		//밀리세컨드로 받아야할듯
		System.out.println(req.getParameter("createdate"));

		Date date = new Date(Long.valueOf(req.getParameter("createdate")));
		dto.setCreateDate(date);
		boolean result= service.delete(dto);
		if(result) {
			resp.sendRedirect("../visit");
		}else {
			resp.sendRedirect("../fail");
		}
		
	}
}
