package Project3;


public class LinkedHeadTailList<T> implements HeadTailListInterface<T> {

	private Node head, tail;

	private class Node {
		private T data;
		private Node next;

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

	@Override
	public void addFront(T newEntry) {
		Node newFront = new Node(newEntry);
		if(size()>0) {
			newFront.setNextNode(head);
		}
		head = newFront;
		if (this.size() == 1) {
			tail = head;
		}
	}

	@Override
	public void addBack(T newEntry) {
		Node newEnd = new Node(newEntry);
		if (size() > 0) {
			tail.setNextNode(newEnd);
			tail = newEnd;
		} else if(size()==0) {
			head = newEnd;
		}
		if (size() == 1) {
			tail = head;
		}
	}

	@Override
	public T removeFront() {
		if (size() == 0) {
			return null;
		}
		Node oldHead = head;
		head = head.getNextNode();
		return (T) oldHead.getData();
	}

	@Override
	public T removeBack() {
		Node oldTail = tail;
		
		if (size() == 0) {
			return null;
		} else if(size()==1) {
			
			tail = null;
			head = tail;
		} else {
			tail = head;
			while(tail.next!=oldTail) {
				tail = tail.next;
			}
			tail.setNextNode(null);
		}
		return (T)oldTail.getData();
	}

	@Override
	public void clear() {
		while (size() != 0) {
			removeFront();
		}

	}

	@Override
	public T getEntry(int givenPosition) {
		{
			Node entry = head;
			T result = null;
			while (givenPosition >= 0) {
				if (givenPosition == 0) {
					result = (T) entry.getData();
				} else {
					entry = entry.getNextNode();
					if (entry == null) {
						break;
					}
				}
				givenPosition--;
			}
			return result;
		}
	}

	@Override
	public void display() {
		System.out.print("[");
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.getData());
			if (currentNode.next != null) {
				System.out.print(", ");
			}
			currentNode = currentNode.next;
		}
		if (size() > 0) {
			System.out.print("]  head=" + head.getData().toString() + " tail=" + tail.getData());
		} else {
			System.out.print("]");
		}
	}

	@Override
	public int indexOf(T anEntry) {
		Node currentNode = head;
		int index = 0;
		while(currentNode.next!= null) {
			if(currentNode.data.equals(anEntry)) {
				return index;
			}
			currentNode = currentNode.next;
			index++;

		}
		if(currentNode.data.equals(anEntry)) { //checking last position outside of while-loop
			return index;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T anEntry) {
		Node currentNode = head;
		int index = 0;
		int savedIndex = -1;
		while(currentNode.next!= null) {
			if(currentNode.data.equals(anEntry)) {
				savedIndex = index;
			}
			index++;
			currentNode = currentNode.next;
		}
		if(currentNode.data.equals(anEntry)) { //checking last position outside of while-loop
			return index;
		}
		return savedIndex;
	}

	@Override
	public boolean contains(T anEntry) {
		Node currentNode = head;

		while (currentNode != null) {

			if (!currentNode.getData().equals(anEntry)) {

				currentNode = currentNode.getNextNode();

			} else {
				return true;
			}

		}
		return false;

	}

	@Override
	public int size() {
		int counter = 0;
		Node currentNode = head;
		if (currentNode != null) {
			while (currentNode != null) {
				counter++;
				currentNode = currentNode.next;
			}
		}
		return counter;
	}

	@Override
	public boolean isEmpty() {

		return this.size() == 0;
	}
}
