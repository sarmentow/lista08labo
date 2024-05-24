package ex03;

import java.util.ArrayList;
import java.util.HashMap;

public class MulticonjuntoArrayList<T> implements Multiconjunto<T> {
	private ArrayList<T> listDS;
	private HashMap<T, Boolean> present;
	
	public MulticonjuntoArrayList() {
		listDS = new ArrayList<T>();
		present = new HashMap<T, Boolean>();
	}
	
	
	public void add(T element) {
		listDS.add(element);
		present.put(element, true);
	}
	public boolean equals (Multiconjunto<T> m) {
		ArrayList<T> converted = m.convertToArrayList();
		HashMap<T, Boolean> seenConverted = new HashMap<T, Boolean>();
		for (T i : converted) {
			seenConverted.put(i, true);
		}
		
		return present.equals(seenConverted);
	}
	
	public void addAll (Multiconjunto<T> m) {
		ArrayList<T> converted = m.convertToArrayList();
		for (T i : converted) {
			add(i);
		}
	}
	@Override
	public ArrayList<T> convertToArrayList() {
		return listDS;
	}


}
