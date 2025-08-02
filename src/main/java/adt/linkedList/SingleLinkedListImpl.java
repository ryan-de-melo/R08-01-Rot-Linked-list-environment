package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> auxHead = head;
		
		while (!auxHead.isNIL()) {
			count++;
			auxHead = auxHead.next;
		}

		return count;
	}

	@Override
	public T search(T element) {
		T returnValue = null;

		SingleLinkedListNode<T> auxHead = head;

		while (!auxHead.isNIL()) {
			if (auxHead.data.equals(element)) {
				returnValue = auxHead.data;
			}
			auxHead = auxHead.next;
		}

		return returnValue;
	}

	@Override
	public void insert(T element) {
		if (head.isNIL()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, head);
			head = newHead;
		} else {
			SingleLinkedListNode<T> auxHead = head;

			while (!auxHead.next.isNIL()) {
				auxHead = auxHead.next;
			}
			auxHead.next.data = element;
			auxHead.next.next = new SingleLinkedListNode<>();
		}

	}

	@Override
	public void remove(T element) {
		if (head.data.equals(element)) {
			head = head.next;
		} else {
			SingleLinkedListNode<T> auxHead = head;

			while (!auxHead.isNIL() && !auxHead.data.equals(element)) {
				auxHead = auxHead.next;
			}
			if (!auxHead.isNIL()) {
				auxHead.data = auxHead.next.data;
				auxHead.next = auxHead.next.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] returnArray = (T[]) new Object[size()];
		int index = 0;
		SingleLinkedListNode<T> auxHead = head;

		while (!auxHead.isNIL()) {
			returnArray[index++] = auxHead.data;
			auxHead = auxHead.next;
		}
		
		return returnArray;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
