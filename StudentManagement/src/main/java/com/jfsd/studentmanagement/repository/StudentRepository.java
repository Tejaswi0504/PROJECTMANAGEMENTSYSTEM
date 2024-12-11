package com.jfsd.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import com.jfsd.studentmanagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Method to check student login
    @Query("SELECT s FROM Student s WHERE s.email = ?1 AND s.password = ?2")
    Student checkStudentLogin(String uemail, String upwd);

    // Method to update student status
    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.status = ?1 WHERE s.id = ?2")
    int updateStudentStatus(String status, int sid);

    // Spring Data JPA automatically generates queries for these methods
    List<Student> findByDepartment(String department);

    List<Student> findByGenderAndDepartment(String gender, String department);

    List<Student> findByGender(String gender);
}

