import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class QueueReverseFirstKElements {
    public static void reverseQueue(Queue<Integer> q, int k) {
        //create a stack
        Stack<Integer> s = new Stack<>();
        //store q.size() - k in a variable
        int x = q.size() - k;
        //remove the first k elements and add tp the stack
        for(int i=0; i<k; i++) {
            s.push(q.remove());
        }
        //add all the elements back to the queue. Hence our kth elements are reversed
        while(!s.isEmpty()) {
          q.add(s.pop());  
        }
        //the x no. of elements are removed from front and added at the back of the queue
        for(int i=0; i<x; i++) {
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println("Original Queue: "+q);
        reverseQueue(q, 3); //k = 3
        System.out.println("Reverse Queue: "+q);
    }
}
