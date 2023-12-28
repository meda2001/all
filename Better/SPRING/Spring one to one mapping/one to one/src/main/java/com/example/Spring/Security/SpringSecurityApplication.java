package com.example.Spring.Security;

import com.example.Spring.Security.Entity.Details;
import com.example.Spring.Security.Entity.Student;
import com.example.Spring.Security.Entity.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

@RestController
public class SpringSecurityApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public List<Student> getAll(){
		message();
		return studentRepository.findAll();
	}

	private void message() {
		Student s = new Student(1,"user","user","user@gmail.com","password");
		Details d = new Details(1,5,"ece","prasad");
		s.setDetails(d);
		d.setStudent(s);
		studentRepository.save(s);

	}

}
