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

public class EmployeeAdd extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();




        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);


        System.out.println(employee.getEmail()+employee.getName()+employee.getPassword()+employee.getReceipt_type());

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        boolean result = false;
        try {
            result = dao.addEmployee(employee);// porque retorna un objecto tipo boolean
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result) {
            out.println("<h1> Employee Saved</h1>");
            System.out.println("employee saved");
            request.getRequestDispatcher("manager_i.html").include(request,response);
        } else {
            System.out.println("something went wrong");
        }
    }
}