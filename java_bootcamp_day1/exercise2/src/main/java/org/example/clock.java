package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class clock {

  public static int readSeconds() {
    Scanner input = new Scanner(System.in);
    int seconds = 0;
    boolean validInput = false;
    while (!validInput) {
      try {
        seconds = input.nextInt();
        validInput = true;
      } catch (InputMismatchException e) {
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
    return seconds;
  }

  public static void solveAnswer(int allSeconds) {
    int hours = allSeconds / 3600;
    int minutes = (allSeconds - (3600 * hours)) / 60;
    int seconds = allSeconds % 60;
    outputAnswer(hours, minutes, seconds);
  }

  public static void outputAnswer(int hours, int minutes, int seconds) {
    System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
  }
}
