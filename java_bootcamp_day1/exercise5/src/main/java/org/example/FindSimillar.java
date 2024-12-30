package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FindSimillar {

  public static int readingSize() {
    int number = 0;
    boolean validInput = false;
    Scanner input = new Scanner(System.in);
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

  public static int[] fillArray(int size) {
    Scanner input = new Scanner(System.in);
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      boolean validInput = false;
      while (!validInput) {
        try {
          array[i] = input.nextInt();
          validInput = true;
        } catch (InputMismatchException e) {
          System.out.println("Couldn't parse a number. Please, try again");
          input.nextLine();
        }
      }
    }
    return array;
  }

  public static int[] processingArray(int[] array) {
    int[] answerArray = new int[array.length];
    int count = 0;
    for (int number : array) {
      if (findNumber(number)) {
        answerArray[count] = number;
        count++;
      }
    }
    for (int i = count; i < array.length; i++) {
      answerArray[i] = -10;
    }
    return answerArray;
  }

  private static boolean findNumber(int number) {
    int count = countDigits(number);
    int last = number % 10;
    int first = (int) (number / Math.pow(10, count - 1));
    return last == first;
  }

  private static int countDigits(int number) {
    int count = 0;
    while (number != 0) {
      number /= 10;
      count++;
    }
    return count;
  }

  public static void printAnswer(int[] answerArray) {
    if (answerArray[0] == -10) {
      System.out.print("There are no such elements");
    } else {
      for (int number : answerArray) {
        if (number != -10) {
          System.out.print(number + " ");
        }
      }
    }
  }
}
