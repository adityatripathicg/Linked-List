import java.util.*;
public class mergeSort {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //FIND MID
    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    // Merge 
    private static Node merge(Node head1, Node head2){
        Node MergedLL = new Node(-1);
        Node temp = MergedLL;

        while (head1!= null && head2 != null) {
            if (head1.data<=head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1!=null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return MergedLL.next;
    }
    //MERGE SORT IN LL
    public static Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        //Find MID
        Node mid = getMid(head);
        //Left & Right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //Merge
        return merge(newLeft, newRight);
    }
    public static void main(String[] args) {
        LinkedList<Integer>ll = new LinkedList<>();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        System.out.println(ll);

        // Convert LinkedList to custom Node-based list
        Node head = null;
        Node prev = null;
        for (int num : ll) {
            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
        }

        // Call mergeSort method
        head = mergeSort(head);

        // Convert sorted Node-based list back to LinkedList
        ll.clear();
        while (head != null) {
            ll.add(head.data);
            head = head.next;
        }

        System.out.println(ll);

    }
}

