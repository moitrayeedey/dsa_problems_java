import java.util.*;
import java.util.LinkedList;

public class FirstNonRepeatingChar {
    public static void firstNonRepeating(String str) {
        //frequency array
        int freq[] = new int[26];
        //queue 
        Queue<Character> q = new LinkedList<>();
        //start traversing
        for(int i=0; i<str.length(); i++) {
            //store the current char in a variable
            char curr = str.charAt(i);
            //add it to the queue
            q.add(curr);
            //increase it's freq
            freq[curr - 'a']++;
            //until my queue is empty and the index of the front char is > 1, remove the chars
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            //if queue is empty, return -1
            if(q.isEmpty()) {
                System.out.println(-1);
            }
            //else return the first element
            else {
                System.out.println(q.peek());
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        firstNonRepeating(str);
    }
}