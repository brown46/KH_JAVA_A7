package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.BoardDTO;
import model.service.BoardService;

//@WebServlet("/board/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");
		BoardService service =new BoardService();
		
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.valueOf(id));
		dto= service.getDetail(dto);
		
		req.setAttribute("detail", dto);
		
		req.getRequestDispatcher("/WEB-INF/view/board/detail.jsp").forward(req, resp);
	}
	
}
