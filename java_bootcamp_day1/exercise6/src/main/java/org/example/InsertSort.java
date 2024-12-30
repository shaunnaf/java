package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertSort {

  public static int readingSize() {
    Scanner input = new Scanner(System.in);
    boolean validInput = false;
    int number = 0;
    while (!validInput) {
      try {
        number = input.nextInt();
        if (number <= 0) {
          System.out.println("Input error. Size <= 0");
        }
        validInput = true;
      } catch (InputMismatchException e) {
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
    return number;
  }

  public static double[] readArray(int sizeArray) {
    Scanner input = new Scanner(System.in);
    double[] array = new double[sizeArray];
    for (int i = 0; i < array.length; i++) {
      boolean validInput = false;
      while (!validInput) {
        try {
          array[i] = input.nextDouble();
          validInput = true;
        } catch (InputMismatchException e) {
          System.out.println("Couldn't parse a number. Please, try again");
          input.nextLine();
        }
      }
    }
    return array;
  }

  public static void sortArray(double[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      double temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }


  public static void printAnswer(double[] array) {
    for (double number : array) {
      System.out.print(number + " ");
    }
  }
}
