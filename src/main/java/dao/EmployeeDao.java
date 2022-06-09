package dao;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
List<Employee> getAllEmployees() throws SQLException;
Employee getEmployeeById(int id) throws SQLException;
boolean addEmployee(Employee employee) throws SQLException;
boolean updateEmployee(Employee employee) throws SQLException;
boolean deleteEmployee(int id) throws SQLException;

Employee updateStatus(Employee employee)throws SQLException;
List<Employee> getPending(int id) throws SQLException;
List<Employee> getApproved() throws SQLException;

boolean updatePassword (Employee employee)throws SQLException;
boolean SubmitRequest (Employee employee)throws SQLException;

Employee login(Employee employee) throws SQLException;
boolean addRequest(Employee employee) throws SQLException;

Employee  getPendingHistory(Employee employee) throws SQLException;

//Employee  getApprovedHistory(Employee employee) throws SQLException;
 List<Employee> getEmployee(int x) throws SQLException;
 public List<Employee>  getApprovedHistory(int id) throws SQLException;
 public List<Employee> getPendingEmployees() throws SQLException;
}
