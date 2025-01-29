package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int countPet = readCountPet(input);
    List <Animal> animals = new ArrayList<>();
    for (int i = 0;i<countPet;i++){
      processingData(input,animals);
    }
    for(Animal x:animals){
      System.out.println(x);
    }
  }

  public static int readCountPet(Scanner input){
    boolean validInput = false;
    int count = -1;
    while(!validInput){
      try{
        count = input.nextInt();
        validInput = true;
      }catch(InputMismatchException e){
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
    input.nextLine();
    return count;
  }

  public static void processingData(Scanner input, List<Animal> animals){
    String pet = input.nextLine().toLowerCase();
    if(!Objects.equals(pet, "dog") && !Objects.equals(pet,"cat")){
      System.out.println("Incorrect input. Unsupported pet type");
    }else{
      String name = input.nextLine();
      int age = input.nextInt();
      if(age<=0){
        System.out.println("Incorrect input. Age <= 0");
        input.nextLine();
      }else{
        double mass = input.nextDouble();
        input.nextLine();
        if(mass<= 0){
          System.out.println("Incorrect input. Mass <= 0");
        }else{
          if(Objects.equals(pet,"dog")){
            animals.add(new Dog(name,age,mass));
          }else{
            animals.add(new Cat(name,age,mass));
          }
        }
      }
    }
  }
}