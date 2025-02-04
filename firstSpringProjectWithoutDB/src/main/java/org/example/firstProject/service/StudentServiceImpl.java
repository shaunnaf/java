package org.example.firstProject.service;

import java.util.List;
import org.example.firstProject.model.Student;
import org.example.firstProject.reposiory.InMemoryStudentDAO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final InMemoryStudentDAO repository;

  public StudentServiceImpl(InMemoryStudentDAO repository) {
    this.repository = repository;
  }

  @Override
  public List<Student> findAllStudent() {
    return repository.findAllStudent();
  }

  @Override
  public Student addStudent(Student student) {
    return repository.addStudent(student);
  }

  @Override
  public Student updateStudent(Student email) {
    return repository.updateStudent(email);
  }

  @Override
  public Student findByEmail(String email) {
    return repository.findByEmail(email);
  }

  @Override
  public void deleteStudent(String email) {
    repository.deleteStudent(email);
  }

}
