package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;
	private DoubleLinkedList<Integer> listaVazia;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
		listaVazia = new DoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	// Meus testes

	@Test
	public void testRemoveUnicoELemento01() {
		lista3.removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testRemoveUnicoELemento02() {
		lista3.removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testRemoveLastVazia() {
		listaVazia.removeLast();
		assertArrayEquals(new Integer[] {}, listaVazia.toArray());
	}

	@Test
	public void testInsertLastVazia() {
		listaVazia.insertFirst(4);
		assertArrayEquals(new Integer[] {4}, listaVazia.toArray());
	}
}