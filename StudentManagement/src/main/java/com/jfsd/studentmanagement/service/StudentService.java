package com.jfsd.studentmanagement.service;


import java.util.List;

import com.jfsd.studentmanagement.model.Student;
import com.jfsd.studentmanagement.model.Student;


public interface StudentService 
{
   public String studentRegistration(Student emp);
   public Student checkstulogin(String email,String pwd);
   public String updateStudentProfile(Student student);
   public Student displayStudentbyId(int eid);
   
   public List<Student> displayStudentByDept(String department);
   
   
}
