package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;


public class ArithmeticMean {

  public static int readingNumber() {
    Scanner input = new Scanner(System.in);
    int number = 0;
    boolean validNumber = false;
    while (!validNumber) {
      try {
        number = input.nextInt();
        if (number <= 0) {
          System.out.println("Input error. Size <= 0");
        }
        validNumber = true;
      } catch (InputMismatchException e) {
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
    return number;
  }

  public static int[] fillArray(int size) {
    Scanner input = new Scanner(System.in);
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      boolean validNumber = false;
      while (!validNumber) {
        try {
          array[i] = input.nextInt();
          validNumber = true;
        } catch (InputMismatchException e) {
          System.out.println("Couldn't parse a number. Please, try again");
          input.nextLine();
        }
      }
    }
    return array;
  }

  public static double decision(int[] array) {
    int sumNegative = 0;
    int count = 0;
    for (int num : array) {
      if (num < 0) {
        count++;
        sumNegative += num;
      }
    }
    if (count == 0) {
      return -1;
    }
    return (double) sumNegative / count;
  }

  public static void printAnswer(double answer) {
    if (answer == -1) {
      System.out.println("There are no negative elements");
    } else {
      System.out.println(answer);
    }
  }
}
