package org.example.firstProject.reposiory;

import java.util.ArrayList;
import java.util.List;
import org.example.firstProject.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStudentDAO {

  List<Student> studentList = new ArrayList<>();


  public List<Student> findAllStudent() {
    return studentList;
  }

  public Student addStudent(Student student) {
    studentList.add(student);
    return student;
  }

  public Student updateStudent(Student student) {
    if (findByEmail(student.getEmail()) == null) {
      return null;
    } else {
      int studentIndex = studentList.indexOf(findByEmail(student.getEmail()));
      return studentList.set(studentIndex, student);
    }
  }

  public Student findByEmail(String email) {
    return studentList.stream()
        .filter(element -> element.getEmail().equals(email))
        .findFirst()
        .orElse(null);
  }

  public void deleteStudent(String email) {
    studentList.remove(findByEmail(email));
  }
}
