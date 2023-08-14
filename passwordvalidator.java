import java.util.Scanner;

public class Basic {

    public static boolean isvalidpassword(String password) {
        int minLength = 8;
        int minUppercase = 1;
        int minLowercase = 1;
        int minDidits = 1;
        int minSpecialChar = 1;

        // Your Password Must In Length 8
        if (password.length() < minLength) {
            return false;
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for at least one special character
        if (!password.matches(".*[!@#$%].*")) {
            return false;
        }

        // check for commonwords
        String[] commonWords = { "12345678", "abcdefgh", "ABCDEFGH", "!@#$%^&*" };
        for (String commonWord : commonWords) {
            if (password.contains(commonWord)) {
                return false;
            }
        }

        // check for repeating characters
        if (password.matches(".*(.)\\1{2,}.*")) {
            return false;
        }

        // Check for sequential patterns
        if (password.matches(".*(abc|123|xyz|987).*")) {
            return false;
        }

        // check for user information
        String userName = "abcd1234";
        if (password.contains(userName)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean isvalid = true;
            System.out.println();

            while (isvalid) {

                System.out.println(
                        "Your password must use at least - 1 uppercase, 1 lowercase, 1 digit, 1 special char,");
                System.out.println();

                System.out.println("Enter Your Password: ");
                String password = sc.nextLine();
                if (isvalidpassword(password)) {
                    System.out.println("Password is valid");
                    isvalid = false;
                } else {
                    System.out.println("Invalid Password");
                }
            }
            System.out.println("Program Ended!!");
            sc.close();
        }
    }
}
