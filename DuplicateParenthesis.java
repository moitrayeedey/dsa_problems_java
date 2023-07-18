import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean isDuplicate(String str) {
        //create a stack
        Stack<Character> s = new Stack<>();
        //start traversing
        for(int i=0; i<str.length(); i++) {
            //if the char is not an opning braceket, push it to stack
            if(str.charAt(i) != ')') {
                s.push(str.charAt(i));
            }
            //if it is a closing bracket
            else {
                //initialize count as 0
                int count = 0;
                //until we get the opening bracket keep doing pop and increase count
                while(s.pop() != '(') {
                    count++;
                }
                //finally if count = 0 that means dulpicate exists
                if(count < 1) {
                    return true;
                }
            }
        }
        //if count > 1 duplicate does not exist
        return false;
    }
    public static void main(String[] args) {
      System.out.println(isDuplicate("((a+b))"));  
    }
}