package org.example.firstProject.controller;

import java.util.List;
import org.example.firstProject.model.Student;
import org.example.firstProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")  // ✅ Добавлен слеш в начале
public class StudentController {     // ✅ Название класса должно быть осмысленным

  private final StudentService service;

  public StudentController(StudentService service) {  // ✅ Исправлено название класса
    this.service = service;
  }

  @GetMapping
  public List<Student> getStudents() {
    return service.findAllStudent();
  }

  @PostMapping
  public ResponseEntity<Student> addStudent(
      @RequestBody Student student) {  // ✅ Теперь возвращаем созданного студента
    Student savedStudent = service.addStudent(student);
    return ResponseEntity.ok(savedStudent);
  }

  @GetMapping("/{email}")
  public ResponseEntity<Student> findByEmail(
      @PathVariable String email) {  // ✅ Добавлен ResponseEntity
    Student student = service.findByEmail(email);
    return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")  // ✅ Обновление по id
  public ResponseEntity<Student> updateStudent(@PathVariable Long id,
      @RequestBody Student student) {
    student.setId(id); // ✅ Убеждаемся, что обновляем правильного студента
    Student updatedStudent = service.updateStudent(student);
    return ResponseEntity.ok(updatedStudent);
  }

  @DeleteMapping("/{id}")  // ✅ Удаление по id
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    service.deleteStudent(String.valueOf(id));
    return ResponseEntity.noContent().build(); // ✅ Возвращаем 204 No Content
  }
}
