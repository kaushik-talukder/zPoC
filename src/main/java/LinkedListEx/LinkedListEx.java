package LinkedListEx;

class LinkedList {
	Node head;

	LinkedList() {
		this.head = new Node();
	}

	void printList() {
		Node next = head.next;
		while (next != null) {
			System.out.println(next.value);
			next = next.next;
		}
	}

	void addLast(int value) {
		Node next = head;
		while (next != null && next.next != null) {
			next = next.next;
		}
		next.next = new Node(value);
	}

	void deleteLast() {
		Node next = head;
		Node prev = null;
		while (next != null && next.next != null) {
			prev = next;
			next = next.next;
		}
		prev.next = null;
	}

	void deleteFirst() {
		head = head.next;
	}

	void addSorted(int value) {
		Node newNode = new Node(value);
		Node curr = head.next;
		Node prev = head;
		while (curr != null) {
			if(newNode.value > curr.value) {
				prev = curr;
				curr = curr.next;
			} else {
				break;
			} 
		}
		newNode.next = curr;
		prev.next = newNode;
	}
}

public class LinkedListEx {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		// ll.printList();
		
		ll.addSorted(4);
		ll.addSorted(6);
		ll.addSorted(5);
		ll.addSorted(66);
		ll.addSorted(3);
		ll.addSorted(99);
		ll.addSorted(100);
		

		// ll.addLast(6);
		// ll.addLast(7);
		// ll.printList();
		// ll.deleteLast();
		// ll.deleteFirst();
		ll.printList();
	}
}
