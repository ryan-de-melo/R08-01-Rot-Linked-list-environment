package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.data == null;
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public int size() {
		int size = 0;
		if (!isEmpty()) {
			size = 1 + next.size();
		}

		return size;
	}

	@Override
	public T search(T element) {
		T result = null;

		if (!isEmpty()) {
			if (data.equals(element)) {
				result = data;
			} else {
				result = next.search(element);
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				data = element;
				next = new RecursiveSingleLinkedListImpl<T>();
			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (data.equals(element)) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size()];
		putInArray(array, this, 0);

		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

	private void putInArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (node != null && !node.isEmpty()) {
			array[index] = node.getData();
			putInArray(array, node.next, ++index);
		}
	}
}
