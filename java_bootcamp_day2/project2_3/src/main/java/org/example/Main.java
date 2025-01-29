package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int countPet = readValidInt(input);
    List<Animal> animals = new ArrayList<>();
    for (int i = 0;i<countPet;i++){
      processingData(input,animals);
    }
    List <Herbivore> herbivores = new ArrayList<>();
    List <Omnivore> omnivores = new ArrayList<>();
    for(Animal x:animals){
      if(x instanceof Herbivore){
        herbivores.add((Herbivore) x);
      }else{
        omnivores.add((Omnivore) x);
      }
    }
    for (Herbivore x:herbivores){
      System.out.println(x);
    }

    for(Omnivore x:omnivores){
      System.out.println(x);
    }
  }

  public static void processingData(Scanner input, List <Animal> animals){
    String petType = input.nextLine().trim().toLowerCase();
    if(!List.of("cat","dog","guinea","hamster").contains(petType)){
      System.out.println("Incorrect input. Unsupported pet type");
      return;
    }
    String name = input.nextLine().trim();
    int age = readValidInt(input);
    if(age<=0){
      System.out.println("Incorrect input. Age <= 0");
      return;
    }
    switch (petType){
      case "dog" -> animals.add(new Dog(name,age));
      case "cat" -> animals.add(new Cat(name,age));
      case "guinea" -> animals.add(new GuineaPig(name,age));
      case "hamster" -> animals.add(new Hamster(name,age));
    }
  }


  public static int readValidInt(Scanner input){
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
}
