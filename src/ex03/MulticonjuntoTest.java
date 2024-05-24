package ex03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
 * As diferentes classes que implementam a interface Multiconjunto se comunicam
 * utilizando uma representação intermediária para a qual todas as classes podem
 * ser convertidas. A "representação intermediária" escolhida foi um ArrayList já
 * que ela é a estrutura de dados mais flexível de todas.
 * 
 */
public class MulticonjuntoTest {

    @Test
    void testAddAllArrayListToLinkedList() {
        MulticonjuntoArrayList<Integer> arrayMulticonjunto = new MulticonjuntoArrayList<>();
        arrayMulticonjunto.add(1);
        arrayMulticonjunto.add(2);
        arrayMulticonjunto.add(3);

        MulticonjuntoLinkedList<Integer> linkedListMulticonjunto = new MulticonjuntoLinkedList<>();
        linkedListMulticonjunto.addAll(arrayMulticonjunto);

        assertEquals(3, linkedListMulticonjunto.convertToArrayList().size());
        assertTrue(linkedListMulticonjunto.convertToArrayList().contains(1));
        assertTrue(linkedListMulticonjunto.convertToArrayList().contains(2));
        assertTrue(linkedListMulticonjunto.convertToArrayList().contains(3));
    }

    @Test
    void testEqualsSetAndArrayList() {
        MulticonjuntoSet<Integer> setMulticonjunto = new MulticonjuntoSet<>();
        setMulticonjunto.add(1);
        setMulticonjunto.add(2);
        setMulticonjunto.add(3);

        MulticonjuntoArrayList<Integer> arrayMulticonjunto = new MulticonjuntoArrayList<>();
        arrayMulticonjunto.add(1);
        arrayMulticonjunto.add(2);
        arrayMulticonjunto.add(3);

        assertTrue(setMulticonjunto.equals(arrayMulticonjunto));
    }

    @Test
    void testAddAllStackToSet() {
        MulticonjuntoStack<Integer> stackMulticonjunto = new MulticonjuntoStack<>();
        stackMulticonjunto.add(1);
        stackMulticonjunto.add(2);
        stackMulticonjunto.add(3);

        MulticonjuntoSet<Integer> setMulticonjunto = new MulticonjuntoSet<>();
        setMulticonjunto.addAll(stackMulticonjunto);

        assertEquals(3, setMulticonjunto.convertToArrayList().size());
        assertTrue(setMulticonjunto.convertToArrayList().contains(1));
        assertTrue(setMulticonjunto.convertToArrayList().contains(2));
        assertTrue(setMulticonjunto.convertToArrayList().contains(3));
    }

    @Test
    void testEqualsLinkedListAndStack() {
        MulticonjuntoLinkedList<Integer> linkedListMulticonjunto = new MulticonjuntoLinkedList<>();
        linkedListMulticonjunto.add(1);
        linkedListMulticonjunto.add(2);
        linkedListMulticonjunto.add(3);

        MulticonjuntoStack<Integer> stackMulticonjunto = new MulticonjuntoStack<>();
        stackMulticonjunto.add(1);
        stackMulticonjunto.add(2);
        stackMulticonjunto.add(3);

        assertTrue(linkedListMulticonjunto.equals(stackMulticonjunto));
    }
}