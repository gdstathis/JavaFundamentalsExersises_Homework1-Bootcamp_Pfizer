import java.net.PasswordAuthentication;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReverseString("absk");

    }

    /*Exercises on simple algorithms*/
    //------------------------------------------------------------------------------

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
        //When the result of CalculateFactorialNumber is negative number means that calculation is wrong
        while (result >= 0) {
            result = CalculateFactorialNumber(n);
            n++;
        }
        return n - 2; //Becasuse I want the previous of n, and when calculate wrong factorial execute n++, so I want to return n-2
    }

    /*3.Write a program that returns true or false depending on if the number is prime or not. */
    public static boolean CheckPrime(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    /*4.Write a program that, for a given n, it calculates the following value: 1 + ½ + ⅓+ ... + 1/n */
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



    /*Exercises on arrays, collections*/
    /*------------------------------------------------------------*/

    /*1.Given a list of integers, return a sub list that contains only the prime numbers */
    public static List<Integer> CreatePrimeNumList(ArrayList<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i : list) {
            if (i % 2 == 0)
                newList.add(i);
        }
        PrintList(newList);
        return newList;
    }

    public static void PrintList(List<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }


    /*2.Implement a way of finding a list eliminating the duplicates from a list.*/
    public static Set<Integer> EliminateDublicatesFromList(ArrayList<Integer> list) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : list) {
            set.add(i);
        }
        for (int i : set) {
            System.out.println(i);
        }
        return set;
    }


    /*3.Write a program that returns the digits of number in descending order.*/
    public static void Exersise3(int num) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
            i++;
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.toString());
    }

    /*4.Implement your own version of a stack and its main  functionalities (pop, push, peek) */
    public static void myStack() {

    }

    public class MyStack {
        private final int sizeStack;
        private int[] mystackArray;
        private int top;

        public MyStack(int size) {
            sizeStack = size;
            mystackArray = new int[size];
            top = -1;
        }

        public void push(int i) {
            mystackArray[++top] = i;
        }

        public int peek() {
            return mystackArray[top];
        }

        public int pop() {
            if (top != -1) {
                top--;
                return 0;
            }
            return mystackArray[top];
        }
    }

    /*5.Reverse a string using only a stack .*/
    public static String ReverseString(String word) {
        Stack<Character> s=new Stack();
        //Create a Stack, push into stack all characters of word, and then pop them and create reversed word
        for (char c: word.toCharArray()){
            s.push(c);
        }
        String newWord=new String();
        int size=s.size();
        for (int i=0;i<size;i++){
            newWord+=s.pop().toString();
        }
    return newWord;
    }

    /*6.Write a program that check if a word is symmetric,  ignoring cases (i.e. AbdBa is symmetric). */
    public static boolean CheckSymmetricWord(String word) {
        char[] temp = word.toUpperCase().toCharArray();
        for (int i = 0, j = temp.length - 1; i <= temp.length / 2 || j > temp.length / 2; i++, j--) {
            if (temp[i] != (temp[j])) {
                return false;
            }
        }
        return true;
    }


    /*String class exercise */
    //------------------------------------------------------------------------------

    //Validate a given password
    public static void StringClassExersise(String pass) {
        Boolean[] boolaray = new Boolean[6];
        boolaray[0] = pass.matches(".*[a-z].*");
        boolaray[1] = pass.matches((".*[A-Z].*"));
        boolaray[2] = pass.matches(".*[0-9].*");
        boolaray[3] = pass.matches(".*[@#$%^&+=].*");
        boolaray[4] = pass.matches(".{8,}");
        boolaray[5] = pass.matches(".*[(?i)(?:([a-z0-9])\\\\1{2,})*].*");
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
