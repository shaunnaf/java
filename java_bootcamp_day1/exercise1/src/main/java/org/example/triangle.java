package org.example;

import java.util.Scanner;

public class triangle {

  public static double readCordinate() {
    Scanner input = new Scanner(System.in);
    return input.nextDouble();
  }

  public static double resolvePerimetr(double x1, double x2, double y1, double y2, double z1,
      double z2) {
    return Math.sqrt(Math.pow(y1 - x1, 2) + Math.pow(y2 - x2, 2)) + Math.sqrt(
        Math.pow(z1 - y1, 2) + Math.pow(z2 - y2, 2)) + Math.sqrt(
        Math.pow(x1 - z1, 2) + Math.pow(x2 - z2, 2));
  }

  public static void printRoundAnswer(double answer) {
    System.out.printf("%.3f", answer);
  }

  public static void checkCorrectCordinate(double x1, double x2, double y1, double y2, double z1,
      double z2) {
    if ((x1 == y1 && x2 == y2) || (y1 == z1 && y2 == z2) || (z1 == x1 && z2 == x2) || (x1 == y1
        && x1 == z1) || (x2 == y2 && x2 == z2)) {
      throw new ArithmeticException();
    }
  }
}
