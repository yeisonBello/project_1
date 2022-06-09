package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);// esto sobrepone navbar en login

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // when user enter correct detail
        if (username.equals("admin") && password.equals("123")) {
            // success
            out.println("You are successfully logged In");
            out.println("<br>Welcome admin");

//            Cookie cookie = new Cookie("username", username);
//            response.addCookie(cookie);
//            Cookie cookie1 = new Cookie("password", password);
//            response.addCookie(cookie1);
        } else {
            // failed
            out.println("sorry! invalid details");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");//
            requestDispatcher.include(request, response);

        }

        out.close();
    }
}
