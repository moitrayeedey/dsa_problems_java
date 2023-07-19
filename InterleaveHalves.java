import java.util.*;
import java.util.LinkedList;

public class InterleaveHalves {
    public static void interleaveQueue(Queue<Integer> q) {
        //store the original size of the queue in a variable as the size of queue changes everytime we remove the elements
        int queueSize = q.size();
        //new queue to store the first-half
        Queue<Integer> qNew = new LinkedList<>();
        for(int i=0; i<queueSize/2; i++) {
            qNew.add(q.remove());
        }
        //since there are even number of elements, we'll operate until the new queue is not empty
        while(!qNew.isEmpty()) {
            //remove elements from new queue and add it to the original queue
            q.add(qNew.remove());
            //remove elements from the front of the original queue and add to the back
            q.add(q.remove());
        }
        System.out.println("Final Queue: "+q);
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
         interleaveQueue(q);
    }
}