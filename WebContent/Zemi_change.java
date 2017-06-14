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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		SubjectDAO subjectDAO = new SubjectDAO();

		ArrayList<Subject> subjects = new ArrayList<Subject>();

		subjects = subjectDAO.getSubjectdata();

		request.setAttribute("subjects", subjects);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/zemi_change.jsp");
		rd.forward(request, response);

	}

}
