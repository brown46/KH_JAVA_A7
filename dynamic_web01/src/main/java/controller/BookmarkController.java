package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.BookmarkDTO;
import model.dto.UserDTO;
import model.service.BookmarkService;
import page.Paging;


@WebServlet("/bookmark")
public class BookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
//		if( session.getAttribute("login")==null) {
//			resp.sendRedirect(req.getContextPath()+"/login");
//			return;
//		}//직접 접근 불가능하게 하기. filter로 대체됨 
		
		UserDTO udto = (UserDTO)session.getAttribute("user");
		BookmarkService service = new BookmarkService();
		BookmarkDTO bdto = new BookmarkDTO();
		bdto.setUserId(udto.getUserId());
//		List<BookmarkDTO> data=service.getAllById(bdto);
//		List<BookmarkDTO> data=service.getAll();
		
		
		
		//10개씩 나눠서 표시하기(임시)
		//map에 object를 담음
//		List<BookmarkDTO> data =service.getPage(bdto);
		//또는 새 클래스 생성해서 담아 넘기기
		
		
		
		//페이지 이동 구현해야됨		
		//현재 위치한 페이지. 값이 없으면 1페이지로 
		int pNum=0;
		if(req.getParameter("p")==null) {
			pNum=1;
		}else if(req.getParameter("p").isEmpty()) {
			pNum=1;
		}else {
			pNum= Integer.valueOf(req.getParameter("p")); 			
		}
		
		Cookie cookie =null;
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("cnt")) {
				cookie =c;
			}
		}//이미 생성된 쿠키 가져오기
		
	
		String cnt =req.getParameter("cnt");
		if(cnt!=null) {
			if(cnt.isEmpty()) {
				if(cookie!=null) {
					cnt=cookie.getValue();					
				}else {
					cnt="10";
				}
			}
		}else {
			if(cookie !=null) {
				cnt=cookie.getValue();
			}else {
				cnt="10";
			}
		}
		//쿠키 생성
		cookie = new Cookie("cnt", cnt);
		cookie.setMaxAge(60 * 60 * 24 * 5);
		resp.addCookie(cookie);
		
		
		//page 클래스 사용
		Paging paging = service.getPage(pNum, Integer.parseInt(cnt),bdto.getUserId());
		
		req.setAttribute("paging", paging);
		
		
		
		
		//p값에 따라 페이지 변경하기. 페이지 수 구하기. DTO를 넘겨서 ID에 해당하는 데이터만 구한다.
//		int pages= service.getAllPages(bdto);
//		
//		int start=1;
//		int end=1;
//		
//		if(pNum<5/2+1) {
//			start=1;
//			end=5;
//		}else {
//			start= pNum-2;
//			end= pNum+2;
//		}
//		if(end>=pages) {
//			end= pages;
//		}
		
		
		//페이지 목록
//		req.setAttribute("pages", pages);
//		req.setAttribute("start", start);
//		req.setAttribute("end", end);
//		req.setAttribute("data", data);
		
		
		
		req.getRequestDispatcher("/WEB-INF/view/bookmark.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookmarkDTO dto = new BookmarkDTO();
		BookmarkService service =new BookmarkService();
		HttpSession session = req.getSession();
		
		UserDTO udto=  (UserDTO)session.getAttribute("user");
		dto.setUserId(udto.getUserId());
		dto.setName(req.getParameter("name"));
		dto.setUrl(req.getParameter("url"));
		
		boolean result=service.add(dto);
		if(result) {
			resp.sendRedirect("./bookmark");
		}else {
			resp.sendRedirect("./fail");
		}
	}

}
