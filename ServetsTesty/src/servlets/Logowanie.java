package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logowanie
 */
@WebServlet("/Logowanie")
public class Logowanie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logowanie() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("imie");
		System.out.println("metoda GET");
		System.out.println(login);
		response.sendRedirect("index.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("metoda POST");
		String login = request.getParameter("imie");
		System.out.println(login);
		//response.sendRedirect("index.html");
		request.getRequestDispatcher("FormularzStartowy").forward(request, response);
		
	}

}
