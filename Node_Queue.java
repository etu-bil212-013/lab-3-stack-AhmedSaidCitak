public class Node_Queue {

	private int element;
	private Node_Queue next;
	
	public Node_Queue(int i) {
		element = i;
	}
	
	public Node_Queue getNext() {
		return next;
	}
	
	public int getElement() {
		return element;
	}
	
	public void setNext(Node_Queue n) {
		next = n;
	}
	
	public void setElement(int i) {
		element = i;
	}
}
