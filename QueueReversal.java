import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

public class QueueReversal {
    public static void reverseQueue(Queue<Integer> q) {
        //create a stack
        Stack<Integer> s = new Stack<>();
        //until queue is empty, remove elements from queue and add it to the stack
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        //send the elements back to the queue
        while(!s.isEmpty()) {
            q.add(s.pop());
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
        reverseQueue(q);
        System.out.println("Reverse Queue: "+q);
    }
}