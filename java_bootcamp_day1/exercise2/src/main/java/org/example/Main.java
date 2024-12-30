package org.example;


public class Main {

  public static void main(String[] args) {
    int allSeconds = clock.readSeconds();
    if (allSeconds < 0) {
      System.out.println("Incorrect time");
    } else {
      clock.solveAnswer(allSeconds);
    }
  }
}