package org.example;

public class Cat extends Animal {

  public Cat(String name, int age) {
    super(name, age);
  }

  @Override
  public String toString() {
    return "Cat name = " + getName() + ", age = " + getAge();
  }

  @Override
  public double goToWalk() {
    return getAge()*0.25;
  }
}
