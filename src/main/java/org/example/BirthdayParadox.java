package org.example;

import org.example.service.BirthdayParadoxService;

import java.util.Objects;
import java.util.Scanner;

public class BirthdayParadox {
    private final BirthdayParadoxService birthdayParadoxService;

    private final Scanner scanner;
    private Integer numberOfPeople;

    public BirthdayParadox(BirthdayParadoxService birthdayParadoxService) {
        this.birthdayParadoxService = birthdayParadoxService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        this.greeting();

        this.numberOfPeople = this.inputNumberOfPeople();

        birthdayParadoxService.generateRandomBirthdays(this.numberOfPeople);
        birthdayParadoxService.printBirthdays();

        Integer totalSimulation = 10_000;
        this.simulate(totalSimulation);

        this.exit();
    }

    public void greeting() {
        System.out.println("Birthday Paradox is a probability two people  \nhaving the same birthday.\n");
    }

    private Integer inputNumberOfPeople() {
        while (true) {
            System.out.println("How many people are in the group? (max: 100)");
            System.out.print(">> ");

            int response = this.scanner.nextInt();

            if (response > 0 && response <= 100) {
                return response;
            }
        }
    }

    public void simulate(Integer totalSimulation) {
        System.out.println("Simulating " + totalSimulation + " times...");

        int totalMatch = 0;
        for (int i = 1; i <= totalSimulation; i++) {
            birthdayParadoxService.generateRandomBirthdays(this.numberOfPeople);

            if (!Objects.isNull(birthdayParadoxService.getMatchBirthday()))
                totalMatch++;

            if (i % 10_000 == 0)
                System.out.println("Calculating... " + i);
        }

        this.result(totalMatch, totalSimulation);
    }

    public void result(Integer totalMatch, Integer totalSimulation) {
        Float probability = (float) totalMatch / totalSimulation * 100;

        System.out.println("Total match: " + totalMatch + ", probability: " + probability + "%");
    }

    public void exit() {
        this.scanner.close();
        System.exit(0);
    }
}
