package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setAttribute("aaa", "전달할 데이터");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("loginurl-doPost()");
		String id = request.getParameter("n1");
		String pw = request.getParameter("n2");
		
		// TODO: DB 갔다오기
		int result = new MemberService().login(id, pw); // 1: 로그인 성공, 0: 로그인 실패
		if (result == 1) {
//			response.sendRedirect(request.getContextPath()+"/");
//			response.sendRedirect("/"); //포트번호 까지만 나온다. contextPath필요
			response.sendRedirect("./");//상대경로
			request.setAttribute("msg","xx님 로그인 되셨습니다");
//			request.getRequestDispatcher("/WEB-INF/msgAlert.jsp").forward(request, response);
		}

	}

}
