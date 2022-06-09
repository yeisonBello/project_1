package servlets;

import dao.EmployeeDao;
import model.Employee;
import utils.EmployeeDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PendingHistory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request,response);


        HttpSession session = request.getSession();
        int id = (int)session.getAttribute("id");



        List<Employee> employeeList = new ArrayList<>();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
            employeeList = dao.getPending(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }      out.println("<h1>PENDING</h1>");
        for (Employee employee: employeeList){
            out.println("<br>");
            out.println("<tr>");
            out.println("<td>ID: "+ employee.getId()+ "  </td>");
            out.println("<td>EMAIL: "+ employee.getEmail()+ "  </td>");
            out.println("<td>NAME: "+ employee.getName()+ "  </td>");
            out.println("<td>RECEIPT TYPE: "+ employee.getReceipt_type()+ "  </td>");
            out.println("<td>STATUS: "+ employee.getStatus()+ "  </td>");
            out.println("<td>AMOUNT: "+ employee.getAmount()+ "  </td>");
            out.println("<td>REQUEST_ID: "+ employee.getRequest_id()+ "  </td>");
            out.println("</tr>");}


        out.println("<h3><a href="+"employee_i.html"+">GO TO HOME PAGE </a></h3>");

        request.getRequestDispatcher("footer.html").include(request,response);
    }


}










































/*

        //int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = new Employee();
        employee.setId(id);
        Employee employee2 = new Employee();
        // get pending request

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {

            employee2 = dao.getPendingHistory(employee);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        if (employee2.getName() == null) {
            out.println("<h1>YOU DONT HAVE PENDING REQUEST</1h>");
            out.println("<h3><a href="+"pending-employee.html"+"#"+">TRY AGAIN </a></h3>");
        } else {
            out.println("<h1>PENDING</1h>");
            out.println("<br>");
            out.println("<tr>");
            out.println("<br>");
            out.println("<td>NAME: " + employee2.getName() + "  </td>");
            out.println("<br>");
            out.println("<td>RECEIPT TYPE: " + employee2.getReceipt_type() + "  </td>");
            out.println("<br>");
            out.println("<td>STATUS: " + employee2.getStatus() + "  </td>");
            out.println("<br>");
            out.println("<td>AMOUNT: " + employee2.getAmount() + "  </td>");
            out.println("</tr>");

        }
*/


