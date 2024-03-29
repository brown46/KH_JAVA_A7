package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.setCharacterEncoding("UTF-8");//요청
//		resp.setContentType("text/html; charset=utf-8");//응답
//		resp.setCharacterEncoding("UTF-8");//응답 인코딩 설정
//		resp.getWriter().print("GET 요청을 받았습니다.");
//		resp.getWriter().print("<h1>GET 요청을 받았습니다.");
//		resp.getWriter().flush();
		
		
		String cnt=req.getParameter("count");
		Integer iCnt=0;
		if(cnt!=null) {
			iCnt =Integer.parseInt(cnt);
		}
		req.setAttribute("iCnt", iCnt);
		
		System.out.println(cnt);
		
		
		
		HttpSession session= req.getSession();
		System.out.println("로그인 상태: "+ session.getAttribute("login"));
		System.out.println("계정 정보: "+ session.getAttribute("user"));
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);

		
		
	}
	
	
}
