package JavafundamentalsExercises.Homework_1;

import java.util.Scanner;

public class ExerciseOnString {

    /*String class exercise */
    //------------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a password");
        String password = sc.next();
        StringClassExersise(password);

    }

    //Validate a given password
    public static void StringClassExersise(String password) {
        Boolean[] boolaray = new Boolean[6];
        boolaray[0] = CheckForLowerCase(password);
        boolaray[1] = CheckForUpperCase(password);
        boolaray[2] = CheckForNumber(password);
        boolaray[3] = CheckForSpecialCharacter(password);
        boolaray[4] = CheckForlength(password);
        boolaray[5] = CheckForSequenceCharacter(password);
        int cnt = 0;
        for (int i = 0; i < boolaray.length; i++) {
            if (boolaray[i]) {
                cnt++;
            }
        }
        if ((boolaray[4] && boolaray[5])) {
            System.out.println("Strong password");
            return;
        }
        if ((boolaray[2] && boolaray[5]) || (boolaray[3] && boolaray[5])) {
            System.out.println("Password OK");

        }
        if (cnt < 3 || !boolaray[4]) {
            System.out.println("Invalid password");
            PrintPassCriteria();
        }
    }

    public static boolean CheckForLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean CheckForUpperCase(String password) {
        return password.matches((".*[A-Z].*"));
    }

    public static boolean CheckForNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean CheckForSpecialCharacter(String password) {
        return password.matches(".*[@#$%^&+=].*");
    }

    public static boolean CheckForlength(String password) {
        return password.matches(".{8,}");
    }

    public static boolean CheckForSequenceCharacter(String password) {
        return password.matches(".*[(?i)(?:([a-z0-9])\\\\1{2,})*].*");
    }

    public static void PrintPassCriteria() {
        System.out.println("A password must met with following criteria");
        System.out.print("1. Password contains at least one uppercase character \n" +
                "2. Password contains at least one lowercase character \n" +
                "3. Contains at least one number \n" +
                "4. Contains at least one special character (e.g., !, _ etc) \n" +
                "5. Password length must be at least 8 characters long \n" +
                "6. Cannot contain a sequence of 3 same characters (i.e. aaa) or a sequence of 3 consecutive characters (i.e abc)\n");
    }
}
