package org.example.firstProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String secondName;
  @Column(unique = true)
  private String email;
  private double GPA;


  public Student(Long id, String firstName, String secondName, String email, double gpa) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
    this.GPA = gpa;
  }

  public Student() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getGPA() {
    return GPA;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setGPA(double GPA) {
    this.GPA = GPA;
  }
}
