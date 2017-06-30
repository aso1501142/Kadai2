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

import dao.SeminarDAO;
import dao.StudentDAO;
import model.Seminar;
import model.Student;

/**
 * Servlet implementation class Stu_login
 */
@WebServlet("/Stu_login")
public class Stu_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//ログイン画面に遷移
		RequestDispatcher rd =
				request.getRequestDispatcher("WEB-INF/jsp/stu_login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String path = "";

		try {
			HttpSession session = request.getSession();

			int stu_id = Integer.parseInt(request.getParameter("stu_id"));
			String stu_password = request.getParameter("stu_password");

			StudentDAO studentDAO = new StudentDAO();
			Student student = new Student();

			student = studentDAO.getStudent(stu_id, stu_password);

			if (student != null) {
				System.out.println("ログイン成功");
				SeminarDAO seminarDAO = new SeminarDAO();
				ArrayList<Seminar> seminar = new ArrayList<Seminar>();

				seminar = seminarDAO.getSeminar(stu_id);

				session.setAttribute("stu_id", student);
				path = ("WEB-INF/jsp/my_page.jsp");

			} else {
				System.out.println("ログイン失敗");
				request.setAttribute("errorMessage", "IDまたはパスワードが違います。");

				path = ("WEB-INF/jsp/stu_login.jsp");
			}

		} catch (Exception e) {
			System.out.println("ログイン失敗");
			request.setAttribute("errorMessage", "IDまたはパスワードが違います。");

			path = ("WEB-INF/jsp/stu_login.jsp");
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}