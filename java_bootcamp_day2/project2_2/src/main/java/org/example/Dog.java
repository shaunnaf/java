package org.example;

public class Dog extends Animal {
  public Dog(String name,int age,double mass){
    super(name,age,mass);
  }

  @Override
  public double getFeedInfoKg(double mass){
    return mass*0.3;
  }

  @Override
  public String toString(){
    return "Dog name = " + getName() + ", age = " + getAge() + ", mass = " + getMass() + ", feed = " + getFeedInfoKg(getMass());
  }
}
