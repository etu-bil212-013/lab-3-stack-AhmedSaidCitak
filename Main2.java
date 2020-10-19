import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		QueueLinkedList queue = new QueueLinkedList();
		
		String input = keyboard.nextLine();
		
		int limit = Integer.parseInt(input.substring(input.indexOf("|")+2));
		input = input.substring(0, input.indexOf("|"));
		input = " " + input;
		input = input.replace(" ", "/");
		
		String temp = "";
				
		int begin = input.length()-1, end = input.length()-1, value = 0;
		
		for (int i = input.length()-2; i >= 0 ; i--) {
			if (input.charAt(i) != '/')
				continue;
			begin = i;
			
			temp = input.substring(begin,end);
			temp = temp.replace("/", "");
			value = Integer.parseInt(temp);
			
			if (i != input.indexOf('/'))
				end = begin;
			
			queue.enqueue(value);
		}
		
		queue.calculate(queue, limit);
	}
}
