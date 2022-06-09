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

public class UpdateInformation extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

        boolean result = false;
        try {
            result = dao.updateEmployee(employee);// porque retorna un objecto tipo boolean
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            System.out.println("employee updated");
            request.getRequestDispatcher("employee_i.html").include(request,response);
            out.println("Employee Updated");
        } else {
            System.out.println("something went wrong");
        }
    }
}







