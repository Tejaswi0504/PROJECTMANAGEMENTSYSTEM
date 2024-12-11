package com.jfsd.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.studentmanagement.repository.StudentRepository;
import com.jfsd.studentmanagement.model.Student;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String studentRegistration(Student student) {
        // Save the student object to the database
        studentRepository.save(student);
        return "Student Registered Successfully";
    }

    @Override
    public Student checkStudentLogin(String email, String pwd) {
        // Check student login using the repository method
        return studentRepository.checkstulogin(email, pwd);
    }

    @Override
    public String updateStudentProfile(Student student) {
        // Fetch the student object by ID
        Student s = studentRepository.findById(student.getId()).orElse(null);
        
        if (s != null) {
            // Update the fields with new values
            s.setContact(student.getContact());
            s.setDateofbirth(student.getDateofbirth());
            s.setDepartment(student.getDepartment());
            s.setGender(student.getGender());
            s.setLocation(student.getLocation());
            s.setName(student.getName());
            s.setPassword(student.getPassword());
            s.setSalary(student.getSalary());

            // Save the updated student back to the database
            studentRepository.save(s);
            return "Student Updated Successfully";
        } else {
            return "Student Not Found";
        }
    }

    @Override
    public Student displayStudentById(int eid) {
        // Fetch student by ID or return null if not found
        return studentRepository.findById(eid).orElse(null);
    }

    @Override
    public List<Student> displayStudentByDept(String department) {
        // Fetch list of students by department
        return studentRepository.findByDepartment(department);
    }

	@Override
	public Student checkstulogin(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student displayStudentbyId(int eid) {
		// TODO Auto-generated method stub
		return null;
	}
}

  

  

  
