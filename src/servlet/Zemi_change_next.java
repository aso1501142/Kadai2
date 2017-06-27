package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class Zemi_change_next
 */
@WebServlet("/Zemi_change_next")
public class Zemi_change_next extends HttpServlet {
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
		String path = null;

		try {

			System.out.println("科目変更サーブレット");

			HttpSession session = request.getSession();

			int new_sub_id = Integer.parseInt(request.getParameter("subId"));
			String new_sub_name = request.getParameter("subName");
			String new_sub_group = request.getParameter("subGroup");
			int new_tea_id = Integer.parseInt(request.getParameter("teaId"));
			int sub_id = Integer.parseInt(request.getParameter("sub_id"));

			System.out.println(new_sub_id);
			System.out.println(new_sub_name);
			System.out.println(new_sub_group);
			System.out.println(new_tea_id);
			System.out.println(sub_id);

			SubjectDAO subjectDAO = new SubjectDAO();
			Subject subject = new Subject();

			subject = subjectDAO.changeSubject(new_sub_id,new_sub_name,new_sub_group,new_tea_id,sub_id);

			if (subject != null) {
				request.setAttribute("errorMess", "すでに使われているIDです。");
				//path = "WEB-INF/jsp/zemi_add.jsp";
				session.invalidate();
			} else {
				//session.setAttribute("zemiId", subId);
				//session.setAttribute("zemiName", subName);
				//session.setAttribute("zemiGroup", subGroup);
				//session.setAttribute("teaId", teaId);
				//path = "WEB-INF/jsp/zemi_add_conf.jsp";
			}

			//RequestDispatcher rd = request.getRequestDispatcher(path);
			//rd.forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
