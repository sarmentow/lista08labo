package ex03;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MulticonjuntoStack<T> implements Multiconjunto<T> {
    private Stack<T> stack;
    private HashMap<T, Boolean> present;

    public MulticonjuntoStack() {
        stack = new Stack<T>();
        present = new HashMap<T, Boolean>();
    }

    public void add(T element) {
        stack.push(element);
        present.put(element, true);
    }

    public boolean equals(Multiconjunto<T> m) {
        ArrayList<T> converted = m.convertToArrayList();
        HashMap<T, Boolean> seenConverted = new HashMap<T, Boolean>();
        for (T i : converted) {
            seenConverted.put(i, true);
        }
        return present.equals(seenConverted);
    }

    public void addAll(Multiconjunto<T> m) {
        ArrayList<T> converted = m.convertToArrayList();
        for (T i : converted) {
            add(i);
        }
    }

    public ArrayList<T> convertToArrayList() {
        ArrayList<T> list = new ArrayList<T>(stack);
        return list;
    }
}