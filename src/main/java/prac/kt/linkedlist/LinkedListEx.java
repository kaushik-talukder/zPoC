package prac.kt.linkedlist;

public class LinkedListEx {
	public static void main(String[] args) {
		LinkedListCustom ll = new LinkedListCustom();
		int i = 0;
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		ll.insertLast(new Node(++i));
		
		ll.printLinkedList();
		//ll.reverseList();
		System.out.println(ll.getMiddleNode());
	}
}
