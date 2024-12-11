package com.jfsd.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import com.jfsd.studentmanagement.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    // Method to check admin login
    @Query("SELECT a FROM Admin a WHERE a.username = ?1 AND a.password = ?2")
    Admin checkAdminLogin(String uname, String pwd);

    // Method to delete an Employee by email
    @Modifying
    @Transactional
    @Query("DELETE FROM Student e WHERE e.email = :email")
    int deleteStuByEmail(String email);
}

