package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);

        Cookie cookie = new Cookie("username", "");
        response.addCookie(cookie);
        Cookie cookie1 = new Cookie("password", "");
        response.addCookie(cookie1);

        out.println("you are logged out successfully");
        out.println("<h3><a href="+"index.html"+">GO TO HOME PAGE </a></h3>");
    }
}
