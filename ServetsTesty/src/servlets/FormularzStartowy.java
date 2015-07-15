package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;



// dodane url do servletu oraz domyœlne parametry podczas inicjalizacji

//@WebServlet(urlPatterns="/FormularzStartowy",initParams={@WebInitParam(name= "ImieDomyslne",value="Gal")} )



public class FormularzStartowy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularzStartowy() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User urzytkownik = generujUsera(request);
		
		pokazUsera(response, urzytkownik);
		
		
	}


	private void pokazUsera(HttpServletResponse response, User urzytkownik) throws IOException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.print("<h2>Dane odebrano pomyœlnie</h2>");
        writer.print("<div>");
        writer.println(urzytkownik.getImie() + "<br>");
        writer.println(urzytkownik.getNazwisko() + "<br>");
        writer.println(urzytkownik.getPassword() + "<br>");
        writer.println(urzytkownik.getPlec() + "<br>");
        if(urzytkownik.getHobby() != null) {
            writer.print("Hobby: <br>");
            for(String hobby: urzytkownik.getHobby())
                writer.println(" " + hobby + "<br>");
        }
        writer.print("</div>");
        writer.println("</body>");
        writer.println("</html>");
	}


	protected void doPost(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {

		User urzytkownik = generujUsera(request1);
		
		pokazUsera(response1, urzytkownik);
		
		
	}
	
	private User generujUsera(HttpServletRequest request){
		String defImie = request.getParameter("imie");
		
		
		
		User user = new User();
		if(defImie == null || defImie ==""){
			user.setImie(getServletConfig().getInitParameter("ImieDomyslne"));	
		}else
		{
			user.setImie(request.getParameter("imie"));
			
		}
		
		user.setNazwisko(request.getParameter("nazwisko"));
		user.setPassword(request.getParameter("haslo"));
		user.setPlec(request.getParameter("plec"));
		user.setHobby(request.getParameterValues("hobby"));
		
		
		return user;
		
		
	}
	
	

}
