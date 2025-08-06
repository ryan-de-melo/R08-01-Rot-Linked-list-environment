package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursiveDoubleLinkedListImplTest {
	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;
    protected LinkedList<Integer> lista3;
    protected LinkedList<Integer> listaVazia;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
        lista3 = new RecursiveDoubleLinkedListImpl<>();
        listaVazia = new RecursiveDoubleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}

    @Test
    public void testInsertFirst01() {
        ((RecursiveDoubleLinkedListImpl<Integer>)lista1).insertFirst(4);
        assertArrayEquals(new Integer[] {4, 3, 2, 1}, lista1.toArray());
        ((RecursiveDoubleLinkedListImpl<Integer>)lista1).insert(5);
        assertArrayEquals(new Integer[] {4, 3, 2, 1, 5}, lista1.toArray());
    }

    	@Test
	public void testInsertFirst02() {
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
		((RecursiveDoubleLinkedListImpl<Integer>)lista3).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testRemoveUnicoELemento02() {
		((RecursiveDoubleLinkedListImpl<Integer>)lista3).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista3.toArray());
	}

	@Test
	public void testRemoveLastVazia() {
		((RecursiveDoubleLinkedListImpl<Integer>)listaVazia).removeLast();
		assertArrayEquals(new Integer[] {}, listaVazia.toArray());
	}

	@Test
	public void testInsertLastVazia() {
		((RecursiveDoubleLinkedListImpl<Integer>)listaVazia).insertFirst(4);
		assertArrayEquals(new Integer[] {4}, listaVazia.toArray());
	}


	@Test
	public void testInsertElemNull() {
		listaVazia.insert(null);
		assertArrayEquals(new Integer[] {}, listaVazia.toArray());
	}

	@Test
	public void testInsertFirstElemNull() {
		((RecursiveDoubleLinkedListImpl<Integer>)listaVazia).insertFirst(null);
		assertArrayEquals(new Integer[] {}, listaVazia.toArray());
	}

	@Test
	public void testSearchInexistente() {
		assertNull(listaVazia.search(Integer.valueOf(4)));
	}

	@Test
	public void testSearchLastEncontraPrimeiro() {
		assertEquals(Integer.valueOf(1), ((RecursiveDoubleLinkedListImpl<Integer>) lista1).search(Integer.valueOf(1)));

	}

	@Test
	public void testRemoveLastVazia02() {
		((RecursiveDoubleLinkedListImpl<Integer>) listaVazia).removeLast();
		assertArrayEquals(new Integer[] {}, listaVazia.toArray());
	}

	@Test
	public void testRemoveLastBasico() {
		((RecursiveDoubleLinkedListImpl<Integer>) lista1).insertFirst(Integer.valueOf(4));
		assertArrayEquals(new Integer[] {4, 3, 2, 1}, lista1.toArray());
		((RecursiveDoubleLinkedListImpl<Integer>) lista1).removeLast();
		assertArrayEquals(new Integer[] {4, 3, 2}, lista1.toArray());
	}

	@Test
	public void testRemoveFirstListaVazia() {
		((RecursiveDoubleLinkedListImpl<Integer>) listaVazia).removeFirst();
		assertArrayEquals(new Integer[] {}, listaVazia.toArray());
	}
}
