package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		next = null;
		previous = null;
	}


	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				data = element;
				next = new RecursiveDoubleLinkedListImpl<>();
				
				if (previous != null && !previous.isEmpty()) {
					previous = this;
				}

				previous = new RecursiveDoubleLinkedListImpl<>();
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
				newNode.previous = this;

				this.next = newNode;
				this.previous = new RecursiveDoubleLinkedListImpl<>();
				this.previous.next = this;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).insertFirst(data);
				data = element;
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			data = next.data;
			next = next.next;
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (next.isEmpty()) {
				data = next.data;
				next = next.next;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
