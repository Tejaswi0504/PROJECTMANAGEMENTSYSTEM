package com.jfsd.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jfsd.studentmanagement.model.Student;
import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

public class AdminController {
	@Autowired
	   private AdminService adminService;
	   @GetMapping("/home")
	      public String home() {
	          return "home"; // Resolves to /WEB-INF/home.jsp
	      }
	  
	  

	  
	  @GetMapping("adminlogin")
	  public ModelAndView adminlogin()
	  {
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("adminlogin");
	    return mv;
	  }
	  
	  @GetMapping("adminhome")
	  public ModelAndView adminhome()
	  {
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("adminhome");
	    
	     Long count = adminService.empcount();
	     mv.addObject("empcount",count);
	    
	    return mv;
	  }
	  
	  @GetMapping("viewallemps")
	    public ModelAndView viewallemps()
	    {
	      ModelAndView mv = new ModelAndView();
	      List<Student> emplist = adminService.viewAllStudents();
	      mv.setViewName("viewallemps");
	      mv.addObject("emplist",emplist);
	      
	      Long count = adminService.empcount();
	     mv.addObject("empcount",count);
	      
	      return mv;
	    }
	  
	  
	  //created a view all customer 
	  
	 
	  
	  
	  
	  @GetMapping("deleteemp")
	    public ModelAndView deleteemp()
	    {
	      ModelAndView mv = new ModelAndView();
	      List<Student> emplist = adminService.viewAllStudents();
	      mv.setViewName("deleteemp");
	      mv.addObject("emplist",emplist);
	      return mv;
	    }
	  
	  @GetMapping("updateempstatus")
	    public ModelAndView updateempstatus()
	    {
	      ModelAndView mv = new ModelAndView();
	      List<Student> emplist = adminService.viewAllStudents();
	      mv.setViewName("updateempstatus");
	      mv.addObject("emplist",emplist);
	      return mv;
	    }
	  
	  @GetMapping("updatestatus")
	  public String updatestatus(@RequestParam("id") int eid,@RequestParam("status") String status)
	  {
	    adminService.updateemployeestatus(status, eid);
	    return "redirect:/updateempstatus"; // include only /
	  }
	  
	  @GetMapping("delete")
	  public String deleteoperation(@RequestParam("id") int eid)
	  {
	    adminService.deleteemp(eid);
	    
	    return "redirect:/deleteemp"; //redirect to specific page
	  }
	  
	  @GetMapping("adminlogout")
	  public ModelAndView adminlogout()
	  {
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("adminlogin");
	    return mv;
	  }
	  
	//  @PostMapping("checkadminlogin")
	//  // @ResponseBody
	//  public ModelAndView checkadminlogin(HttpServletRequest request)
	//  {
	//    
//	    ModelAndView mv = new ModelAndView();
	//    
//	    String auname = request.getParameter("auname");
//	    String apwd = request.getParameter("apwd");
	//    
//	    Admin admin = adminService.checkadminlogin(auname, apwd);
	//    
//	    if (admin!=null)
//	    {
//	      //return "admin login Success";
//	      mv.setViewName("adminhome");
//	       Long count = adminService.empcount();
//	       mv.addObject("empcount",count);
//	      
//	    }
//	    else
//	    {
//	      //return "admin login Failed";
//	      mv.setViewName("adminlogin");
//	      mv.addObject("message", "Login Failed");
//	    }
//	    return mv;
	//    
	//  }
	  
	  
	  @PostMapping("checkadminlogin")
	  public ModelAndView checkadminlogin(HttpServletRequest request) {
	      ModelAndView mv = new ModelAndView();
	      
	      String auname = request.getParameter("auname");
	      String apwd = request.getParameter("apwd");

	      Admin admin = adminService.checkadminlogin(auname, apwd);
		return mv;}
	

}

