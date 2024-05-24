package ex03;

import java.util.HashSet;
import java.util.ArrayList;

public class MulticonjuntoSet<T> implements Multiconjunto<T> {
    private HashSet<T> set;

    public MulticonjuntoSet() {
        set = new HashSet<T>();
    }

    public void add(T element) {
        set.add(element);
    }

    public boolean equals(Multiconjunto<T> m) {
        HashSet<T> converted = new HashSet<T>(m.convertToArrayList());
        return set.equals(converted);
    }


    public void addAll(Multiconjunto<T> m) {
        set.addAll(m.convertToArrayList());
    }

    @Override
    public ArrayList<T> convertToArrayList() {
        return new ArrayList<T>(set);
    }
}
