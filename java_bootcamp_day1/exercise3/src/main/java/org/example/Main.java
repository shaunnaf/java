package org.example;

public class Main {

  public static void main(String[] args) {
    try {
      long number = Fibonnaci.readingNumber();
      long answer = Fibonnaci.findFibonnaci(number);
      Fibonnaci.printFibonnaci(answer);
    } catch (ArithmeticException e) {
      System.out.println("Too large n");
    }
  }
}// обработать ошибку с переполнением