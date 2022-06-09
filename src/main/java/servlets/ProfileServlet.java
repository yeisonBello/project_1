package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);//



        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = cookies[1].getValue();
            String password = cookies[2].getValue();
            if (!username.equals("")) {
                out.println("<h1>Welcome to your profile</h1>");
                out.println("<h3>This is your username: " + username + "</h3>");
                out.println("<h3>This is your password: " + password + "</h3>");
            } else {
                out.println("please go the login page and login first");
                request.getRequestDispatcher("/LoginServlet").include(request, response);
            }
            out.close();
        }
    }

}
