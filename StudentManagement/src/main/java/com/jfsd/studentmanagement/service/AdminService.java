package com.jfsd.studentmanagement.service;

import java.util.List;

import com.jfsd.studentmanagement.model.Admin;

import com.jfsd.studentmanagement.model.Student;
import com.klef.jfsd.springboot.model.Customer;


    public interface AdminService {

        // Method to view all employees
        List<Student> viewAllStudents();

        // Method to validate admin login
        Admin checkAdminLogin(String uname, String pwd);

        // Method to display employee details by ID
        Student displayStudentById(int eid);

        // Method to count the number of employees

        // Method to delete an employee by ID
        String deleteStu(int eid);
        Long stuCount();

        // Method to update employee status
        String updateStudentStatus(String status, int eid);

        // Method to add a customer


     
  


    // Method to count the number of customers
   
}

