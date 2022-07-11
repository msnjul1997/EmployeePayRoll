package com.databaseconnection;

import com.emppayroll.EmpDeptDetails;
import com.emppayroll.EmpPayDetails;
import com.emppayroll.Employee;

import java.sql.*;

public class EmpDetailsToDataBaseConnection implements IEmpDetails{
    Statement statement;
    private DataBaseConnection dbConection;
    //DBConection dbConection = new DBConection();
    Connection connection = dbConection.getConnection();
    ResultSet resultSet;
    @Override
    public void getEmployeeDetails(int id) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String retrieveEmpQuery = "select * from employee_details where emp_id = "+id+";";
        String retrievePayQuery = "select * from employee_pay where emp_id = "+id+";";
        String retrieveDeptQuery = "select * from employee_department_details where emp_id = "+id+";";
        try {
            resultSet = statement.executeQuery(retrieveEmpQuery);
            while(resultSet.next()){
                System.out.println("----------------------");
                System.out.println("Employee ID: "+resultSet.getInt("emp_id"));
                System.out.println("Employee Name: "+resultSet.getString("name"));
                System.out.println("Employee Gender: "+resultSet.getString("emp_gender"));
                System.out.println("Employee Phone: "+resultSet.getLong("emp_phone"));
                System.out.println("Employee Address: "+resultSet.getString("emp_address"));
            }
            resultSet = statement.executeQuery(retrievePayQuery);
            while(resultSet.next()){
                System.out.println("----------------------");
                System.out.println("Employee Basic_Pay: "+resultSet.getInt("Basic_Pay"));
                System.out.println("Employee Deductions: "+resultSet.getInt("Deductions"));
                System.out.println("Employee Taxable_Pay: "+resultSet.getInt("Taxable_Pay"));
                System.out.println("Employee Income_Tax: "+resultSet.getInt("Income_Tax"));
                System.out.println("Employee Net_Pay: "+resultSet.getInt("Net_Pay"));
            }
            resultSet = statement.executeQuery(retrieveDeptQuery);
            while(resultSet.next()){
                System.out.println("----------------------");
                System.out.println("Employee Salary: "+resultSet.getInt("emp_salar"));
                System.out.println("Employee Department: "+resultSet.getString("emp_department"));
                System.out.println("Employee Start date: "+resultSet.getDate("emp_start_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
    @Override
    public void addEmployeePersonalDetails(Employee employee) {
        String addQuery = "insert into employee_details(name,emp_gender,emp_phone,emp_address) values(?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getId());
            preparedStatement.setLong(3,employee.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Employee details added Successfully!");
    }

    @Override
    public void addEmployeePayDetails(EmpPayDetails employeePayDetails) {
        String addQuery = "insert into employee_pay(Basic_Pay,Deductions,Taxable_Pay,Income_Tax,Net_Pay) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setInt(1,employeePayDetails.getBasic_Pay());
            preparedStatement.setInt(2,employeePayDetails.getDeductions());
            preparedStatement.setInt(3,employeePayDetails.getTaxable_Pay());
            preparedStatement.setInt(4,employeePayDetails.getIncome_Tax());
            preparedStatement.setInt(5,employeePayDetails.getNet_Pay());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Employee's pay details added Successfully!");
    }

    @Override
    public void addEmployeeDepartmentDetails(EmpDeptDetails employee_department_details) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String addQuery = "insert into employee_department_details(emp_salar,emp_department,emp_start_date) values(?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setInt(1,employee_department_details.getEmp_salary());
            preparedStatement.setString(2,employee_department_details.getEmp_department());
            preparedStatement.setString(3,employee_department_details.getStart_date());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Employee details added Successfully!");
    }
}
