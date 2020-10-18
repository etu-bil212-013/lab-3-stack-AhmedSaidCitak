public class StackLinkedList {
	
	private Node head;
	
	public StackLinkedList() {
		head = null;
	}
	
	public void HTMLControl(StackLinkedList stack, String input) {
		StackLinkedList tempStack = new StackLinkedList();
		String word = "";
		int first = 0, end = 0, temp = 0;
		boolean condition = false;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '>')
				continue;
			end = i;
			temp++;
			
			if (i != input.length()-1) {					// not at the end of input
				word = input.substring(first, end+1);
				first = i+1;
			} 
			else 											// at the end of input
				word = input.substring(first);
			
			word = word.substring(word.indexOf("<"), word.indexOf(">")+1);
						
			if (word.contains("/")) {
				if (stack.isEmpty()) {
					System.out.println("Yanlis, henuz acilmamis bir tag kapatilmis.");
					return;
				} 
				else {
					try {
						if (stack.top().getElement().equals(word.replace("/", ""))) {
							stack.pop();
						} 
						else {
							while(!stack.isEmpty()) {
								if(stack.pop().getElement().equals(word.replace("/", ""))) {
									System.out.println("Yanlis, tag farkli sirada kapatilmis.");
									return;
								}
							}
							System.out.println("Yanlis, henuz acilmamis bir tag kapatilmis.");
							return;
						}
					} catch (EmptyStackException e) {
						e.printStackTrace();
					}
				}
			} 
			else {
				try {
					while(!stack.isEmpty()) {
						if(stack.top().getElement().equals(word))
							condition = true;
						tempStack.push(stack.pop().getElement());
					} 
					
					if(condition) {
						System.out.println("Yanlis, tag kapatilmadan ayni tag acilmis.");
						return;
					}
					
					while(!tempStack.isEmpty()) {
						stack.push(tempStack.pop().getElement());
					}
					
				} catch (EmptyStackException e) {
						e.printStackTrace();
					}
				
				stack.push(word);
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println("Yanlis, kapatilmayan tag var.");
			return;
		}
		
		System.out.println("Dogru.");
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(String s) {
		Node newNode = new Node(s);
		if (isEmpty()) {
			head = newNode;
			newNode.setNext(null);
		} 
		else {
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	public Node pop() throws EmptyStackException {
		String element = "";
		Node newNode = new Node(element);
		if (isEmpty()) {
			throw new EmptyStackException("Stack is Empty! Cannot pop!");
		} 
		else {
			newNode = head;
			head = head.getNext();
			newNode.setNext(null);
		}
		return newNode;
	}
	
	public Node top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is Empty! Stack does not have any element!");
		} 
		else {
			return head;
		}
	}
}
