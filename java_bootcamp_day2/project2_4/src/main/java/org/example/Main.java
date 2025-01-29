package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int countPet = validInt(input);
    input.nextLine();

    List <Animal> animals = IntStream.range(0,countPet)
        .mapToObj(i -> readAnimals(input))
        .filter(Objects::nonNull)
        .toList();

    animals = animals.stream()
        .map(Animal::incrementAge)
        .toList();
    animals.forEach(System.out::println);
  }

  public static Animal readAnimals(Scanner input){

    String typePet = input.nextLine().toLowerCase();

    if(!typePet.equals("dog") && !typePet.equals("cat")){
      System.out.println("Incorrect input. Unsupported pet type");
      return null;
    }

    String name = input.nextLine();
    int age = validInt(input);

    if(age<=0){
      System.out.println("Incorrect input. Age <= 0");
      input.nextLine();
      return null;
    }

    input.nextLine();

    return typePet.equals("dog") ? new Dog(name,age) : new Cat(name,age);

  }

  public static int validInt(Scanner input){
    try{
      return input.nextInt();
    }catch (InputMismatchException e){
      System.out.println("Couldn't parse a number. Please, try again");
      input.nextLine();
      return validInt(input);
    }
  }
}