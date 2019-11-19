

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		/*if(username.equals("admin") &&
			password.equals("admin") ) {
			response.sendRedirect("Member.jsp");
		}else {
			response.sendRedirect("LoginError.jsp");
		}*/
		Database db = new Database();
		if(db == null) {
			System.out.println("Error at dabatase conenction");
			return;
		}
		boolean userRegistered = db.IsUserRegisteredWithPassword(username, password);
		if (userRegistered) {
			response.sendRedirect("Member.jsp");
		}else {
			response.sendRedirect("LoginError.jsp");
		}
		// Connect to mysql and verify username password
		
				/*try {
					Class.forName("com.mysql.jdbc.Driver");
					 // loads driver
					//Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8080/accounts", "kostas", "12345"); // gets a new connection
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:8000/accounts?user=kostas&password=12345");
					PreparedStatement ps = c.prepareStatement("select USERNAME,PASSWORD from user where USERNAME=? and PASSWORD=?");
					ps.setString(1, username);
					ps.setString(2, password);
			 
					ResultSet rs = ps.executeQuery();
			 
					while (rs.next()) {
						response.sendRedirect("Member.jsp");
						return;
					}
					response.sendRedirect("LoginError.jsp");
					return;
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("SDKoakods\n");
					e.printStackTrace();
				}*/
	}

}
