public class QueueLinkedList {
	
	private Node_Queue head;
	private Node_Queue tail;
	private int size;
	
	public QueueLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void calculate(QueueLinkedList queue, int limit) {
		int min, min2, deger = 0, boyut = size, count = 0;
		while(true) {
			min = limit+1;
			min2 = limit+1;
			
			try {
				if(size == 1 && queue.front().getElement() < limit) {
					System.out.println("Error: Verilen dizi ile istenen sayi gecilemez.");
					break;
				}
			} catch (EmptyQueueException e1) {
				e1.printStackTrace();
			}
			
			for(int i=0; i<boyut; i++) {					// min min2 bulunuyor
				try {
					deger = queue.front().getElement();
					queue.dequeue();
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
				if(deger < min)
					min = deger;
				else if(deger < min2)
					min2 = deger;
				queue.enqueue(deger);	
			}
			count++;
			
			if(min >= limit || min2 >= limit) {				// limit sayilardan kucuk yapilacak islem yok
				queue.printQueue(queue, count);
				break;
			}
			
			for(int i=0; i<boyut; i++) {					// min min cikartiliyor
				try {
					deger = queue.front().getElement();
					queue.dequeue();
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
				if(deger == min || deger == min2) {
					
				}
				else 
					queue.enqueue(deger);
					
				if(size == boyut-2)
					break;
			}
			
			queue.enqueue(min+min2*2);							// yeni deger ekleniyor
			count++;
		}
		
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void printQueue(QueueLinkedList queue, int count) {
		System.out.println(count/2);
		for(int i=0; !isEmpty(); i++) {
			if(size == 1) {
				try {
					System.out.print(queue.dequeue().getElement() + " ");
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
				return;
			}
				
			if(i == (size-1)) {
				i=0;
				try {
					System.out.print(queue.dequeue().getElement() + " ");
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					queue.enqueue(queue.front().getElement());
					//System.out.println(queue.front().getElement() + "****");
					queue.dequeue();
				} catch (EmptyQueueException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void enqueue(int element) {
		Node_Queue newNode = new Node_Queue(element);
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
			newNode.setNext(null);
		}
		else {
			newNode.setNext(null);
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}
	
	public Node_Queue dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Empty Queue! Cannot dequeue!");
		}
		Node_Queue temp = head;
		head = head.getNext();
		temp.setNext(null);
		size--;
		return temp;
	}
	
	public Node_Queue front() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Empty Queue! Cannot dequeue!");
		}
		return head;
	}
}
