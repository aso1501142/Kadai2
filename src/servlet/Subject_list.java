package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeminarDAO;
import model.Seminar;

/**
 * Servlet implementation class Subject_list
 */
@WebServlet("/Subject_list")
public class Subject_list extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		try{
		int sub = Integer.parseInt(request.getParameter("sub"));
		System.out.println(sub);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/subject_stu.jsp");
		rd.forward(request, response);

		SeminarDAO seminarDAO = new SeminarDAO();
		ArrayList<Seminar> seminar = new ArrayList<Seminar>();
		seminar = seminarDAO.getSeminar(sub);


		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
