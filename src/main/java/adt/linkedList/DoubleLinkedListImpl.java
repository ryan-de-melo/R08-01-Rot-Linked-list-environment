package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>();
		this.head = node;
		this.last = node;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>();
			newHead.data = element;
			newHead.next = head;
			newHead.previous = new DoubleLinkedListNode<>();
			
			if (head instanceof DoubleLinkedListNode) {
				((DoubleLinkedListNode<T>) head).previous = newHead;
			}
			if (head.isNIL()) {
				last = newHead;
			}
			head = newHead;
		}
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>)head, last);
				head = newNode;
				last = newNode;
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) last.next, last);
				last.next = newNode;
				last = newNode;
			}
		}
	}


	@Override
	public void removeFirst() {
		if (!head.isNIL()) {
			head = head.next;

			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			} else {
				if (head instanceof DoubleLinkedListNode) {
					((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<>(); 
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if (last != null && !last.isNIL()) {
			last = last.previous;

			if (last.isNIL()) {
				head = last;
			} else {
				last.next = new DoubleLinkedListNode<>();
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
