package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeacherDAO;
import model.Teacher;

/**
 * Servlet implementation class Tea_login
 */
@WebServlet("/Tea_login")
public class Tea_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tea_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


		// ログイン画面に遷移
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/tea_login.jsp");
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

		String path = "";

		try {
			HttpSession session = request.getSession();

			int tea_id = Integer.parseInt(request.getParameter("tea_id"));
			String tea_password = request.getParameter("tea_password");

			TeacherDAO teacherDAO = new TeacherDAO();
			Teacher teacher = new Teacher();

			//System.out.println(stu_id);
			//System.out.println(stu_password);

			teacher = teacherDAO.getTeacher(tea_id, tea_password);

			if (teacher != null) {
				System.out.println("ログイン成功");
				// session.setAttribute("CommonLoginStudent", student);
				session.setAttribute("tea_id", tea_id);
				session.setAttribute("tea_password", tea_password);

				path = ("/jsp/top.jsp");

			} else {
				System.out.println("ログイン失敗");
				request.setAttribute("errorMessage", "IDまたはパスワードが違います。");
				path = ("/jsp/tea_login.jsp");
			}

		} catch (Exception e) {
			System.out.println("ログイン失敗");
			request.setAttribute("errorMessage", "IDまたはパスワードが違います。");
			path = ("/jsp/tea_login.jsp");
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}