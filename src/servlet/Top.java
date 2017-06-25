package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Top
 */
@WebServlet("/Top")
public class Top extends HttpServlet {
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


		try{

			String path = null;
			String action =request.getParameter("action");

			if("zemi".equals(action)){
				path="WEB-INF/jsp/zemi_add.jsp";
			}else if("change".equals(action)){
				path="WEB-INF/jsp/zemi_change.jsp";
			}else if("entry".equals(action)){
				path="WEB-INF/jsp/zemi_stu.jsp";
			}else{
				throw new Exception();
			}


			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}catch(Exception e){

		}
	}

}
