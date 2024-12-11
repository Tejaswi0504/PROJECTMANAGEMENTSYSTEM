package com.jfsd.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.studentmanagement.model.Student;
import com.jfsd.studentmanagement.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Blob;




import java.util.List;

@Controller // Add the Controller annotation
public class StudentController {

    @Autowired
    private StudentService studentService; // Assuming you have a StudentService to handle logic

    @PostMapping("/updateStudent") // Assuming this method updates the student's profile
    public ModelAndView updateStudentProfile(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            // Fetching parameters from request
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("ename");
            String gender = request.getParameter("egender");
            String dob = request.getParameter("edob");
            String dept = request.getParameter("edept");
            double salary = Double.parseDouble(request.getParameter("esalary"));
            String password = request.getParameter("epwd");
            String location = request.getParameter("elocation");
            String contact = request.getParameter("econtact");

            // Creating Student object
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setGender(gender);
            student.setDepartment(dept);
            student.setDateofbirth(dob);
            student.setSalary(salary);
            student.setPassword(password);
            student.setLocation(location);
            student.setContact(contact);

            // Update the student's profile
            String msg = studentService.updateStudentProfile(student);

            // Retrieve updated student
            Student updatedStudent = studentService.getStudentById(id);

            // Update session attribute
            HttpSession session = request.getSession();
            session.setAttribute("student", updatedStudent); // session variable: student

            mv.setViewName("updatesuccess");
            mv.addObject("message", msg);
        } catch (Exception e) {
            mv.setViewName("updateerror");
            mv.addObject("message", "Error updating student: " + e.getMessage());
        }
        return mv;
    }

    @GetMapping("/studentLogout")
    public ModelAndView studentLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("student"); // Remove single attribute
        // session.invalidate(); // Uncomment this to invalidate the entire session

        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentlogin");
        return mv;
    }

    @GetMapping("/sessionExpiry")
    public ModelAndView sessionExpiry() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sessionexpiry");
        return mv;
    }

    @GetMapping("/viewStudentsByDept")
    public ModelAndView viewStudentsByDept(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();

        Student student = (Student) session.getAttribute("student");
        if (student != null) {
            List<Student> studentList = studentService.displayStudentByDept(student.getDepartment());
            mv.addObject("studentList", studentList);
            mv.setViewName("viewstudents");
        } else {
            mv.setViewName("sessionexpired");
            mv.addObject("message", "Session expired. Please login again.");
        }
        return mv;
    }
}
