package org.example;

public class Main {

  public static void main(String[] args) {
    int sizeArray = InsertSort.readingSize();
    if (sizeArray > 0) {
      double[] array;
      array = InsertSort.readArray(sizeArray);
      InsertSort.sortArray(array);
      InsertSort.printAnswer(array);
    }
  }
}