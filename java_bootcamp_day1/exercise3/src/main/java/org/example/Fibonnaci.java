package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Fibonnaci {

  public static long readingNumber() {
    Scanner input = new Scanner(System.in);
    boolean validAnswer = false;
    long number = 0;
    while (!validAnswer) {
      try {
        number = input.nextLong();
        validAnswer = true;
      } catch (InputMismatchException e) {
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
    return number;
  }

  public static long findFibonnaci(long number) {
    if (number <= 2) {
      return 1;
    } else {
      long fib1 = findFibonnaci(number - 1);
      long fib2 = findFibonnaci(number - 2);
      try {
        return Math.addExact(fib1, fib2);
      } catch (ArithmeticException e) {
        System.out.println("Too large n");
        return -1;
      }
    }
  }

  public static void printFibonnaci(long answer) {
    System.out.println(answer);
  }
}
