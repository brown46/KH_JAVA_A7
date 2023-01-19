package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.dto.VisitDTO;
import model.service.VisitService;

/**
 * 방명록을 위한 컨트롤러
 * @author user1
 *
 */
public class VisitController extends HttpServlet{
	
	/**
	 * 방명록 페이지 요청이 있을 경우 사용하는 메서드 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				
		String pageNumber = req.getParameter("p");
		int pNum;
		if(pageNumber== null || pageNumber.isEmpty()) {
			pNum= 1;
		}else {
			pNum= Integer.valueOf(pageNumber);
		}
		
		VisitService service =new VisitService();
		List<VisitDTO> visitList= service.getPage(pNum);
		
		int rowCount=service.getRowCount();
		int pageCount=0;
		if(rowCount%10==0) {
			pageCount=rowCount/10;
		}else {
			pageCount=rowCount/10+1;
		}
		 
		req.setAttribute("pageCount", pageCount);
		
//		System.out.println(visitList);
		req.setAttribute("dataList", visitList);
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	}//링크 클릭
	
	/**
	 * 방명록 작성 후 저장 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("login")==null) {
			resp.sendRedirect(req.getContextPath()+"/login");
			return;
		}
		
		UserDTO udto= (UserDTO)session.getAttribute("user");
		
		VisitDTO data =new VisitDTO();
		data.setId(udto.getUserId());
		data.setContext(req.getParameter("context"));

		VisitService service = new VisitService();
		boolean result= service.add(data); //전달 후 응답 반환
		if(result) {
			resp.sendRedirect("./visit");
		}else {
//			req.getRequestDispatcher("/WEB-INF/view/fail.jsp").forward(req, resp);
			resp.sendRedirect("./fail");
		}
		resp.getWriter().flush();
		
	}//<form method="post"
}
