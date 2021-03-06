package JavafundamentalsExercises.Homework_1;

import java.util.Scanner;

public class ExercisesOnSimpleAlgorithms {
    /*Exercises on simple algorithms*/
    //------------------------------------------------------------------------------

    /*I create some examples to present the exersises*/
    public static void main(String[] args) {
        System.out.println("The factorial number of 5 is: " + CalculateFactorialNumber(5));
        System.out.println("\nThe maximum value of an Integer that can be calculated is " + findMaxValue());
        System.out.println("The number 5 is prime" + CheckPrime(5));
        System.out.println("The number 5 is prime" + CheckPrime(10));
        System.out.println("Result of the following value: 1 + ½ + ⅓+ ... + 1/n " + Exersise1_4(2));
        System.out.println("150 has " + DigitCalculator(150) + "digits");
        System.out.println("Give a double number to return decimal part");
        System.out.println("The digits of 3.56 is: " + GetDecimalPart(3.56));
    }


    /*1.Write a program that calculates the factorial of a number n (n!). */
    public static long CalculateFactorialNumber(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /*2. Find the maximum value of n as int so that the calculated output is valid.*/
    public static int findMaxValue() {
        int n = 1;
        long result = 0;
        //When the result of CalculateFactorialNumber is a negative number means that calculation is wrong
        while (result >= 0) {
            result = CalculateFactorialNumber(n);
            n++;
        }
        return n - 2; //Becasuse I want the previous of n, and when calculate wrong factorial execute n++, so I want to return n-2
    }

    /*3.Write a program that returns true or false depending on if the number is prime or not. */
    public static boolean CheckPrime(int n) {
        if (n < 2) {
            System.out.println("Invalid argument");
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*4.Write a program that, for a given number n, it calculates the following value: 1 + ½ + ⅓+ ... + 1/n */
    public static double Exersise1_4(int n) {
        double result = 0.0;
        for (double i = 1; i <= n; i++) {
            result += 1 / i;
        }
        return result;
    }

    /*5. Write a program that counts the digits of a long number. */
    public static int DigitCalculator(long n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    /*6.Given a positive float number, print its decimal part. For example, given the number 2.31, the output should be 0.31*/
    public static float GetDecimalPart(double number) {
        double decim = number - (int) number;
        return (float) decim;
    }

}
