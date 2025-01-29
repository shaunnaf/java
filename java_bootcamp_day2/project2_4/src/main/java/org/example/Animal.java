package org.example;

public abstract class Animal {
  private final String name;
  private final int age;

  public Animal(String name,int age){
    this.name = name;
    this.age = age;
  }

  public String getName(){
    return name;
  }

  public int getAge(){
    return age;
  }

  public Animal incrementAge() {
    return (age > 10) ? createAnimal(name, age + 1) : this;
  }

  public abstract Animal createAnimal(String name,int age);

  public abstract String toString();

}
