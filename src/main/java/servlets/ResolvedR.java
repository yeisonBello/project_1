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

public class ResolvedR extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("managernavbar.html").include(request, response);
        // get employees
        List<Employee> employeeList = new ArrayList<>();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
            employeeList = dao.getApproved();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("<h1>Approved</h1>");
        for (Employee employee : employeeList) {
            out.println("<br>");
            out.println("<tr>");
            out.println("<td>ID: " + employee.getId() + "  </td>");
            out.println("  ||  ");
            out.println("<td>EMAIL: " + employee.getEmail() + "  </td>");
            out.println("  ||  ");
            out.println("<td>NAME: " + employee.getName() + "  </td>");
            out.println("  ||  ");
            out.println("<td>RECEIPT TYPE: " + employee.getReceipt_type() + "  </td>");
            out.println("  ||  ");
            out.println("<td>STATUS: " + employee.getStatus() + "  </td>");
            out.println("  ||  ");
            out.println("<td>AMOUNT: " + employee.getAmount() + "  </td>");
            out.println("<td>REQUEST_ID: " + employee.getReceipt_type() + "  </td>");
            out.println("</tr>");

        }

        out.println("<h3><a href="+"pending-employees.html"+"#"+">View Pending Employees</a></h3>");
        out.println("<h3><a href="+"employee-list.html"+">View All Employees </a></h3>");
        out.println("<h3><a href="+"manager_i.html"+">GO TO MANAGER HOME PAGE </a></h3>");
    }
}
