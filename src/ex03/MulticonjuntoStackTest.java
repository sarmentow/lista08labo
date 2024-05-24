package ex03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class MulticonjuntoStackTest {

	@Test
	void testAdd() {
		MulticonjuntoStack<Integer> multiconjunto = new MulticonjuntoStack<>();
		multiconjunto.add(1);
		multiconjunto.add(2);
		multiconjunto.add(2); // duplicate element
		assertEquals(3, multiconjunto.convertToArrayList().size());
		assertTrue(multiconjunto.convertToArrayList().contains(1));
		assertTrue(multiconjunto.convertToArrayList().contains(2));
	}

	@Test
	void testEquals() {
		MulticonjuntoStack<Integer> multiconjunto1 = new MulticonjuntoStack<>();
		multiconjunto1.add(1);
		multiconjunto1.add(2);

		MulticonjuntoStack<Integer> multiconjunto2 = new MulticonjuntoStack<>();
		multiconjunto2.add(1);
		multiconjunto2.add(2);

		assertTrue(multiconjunto1.equals(multiconjunto2));

		MulticonjuntoStack<Integer> multiconjunto3 = new MulticonjuntoStack<>();
		multiconjunto3.add(1);
		multiconjunto3.add(3); // different element

		assertFalse(multiconjunto1.equals(multiconjunto3));
	}

	@Test
	void testAddAll() {
		MulticonjuntoStack<Integer> multiconjunto1 = new MulticonjuntoStack<>();
		multiconjunto1.add(1);
		multiconjunto1.add(2);

		MulticonjuntoStack<Integer> multiconjunto2 = new MulticonjuntoStack<>();
		multiconjunto2.add(3);
		multiconjunto2.add(4);

		multiconjunto1.addAll(multiconjunto2);

		assertEquals(4, multiconjunto1.convertToArrayList().size());
		assertTrue(multiconjunto1.convertToArrayList().contains(1));
		assertTrue(multiconjunto1.convertToArrayList().contains(2));
		assertTrue(multiconjunto1.convertToArrayList().contains(3));
		assertTrue(multiconjunto1.convertToArrayList().contains(4));
	}

	@Test
	void testConvertToArrayList() {
		MulticonjuntoStack<Integer> multiconjunto = new MulticonjuntoStack<>();
		multiconjunto.add(1);
		multiconjunto.add(2);
		multiconjunto.add(2); // duplicate element

		ArrayList<Integer> arrayList = multiconjunto.convertToArrayList();
		assertEquals(3, arrayList.size());
		assertTrue(arrayList.contains(1));
		assertTrue(arrayList.contains(2));
	}
}
