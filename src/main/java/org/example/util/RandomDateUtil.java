package org.example.util;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateUtil {
    public static LocalDate generate() {
        Integer rangeDay = ThreadLocalRandom
                .current()
                .nextInt(365);

        return LocalDate.ofEpochDay(rangeDay);
    }
}
