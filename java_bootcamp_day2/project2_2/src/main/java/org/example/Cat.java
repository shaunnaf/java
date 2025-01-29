package org.example;

public class Cat extends Animal {
  public Cat(String name, int age, double mass){
    super(name,age,mass);
  }

  @Override
  public double getFeedInfoKg(double mass) {
    return mass*0.1;
  }

  @Override
  public String toString() {
    return "Cat name = " + getName() + ", age = " + getAge() + ", mass = " + getMass() + ", feed = " + getFeedInfoKg(getMass());
  }
}
