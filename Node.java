public class Node {
	
	private String element;
	private Node next;
	
	public Node(String s) {
		element = s;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String getElement() {
		return element;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public void setElement(String s) {
		element = s;
	}
}
