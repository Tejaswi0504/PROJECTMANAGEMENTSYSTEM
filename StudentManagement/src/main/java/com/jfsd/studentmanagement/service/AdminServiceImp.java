package com.jfsd.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.studentmanagement.model.Admin;
import com.jfsd.studentmanagement.model.Student;

import com.jfsd.studentmanagement.repository.AdminRepository;
import com.jfsd.studentmanagement.repository.StudentRepository;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdminRepository adminRepository;

    // View all employees (students)
    @Override
    public List<Student> viewAllStudents() {
        return studentRepository.findAll();
    }

    // Admin login validation
    @Override
    public Admin checkAdminLogin(String uname, String pwd) {
        return adminRepository.checkAdminLogin(uname, pwd);
    }

    // Display employee by ID
    @Override
    public Student displayStudentById(int eid) {
        return studentRepository.findById(eid).orElse(null);
    }

    // Employee count
    @Override
    public Long stuCount() {
        return studentRepository.count();
    }

    // Delete employee by ID
    @Override
    public String deleteStu(int eid) {
        studentRepository.deleteById(eid);
        return "Student Deleted Successfully";
    }

   
    @Override
    public String updateStudentStatus(String status, int eid) {
        studentRepository.updateStudentStatus(status, eid);
        return "Student Status Updated Successfully";
    }





	

  

}
