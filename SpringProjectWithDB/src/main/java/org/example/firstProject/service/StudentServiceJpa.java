package org.example.firstProject.service;

import java.util.List;
import org.example.firstProject.model.Student;
import org.example.firstProject.reposiory.RepositoryJpa;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StudentServiceJpa implements StudentService {

  private final RepositoryJpa repository;

  public StudentServiceJpa(RepositoryJpa repository) {
    this.repository = repository;
  }

  @Override
  public List<Student> findAllStudent() {
    return repository.findAll();
  }

  @Override
  public Student addStudent(Student student) {
    return repository.save(student);
  }

  @Override
  public Student updateStudent(Student student) {
    return repository.save(student);
  }

  @Override
  public Student findByEmail(String email) {
    return repository.findStudentByEmail(email);
  }

  @Override
  public void deleteStudent(String email) {
    repository.deleteByEmail(email);
  }
}
