package org.example;

public abstract class Animal {
  private String name;
  private int age;

  public Animal(String name, int age){
    this.name = name;
    this.age = age;
  }

  public int getAge(){
    return age;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setAge(int age){
    this.age = age;
  }

  public abstract String toString();
}
