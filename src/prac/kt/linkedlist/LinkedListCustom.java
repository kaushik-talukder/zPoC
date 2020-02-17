package prac.kt.linkedlist;

public class LinkedListCustom {

	private Node head;

	public LinkedListCustom() {
		head = new Node();
	}

	public void insertLast(Node n) {
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = n;
	}

	public void insertFirst(Node n) {
		n.next = head.next;
		head.next = n;
	}

	public void insertAtPosition(int k, Node n) {
		if (k == 0) {
			insertFirst(n);
		} else if (k >= size()) {
			insertLast(n);
		} else {

		}
	}

	public int size() {
		int size = 0;
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	public void printLinkedList() {
		Node curr = head;
		while (curr.next != null) {
			System.out.print(curr.next.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public void reverseList() {
		Node prev = null, next = null;
		Node curr = head.next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head.next = prev;
	}
	
	public int getMiddleNode() {
		Node pointer = head.next;
		Node fastPointer = head.next;
		while(fastPointer != null && fastPointer.next != null) {
			pointer = pointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		return pointer.value;
	}
}