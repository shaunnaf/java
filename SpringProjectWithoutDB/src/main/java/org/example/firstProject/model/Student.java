package org.example.firstProject.model;


public class Student {

  private Long id;
  private String firstName;
  private String secondName;
  private String email;
  private double GPA;


  public Student(Long id, String firstName, String secondName, String email, double gpa) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
    this.GPA = gpa;
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

  public void setGPA(int GPA) {
    this.GPA = GPA;
  }
}
