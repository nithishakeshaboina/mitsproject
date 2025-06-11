import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+<>?";

    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARS;

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

       
        for (int i = 4; i < length; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        return password.toString();
    }

   public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        if (length < 4) {
            System.out.println("Password length should be at least 4 characters.");
        } else {
            String password = generatePassword(length);
            System.out.println("Generated Password: " + password);
        }
        scanner.close();
    }
}
