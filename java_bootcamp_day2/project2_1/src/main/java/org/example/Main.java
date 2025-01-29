package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    List<Animal> animals = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int countAnimals = readCountAnimals(input);
    for(int i = 0;i<countAnimals;i++){
      readData(input,animals);
    }
    for (Animal pet:animals){
      System.out.println(pet);
    }
  }

  private static void printList(List <Animal> animals){
      System.out.println(animals);
  }

  private static void readData(Scanner input,List <Animal> animals){
    String typeAnimal = input.nextLine().toLowerCase();
    if(!Objects.equals(typeAnimal,"dog") && !Objects.equals(typeAnimal,"cat")){
      System.out.println("Incorrect input. Unsupported pet type");
    }else{
      String name = input.nextLine();
      int age = input.nextInt();
      input.nextLine();
      if(age<=0){
        System.out.println("Incorrect input. Age <= 0");
      }else{
        if(Objects.equals(typeAnimal,"dog")){
          animals.add(new Dog(name,age));
        }else{
          animals.add(new Cat(name,age));
        }
      }
    }
  }

  private static int readCountAnimals(Scanner input){
    return validIntInput(input);
  }

  private static int validIntInput(Scanner input){
    boolean validInput = false;
    int answer = -1;
    while (!validInput){
      try{
        answer = input.nextInt();
        validInput = true;
      }catch (InputMismatchException e){
        System.out.println("Error input, try again");
        input.nextLine();
      }
    }
    input.nextLine();
    return answer;
  }
}