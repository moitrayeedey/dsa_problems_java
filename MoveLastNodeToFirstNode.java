public class MoveLastNodeToFirstNode {
    public static Node moveToFront(Node head) {
        //if the list is empty
        if(head == null) {
            return null;
        }
        //if there is only one node
        if(head.next == null) {
            return head;
        }
        //prev will stop at 2nd last node
        Node prev = head;
        //temp will stop at last node
        Node temp = head.next;
        while(temp.next != null) {
            temp = temp.next;
            prev = prev.next;
        }
        //make the connection between temp and head
        temp.next = head;
        head = temp;
        //prev.next was pointing to temp, so remove it
        prev.next = null;
        return head;

    }
    public static void main(String[] args) {
        //driver function will be provided
    }
}
