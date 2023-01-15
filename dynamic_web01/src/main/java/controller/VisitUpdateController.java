package controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.VisitDTO;
import model.service.VisitService;

public class VisitUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//select로 받고 setatrribute로 dto 넘겨주기
		VisitService service = new VisitService();
		VisitDTO dto = new VisitDTO();
		Date date= new Date(Long.valueOf(req.getParameter("createdate")));
		dto.setCreateDate(date);
		dto= service.get(dto);
		req.setAttribute("data", dto);
		
		req.getRequestDispatcher("/WEB-INF/view/visitupdate.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getparameter로 얻고 dto보내서 update작성
		VisitDTO dto = new VisitDTO();
		VisitService service = new VisitService();
		
		dto.setNickname(req.getParameter("nickname")); 
		dto.setContext(req.getParameter("context"));
		Date date= new Date(Long.valueOf(req.getParameter("createdate")));
		dto.setCreateDate(date);
		
		//성공실패반환
		boolean result= service.update(dto);	
		if(result) {
			resp.sendRedirect("../visit");
		}else {
			resp.sendRedirect("../fail");
		}
		
	}
}
