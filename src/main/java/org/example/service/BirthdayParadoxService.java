package org.example.service;

import java.time.LocalDate;

public interface BirthdayParadoxService {
    void generateRandomBirthdays(Integer numberOfPeople);
    void printBirthdays();
    LocalDate getMatchBirthday();
}
