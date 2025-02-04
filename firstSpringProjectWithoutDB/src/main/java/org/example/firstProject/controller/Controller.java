package org.example.firstProject.controller;

import java.util.List;
import org.example.firstProject.model.Student;
import org.example.firstProject.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class Controller {

  private final StudentService service;

  public Controller(StudentService service) {
    this.service = service;
  }

  @GetMapping
  public List<Student> getStudents() {
    return service.findAllStudent();
  }

  @PostMapping("add_student")
  public String addStudent(@RequestBody Student student) {
    service.addStudent(student);
    return "Студент успешно добавлен!";
  }

  @GetMapping("/{email}")
  public Student findByEmail(@PathVariable String email) {
    return service.findByEmail(email);
  }

  @PutMapping("update_student")
  public String updateStudent(@RequestBody Student student) {
    service.updateStudent(student);
    return "Информация обновлена!";
  }

  @DeleteMapping("delete_student/{email}")
  public String deleteStudent(@PathVariable String email) {
    service.deleteStudent(email);
    return "Студент удален!";
  }
}
