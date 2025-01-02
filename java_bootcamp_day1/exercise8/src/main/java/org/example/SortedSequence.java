package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortedSequence {

  public static void readingInt(Scanner input) {
    int number = -1;
    int index = 0;
    while (input.hasNextInt()) {
      if (index == 0) {
        number = input.nextInt();
        index++;
      } else {
        int temp = input.nextInt();
        if (number < temp) {
          number = temp;
          index++;
        } else {
          System.out.println(
              "The sequence is not ordered from the ordinal number of the number " + index);
          index = -1;
          break;
        }
      }
    }
    if (index == 0) {
      System.out.println("Input error");
    } else if (index != -1) {
      System.out.println("The sequence is ordered in ascending order");
    }
  }
}
