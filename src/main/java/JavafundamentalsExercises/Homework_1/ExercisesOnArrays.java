package JavafundamentalsExercises.Homework_1;

import java.util.*;
import java.util.stream.Collectors;

public class ExercisesOnArrays {
    /*Exercises on arrays, collections*/
    /*------------------------------------------------------------*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(57);
        list.add(54);
        list.add(7);
        list.add(7);
        list.add(5);
        System.out.println("The list that was created with prime numbers is");
        CreatePrimeNumList(list);
        System.out.println("The list without dublicates is:");
        EliminateDublicatesFromList(list);
        PrintList(EliminateDublicatesFromList(list).stream().collect(Collectors.toList()));
        System.out.println("Give a number to reverse the digits of it");
        Exersise3(sc.nextInt());
        System.out.println("Give a word to reverse it");
        System.out.println(ReverseString(sc.next()));
        System.out.println("Give a word to check if it is symmetric word");
        System.out.println(CheckSymmetricWord(sc.next()));
        System.out.println("I will create a stack, I will check if stack is empty and then I push a number");
        MyStack myStack=new MyStack();
        System.out.println("Is stack empty?: "+myStack.isEmpty());
        myStack.push(3);
        System.out.println("Push another number. Is stack empty? :"+myStack.isEmpty());
        myStack.pop();
        System.out.println("Pop the stack. Is stack empty? : "+myStack.isEmpty());
        myStack.push(4);
        myStack.push(54);
        System.out.println("Push 2 numbers and then peek the latest "+myStack.peek());
    }


    /*1.Given a list of integers, return a sub list that contains only the prime numbers */
    public static List<Integer> CreatePrimeNumList(ArrayList<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i : list) {
            if (ExercisesOnSimpleAlgorithms.CheckPrime(i))
                newList.add(i);
        }
        PrintList(newList);
        return newList;
    }

    public static void PrintList(List<Integer> list) {
        System.out.println("The following list has:");
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


    /*5.Reverse a string using only a stack .*/
    public static String ReverseString(String word) {
        Stack<Character> s = new Stack();
        //Create a Stack, push into stack all characters of word, and then pop them and create reversed word
        for (char c : word.toCharArray()) {
            s.push(c);
        }
        String newWord = new String();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            newWord += s.pop().toString();
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
}
