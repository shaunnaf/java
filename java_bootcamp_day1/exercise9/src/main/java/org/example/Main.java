package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int countString = OurIndexOf.readingCountStrings(input);
    if (countString > 0) {
      List<String> stringList = new ArrayList<>();
      input.nextLine();
      OurIndexOf.readingStrings(input, stringList, countString);
      String pattern = input.nextLine();
      boolean flag = false;
      for (int i = 0; i < countString; i++) {
        if (OurIndexOf.indexOf(stringList.get(i), pattern)) {
          if (flag) {
            System.out.print(", " + stringList.get(i));
          } else {
            System.out.print(stringList.get(i));
            flag = true;
          }
        }
      }
    }
  }
}