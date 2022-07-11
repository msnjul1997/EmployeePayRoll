package com.emppayroll;

public class EmpDeptDetails {
    private int emp_id , emp_salary ;
    private String emp_department;
    private String start_date;

    public EmpDeptDetails(int emp_id, int emp_salary, String emp_department, String start_date) {
        this.emp_id = emp_id;
        this.emp_salary = emp_salary;
        this.emp_department = emp_department;
        this.start_date = start_date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public int getEmp_salary() {
        return emp_salary;
    }

    public String getEmp_department() {
        return emp_department;
    }

    public String getStart_date() {
        return start_date;
    }

    @Override
    public String toString() {
        return "Employee_Department_Details{" +
                "emp_id=" + emp_id +
                ", emp_salary=" + emp_salary +
                ", emp_department='" + emp_department + '\'' +
                ", start_date=" + start_date +
                '}';
    }
}
