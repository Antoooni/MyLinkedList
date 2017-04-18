package by.htp.mylinkedlist;

public class MyLinkedList<E> {
	private Link first;
	private Link last;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyLinkedList<?> other = (MyLinkedList<?>) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}

	public MyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		if (isEmpty())
			last = newLink;
		else
			first.previous = newLink;

		newLink.next = first;
		first = newLink;
	}

	public Link getFirst() {
		return first;
	}

	public void setFirst(Link first) {
		this.first = first;
	}

	public Link getLast() {
		return last;
	}

	public void setLast(Link last) {
		this.last = last;
	}

	public void insertLast(Object o) {
		Link newLink = new Link(o);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
			first = first.next;
		}
		return temp;
	}

	public Link deleteLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
			last = last.previous;
		}
		return temp;
	}

	public boolean insertAfter(Object key, Object val) {
		Link current = first;
		while (!current.data.equals(key)) {
			current = current.next;
			if (current == null)
				return false;
		}
		Link newLink = new Link(val);
		if (current == last) {
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}

	public Link deleteKey(Object key) {
		Link current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null)
				return null;
		}
		if (current == first)
			first = current.next;
		else

			current.previous.next = current.next;
		if (current == last)
			last = current.previous;
		else

			current.next.previous = current.previous;
		return current;
	}

	public void displayFront() {
		System.out.print("List forward: ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}

	public void displayBack() {
		System.out.print("List backward: ");
		Link current = last;
		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}
}
