package org.example;

import java.util.InputMismatchException;

public class Main {

  public static void main(String[] args) {
    try {
      double x1 = triangle.readCordinate();
      double x2 = triangle.readCordinate();
      double y1 = triangle.readCordinate();
      double y2 = triangle.readCordinate();
      double z1 = triangle.readCordinate();
      double z2 = triangle.readCordinate();
      try {
        triangle.checkCorrectCordinate(x1, x2, y1, y2, z1, z2);
        triangle.printRoundAnswer(triangle.resolvePerimetr(x1, x2, y1, y2, z1, z2));
      } catch (ArithmeticException e) {
        System.out.println("It isn't triangle");
      }
    } catch (InputMismatchException e) {
      System.out.println("Couldn't parse a number. Please, try again");
    }
  }
}