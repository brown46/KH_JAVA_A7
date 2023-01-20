package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.UserDTO;
import model.dto.VisitDTO;
import model.service.VisitService;

/**
 * 방명록을 위한 컨트롤러
 * 
 * @author user1
 *
 */
public class VisitController extends HttpServlet {

	/**
	 * 방명록 페이지 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pageNumber = req.getParameter("p");

		int pNum;
		if (pageNumber == null || pageNumber.isEmpty()) {
			pNum = 1;
		} else {
			pNum = Integer.valueOf(pageNumber);
		}

		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("cnt")) {
				cookie = c;
			}
		} // 이미 저장된 쿠키가 있으면 사용

		String cnt = req.getParameter("cnt");
		if (cnt != null) { // cnt-parameter값- 자체가 없는 경우
			if (cnt.isEmpty()) {// cnt가 빈 문자열 일 경우. cnt =
				if (cookie != null) {
					cnt = cookie.getValue();
				} else {
					cnt = "10"; // 초기값
				}
			}
		} else {
			if(cookie !=null) {
				cnt = cookie.getValue();
			}else {				
				cnt = "10";
			}
		}

		cookie = new Cookie("cnt", cnt);
		cookie.setMaxAge(60 * 60 * 24 * 5);
		resp.addCookie(cookie);
		
		VisitService service = new VisitService();
		List<VisitDTO> visitList = service.getPage(pNum, Integer.parseInt(cnt));

		int rowCount = service.getRowCount();
		int pageCount = 0;
		if (rowCount % Integer.parseInt(cnt) == 0) {
			pageCount = rowCount / Integer.parseInt(cnt);
		} else {
			pageCount = rowCount / Integer.parseInt(cnt) + 1;
		}
		
		
		//pageCount를 잘라서 전달
		int start =1;
		int end =5;
		if(pNum >5/2+1) {
			start =pNum-2;
			end =pNum+2;
		}
		
		if(end>=pageCount) {
			end=pageCount;
		}
		
		req.setAttribute("pageStart", start);
		req.setAttribute("pageEnd", end);
		
//		req.setAttribute("pageCount", pageCount); //start end 로 대체
		req.setAttribute("cnt", cnt);
//		System.out.println(visitList);
		req.setAttribute("dataList", visitList);
		req.getRequestDispatcher("/WEB-INF/view/visit.jsp").forward(req, resp);
	}// 링크 클릭

	/**
	 * 방명록 작성 후 저장 요청이 있을 경우 사용하는 메서드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("login") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		UserDTO udto = (UserDTO) session.getAttribute("user");

		VisitDTO data = new VisitDTO();
		data.setId(udto.getUserId());
		data.setContext(req.getParameter("context"));

		VisitService service = new VisitService();
		boolean result = service.add(data); // 전달 후 응답 반환
		if (result) {
			resp.sendRedirect("./visit");
		} else {
//			req.getRequestDispatcher("/WEB-INF/view/fail.jsp").forward(req, resp);
			resp.sendRedirect("./fail");
		}
		resp.getWriter().flush();

	}// <form method="post"
}
