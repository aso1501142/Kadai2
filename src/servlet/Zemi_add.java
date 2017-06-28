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
 * Servlet implementation class Zemi_add
 */
@WebServlet("/Zemi_add")
public class Zemi_add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/top.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String path = null;

		try {

			HttpSession session = request.getSession();

			int subId = Integer.parseInt(request.getParameter("subId"));
			String subName = request.getParameter("subName");
			String subGroup = request.getParameter("subGroup");
			int teaId = Integer.parseInt(request.getParameter("tea_Id"));

			SubjectDAO subjectDAO = new SubjectDAO();
			Subject subject = new Subject();

			subject = subjectDAO.getSubject(subId);

			if (subject != null) {
				request.setAttribute("errorMess", "すでに使われているIDです。");
				path = "WEB-INF/jsp/zemi_add.jsp";
				session.invalidate();
			} else {
				session.setAttribute("zemiId", subId);
				session.setAttribute("zemiName", subName);
				session.setAttribute("zemiGroup", subGroup);
				session.setAttribute("teaId", teaId);
				path = "WEB-INF/jsp/zemi_add_conf.jsp";
			}

			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
