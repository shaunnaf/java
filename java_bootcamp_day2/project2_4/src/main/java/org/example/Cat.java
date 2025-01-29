package org.example;

public class Cat extends Animal{

  public Cat(String name,int age){
    super(name,age);
  }

  @Override
  public Animal createAnimal(String name, int age) {
    return new Cat(name,age);
  }

  @Override
  public String toString() {
    return "Cat name = " + getName() + ", age = " + getAge();
  }
}
