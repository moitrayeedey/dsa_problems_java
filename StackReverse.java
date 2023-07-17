import java.util.Stack;

public class StackReverse {
    //function to add elements at the bottom instead of top
    public static void pushAtBottom(Stack<Integer> s, int data) {
        //base case
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    //function to reverse the stack
    public static void reverse(Stack<Integer> s) {
        //base case
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverse(s);
        //push the elements at the bottom instead of top
        pushAtBottom(s, top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(4);
        s.push(10);
        reverse(s);
        System.out.println(s);
    }
}