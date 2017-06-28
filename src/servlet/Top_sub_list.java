package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Top_sub_list
 */
@WebServlet("/Top_sub_list")
public class Top_sub_list extends HttpServlet {
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
		//doGet(request, response);

		String path ="";

		try{
			HttpSession session = request.getSession();
			SubjectDAO subjectDAO = new SubjectDAO();
			ArrayList<Subject> subjects = new ArrayList<Subject>();
			subjects = subjectDAO.getSubjectdata("IT");
			session.setAttribute("IT", subjects);

			subjects = subjectDAO.getSubjectdata("English");
			session.setAttribute("English", subjects);

			subjects = subjectDAO.getSubjectdata("communication");
			session.setAttribute("commnuication", subjects);

			path="WEB-INF/jsp/subject_list.jsp";




		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		}catch(Exception e){
			System.out.println(e);

		}

	}

}
