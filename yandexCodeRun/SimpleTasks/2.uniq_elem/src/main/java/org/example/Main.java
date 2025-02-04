package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int countNumbers = scanner.nextInt();
    int[] numbers = new int[countNumbers];

    for (int i = 0; i < countNumbers; i++) {
      numbers[i] = scanner.nextInt();
    }

    Arrays.sort(numbers);
    int countNonRepeatingNumbers = 0;

    for (int i = 0; i < countNumbers; i++) {
      if ((i == 0 || numbers[i] != numbers[i - 1]) && (i == countNumbers - 1
          || numbers[i] != numbers[i + 1])) {
        countNonRepeatingNumbers++;
      }
    }

    System.out.println(countNonRepeatingNumbers);
  }
}
