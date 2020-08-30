package JavafundamentalsExercises.Homework_1;

import java.util.ArrayList;
import java.util.List;

/*4.Implement your own version of a stack and its main  functionalities (pop, push, peek) */
/*I used List, to create a dynamic stack*/
public class MyStack {

    private List<Integer> mystack;
    private int top;
    private int stackSize;

    public MyStack() {
        mystack = new ArrayList<>();
        stackSize = 0;
        top = -1;
    }

    public void push(int i) {

        mystack.add(i);
        ++top;
        stackSize++;
    }

    public int peek() {
        return mystack.get(top);
    }

    public boolean isEmpty() {
        if (mystack.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!isEmpty()) {
            mystack.remove(top);
            stackSize--;
            --top;
            return true;
        }
        return false;
    }

    public int getSizeStack() {
        return mystack.size();
    }
}