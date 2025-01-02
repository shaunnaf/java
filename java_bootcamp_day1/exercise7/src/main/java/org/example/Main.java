package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    String fileName = FindMaxMin.readingFileName();
    try (Scanner input = new Scanner(new File(fileName))) {
      int countNumbers = FindMaxMin.readingFromFileCount(input);
      if (countNumbers > 0) {
        double[] array = new double[countNumbers];
        if (!FindMaxMin.readingFromFileNumbers(input, array, countNumbers)) {
          File file = new File("result.txt");
          try {
            file.createNewFile();
            FindMaxMin.saveResultInFile(array);
            FindMaxMin.output(countNumbers, array);
          } catch (IOException e) {
            System.out.println("Ошибка создания файла result.txt");
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Input error. File isn't exist");
    }
  }
}