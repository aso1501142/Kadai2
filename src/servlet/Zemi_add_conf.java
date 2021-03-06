package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class Zemi_add_conf
 */
@WebServlet("/Zemi_add_conf")
public class Zemi_add_conf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/zemi_add.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String path = "WEB-INF/jsp/top.jsp";

		try{

			HttpSession session = request.getSession();

			int subId = (int)session.getAttribute("zemiId");
			String subName = (String)session.getAttribute("zemiName");
			String subGroup = (String)session.getAttribute("zemiGroup");
			int teaId = (int)session.getAttribute("teaId");

			SubjectDAO subjectDAO = new SubjectDAO();
			Subject subject = new Subject();

			subject = subjectDAO.getSubject(subId, subName, subGroup,teaId);

			if(subject.equals(null)){
				path="WEB-INF/jsp/zemi_add_conf.jsp";
				System.out.println("エラーが発生しています。");
			}

			session.invalidate();

			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);


		}catch(Exception e){
			path="WEB-INF/jsp/zemi_add_conf.jsp";
			System.out.println("例外エラーが発生しています。");
		}


	}

}
