package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Student;

/**
 * Servlet implementation class first
 */
@WebServlet("/first")
public class first extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(10);

		 Student student = (Student) session.getAttribute("student");
	

		 if (student == null || (student.getNazwisko() == null || student.getImie() == null)) {
			student = new Student();
			String imie = request.getParameter("imie");
			String nazwisko = request.getParameter("nazwisko");
			student.setImie(imie);
			student.setNazwisko(nazwisko);

			session.setAttribute("student", student);

		}

		PrintWriter pw = response.getWriter();
		pw.write("<html>");
		pw.write(" o lala");

		if (student.getImie() != null && student.getNazwisko() != null) {

			pw.println("<div>Witaj " + student.getImie() + " " + student.getNazwisko() + "</div>");
		}

		else

		{
			pw.println("<div>Witaj nieznajomy</div>");
			pw.write("</html>");

		}

	}

}
