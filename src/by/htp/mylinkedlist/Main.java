package by.htp.mylinkedlist;

public class Main {
	public static <E> void main(String[] args) {
		MyLinkedList<E> myList = new MyLinkedList<E>();
		
		myList.insertFirst("A"); 
		myList.insertFirst("B");
		myList.insertFirst("C");
		myList.insertLast("D"); 
		myList.insertLast("E");
		myList.insertLast("F");
		
		myList.displayFront(); 
		myList.displayBack(); 
		
		myList.deleteFirst(); 
		myList.deleteLast(); 
		myList.deleteKey("E"); 
		myList.displayFront(); 
		
		myList.insertAfter("A", "B"); 
		myList.insertAfter("D", "M"); 
		myList.displayFront(); 
	}
}
