package org.example;

import org.example.service.BirthdayParadoxService;
import org.example.service.BirthdayParadoxServiceImpl;

public class Application {
    public static void main(String[] args) {
        BirthdayParadoxService birthdayParadoxService = new BirthdayParadoxServiceImpl();

        BirthdayParadox birthdayParadox = new BirthdayParadox(birthdayParadoxService);
        birthdayParadox.run();
    }
}
