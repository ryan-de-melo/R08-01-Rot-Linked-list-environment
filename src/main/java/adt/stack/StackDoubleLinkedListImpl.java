package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull()) {
			top.insert(element);
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()) {
			T removedElement = ((DoubleLinkedListImpl<T>) top).getLast().getData();
			top.removeLast();
			return removedElement;
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return top.size() == this.size;
	}

}
