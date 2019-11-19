

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//TODO search if the username already exists

		/*if(!username.equals("admin") && !password.isEmpty()){
			//Registration succeed!
			response.sendRedirect("RegistrationSucceed.jsp");
		}else {
			//Registration failed!
			response.sendRedirect("RegistrationFailed.jsp");
		}*/
		Database db = new Database();
		boolean isUserRegistered = db.IsUserRegistered(username);
		if(isUserRegistered) {
			// username already exists
			response.sendRedirect("RegistrationFailed.jsp");
		}else {
			db.RegisterUser(username,password);
			response.sendRedirect("RegistrationSucceed.jsp");
		}
	}

}
