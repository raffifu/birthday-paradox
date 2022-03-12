package org.example.service;

import org.example.util.RandomDateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;

public class BirthdayParadoxServiceImpl implements BirthdayParadoxService {
    private final ArrayList<LocalDate> birthdays = new ArrayList<>();

    @Override
    public void generateRandomBirthdays(Integer numberOfPeople) {
        this.birthdays.clear();
        for (int i = 0; i < numberOfPeople; i++) {
            this.birthdays.add(RandomDateUtil.generate());
        }
    }

    @Override
    public void printBirthdays() {
        System.out.println("Generated Birthdays:");

        int pos = 0;
        for (LocalDate birthday : this.birthdays) {
            String month = Month.of(birthday.getMonthValue()).name().substring(0, 3);
            String dateText = String.format("%2d %s", birthday.getDayOfMonth(), month);

            if (pos != 0)
                System.out.print(", ");
            if (pos % 10 == 0)
                System.out.println();

            System.out.print(dateText);
            pos++;
        }
        System.out.println();

        LocalDate matchDate = this.getMatchBirthday();
        if (!Objects.isNull(matchDate))
            System.out.println("Found match birthday: " + matchDate.getDayOfMonth() + " " + matchDate.getMonth().name().substring(0, 3) + "\n");
        else
            System.out.println("No match birthday found\n");
    }

    @Override
    public LocalDate getMatchBirthday() {
        birthdays.sort(LocalDate::compareTo);

        for (int i = 0; i < birthdays.size() - 1; i++) {
            if (birthdays.get(i).equals(birthdays.get(i + 1)))
                return birthdays.get(i);
        }

        return null;
    }
}
