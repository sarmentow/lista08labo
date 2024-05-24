package ex04;

import org.junit.jupiter.api.Test;

import ex03.MulticonjuntoArrayList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

public class MulticonjuntoAdapterConjuntoTest {

    @Test
    void testConvertToArrayList() {
        MulticonjuntoAdapterConjunto<Integer> adapter = new MulticonjuntoAdapterConjunto<>(new MulticonjuntoArrayList<>());
        adapter.add(1);
        adapter.add(2);
        adapter.add(2); // duplicate
        adapter.add(3);

        ArrayList<Integer> list = adapter.convertToArrayList();
        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }

    @Test
    void testIterator() {
        MulticonjuntoAdapterConjunto<Integer> adapter = new MulticonjuntoAdapterConjunto<>(new MulticonjuntoArrayList<>());
        adapter.add(1);
        adapter.add(2);
        adapter.add(2); // duplicate
        adapter.add(3);

        Iterator<Integer> iterator = adapter.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next().intValue());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testAdd() {
        MulticonjuntoAdapterConjunto<Integer> adapter = new MulticonjuntoAdapterConjunto<>(new MulticonjuntoArrayList<>());
        adapter.add(1);
        adapter.add(2);
        adapter.add(2); // duplicate
        adapter.add(3);

        assertEquals(3, adapter.convertToArrayList().size());
    }

    @Test
    void testAddAll() {
        MulticonjuntoAdapterConjunto<Integer> adapter = new MulticonjuntoAdapterConjunto<>(new MulticonjuntoArrayList<>());
        MulticonjuntoArrayList<Integer> collection = new MulticonjuntoArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(2); // duplicate
        collection.add(3);

        adapter.addAll(collection);

        assertEquals(3, adapter.convertToArrayList().size());
    }
}