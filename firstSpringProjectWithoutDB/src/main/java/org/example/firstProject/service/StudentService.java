package org.example.firstProject.service;

import java.util.List;
import org.example.firstProject.model.Student;

public interface StudentService {

  List<Student> findAllStudent();

  Student addStudent(Student student);

  Student updateStudent(Student student);

  Student findByEmail(String email);

  void deleteStudent(String email);
}
