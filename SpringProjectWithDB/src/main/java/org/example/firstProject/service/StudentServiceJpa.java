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
    if (repository.existsById(student.getId())) {
      return repository.save(student);
    }
    throw new RuntimeException("Студент с ID " + student.getId() + " не найден");
  }

  @Override
  public Student findByEmail(String email) {
    return repository.findByEmail(email);
  }

  @Override
  public void deleteStudent(String email) {
    if (repository.findByEmail(email) != null) {
      repository.deleteByEmail(email);
    } else {
      throw new RuntimeException("Студент с email " + email + " не найден");
    }
  }
}
