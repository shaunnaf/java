package org.example;

import java.time.Instant;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

public class Main {
  private static final List<Animal> animals = new ArrayList<>();

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int countPet = readValidInt(input);

    for (int i = 0; i < countPet; i++) {
      readAnimals(input);
    }

    ExecutorService executor = Executors.newFixedThreadPool(animals.size());
    List<CompletableFuture<Void>> futures = new ArrayList<>();
    Instant programStart = Instant.now();

    for (Animal pet : animals) {
      futures.add(CompletableFuture.runAsync(() -> startWalk(pet, programStart), executor));
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    executor.shutdown();
  }

  public static void startWalk(Animal animal, Instant programStart) {
    Instant startWalk = Instant.now();
    double walkTime = animal.goToWalk();

    double startSeconds = Duration.between(programStart, startWalk).toMillis() / 1000.0;

    try {
      TimeUnit.SECONDS.sleep((long) walkTime);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    Instant endWalk = Instant.now();
    double endSeconds = Duration.between(programStart, endWalk).toMillis() / 1000.0;

    System.out.printf("%s, start time = %.2f, end time = %.2f%n", animal, startSeconds, endSeconds);
  }

  public static int readValidInt(Scanner input) {
    while (true) {
      try {
        int count = input.nextInt();
        input.nextLine();
        return count;
      } catch (InputMismatchException e) {
        System.out.println("Couldn't parse a number. Please, try again");
        input.nextLine();
      }
    }
  }

  public static void readAnimals(Scanner input) {
    String typePet = input.nextLine().toLowerCase();

    if (!typePet.equals("dog") && !typePet.equals("cat")) {
      System.out.println("Incorrect input. Unsupported pet type");
      return;
    }

    String name = input.nextLine();
    int age = readValidInt(input);

    if (age <= 0) {
      System.out.println("Incorrect input. Age <= 0");
      return;
    }

    if (Objects.equals(typePet, "dog")) {
      animals.add(new Dog(name, age));
    } else {
      animals.add(new Cat(name, age));
    }
  }
}
