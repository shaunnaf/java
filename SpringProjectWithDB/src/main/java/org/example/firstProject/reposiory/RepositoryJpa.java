package org.example.firstProject.reposiory;

import jakarta.transaction.Transactional;
import org.example.firstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJpa extends JpaRepository<Student, Long> {

  @Transactional
  void deleteByEmail(String email); // ✅ Добавлена транзакция, убран @Param

  Student findByEmail(String email); // ✅ Исправлено имя метода
}
