package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FindMaxMin {

  private static int validInputInt(Scanner input) {
    boolean validInput = false;
    int number = -1;
    while (!validInput) {
      try {
        number = input.nextInt();
        validInput = true;
      } catch (InputMismatchException e) {
        input.next();
      }
    }
    return number;
  }

  public static String readingFileName() {
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public static int readingFromFileCount(Scanner input) {
    int number = validInputInt(input);
    if (number <= 0) {
      System.out.println("Input error. Size <= 0");
    }
    return number;
  }

  public static boolean readingFromFileNumbers(Scanner input, double[] array, int countNumbers) {
    int index = 0;
    boolean error = false;
    while (index != countNumbers && input.hasNext()) {
      if (input.hasNextDouble()) {
        array[index] = input.nextDouble();
        index += 1;
      } else {
        input.next();
      }
    }
    if (index != countNumbers) {
      System.out.println("Input error. Insufficient number of elements");
      error = true;
    }
    return error;
  }

  private static double findMax(double[] array) {
    double max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }

  private static double findMin(double[] array) {
    double min = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }

  public static void saveResultInFile(double[] array) {
    try (FileWriter writer = new FileWriter("result.txt")) {
      writer.write(Double.toString(findMin(array)) + " " + Double.toString(findMax(array)));
    } catch (IOException e) {
      System.out.println("Error writing");
    }
  }

  public static void output(int count, double[] array) {
    System.out.println(count);
    for (int i = 0; i < count; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    System.out.println("Saving min and max values in file");
  }


}
