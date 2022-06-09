package dao.impl;

import dao.EmployeeDao;
import model.Employee;
import utils.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    Connection connection;

    public EmployeeDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>(); //ARRAY LIST
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while ( resultSet.next()){

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            Employee employee = new Employee();

            employee.setId(id);
            employee.setName(name);
            employee.setEmail(email);
            employee.setPassword(password);

employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int empId) throws SQLException {
        Employee employee= new Employee();
        String sql = " select * from employee where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(empId));


        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        if (resultSet!=null){


            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            employee.setId(id);
            employee.setName(name);
            employee.setEmail(email);
            employee.setPassword(password);
        }
        return employee;
    }

    @Override
     public boolean  addEmployee(Employee employee) throws SQLException {
        String sql = " insert into employee (name, email, password) values (? , ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getPassword());


        int count = preparedStatement.executeUpdate();
        if(count > 0 ) {
            System.out.println("employee Update");
            return true;
        }else {
            System.out.println("error ");
            return false;
        }


    }

    public boolean updateEmployee(Employee employee) throws SQLException {

        String sql = " update employee set name = ? , email = ? , password = ?  where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(3, employee.getPassword());
        preparedStatement.setInt(4, employee.getId());

        int count = preparedStatement.executeUpdate();
        if(count > 0 ) {
            System.out.println("employee saved");
            return true;
        }else {
            System.out.println("error ");
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        String sql = "delete from employee where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0 ) {
            System.out.println("employee deleted");
            return true;
        }else {
            System.out.println("error ");
            return false;
        }

    }

    @Override
    public  Employee updateStatus(Employee employee) throws SQLException {
        String sql = " update requests set status ='approved' where request_id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getRequest_id());

        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("employee saved");

        } else {
            System.out.println("error ");



        }

        return employee;
    }

    @Override
    public List<Employee> getPending(int x) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from requests where status ='pending' and id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x);


        ResultSet resultSet = preparedStatement.executeQuery();
        while ( resultSet.next()){

            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String receipt_type = resultSet.getString("receipt_type");
            String status = resultSet.getString("status");
            int amount = resultSet.getInt("amount");
            int request_id= resultSet.getInt("request_id");
            //String date = resultSet.getString("date");

            Employee employee = new Employee(); //(id, email , name , receipt_type , status, amount, date);
            employee.setId(id);
            employee.setEmail(email);
            employee.setName(name);
            employee.setReceipt_type(receipt_type);
            employee.setStatus(status);
            employee.setAmount(amount);
            employee.setRequest_id(request_id);




            employees.add(employee);
        }
        return employees;
    }


    @Override
    public List<Employee> getPendingEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from requests where status ='pending'";


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);


        while ( resultSet.next()){

            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String receipt_type = resultSet.getString("receipt_type");
            String status = resultSet.getString("status");
            int amount = resultSet.getInt("amount");
            int request_id= resultSet.getInt("request_id");
            //String date = resultSet.getString("date");

            Employee employee = new Employee(); //(id, email , name , receipt_type , status, amount, date);
            employee.setId(id);
            employee.setEmail(email);
            employee.setName(name);
            employee.setReceipt_type(receipt_type);
            employee.setStatus(status);
            employee.setAmount(amount);
            employee.setRequest_id(request_id);




            employees.add(employee);
        }
        return employees;
    }



    public List<Employee> getApproved() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from requests where status = 'approved' ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while ( resultSet.next()){

            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String receipt_type = resultSet.getString("receipt_type");
            String status = resultSet.getString("status");
            int amount = resultSet.getInt("amount");
            int request_id= resultSet.getInt("request_id");
            //Employee employee = new Employee(id, email , name, password , receipt_type , status , amount);

            Employee employee = new Employee();

            employee.setId(id);
            employee.setEmail(email);
            employee.setName(name);
            employee.setReceipt_type(receipt_type);
            employee.setStatus(status);
            employee.setAmount(amount);
            employee.setReceipt_type(String.valueOf(request_id));

            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean updatePassword(Employee employee) throws SQLException {
        String sql = " update employee set password = ? where email = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setString(1, employee.getPassword());


        int count = preparedStatement.executeUpdate();
        if(count > 0 ) {
            System.out.println("employee saved");
            return true;
        }else {
            System.out.println("error ");
            return false;
        }
    }

    @Override
    public boolean SubmitRequest(Employee employee) throws SQLException {
        String sql = " update employee set amount=? ,receipt_type=?, status='pending' where id =? ";
        //String sql = " update employee set amount= ?, set receipt_type = ? , set status = 'PENDING' where email = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getAmount());
        preparedStatement.setString(2, employee.getReceipt_type());
        preparedStatement.setString(3, String.valueOf(employee.getId()));



        int count = preparedStatement.executeUpdate();
        if(count > 0 ) {
            System.out.println("employee saved");
            return true;
        }else {
            System.out.println("error ");
            return false;
        }
    }

    public Employee login(Employee employee) throws SQLException {

        String email = employee.getEmail();
        String pass = employee.getPassword();
        System.out.println(email + pass +"    this line is frimplementacion ");

        //String sql = " select * from employee where email='?' and password='?' ";

        //PreparedStatement preparedStatement =(PreparedStatement)  connection.prepareStatement(sql);

        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(" select * from employee where email=? and password=? ");


        preparedStatement.setString(1, email);
        preparedStatement.setString(2, pass);
        ResultSet resultSet = preparedStatement.executeQuery();

        while ( resultSet.next()){
            employee.setId(resultSet.getInt("id"));
            employee.setEmail(resultSet.getString("email"));
            employee.setName(resultSet.getString("name"));
            employee.setPassword(resultSet.getString("password"));
        }
        return employee;
    }

    @Override

    public boolean addRequest(Employee employee) throws SQLException {

        String sql = " insert into requests(amount ,receipt_type, id, name , email , status) values (?,?,?, ?,?, 'pending') ";
        PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(employee.getAmount()));
        preparedStatement.setString(2, employee.getReceipt_type());
        preparedStatement.setString(3, String.valueOf(employee.getId()));
        preparedStatement.setString(4, employee.getName());
        preparedStatement.setString(5, employee.getEmail());



        int count = preparedStatement.executeUpdate();
        if(count > 0 ) {
            System.out.println("request saved");
            return true;
        }else {
            System.out.println("error ");
            return false;
        }
    }

//    @Override
//    public Employee getEmployee(Employee employee) throws SQLException {
//
//
//        int id = employee.getId();
//
//        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(" select * from requests where id = ?");
//
//        preparedStatement.setInt(1,id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while ( resultSet.next()){
//            employee.setId(resultSet.getInt("id"));
//            employee.setEmail(resultSet.getString("email"));
//            employee.setName(resultSet.getString("name"));
//            employee.setPassword(resultSet.getString("password"));
//            employee.setReceipt_type(resultSet.getString("receipt_type"));
//            employee.setStatus(resultSet.getString("status"));
//            employee.setAmount(resultSet.getInt("amount"));
//        }
//        return employee;
//    }

    @Override
    public List<Employee> getEmployee(int x) throws SQLException {


        List<Employee> employees = new ArrayList<>();
        String sql = "select * from requests where id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x);


        ResultSet resultSet = preparedStatement.executeQuery();
        while ( resultSet.next()){

            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String receipt_type = resultSet.getString("receipt_type");
            String status = resultSet.getString("status");
            int amount = resultSet.getInt("amount");
            int request_id= resultSet.getInt("request_id");
            //String date = resultSet.getString("date");

            Employee employee = new Employee(); //(id, email , name , receipt_type , status, amount, date);
            employee.setId(id);
            employee.setEmail(email);
            employee.setName(name);
            employee.setReceipt_type(receipt_type);
            employee.setStatus(status);
            employee.setAmount(amount);
            employee.setRequest_id(request_id);




            employees.add(employee);
        }
        return employees;
    }

    @Override
    public  Employee  getPendingHistory(Employee employee) throws SQLException{

        String sql = "select * from employee where status='pending' and id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(employee.getId()));

        ResultSet resultSet = preparedStatement.executeQuery();
        while ( resultSet.next()){

            employee.setId(resultSet.getInt(1));
            employee.setName(resultSet.getString(3));
            employee.setReceipt_type(resultSet.getString(5));
            employee.setStatus(resultSet.getString(6));
            employee.setAmount(resultSet.getInt(7));

        }
        return employee;

    }

  /*  @Override
    public  Employee  getApprovedHistory(Employee employee) throws SQLException{

        String sql = "select * from employee where status='approved' and id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(employee.getId()));

        ResultSet resultSet = preparedStatement.executeQuery();
        while ( resultSet.next()){

            employee.setId(resultSet.getInt(1));
            employee.setName(resultSet.getString(3));
            employee.setReceipt_type(resultSet.getString(5));
            employee.setStatus(resultSet.getString(6));
            employee.setAmount(resultSet.getInt(7));

        }
        return employee;

    }*/




    public List<Employee>  getApprovedHistory(int x) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from requests where status ='approved' and id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x);


        ResultSet resultSet = preparedStatement.executeQuery();
        while ( resultSet.next()){

            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String receipt_type = resultSet.getString("receipt_type");
            String status = resultSet.getString("status");
            int amount = resultSet.getInt("amount");
            //String date = resultSet.getString("date");

            Employee employee = new Employee(); //(id, email , name , receipt_type , status, amount, date);
            employee.setId(id);
            employee.setEmail(email);
            employee.setName(name);
            employee.setReceipt_type(receipt_type);
            employee.setStatus(status);
            employee.setAmount(amount);




            employees.add(employee);
        }
        return employees;
    }

}
