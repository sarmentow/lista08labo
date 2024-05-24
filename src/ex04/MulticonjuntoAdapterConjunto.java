package ex04;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashSet;

import ex03.Multiconjunto;
import ex03.MulticonjuntoSet;

/*
 * Basicamente esse adaptador funciona duplicando a lógica de um multiconjunto padrão
 * para também ter um multiconjunto que usa um HashSet. Assim conseguimos garantir as
 * propriedades de um Conjunto mas sem perder a informação da estrutura de dados subjacente.
 */
public class MulticonjuntoAdapterConjunto<T> {
    private Multiconjunto<T> multiconjunto;
    private MulticonjuntoSet<T> multiconjuntoSet;

    public MulticonjuntoAdapterConjunto(Multiconjunto<T> multiconjunto) {
        this.multiconjunto = multiconjunto;
        this.multiconjuntoSet = new MulticonjuntoSet<T>();
        this.multiconjuntoSet.addAll(multiconjunto);
    }

    public ArrayList<T> convertToArrayList() {
    	return  multiconjuntoSet.convertToArrayList();
    }
    
    public Iterator<T> iterator() {
        return new MulticonjuntoIterator(multiconjuntoSet);
    }

    public boolean add(T t) {
        multiconjunto.add(t);
        multiconjuntoSet.add(t);
        return true;
    }

    public boolean addAll(Multiconjunto<T> c) {
        for (T t : c.convertToArrayList()) {
            multiconjunto.add(t);
            multiconjuntoSet.add(t);
        }
        return true;
    }

    private class MulticonjuntoIterator implements Iterator<T> {
        private Iterator<T> iterator;

        public MulticonjuntoIterator(Multiconjunto<T> multiconjunto) {
            this.iterator = new HashSet<T>(multiconjuntoSet.convertToArrayList()).iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public T next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}