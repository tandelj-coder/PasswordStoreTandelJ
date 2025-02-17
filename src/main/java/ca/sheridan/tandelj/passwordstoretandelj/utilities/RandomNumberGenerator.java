package ca.sheridan.tandelj.passwordstoretandelj.utilities;

import java.util.Random;
public class RandomNumberGenerator {
    public static long generateNineDigitNumber() {
        Random random = new Random();
        return 100000000L + random.nextInt(900000000);
    }
}

