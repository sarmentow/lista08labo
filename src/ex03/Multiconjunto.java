package ex03;

import java.util.ArrayList;

public interface Multiconjunto<T> {
	void add(T element);
	boolean equals (Multiconjunto<T> m);
	void addAll (Multiconjunto<T> m);
	ArrayList<T> convertToArrayList();
}
