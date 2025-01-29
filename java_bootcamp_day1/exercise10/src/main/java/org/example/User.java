package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {

  private String name;
  private int age;

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "User{name='" + name + "', age=" + age + '}';
  }

  public static int readingCountUsers(Scanner input) {
    int countUsers = -1;
    boolean validInput = false;
    while (!validInput) {
      try {
        countUsers = input.nextInt();
        validInput = true;
      } catch (InputMismatchException e) {
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
    input.nextLine();
    return countUsers;
  }

  public static List<User> readingData(Scanner input, int usersCount) {
    List<User> users = new ArrayList<>();
    for (int i = 0; i < usersCount; i++) {
      String name = input.nextLine();
      int age = input.nextInt();
      input.nextLine();
      if (age <= 0) {
        System.out.println("Incorrect input. Age <= 0");
      } else {
        users.add(new User(name, age));
      }
    }
    return users;
  }

  public static void processingData(List<User> users) {
    String result = users.stream()
        .filter(user -> user.getAge() >= 18)
        .map(User::getName)
        .collect(Collectors.joining(", "));
    System.out.println(result);
  }
}
