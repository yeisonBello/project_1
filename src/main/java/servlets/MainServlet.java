package servlets;

import dao.EmployeeDao;
import model.Employee;
import utils.EmployeeDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("managernavbar.html").include(request, response);

        // get employees
        List<Employee> employeeList = new ArrayList<>();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
            employeeList = dao.getAllEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        out.println(" <th>     Id  ||</th>");
        out.println("<th>Name   ||</th>");
        out.println("<th>    Email||</th>");
        out.println(" <th>     Password    ||</th>");

        out.println("<br>");
        out.println("--------------------------------------------------------------------------------------------------");
        out.println("<br>");


for (Employee employee: employeeList){


      out.println("<tr>");
      out.println("<th>     "+ employee.getId()+  "</th>");
      out.println("  ||  ");
    out.println("<th>"+ employee.getName()+ "</th>");
    out.println("  ||  ");
    out.println("<th>"+ employee.getEmail()+ "</th>");
    out.println("  ||  ");
    out.println("<th>"+ employee.getPassword()+ "</th>");
    out.println("  ||  ");

    out.println("<br>");
    out.println("<br>");
    out.println("</tr>");


}

        out.println("<h3><a href="+"pending-employees.html"+"#"+">View Pending Employees</a></h3>");
        out.println("<h3><a href="+"resolved-employees.html"+"#"+">View Approved Employees</a></h3>");
        out.println("<h3><a href="+"manager_i.html"+">GO TO MANAGER HOME PAGE </a></h3>");

}}
