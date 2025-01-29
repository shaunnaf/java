package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    List<User> users = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int usersCount = User.readingCountUsers(input);
    users = User.readingData(input, usersCount);
    User.processingData(users);
  }
}