package util;

import java.util.Random;

public class NumberGenerator {

    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static final String ACCOUNT_NUMBER_PREFIX = "ACCT-";
    private static final String ACCOUNT_NUMBER_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random random = new Random();

    public static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(ACCOUNT_NUMBER_PREFIX);
        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH - ACCOUNT_NUMBER_PREFIX.length(); i++) {
            int randomIndex = random.nextInt(ACCOUNT_NUMBER_CHARS.length());
            char randomChar = ACCOUNT_NUMBER_CHARS.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}