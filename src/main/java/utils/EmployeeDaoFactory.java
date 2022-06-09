package utils;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;

public class EmployeeDaoFactory {
    public static EmployeeDao dao;


    private EmployeeDaoFactory() {
    }

    public static EmployeeDao getEmployeeDao() {
        if (dao == null)
            dao = new EmployeeDaoImpl() ;
        return dao;
    }
}
