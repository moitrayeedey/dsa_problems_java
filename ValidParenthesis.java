import java.util.Stack;

public class ValidParenthesis {
    //helper method to check if the braces are matching or not
    public static boolean isMatching(Stack<Character> s, char c) {
        if(s.peek() == '(' && c == ')' ||s.peek() == '{' && c == '}' || s.peek() == '[' && c == ']') {
            return true;
        }
        return false;
    }
    public static boolean checkParentheis(String str) {
        //create a stack
        Stack<Character> s = new Stack<>();
        //start traversing
        for(int i=0; i<str.length(); i++) {
            //if we find an opening brace, push it to stack
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            }
            //check if it is same as the top
            else {
                //if they are the same, pop the top
                if(isMatching(s, str.charAt(i))) {
                    s.pop();
                }
                //else return false
                else {
                    return false;
                }
            }
        }
        //if at the end the stack is empty return true
        if(s.isEmpty()) {
            return true;
        }
        //else return false as some opening braces might not have been closed
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkParentheis("({}"));
    }
}