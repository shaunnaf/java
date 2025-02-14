package org.example.firstProject.reposiory;

import jakarta.transaction.Transactional;
import org.example.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryJpa extends JpaRepository<Student, Long> {

  void deleteByEmail(@Param("email") String email);

  Student findStudentByEmail(String email);
}
