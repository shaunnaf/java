package org.example.firstProject.controller;

import java.util.List;
import org.example.firstProject.model.Student;
import org.example.firstProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @GetMapping
  public List<Student> getStudents() {
    return service.findAllStudent();
  }

  @PostMapping
  public ResponseEntity<Student> addStudent(
      @RequestBody Student student) {
    Student savedStudent = service.addStudent(student);
    return ResponseEntity.ok(savedStudent);
  }

  @GetMapping("/{email}")
  public ResponseEntity<Student> findByEmail(
      @PathVariable String email) {
    Student student = service.findByEmail(email);
    return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Long id,
      @RequestBody Student student) {
    student.setId(id);
    Student updatedStudent = service.updateStudent(student);
    return ResponseEntity.ok(updatedStudent);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    service.deleteStudent(String.valueOf(id));
    return ResponseEntity.noContent().build();
  }
}
