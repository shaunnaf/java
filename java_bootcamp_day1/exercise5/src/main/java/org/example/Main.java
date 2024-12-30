package org.example;

public class Main {

  public static void main(String[] args) {
    int sizeArray = FindSimillar.readingSize();
    if (sizeArray > 0) {
      int[] array;
      array = FindSimillar.fillArray(sizeArray);
      int[] answerArray;
      answerArray = FindSimillar.processingArray(array);
      FindSimillar.printAnswer(answerArray);
    }
  }
}