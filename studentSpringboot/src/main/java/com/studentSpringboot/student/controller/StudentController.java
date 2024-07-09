package com.studentSpringboot.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentSpringboot.student.domain.Student;
import com.studentSpringboot.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Student> studentList = service.getAllStudents();
		model.addAttribute("studentList", studentList);
		System.out.println("GET /");
		return "index";
	}
	
	@GetMapping("/addStudent")
    public String addStudentPage(Model model) {
		model.addAttribute("student", new Student());
//		model.addAttribute("student", );
		return "addStudent";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("editStudent");
        Student student = service.getStudentById(id);
        mav.addObject("student", student);
        return mav;
	}
	
	@RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id) {
		service.deleteStudent(id);
		return "redirect:/";
	}
}
