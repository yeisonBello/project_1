package servlets;

import dao.EmployeeDao;
import model.Employee;
import utils.EmployeeDaoFactory;

import javax.servlet.RequestDispatcher;
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

public class ApprovedHistory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request,response);


        HttpSession session = request.getSession();
        int id = (int)session.getAttribute("id");



        List<Employee> employeeList = new ArrayList<>();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        try {
            employeeList = dao.getApprovedHistory(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }      out.println("<h1>APPROVED</h1>");
        for (Employee employee: employeeList){
            out.println("<br>");
            out.println("<tr>");
            out.println("<td>ID: "+ employee.getId()+ "  </td>");
            out.println("<td>EMAIL: "+ employee.getEmail()+ "  </td>");
            out.println("<td>NAME: "+ employee.getName()+ "  </td>");
            out.println("<td>RECEIPT TYPE: "+ employee.getReceipt_type()+ "  </td>");
            out.println("<td>STATUS: "+ employee.getStatus()+ "  </td>");
            out.println("<td>AMOUNT: "+ employee.getAmount()+ "  </td>");
            out.println("</tr>");}


        out.println("<h3><a href="+"employee_i.html"+">GO TO HOME PAGE </a></h3>");

        request.getRequestDispatcher("footer.html").include(request,response);
    }


}