package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class Zemi_change
 */
@WebServlet("/Zemi_change")
public class Zemi_change extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


		SubjectDAO subjectDAO = new SubjectDAO();


		ArrayList<Subject> subjects = new ArrayList<Subject>();

		subjects = subjectDAO.getSubjectdata();

		request.setAttribute("subjects", subjects);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/zemi_change.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String id = request.getParameter("sub_id");
		int sub_id = Integer.parseInt(id);

		SubjectDAO subjectDAO = new SubjectDAO();

		Subject subject = new Subject();
		subject=subjectDAO.changeClick(sub_id);

		request.setAttribute("subject", subject);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/zemi_change_next.jsp");
		rd.forward(request, response);




	}

}
