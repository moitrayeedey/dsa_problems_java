import java.util.Stack;

public class StringReverseWithStack {
    public static void reverseString(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb =new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        reverseString("hello");
    }
}