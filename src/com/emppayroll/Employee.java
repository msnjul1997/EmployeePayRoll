package com.emppayroll;

public class Employee {
    private String name;
    private byte id;
    private long salary;
    private String emp_gender;
    private long emp_phone;
    private String emp_address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(String name, byte id, long salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }


    public String getEmp_gender() {
        String emp_gender = null;
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public long getEmp_phone() {
        long emp_phone = 0;
        return emp_phone;
    }

    public void setEmp_phone(long emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getEmp_address() {
        String emp_address = null;
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }
}
