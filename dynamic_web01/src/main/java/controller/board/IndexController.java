package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.service.BoardService;
import page.Paging;

//@WebServlet("/board")
public class IndexController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String p = req.getParameter("p");
		int pageNumber =1;
		if(p!= null) {
			if(!p.isEmpty()) {
				pageNumber= Integer.valueOf(p);
			}
		}
		
		//cnt라는 이름의 쿠키를 찾아 cookie에 저장
		Cookie cookie = null;
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("cnt")){
				cookie = c;
			}
		}
		
		//cnt 파라메터를 찾아 pageListLimit에 저장
		String cnt = req.getParameter("cnt");
		int  pageListLimit=10;//쿠키와 parameter값이 모두 없을 때의 기본값
		if(cnt != null) {
			if(!cnt.isEmpty()) {
				pageListLimit = Integer.valueOf(cnt);
				//사용자 요청에 의해 cnt가 변경된 경우 새로운 쿠키를 만들어서 사용
				cookie = new Cookie("cnt", cnt);
				cookie.setMaxAge(60*60*24*5);
				resp.addCookie(cookie);
			}
		}else {
			//cnt 파라메터가 없으면 cookie에 저장된 cnt 쿠키를 pageListLimit에 저장
			if(cookie !=null) {
				pageListLimit = Integer.valueOf(cookie.getValue()); 
			}
		}
		
		
		BoardService service = new BoardService();
		Paging paging = service.getPage(pageNumber,pageListLimit);
		
		req.setAttribute("paging", paging);
		req.getRequestDispatcher("/WEB-INF/view/board/index.jsp").forward(req, resp);
	}
}
