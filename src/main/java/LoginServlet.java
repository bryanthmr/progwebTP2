import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            out.println("<html><body>");
            out.println("<form action='/tp2_progweb_war_exploded/RedirectServlet' method='get'>");
            out.println("<label>Action:</label>");
            out.println("<select name='action'>");
            out.println("<option value='PageRedirect'>PageRedirect</option>");
            out.println("</select><br><br>");
            out.println("<label>URL:</label>");
            out.println("<input type='text' name='page' placeholder='http://google.fr'><br><br>");
            out.println("<button type='submit'>Redirect</button>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<p>Incorrect login or password!</p>");
            out.println("</body></html>");
        }
    }
}
