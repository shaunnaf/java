package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OurIndexOf {

  public static int readingCountStrings(Scanner input) {
    int number = -1;
    boolean validInput = false;
    while (!validInput) {
      try {
        number = input.nextInt();
        if (number <= 0) {
          System.out.println("Input error, counts strings <=0");
        }
        validInput = true;
      } catch (InputMismatchException e) {
        System.out.println("Error input, try again");
        input.nextLine();
      }
    }
    return number;
  }

  public static void readingStrings(Scanner input, List<String> stringList, int countStrings) {
    for (int i = 0; i < countStrings; i++) {
      stringList.add(input.nextLine());
    }
  }

  public static boolean indexOf(String text, String pattern) {
    boolean find = true;
    for (int i = 0; i <= text.length() - pattern.length(); i++) {
      find = true;
      for (int j = 0; j < pattern.length(); j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          find = false;
          break;
        }
      }
      if (find) {
        break;
      }
    }
    return find;
  }
}
