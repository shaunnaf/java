package org.example;

public class Main {

  public static void main(String[] args) {
    int sizeArray = ArithmeticMean.readingNumber();
    if (sizeArray > 0) {
      int[] array = ArithmeticMean.fillArray(sizeArray);
      double answer = ArithmeticMean.decision(array);
      ArithmeticMean.printAnswer(answer);
    }
  }
}