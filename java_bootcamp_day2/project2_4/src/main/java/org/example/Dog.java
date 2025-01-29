package org.example;

public class Dog extends Animal {

  public Dog(String name,int age){
    super(name,age);
  }

  @Override
  public Animal createAnimal(String name, int age) {
    return new Dog(name,age);
  }

  @Override
  public String toString() {
    return "Dog name = " + getName() + ", age = " + getAge();
  }
}
