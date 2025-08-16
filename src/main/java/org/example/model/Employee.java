package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;
    private String empAddress;
    private String empDepartment;
    private double salary;

    public Employee() {
    }

    public Employee(Long empId, String empName, String empAddress, String empDepartment, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empDepartment = empDepartment;
        this.salary = salary;
    }

    public Employee(String empName, String empAddress, String empDepartment, double salary) {
        this.empName = empName;
        this.empAddress = empAddress;
        this.empDepartment = empDepartment;
        this.salary = salary;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", salary=" + salary +
                '}';
    }
}
